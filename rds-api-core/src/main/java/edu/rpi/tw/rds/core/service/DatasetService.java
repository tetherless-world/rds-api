package edu.rpi.tw.rds.core.service;

import edu.rpi.tw.rds.core.model.Dataset;
import edu.rpi.tw.rds.core.repository.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author szednik
 */
@Service
public class DatasetService {

    @Autowired
    private DatasetRepository datasetRepository;

    public Dataset getByIdentifier(String identifier) {
        Assert.hasText(identifier, "dataset identifier must not be null or empty");
        return datasetRepository.findByIdentifier(identifier);
    }

    public Dataset getByURI(String uri) {
        Assert.hasText(uri, "dataset URI must not be null or empty");
        return datasetRepository.findByURI(uri);
    }

    public Dataset getByTitle(String title) {
        Assert.hasText(title, "dataset title must not be null or empty");
        return datasetRepository.findByTitle(title);
    }

    public List<Dataset> getAll() {
        return datasetRepository.findAll();
    }

    public Dataset save(Dataset dataset) {
        Assert.notNull(dataset, "dataset must not be null");
        return datasetRepository.save(dataset);
    }

    public void delete(Dataset dataset) {
        Assert.notNull(dataset, "dataset must not be null");
        datasetRepository.delete(dataset);
    }

    public void deleteByIdentifier(String identifier) {
        Dataset dataset = getByIdentifier(identifier);
        if(dataset != null) delete(dataset);
    }

    public void deleteByURI(String uri) {
        Dataset dataset = getByURI(uri);
        if(dataset != null) delete(dataset);
    }

    public void deleteByTitle(String title) {
        Dataset dataset = getByTitle(title);
        if(dataset != null) delete(dataset);
    }

}
