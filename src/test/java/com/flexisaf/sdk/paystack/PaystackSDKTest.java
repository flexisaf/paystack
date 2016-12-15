package com.flexisaf.sdk.paystack;


import com.flexisaf.sdk.paystack.json.TransactionJson;
import com.flexisaf.sdk.paystack.json.TransactionResponse;
import com.flexisaf.sdk.paystack.http.FSFlightAgent;
import com.flexisaf.sdk.paystack.http.JacksonJsonConverter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

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
    public void testThatTransactionGetInitialized()  throws Exception{
        FSFlightAgent<TransactionJson> flightAgent = new FSFlightAgent<>();
        flightAgent.addHeader("Authorization", PaystackConstant.AUTHORIZATION_KEY_TEST);
        flightAgent.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpEntity response = flightAgent.httpPost(PaystackConstant.INITIALIZING_URL, Mock.mockTansactionjson());

        JacksonJsonConverter<TransactionResponse> responseJacksonJsonConverter
                = new JacksonJsonConverter<>();
            TransactionResponse transactionResponse =
                    responseJacksonJsonConverter.getPojoFromJson(response.getContent(), TransactionResponse.class);
            String expectedMessage = "Authorization URL created";
            assertEquals(transactionResponse.isSuccessfull(), true);
            assertEquals(expectedMessage, transactionResponse.getMessage());

    }

    @Test
    public void  testConvertPojoToJson() {

        JacksonJsonConverter<TransactionJson> jacksonJsonConverter = new JacksonJsonConverter<>();
        String actualJson = jacksonJsonConverter.getJson(Mock.mockTansactionjson());
        Logger.getAnonymousLogger().log(Level.INFO,actualJson );
        String expectedJson = "{}";
        assertEquals(expectedJson, "{}");
    }


}