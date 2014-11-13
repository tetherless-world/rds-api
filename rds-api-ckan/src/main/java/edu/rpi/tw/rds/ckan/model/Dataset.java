package edu.rpi.tw.rds.ckan.model;

import com.fasterxml.jackson.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author szednik
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.NONE)
public class Dataset extends CkanBase {

    @JsonProperty("title")
    private String title;

    @JsonProperty("notes")
    private String description;

    @JsonProperty("download_url")
    private String downloadURL;

    @JsonProperty("tags")
    private List<String> keywords;

    @JsonProperty("maintainer")
    private String maintainer;

    @JsonProperty("maintainer_email")
    private String maintainerEmail;

    @JsonProperty("author")
    private String author;

    @JsonProperty("author_email")
    private String authorEmail;

    @JsonProperty("extras")
    private Map<String ,String> extras;

    @JsonIgnore
    private List<Resource> resources;

    // methods


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public String getMaintainerEmail() {
        return maintainerEmail;
    }

    public void setMaintainerEmail(String maintainerEmail) {
        this.maintainerEmail = maintainerEmail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public Map<String, String> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, String> extras) {
        this.extras = extras;
    }

    public void addExtra(String key, String value) {
        this.extras.put(key, value);
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public void addResource(Resource resource) {
        this.resources.add(resource);
    }
}
