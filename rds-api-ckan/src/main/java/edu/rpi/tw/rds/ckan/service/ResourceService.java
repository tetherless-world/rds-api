package edu.rpi.tw.rds.ckan.service;

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
public class ResourceService {

    @Value("#{ckanProperties.base_url}")
    private String CKAN_BASE_URL;

    @Value("#{ckanProperties.api_key}")
    private String CKAN_API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    public Resource register(Resource resource) {
        Assert.notNull(resource, "resource must not be null");
        Assert.hasText(resource.getDatasetId(), "resource must have a dataset id");

        final String CKAN_CREATE_RESOURCE_URL = CKAN_BASE_URL + "/api/3/action/resource_create";

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("X-CKAN-API-Key", CKAN_API_KEY);

        HttpEntity<Resource> requestEntity = new HttpEntity<>(resource, requestHeaders);

        ResponseEntity<Resource> responseEntity = restTemplate.postForEntity(CKAN_CREATE_RESOURCE_URL, requestEntity, Resource.class);

        if(responseEntity.getStatusCode().value() != 200) {
            // throw Exception?
            return resource;
        }

        Resource response = responseEntity.getBody();
        Assert.notNull(response.getId(), "resource id should be set");

        String ckan_url = CkanUtils.computeResourceURL(CKAN_BASE_URL, response.getDatasetId(), response.getId());
        response.setCkanURL(ckan_url);

        return response;
    }
}
