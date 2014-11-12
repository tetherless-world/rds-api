package edu.rpi.tw.rds.core.repository;

import edu.rpi.tw.rds.core.model.AbstractResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author szednik
 */
public interface BaseRepository<T extends AbstractResource> extends MongoRepository<T, String> {

    @Query("{ identifier : ?0 }")
    T findByIdentifier(String identifier);

    @Query("{ uri : ?0 }")
    T findByURI(String uri);

    @Query("{ label : ?0 }")
    T findByLabel(String label);

    //@Query("{ integrations.?0 : ?1 }")
    //T findByIntegration(String key, String value);
}
