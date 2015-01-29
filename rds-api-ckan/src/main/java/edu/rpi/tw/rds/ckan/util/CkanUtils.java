package edu.rpi.tw.rds.ckan.util;

/**
 * @author szednik
 */
public class CkanUtils {

    public static String computeResourceURL(final String ckanBaseURL, final String datasetId, final String resourceId) {
        return ckanBaseURL + "/dataset/" + datasetId + "/resource/" + resourceId;
    }

    public static String computeDatasetURL(final String ckanBaseURL, final String datasetId) {
        return ckanBaseURL + "/dataset/" + datasetId;
    }
}
