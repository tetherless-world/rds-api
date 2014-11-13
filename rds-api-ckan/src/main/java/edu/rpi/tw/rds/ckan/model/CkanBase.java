package edu.rpi.tw.rds.ckan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author szednik
 */
public abstract class CkanBase {

    @JsonProperty("id")
    protected String id;

    @JsonIgnore
    protected String identifier;

    @JsonProperty("name")
    protected String name;

    @JsonProperty("url")
    protected String url;

    @JsonProperty("ckan_url")
    protected String ckanURL;

    // methods

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public String getCkanURL() {
        return ckanURL;
    }

    public void setCkanURL(String ckanURL) {
        this.ckanURL = ckanURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CkanBase ckanBase = (CkanBase) o;

        return !(id != null ? !id.equals(ckanBase.id) : ckanBase.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
