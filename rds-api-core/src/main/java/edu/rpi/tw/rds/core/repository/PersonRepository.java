package edu.rpi.tw.rds.core.repository;

import edu.rpi.tw.rds.core.model.EmailAddress;
import edu.rpi.tw.rds.core.model.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author szednik
 */
@Repository
public interface PersonRepository extends BaseRepository<Person> {

    @Query("{ orcid : ?0 }")
    Person findByORCID(@Param("orcid") String orcid);

    List<Person> findByName(String name);

    List<Person> findByNameLike(String name);

    List<Person> findByGivenName(String givenName);

    List<Person> findByGivenNameLike(String givenName);

    List<Person> findByFamilyName(String familyName);

    List<Person> findByFamilyNameLike(String familyName);

    @Query("{ email : ?0 }")
    Person findByEmail(EmailAddress email);
}
