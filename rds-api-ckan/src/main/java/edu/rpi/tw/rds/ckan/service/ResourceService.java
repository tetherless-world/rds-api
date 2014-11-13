package edu.rpi.tw.rds.ckan.service;

import edu.rpi.tw.rds.ckan.model.Resource;
import edu.rpi.tw.rds.ckan.util.CkanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author szednik
 */
@Service
public class ResourceService {

    @Value("#{ckanProperties.base_url}")
    private String CKAN_BASE_URL;

    @Autowired
    @Qualifier("createResourceWebServiceTemplate")
    private WebServiceTemplate createResourceTemplate;

    public Resource register(Resource resource) {
        Assert.notNull(resource, "resource must not be null");
        Assert.hasText(resource.getDatasetId(), "resource must have a dataset id");

        System.out.println(createResourceTemplate.getDefaultUri());

        //createResourceTemplate.sendSourceAndReceiveToResult(source, result);

        String ckan_url = CkanUtils.computeResourceURL(CKAN_BASE_URL, resource.getDatasetId(), resource.getId());
        resource.setCkanURL(ckan_url);

        return resource;
    }

    public WebServiceTemplate getCreateResourceTemplate() {
        return createResourceTemplate;
    }

    public void setCreateResourceTemplate(WebServiceTemplate createResourceTemplate) {
        this.createResourceTemplate = createResourceTemplate;
    }
}
