package edu.rpi.tw.rds.core.repository;

import edu.rpi.tw.rds.core.model.Dataset;
import edu.rpi.tw.rds.core.model.EmailAddress;
import edu.rpi.tw.rds.core.model.Organization;
import edu.rpi.tw.rds.core.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author szednik
 */
@Component
public class DatasetRepositoryImpl implements DatasetRepositoryManualMethods {

    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<Dataset> findByAuthorIdentifier(String identifier) {
        Person author = personRepository.findByIdentifier(identifier);
        if(author == null) return null;
        return datasetRepository.findByAuthor(author);
    }

    @Override
    public List<Dataset> findByAuthorURI(String uri) {
        Person author = personRepository.findByURI(uri);
        if(author == null) return null;
        return datasetRepository.findByAuthor(author);
    }

    @Override
    public List<Dataset> findByAuthorEmail(String email) {
        Person author = personRepository.findByEmail(new EmailAddress(email));
        if(author == null) return null;
        return datasetRepository.findByAuthor(author);
    }

    @Override
    public List<Dataset> findByContactPointURI(String uri) {
        Person contactPoint = personRepository.findByURI(uri);
        if(contactPoint == null) return null;
        return datasetRepository.findByContactPoint(contactPoint);
    }

    @Override
    public List<Dataset> findByContactPointIdentifier(String identifier) {
        Person contactPoint = personRepository.findByIdentifier(identifier);
        if(contactPoint == null) return null;
        return datasetRepository.findByContactPoint(contactPoint);
    }

    @Override
    public List<Dataset> findByContactPointEmail(String email) {
        Person contactPoint = personRepository.findByEmail(new EmailAddress(email));
        if(contactPoint == null) return null;
        return datasetRepository.findByContactPoint(contactPoint);
    }

    @Override
    public List<Dataset> findByPublisherURI(String uri) {
        Organization publisher = organizationRepository.findByURI(uri);
        if(publisher == null) return null;
        return this.datasetRepository.findByPublisher(publisher);
    }

    @Override
    public List<Dataset> findByPublisherIdentifier(String identifier) {
        Organization publisher = organizationRepository.findByIdentifier(identifier);
        if(publisher == null) return null;
        return this.datasetRepository.findByPublisher(publisher);
    }

    @Override
    public List<Dataset> findByPublisherName(String name) {
        Organization publisher = organizationRepository.findByName(name);
        if(publisher == null) return null;
        return this.datasetRepository.findByPublisher(publisher);
    }
}
