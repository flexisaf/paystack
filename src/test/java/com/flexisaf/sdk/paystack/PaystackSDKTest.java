package com.flexisaf.sdk.paystack;


import com.flexisaf.sdk.paystack.json.TransactionJson;
import com.flexisaf.sdk.paystack.utils.JacksonJsonConverter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class PaystackSDKTest{
    // Enabling sout in juniit test
    //http://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void transactionInitialization() {
        assertEquals(1, 1);
    }

    @Test
    public void  testConvertPojoToJson() {
        TransactionJson transactionJson = new TransactionJson();
        transactionJson.setAmount("10000");
        transactionJson.setReference("some-random-string");
        transactionJson.setEmail("fr33wayz@gmail.com");

        JacksonJsonConverter<TransactionJson> jacksonJsonConverter = new JacksonJsonConverter<>();
        String actualJson = jacksonJsonConverter.getJson(transactionJson);
        Logger.getAnonymousLogger().log(Level.INFO,actualJson );
        String expectedJson = "{}";
//        assertEquals(expectedJson, actualJson);
    }
}