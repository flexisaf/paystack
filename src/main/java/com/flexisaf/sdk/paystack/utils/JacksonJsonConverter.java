package com.flexisaf.sdk.paystack.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonConverter<T>{

    private ObjectMapper objectMapper = new ObjectMapper();


    public String getJson(T pojoToConvert) {
        try {
            return objectMapper.writeValueAsString(pojoToConvert);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // just return an empty json if an exception happened
        return "{}";
    }
}