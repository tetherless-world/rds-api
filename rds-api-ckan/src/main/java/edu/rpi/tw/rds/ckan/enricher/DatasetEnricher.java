package edu.rpi.tw.rds.ckan.enricher;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import edu.rpi.tw.rds.vocabulary.DCAT;

/**
 * @author szednik
 */
public class DatasetEnricher {

    public void updateCkanURL(Individual dataset, String ckanURL) {
        dataset.addSameAs(ResourceFactory.createResource(ckanURL));
    }

    public void updateLandingPage(Individual dataset, String landingPage) {
        dataset.setPropertyValue(DCAT.accessURL, ResourceFactory.createResource(landingPage));
    }
}
