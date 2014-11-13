package edu.rpi.tw.rds.core.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

/**
 * @author szednik
 */
@Document(collection = "distribution")
public class Distribution extends AbstractResource {

    @Field("title")
    private String title;

    @Field("issued")
    private LocalDate issuedDate;

    @Field("modified")
    private LocalDate modifiedDate;

    @Field("accessURL")
    private URI accessURL;

    @Field("downloadURL")
    private URI downloadURL;

    @Field("format")
    private String format;

    @Field("mediaType")
    private String mediaType;

    public Distribution() {
        super();
        this.addType("Distribution");
    }

    // title

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean hasTitle() {
        return StringUtils.isNotBlank(this.title);
    }

    // issuedDate

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public boolean hasIssuedDate() {
        return (this.issuedDate != null);
    }

    // modifiedDate

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean hasModifiedDate() {
        return (this.modifiedDate != null);
    }

    // accessURL

    public URI getAccessURL() {
        return accessURL;
    }

    public void setAccessURL(URI accessURL) {
        this.accessURL = accessURL;
    }

    public void setAccessURL(String accessURL) {
        if(StringUtils.isNotBlank(accessURL)) {
            try {
                this.accessURL = new URI(accessURL);
            } catch (URISyntaxException e) {
                //logger.warn("Distribution accessURL has malformed URI {}", accessURL, e);
            }
        }
    }

    public boolean hasAccessURL() {
        return (this.accessURL != null);
    }

    // downloadURL

    public URI getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(URI downloadURL) {
        this.downloadURL = downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        if(StringUtils.isNotBlank(downloadURL)) {
            try {
                this.downloadURL = new URI(downloadURL);
            } catch (URISyntaxException e) {
                //logger.warn("Distribution downloadURL has malformed URI {}", downloadURL, e);
            }
        }
    }

    public boolean hasDownloadURL() {
        return (this.downloadURL != null);
    }

    // format

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean hasFormat() {
        return StringUtils.isNotBlank(this.format);
    }

    // mediaType

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public boolean hasMediaType() {
        return StringUtils.isNotBlank(this.mediaType);
    }
}
