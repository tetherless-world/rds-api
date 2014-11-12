package edu.rpi.tw.rds.core.model;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * @author szednik
 */

@Document(collection = "dataset")
public class Dataset extends AbstractResource {

    @NotNull
    @Field("title")
    @TextIndexed
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
