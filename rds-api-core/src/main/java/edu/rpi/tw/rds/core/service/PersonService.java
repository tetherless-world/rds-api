package edu.rpi.tw.rds.core.service;

import edu.rpi.tw.rds.core.model.EmailAddress;
import edu.rpi.tw.rds.core.model.Person;
import edu.rpi.tw.rds.core.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author szednik
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getByIdentifier(String identifier) {
        Assert.hasText(identifier, "person identifier cannot be null or empty");
        return personRepository.findByIdentifier(identifier);
    }

    public Person getByURI(String uri) {
        Assert.hasText(uri, "person URI cannot be null or empty");
        return personRepository.findByURI(uri);
    }

    public Person getByORCID(String orcid) {
        Assert.hasText(orcid, "person ORCID cannot be null or empty");
        return personRepository.findByORCID(orcid);
    }

    public Person getByEmail(String email) {
        Assert.hasText(email, "person email cannot be null or empty");
        EmailAddress emailAddress = new EmailAddress(email);
        return personRepository.findByEmail(emailAddress);
    }

    public List<Person> getByName(String name) {
        Assert.hasText(name, "person name cannot be null or empty");
        return personRepository.findByName(name);
    }

    public List<Person> getByGivenName(String name) {
        Assert.hasText(name, "person name cannot be null or empty");
        return personRepository.findByGivenName(name);
    }

    public List<Person> getByFamilyName(String name) {
        Assert.hasText(name, "person name cannot be null or empty");
        return personRepository.findByFamilyName(name);
    }

    public List<Person> getByNameLike(String name) {
        Assert.hasText(name, "person name cannot be null or empty");
        return personRepository.findByNameLike(name);
    }

    public List<Person> getByGivenNameLike(String name) {
        Assert.hasText(name, "person name cannot be null or empty");
        return personRepository.findByGivenNameLike(name);
    }

    public List<Person> getByFamilyNameLike(String name) {
        Assert.hasText(name, "person name cannot be null or empty");
        return personRepository.findByFamilyNameLike(name);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person save(Person person) {
        Assert.notNull(person, "person to save must not be null");
        return personRepository.save(person);
    }

    public void delete(Person person) {
        Assert.notNull(person, "person to delete must not be null");
        personRepository.delete(person);
    }

    public void deleteByIdentifier(String identifier) {
        Person person = getByIdentifier(identifier);
        if(person != null) delete(person);
    }

    public void deleteByURI(String uri) {
        Person person = getByURI(uri);
        if(person != null) delete(person);
    }

    public void deleteByORCID(String orcid) {
        Person person = getByORCID(orcid);
        if(person != null) delete(person);
    }

    public void deleteByEmail(String email) {
        Person person = getByEmail(email);
        if(person != null) delete(person);
    }
}
