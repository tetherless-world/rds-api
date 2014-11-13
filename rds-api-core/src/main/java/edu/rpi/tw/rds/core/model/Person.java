package edu.rpi.tw.rds.core.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * @author szednik
 */
@Document(collection = "person")
public class Person extends Agent {

    @Field("orcid")
    private String orcid;

    @Field("givenName")
    private String givenName;

    @Field("familyName")
    private String familyName;

    @Field("email")
    @Indexed(unique = true)
    private EmailAddress email;

    public Person() {
        super();
        this.addType("Person");
    }

    public String getORCID() {
        return orcid;
    }

    public void setORCID(String orcid) {
        this.orcid = orcid;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public void setEmail(EmailAddress email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = new EmailAddress(email);
    }
}
