package edu.rpi.tw.rds.core.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author szednik
 */
@Document(collection = "datasetCatalog")
public class DatasetCatalog extends AbstractResource {

    public DatasetCatalog() {
        super();
        this.addType("DatasetCatalog");
    }
}
