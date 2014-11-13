package edu.rpi.tw.rds.ckan.ws.ckan_rest_api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

/**
 * @author szednik
 */
public class UpdateHeaderIntercepter implements ClientInterceptor {

    @Value("#{ckanProperties.api_key}")
    private String CKAN_API_KEY;

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        messageContext.setProperty("content-type", "applicaiton/json");
        messageContext.setProperty("Authorization", CKAN_API_KEY);
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        return false;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        return false;
    }
}
