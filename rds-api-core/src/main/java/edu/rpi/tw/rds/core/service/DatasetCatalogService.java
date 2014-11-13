package edu.rpi.tw.rds.core.service;

import edu.rpi.tw.rds.core.model.DatasetCatalog;
import edu.rpi.tw.rds.core.repository.DatasetCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author szednik
 */
@Service
public class DatasetCatalogService {

    @Autowired
    private DatasetCatalogRepository datasetCatalogRepository;

    public DatasetCatalog getByIdentifier(String identifier) {
        Assert.hasText(identifier, "catalog identifier cannot be null or empty");
        return datasetCatalogRepository.findByIdentifier(identifier);
    }

    public DatasetCatalog getByURI(String uri) {
        Assert.hasText(uri, "catalog URI cannot be null or empty");
        return datasetCatalogRepository.findByURI(uri);
    }

    public DatasetCatalog getByHomepage(String homepage) {
        Assert.hasText(homepage, "catalog homepage cannot be null or empty");
        return datasetCatalogRepository.findByHomepage(homepage);
    }

    public DatasetCatalog save(DatasetCatalog catalog) {
        Assert.notNull(catalog, "catalog to save must not be null");
        return datasetCatalogRepository.save(catalog);
    }

    public void delete(DatasetCatalog catalog) {
        Assert.notNull(catalog, "catalog to delete must not be null");
        datasetCatalogRepository.delete(catalog);
    }

    public void deleteByIdentifier(String identifier) {
        DatasetCatalog catalog = getByIdentifier(identifier);
        if(catalog != null) delete(catalog);
    }

    public void deleteByURI(String uri) {
        DatasetCatalog catalog = getByURI(uri);
        if(catalog != null) delete(catalog);
    }
}
