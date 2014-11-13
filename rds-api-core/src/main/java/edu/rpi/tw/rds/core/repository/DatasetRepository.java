package edu.rpi.tw.rds.core.repository;

import edu.rpi.tw.rds.core.model.Dataset;
import edu.rpi.tw.rds.core.model.Organization;
import edu.rpi.tw.rds.core.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author szednik
 */
@Repository
public interface DatasetRepository extends BaseRepository<Dataset>, DatasetRepositoryManualMethods {

    Dataset findByTitle(String title);

    Dataset findByLandingPage(String landingPage);

    List<Dataset> findByAuthor(Person author);

    List<Dataset> findByContactPoint(Person contactPoint);

    List<Dataset> findByPublisher(Organization publisher);
}
