package edu.rpi.tw.rds.core.repository;

import edu.rpi.tw.rds.core.model.Distribution;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author szednik
 */
@Repository
public interface DistributionRepository extends BaseRepository<Distribution> {

    Distribution findByTitle(String title);

    @Query("{ accessURL : ?0 }")
    Distribution findByAccessURL(String accessURL);

    @Query("{ downloadURL : ?0 }")
    Distribution findByDownloadURL(String downloadURL);

    @Query("{ format : ?0 }")
    List<Distribution> findByFormat(String format);
}
