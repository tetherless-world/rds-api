package edu.rpi.tw.rds.core.model;

import edu.rpi.tw.rds.core.mongo.CascadeSave;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author szednik
 */

@Document(collection = "dataset")
public class Dataset extends AbstractResource {

    @NotNull
    @Field("title")
    @TextIndexed
    private String title;

    @Field("landingPage")
    private String landingPage;

    @DBRef
    @CascadeSave
    private Person author;

    @DBRef
    @CascadeSave
    private Person contactPoint;

    @DBRef
    @CascadeSave
    private Organization publisher;

    @DBRef
    @CascadeSave
    private List<Distribution> distributions;

    @Field("keywords")
    private List<String> keywords;

    public Dataset() {
        super();
        this.addType("Dataset");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLandingPage() {
        return landingPage;
    }

    public void setLandingPage(String landingPage) {
        this.landingPage = landingPage;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Person getContactPoint() {
        return contactPoint;
    }

    public void setContactPoint(Person contactPoint) {
        this.contactPoint = contactPoint;
    }

    public Organization getPublisher() {
        return publisher;
    }

    public void setPublisher(Organization publisher) {
        this.publisher = publisher;
    }

    public List<Distribution> getDistributions() {
        return distributions;
    }

    public void setDistributions(List<Distribution> distributions) {
        this.distributions = distributions;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public void addKeyword(String keyword) {
        this.keywords.add(keyword);
    }
}
