package edu.rpi.tw.rds.core.repository;

import edu.rpi.tw.rds.core.model.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author szednik
 */
@Repository
public interface OrganizationRepository extends BaseRepository<Organization> {

    Organization findByName(String name);

    List<Organization> findByNameLike(String name);

    Organization findByHomepage(String homepage);
}
