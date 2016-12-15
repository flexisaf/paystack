package com.flexisaf.sdk.paystack.http;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JacksonJsonConverter<T> {

    private ObjectMapper objectMapper = new ObjectMapper();


    public String getJson(T pojoToConvert) {
        try {
            return objectMapper.writeValueAsString(pojoToConvert);

        } catch (Exception e) {
            e.printStackTrace();

            // just return an empty json if an exception happened
            return "{}";
        }
    }

    public T getPojoFromJson(InputStream inputStream, Class<T> tClass) {

        try {
            return objectMapper.readValue(inputStream, tClass);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getAnonymousLogger().log(Level.INFO, e.getMessage());
        }
        return null;
    }
}