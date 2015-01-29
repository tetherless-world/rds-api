package edu.rpi.tw.rds.ckan.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.StringUtils;

/**
 * @author szednik
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.NONE)
public class Resource extends CkanBase {

    @JsonProperty("description")
    private String description;

    @JsonProperty("format")
    private String format;

    @JsonProperty("mimetype")
    private String mimetype;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("package_id")
    private String datasetId;

    @JsonProperty("revision_id")
    private String revisionId;

    @JsonIgnore
    private String uploadURL;

    // methods

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public String getRevisionId() {
        return revisionId;
    }

    public void setRevisionId(String revisionId) {
        this.revisionId = revisionId;
    }

    public String getUploadURL() {
        return uploadURL;
    }

    public void setUploadURL(String uploadURL) {
        this.uploadURL = uploadURL;
    }

    public boolean hasUploadURL() {
        return StringUtils.isNotBlank(this.uploadURL);
    }
}
