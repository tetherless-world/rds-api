package edu.rpi.tw.rds.core.repository;

import edu.rpi.tw.rds.core.model.Dataset;

import java.util.List;

/**
 * @author szednik
 */
public interface DatasetRepositoryManualMethods {

    List<Dataset> findByAuthorIdentifier(String identifier);

    List<Dataset> findByAuthorURI(String uri);

    List<Dataset> findByAuthorEmail(String email);

    List<Dataset> findByContactPointURI(String uri);

    List<Dataset> findByContactPointIdentifier(String identifier);

    List<Dataset> findByContactPointEmail(String email);

    List<Dataset> findByPublisherURI(String uri);

    List<Dataset> findByPublisherIdentifier(String identifier);

    List<Dataset> findByPublisherName(String name);
}
