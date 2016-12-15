package com.flexisaf.sdk.paystack.http;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by peter on 12/15/16.
 */
public class FSFlightAgent<T> {
    private static final Logger LOGGER = Logger.getLogger(FSFlightAgent.class.getName());
    private List<Header> headers = new ArrayList<>();

    public HttpResponse httpPost(String url, T bodyData) {
        // todo check with regex that is a valid url
        // todo check that the header contain atleast one information or add a content type
        HttpClient httpClient = HttpClients
                .custom()
                .setDefaultHeaders(headers)
                .build();

        HttpEntity bodyEntity = createJsonBody(bodyData);
        HttpUriRequest request = RequestBuilder.post(url).setEntity(bodyEntity).build();

        try {
            return httpClient.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.log(Level.INFO, "Error from FSFlight Agent during HTTP POST");
        }

        return null;

    }

    public HttpResponse httpGet(String apiUrl) {
        HttpClient httpClient = HttpClients.custom()
                .setDefaultHeaders(headers)
                .build();

        HttpUriRequest request = RequestBuilder.get(apiUrl).build();
        try {
            return httpClient.execute(request);
        }catch (Exception e) {
            e.printStackTrace();
            LOGGER.log(Level.INFO, "Error from FSFlight Agent during HTTP GET");
        }
        return null;
    }

    public void addHeader(String name, String value) {
        Header header = new BasicHeader(name, value);
        headers.add(header);
    }

    private HttpEntity createJsonBody(T object) {
        JacksonJsonConverter<T> jacksonJsonConverter = new JacksonJsonConverter<>();
        String bodyJson = jacksonJsonConverter.getJson(object);
        Logger.getAnonymousLogger().log(Level.INFO, "JSON Sent is " + bodyJson);
        try {

            return new ByteArrayEntity(bodyJson.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
