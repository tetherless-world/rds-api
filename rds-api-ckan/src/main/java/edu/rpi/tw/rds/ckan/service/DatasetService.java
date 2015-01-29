package edu.rpi.tw.rds.ckan.service;

import edu.rpi.tw.rds.ckan.model.Dataset;
import edu.rpi.tw.rds.ckan.model.Resource;
import edu.rpi.tw.rds.ckan.util.CkanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

/**
 * @author szednik
 */
@Service
public class DatasetService {

    @Value("#{ckanProperties.base_url}")
    private String CKAN_BASE_URL;

    @Value("#{ckanProperties.api_key}")
    private String CKAN_API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ResourceService resourceService;

    public Dataset register(Dataset dataset) {

        Assert.notNull(dataset, "dataset must not be null");
        Assert.hasText(dataset.getName(), "dataset name must have a value");
        Assert.hasText(dataset.getTitle(), "dataset title must have a value");

        final String CREATE_DATASET_URL = CKAN_BASE_URL + "/api/rest/dataset";

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("Authorization", CKAN_API_KEY);

        HttpEntity<Dataset> requestEntity = new HttpEntity<>(dataset, requestHeaders);

        ResponseEntity<Dataset> responseEntity = restTemplate.postForEntity(CREATE_DATASET_URL, requestEntity, Dataset.class);
        Assert.notNull(responseEntity, "response entity from rest template must not be null");

        if(responseEntity.getStatusCode().value() != 201) {
            // throw Exception?
            return dataset;
        }

        Dataset response = responseEntity.getBody();

        Assert.notNull(response.getId(), "dataset id should not be null");
        Assert.notNull(response.getCkanURL(), "dataset CKAN_URL should not be null");

        for(Resource resource : dataset.getResources()) {
            resource.setDatasetId(response.getId());
            response.addResource(resourceService.register(resource));
        }

        return response;
    }
}
