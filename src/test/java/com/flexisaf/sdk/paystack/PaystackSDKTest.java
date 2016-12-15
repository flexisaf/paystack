package com.flexisaf.sdk.paystack;


import com.flexisaf.sdk.paystack.json.TransactionJson;
import com.flexisaf.sdk.paystack.utils.JacksonJsonConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaystackSDKTest{


    @Test
    public void transactionInitialization() {
        assertEquals(1, 2);
    }

    @Test
    public void  testConvertPojoToJson() {
        TransactionJson transactionJson = new TransactionJson();
        transactionJson.setAmount("10000");
        transactionJson.setReference("some-random-string");
        transactionJson.setCustomerEmail("fr33wayz@gmail.com");

        JacksonJsonConverter<TransactionJson> jacksonJsonConverter = new JacksonJsonConverter<>();
        System.out.println(jacksonJsonConverter.getJson(transactionJson));
    }
}