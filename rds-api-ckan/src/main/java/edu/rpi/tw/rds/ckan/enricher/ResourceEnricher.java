package edu.rpi.tw.rds.ckan.enricher;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import edu.rpi.tw.rds.vocabulary.DCAT;

/**
 * @author szednik
 */
public class ResourceEnricher {

    public void updateCkanURL(Individual resource, String ckanURL) {
        resource.addSameAs(ResourceFactory.createResource(ckanURL));
    }

    public void updateDownloadURL(Individual resource, String downloadURL) {
        resource.setPropertyValue(DCAT.downloadURL, ResourceFactory.createResource(downloadURL));
    }

    public void updateAccessURL(Individual resource, String accessURL) {
        resource.setPropertyValue(DCAT.accessURL, ResourceFactory.createResource(accessURL));
    }
}
