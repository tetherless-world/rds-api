package edu.rpi.tw.rds.core.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * @author szednik
 */

@Document(collection = "organization")
public class Organization extends Agent {

    @Field("homepage")
    private String homepage;

    public Organization() {
        super();
        this.addType("Organization");
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public boolean hasHomepage() {
        return StringUtils.isNotBlank(this.homepage);
    }
}
