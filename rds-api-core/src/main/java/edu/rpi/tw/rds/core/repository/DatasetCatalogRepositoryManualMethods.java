package edu.rpi.tw.rds.core.repository;

import edu.rpi.tw.rds.core.model.DatasetCatalog;

import java.util.List;

/**
 * @author szednik
 */
public interface DatasetCatalogRepositoryManualMethods {

    List<DatasetCatalog> findByDatasetURI(String uri);

    List<DatasetCatalog> findByDatasetIdentifier(String identifier);

    List<DatasetCatalog> findByPublisherURI(String uri);

    List<DatasetCatalog> findByPublisherIdentifier(String identifier);

}
