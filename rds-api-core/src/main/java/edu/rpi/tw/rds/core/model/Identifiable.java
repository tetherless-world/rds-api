package edu.rpi.tw.rds.core.model;

/**
 * @author szednik
 */
public interface Identifiable {

    // persistent identifier

    String getIdentifier();

    void setIdentifier(String identifier);

    boolean hasIdentifier();

    // resource URI

    String getURI();

    void setURI(String uri);

    boolean hasURI();
}
