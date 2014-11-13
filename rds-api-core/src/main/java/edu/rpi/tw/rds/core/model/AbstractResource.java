package edu.rpi.tw.rds.core.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * @author szednik
 */
public abstract class AbstractResource implements Identifiable {

    @Id
    private String id;

    @Field("identifier")
    @Indexed(unique = true)
    private String identifier;

    @Field("uri")
    @Indexed(unique = true)
    private String uri;

    @Field("label")
    private String label;

    @Field("description")
    private String description;

    @Field("type")
    private List<String> types = new ArrayList<>();

    public String getId() {
        return id;
    }

    public boolean hasId() {
        return StringUtils.isNoneBlank(this.id);
    }

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean hasIdentifier() {
        return StringUtils.isNotBlank(identifier);
    }

    @Override
    public String getURI() {
        return this.uri;
    }

    @Override
    public void setURI(String uri) {
        this.uri = uri;
    }

    @Override
    public boolean hasURI() {
        return StringUtils.isNotBlank(this.uri);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean hasLabel() {
        return StringUtils.isNotBlank(this.label);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public void addType(String type) {
        this.types.add(type);
    }
}
