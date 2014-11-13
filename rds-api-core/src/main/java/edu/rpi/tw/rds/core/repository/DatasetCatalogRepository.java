package edu.rpi.tw.rds.core.repository;

import edu.rpi.tw.rds.core.model.Dataset;
import edu.rpi.tw.rds.core.model.DatasetCatalog;
import edu.rpi.tw.rds.core.model.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author szednik
 */
@Repository
public interface DatasetCatalogRepository
        extends BaseRepository<DatasetCatalog>, DatasetCatalogRepositoryManualMethods {

    DatasetCatalog findByTitle(String title);

    DatasetCatalog findByHomepage(String homepage);

    List<DatasetCatalog> findByPublisher(Organization publisher);

    List<DatasetCatalog> findByDataset(Dataset dataset);
}
