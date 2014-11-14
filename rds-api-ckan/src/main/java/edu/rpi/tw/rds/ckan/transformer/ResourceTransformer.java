package edu.rpi.tw.rds.ckan.transformer;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.vocabulary.DCTerms;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;
import edu.rpi.tw.rds.ckan.model.Resource;
import edu.rpi.tw.rds.vocabulary.DCAT;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author szednik
 */
@Component
public class ResourceTransformer {

    public List<Resource> transform(OntModel m) {
        List<Resource> resources = new ArrayList<>();
        for(Individual distribution : m.listIndividuals(DCAT.Distribution).toList()) {
            resources.add(getResource(distribution));
        }
        return resources;
    }

    public Resource getResource(Individual i) {

        Assert.notNull(i, "distribution individual must not be null");
        Assert.isTrue(i.hasRDFType(DCAT.Distribution), "individual must be of type dcat:Distribution");

        Resource resource = new Resource();

        addTitle(resource, i);
        addDescription(resource, i);
        addFormat(resource, i);
        addSize(resource, i);
        addURL(resource, i);

        return resource;
    }

    protected void addTitle(Resource resource, Individual i) {
        if(i.hasProperty(DCTerms.title)) {
            String title = i.getPropertyResourceValue(DCTerms.title).asLiteral().getString();
            resource.setName(title);
        }
    }

    protected void addDescription(Resource resource, Individual i) {
        if(i.hasProperty(DCTerms.description)) {
            String description = i.getPropertyResourceValue(DCTerms.description).asLiteral().getString();
            resource.setDescription(description);
        }
    }

    private void addFormat(Resource resource, Individual i) {
        if(i.hasProperty(DCAT.mediaType)) {
            com.hp.hpl.jena.rdf.model.Resource format = i.getPropertyResourceValue(DCAT.mediaType).asResource();
            if(format.hasProperty(RDF.value)) {
                String formatValue = format.getPropertyResourceValue(RDF.value).asLiteral().getString();
                resource.setFormat(formatValue);
            } else if(format.hasProperty(DCTerms.title)) {
                String formatTitle = format.getPropertyResourceValue(RDFS.label).asLiteral().getString();
                resource.setFormat(formatTitle);
            } else if(format.hasProperty(RDFS.label)) {
                String formatLabel = format.getPropertyResourceValue(RDFS.label).asLiteral().getString();
                resource.setFormat(formatLabel);
            }
        }
    }

    private void addSize(Resource resource, Individual i) {
        if(i.hasProperty(DCAT.byteSize)) {
            int byteSize = i.getPropertyResourceValue(DCAT.byteSize).asLiteral().getInt();
            resource.setSize(byteSize);
        }
    }

    protected void addURL(Resource resource, Individual i) {
        if(i.hasProperty(DCAT.accessURL)) {
            String accessURL = i.getPropertyResourceValue(DCAT.accessURL).asResource().getURI();
            resource.setURL(accessURL);
        } else if(i.hasProperty(DCAT.downloadURL)) {
            String downloadURL = i.getPropertyResourceValue(DCAT.downloadURL).asResource().getURI();
            resource.setURL(downloadURL);
        }
    }
}
