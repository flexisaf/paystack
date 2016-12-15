package com.flexisaf.sdk.paystack;


import com.flexisaf.sdk.paystack.http.FSFlightAgent;
import com.flexisaf.sdk.paystack.http.JacksonJsonConverter;
import com.flexisaf.sdk.paystack.json.TransactionJson;
import com.flexisaf.sdk.paystack.json.TransactionResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PaystackTransaction {


    private static final Logger LOGGER = Logger.getLogger(PaystackTransaction.class.getName());

    public TransactionResponse initializeTransaction(TransactionJson transactionJson) {
        FSFlightAgent<TransactionJson> flightAgent = new FSFlightAgent<>();
        flightAgent.addHeader("Authorization", PaystackConstant.AUTHORIZATION_KEY_TEST);
        flightAgent.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpEntity response = flightAgent.httpPost(PaystackConstant.INITIALIZING_URL, transactionJson);

        JacksonJsonConverter<TransactionResponse> responseJacksonJsonConverter
                = new JacksonJsonConverter<>();
        try {

            TransactionResponse transactionResponse =
                    responseJacksonJsonConverter.getPojoFromJson(response.getContent(), TransactionResponse.class);
            return transactionResponse;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, e.getMessage());
            LOGGER.log(Level.INFO, "Transaction initialization failed");
        }

        return null;
    }

    public TransactionResponse verifyTransaction(String transactionRef) {
        return null;
    }
}