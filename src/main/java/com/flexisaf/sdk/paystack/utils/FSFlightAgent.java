package com.flexisaf.sdk.paystack.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peter on 12/15/16.
 */
public class FSFlightAgent<T> {

    private List<Header> headers = new ArrayList<>();

    public HttpEntity httpPost(String url, T bodyData) {
        // todo check with regex that is a valid url
        // todo check that the header contain atleast one information or add a content type
        HttpClient httpClient = HttpClients
                .custom()
                .setDefaultHeaders(headers)
                .build();

        HttpEntity bodyEntity = createJsonBody(bodyData);
        HttpUriRequest request = RequestBuilder.post(url).setEntity(bodyEntity).build();
        HttpEntity responseEntity;

        try {
            responseEntity = httpClient.execute(request).getEntity();
            EntityUtils.consume(responseEntity);
            return responseEntity;
        } catch (IOException e) {
            e.printStackTrace();
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
        try {

            HttpEntity httpEntity = new ByteArrayEntity(bodyJson.getBytes("UTF-8"));
            return httpEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
