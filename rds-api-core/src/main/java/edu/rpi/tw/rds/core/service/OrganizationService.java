package edu.rpi.tw.rds.core.service;

import edu.rpi.tw.rds.core.model.Organization;
import edu.rpi.tw.rds.core.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author szednik
 */
@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization getByIdentifier(String identifier) {
        Assert.hasText(identifier, "organization identifier must not be null or empty");
        return organizationRepository.findByIdentifier(identifier);
    }

    public Organization getByURI(String uri) {
        Assert.hasText(uri, "organization URI must not be null or empty");
        return organizationRepository.findByURI(uri);
    }

    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    public Organization save(Organization organization) {
        Assert.notNull(organization, "organization to save must not be null");
        return organizationRepository.save(organization);
    }

    public void delete(Organization organization) {
        Assert.notNull(organization, "organization to delete must not be null");
        organizationRepository.save(organization);
    }

    public void deleteByIdentifier(String identifier) {
        Organization organization = getByIdentifier(identifier);
        if(organization != null) delete(organization);
    }

    public void deleteByURI(String uri) {
        Organization organization = getByURI(uri);
        if(organization != null) delete(organization);
    }
}
