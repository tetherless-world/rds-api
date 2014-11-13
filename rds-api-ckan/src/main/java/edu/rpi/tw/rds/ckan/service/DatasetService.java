package edu.rpi.tw.rds.ckan.service;

import edu.rpi.tw.rds.ckan.model.Dataset;
import edu.rpi.tw.rds.ckan.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author szednik
 */
@Service
public class DatasetService {

    @Value("#{ckanProperties.api_key}")
    private String CKAN_API_KEY;

    @Autowired
    @Qualifier("datasetWebServiceTemplate")
    private WebServiceTemplate datasetWebServiceTemplate;

    @Autowired
    private ResourceService resourceService;

    public Dataset register(Dataset dataset) {

        System.out.println(datasetWebServiceTemplate.getDefaultUri());

        // TODO create Source from dataset

        //webServiceTemplate.sendSourceAndReceiveToResult(source, result);

        final String datasetId = "";

        dataset.setId("");
        dataset.setCkanURL("");

        for(Resource resource : dataset.getResources()) {
            resource.setDatasetId(datasetId);
            resource = resourceService.register(resource);
        }

        return dataset;
    }

    public WebServiceTemplate getDatasetWebServiceTemplate() {
        return datasetWebServiceTemplate;
    }

    public void setDatasetWebServiceTemplate(WebServiceTemplate datasetWebServiceTemplate) {
        this.datasetWebServiceTemplate = datasetWebServiceTemplate;
    }
}
