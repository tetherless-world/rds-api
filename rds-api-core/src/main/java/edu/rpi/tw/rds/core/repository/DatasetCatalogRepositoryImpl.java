package edu.rpi.tw.rds.core.repository;

import edu.rpi.tw.rds.core.model.Dataset;
import edu.rpi.tw.rds.core.model.DatasetCatalog;
import edu.rpi.tw.rds.core.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author szednik
 */
@Component
public class DatasetCatalogRepositoryImpl implements DatasetCatalogRepositoryManualMethods {

    @Autowired
    private DatasetCatalogRepository datasetCatalogRepository;

    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<DatasetCatalog> findByDatasetURI(String uri) {
        Dataset dataset = datasetRepository.findByURI(uri);
        if(dataset == null) return null;
        return datasetCatalogRepository.findByDataset(dataset);
    }

    @Override
    public List<DatasetCatalog> findByDatasetIdentifier(String identifier) {
        Dataset dataset = datasetRepository.findByIdentifier(identifier);
        if(dataset == null) return null;
        return datasetCatalogRepository.findByDataset(dataset);
    }

    @Override
    public List<DatasetCatalog> findByPublisherURI(String uri) {
        Organization publisher = organizationRepository.findByURI(uri);
        if(publisher == null) return null;
        return datasetCatalogRepository.findByPublisher(publisher);
    }

    @Override
    public List<DatasetCatalog> findByPublisherIdentifier(String identifier) {
        Organization publisher = organizationRepository.findByIdentifier(identifier);
        if(publisher == null) return null;
        return datasetCatalogRepository.findByPublisher(publisher);
    }
}
