package edu.rpi.tw.rds.core.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * @author szednik
 */
public abstract class Agent extends AbstractResource {

    @NotNull
    @Field("name")
    private String name;

    public Agent() {
        super();
        this.addType("Agent");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasName() {
        return StringUtils.isNotBlank(this.name);
    }
}
