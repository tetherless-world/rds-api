package edu.rpi.tw.rds.ckan.transformer;

import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;
import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.DCTerms;
import com.hp.hpl.jena.vocabulary.RDFS;
import edu.rpi.tw.rds.vocabulary.DCAT;

import com.hp.hpl.jena.ontology.Individual;
import edu.rpi.tw.rds.ckan.model.Dataset;
import edu.rpi.tw.rds.vocabulary.VCARD;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author szednik
 */
@Component
public class DatasetTransformer {

    protected Dataset getDataset(Individual i) {

        Assert.notNull(i, "dataset individual must not be null");
        Assert.isTrue(i.hasRDFType(DCAT.Dataset), "individual most have rdf:type dcat:Dataset");

        Dataset dataset = new Dataset();

        addIdentifier(dataset, i);
        addTitle(dataset, i);
        addDescription(dataset, i);
        addIssuedDate(dataset, i);
        addKeywords(dataset, i);
        addContributors(dataset, i);
        addLandingPage(dataset, i);
        addPublisher(dataset, i);
        addAuthor(dataset, i);
        addContact(dataset, i);

        return dataset;
    }

    protected void addIdentifier(Dataset dataset, Individual i) {
        if(i.hasProperty(DCTerms.identifier)) {
            String identifier = i.getPropertyResourceValue(DCTerms.identifier).asLiteral().getString();
            dataset.setIdentifier(identifier);
        }
    }

    protected void addDescription(Dataset dataset, Individual i) {
        if(i.hasProperty(DCTerms.description)) {
            String description = i.getPropertyResourceValue(DCTerms.description).asLiteral().getString();
            dataset.setDescription(description);
        }
    }

    protected void addTitle(Dataset dataset, Individual i) {
        if(i.hasProperty(DCTerms.title)) {
            String title = i.getPropertyResourceValue(DCTerms.title).asLiteral().getString();
            dataset.setTitle(title);
        }
    }

    protected void addIssuedDate(Dataset dataset, Individual i) {
        if(i.hasProperty(DCTerms.issued)) {
            String issuedDate = i.getPropertyResourceValue(DCTerms.issued).asLiteral().getString();
            dataset.setIssuedDate(issuedDate);
        }
    }

    protected void addKeywords(Dataset dataset, Individual i) {
        if(i.hasProperty(DCAT.keyword)) {
            List<String> keywords = new ArrayList<>();
            for(RDFNode node : i.listPropertyValues(DCAT.keyword).toList()) {
                String keyword = node.asLiteral().getString();
                keywords.add(keyword);
            }
            dataset.setKeywords(keywords);
        }
    }

    protected void addContributors(Dataset dataset, Individual i) {
        if(i.hasProperty(DC.contributor)) {
            List<String> contributors = new ArrayList<>();
            for(RDFNode node : i.listPropertyValues(DC.contributor).toList()) {
                String contributor = node.asLiteral().getString();
                contributors.add(contributor);
            }
            dataset.setContributors(contributors);
        }
    }

    protected void addPublisher(Dataset dataset, Individual i) {
        if(i.hasProperty(DCTerms.publisher)) {
            Resource publisher = i.getPropertyResourceValue(DCTerms.publisher).asResource();
            if(publisher.hasProperty(RDFS.label)) {
                String publisherName = publisher.getPropertyResourceValue(RDFS.label).asLiteral().getString();
                dataset.setPublisher(publisherName);
            }
        }
    }

    protected void addLandingPage(Dataset dataset, Individual i) {
        if(i.hasProperty(DCAT.landingPage)) {
            String landingPage = i.getPropertyResourceValue(DCAT.landingPage).toString();
            dataset.setLandingPage(landingPage);
        }
    }

    protected void addAuthor(Dataset dataset, Individual i) {
        if(i.hasProperty(DCTerms.creator)) {
            Resource author = i.getPropertyResourceValue(DCTerms.creator).asResource();

            if(author.hasProperty(FOAF.name)) {
                String authorName = author.getPropertyResourceValue(FOAF.name).asLiteral().getString();
                dataset.setAuthor(authorName);
            } else if(author.hasProperty(VCARD.fn)) {
                String formattedName = author.getPropertyResourceValue(VCARD.fn).asLiteral().getString();
                dataset.setAuthor(formattedName);
            } else if(author.hasProperty(RDFS.label)) {
                String formattedName = author.getPropertyResourceValue(RDFS.label).asLiteral().getString();
                dataset.setAuthor(formattedName);
            }

            if(author.hasProperty(VCARD.email)) {
                Resource email = author.getPropertyResourceValue(VCARD.email).asResource();
                if(email.getURI().contains("mailto:")) {
                    String emailAddress = email.getURI().substring(7);
                    dataset.setAuthorEmail(emailAddress);
                }
            } else if(author.hasProperty(FOAF.mbox)) {
                Resource mbox = author.getPropertyResourceValue(FOAF.mbox).asResource();
                if(mbox.getURI().contains("mailto:")) {
                    String emailAddress = mbox.getURI().substring(7);
                    dataset.setAuthorEmail(emailAddress);
                }
            }
        }
    }

    protected void addContact(Dataset dataset, Individual i) {

        if(i.hasProperty(DCAT.contactPoint)) {
            Resource contactPoint = i.getPropertyResourceValue(DCAT.contactPoint).asResource();

            if(contactPoint.hasProperty(VCARD.email)) {
                Resource email = contactPoint.getPropertyResourceValue(VCARD.email).asResource();
                if(email.getURI().contains("mailto:")) {
                    String emailAddress = email.getURI().substring(7);
                    dataset.setMaintainerEmail(emailAddress);
                }
            } else if(contactPoint.hasProperty(FOAF.mbox)) {
                Resource mbox = contactPoint.getPropertyResourceValue(FOAF.mbox).asResource();
                if(mbox.getURI().contains("mailto:")) {
                    String emailAddress = mbox.getURI().substring(7);
                    dataset.setMaintainerEmail(emailAddress);
                }
            }

            if(contactPoint.hasProperty(VCARD.fn)) {
                String formattedName = contactPoint.getPropertyResourceValue(VCARD.fn).asLiteral().getString();
                dataset.setMaintainer(formattedName);
            } else if(contactPoint.hasProperty(RDFS.label)) {
                String formattedName = contactPoint.getPropertyResourceValue(RDFS.label).asLiteral().getString();
                dataset.setMaintainer(formattedName);
            }
        }
    }

}
