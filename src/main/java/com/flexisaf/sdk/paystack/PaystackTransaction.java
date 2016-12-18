package com.flexisaf.sdk.paystack;


import com.flexisaf.sdk.paystack.http.FSFlightAgent;
import com.flexisaf.sdk.paystack.http.JacksonJsonConverter;
import com.flexisaf.sdk.paystack.json.TransactionJson;
import com.flexisaf.sdk.paystack.json.TransactionResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class PaystackTransaction {


    private static final Logger LOGGER = Logger.getLogger(PaystackTransaction.class.getName());
    private Map<String, String> flightAgentHeaderMap;

    /**
     * Initialize a paystack customer transaction
     *
     * @param transactionJson construct the json object to be passed
     * @return {@link TransactionResponse} if the transaction is  or null if some Exception happens
     */
    public TransactionResponse initializeTransaction(TransactionJson transactionJson) {
        FSFlightAgent<TransactionJson> flightAgent = new FSFlightAgent<>();
        //check if no http flight header has been set, then use the test key
        if (flightAgentHeaderMap == null) {
            flightAgent.addHeader(HttpHeaders.AUTHORIZATION, PaystackConstant.AUTHORIZATION_KEY_TEST);
        }
        flightAgent.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        flightAgent.addHeaders(flightAgentHeaderMap);
        HttpResponse httpResponse = flightAgent.httpPost(PaystackConstant.INITIALIZING_URL, transactionJson);
        HttpEntity httpEntity = httpResponse.getEntity();
        JacksonJsonConverter<TransactionResponse> responseJacksonJsonConverter
                = new JacksonJsonConverter<>();
        try {
            return responseJacksonJsonConverter.getPojoFromJson(httpEntity.getContent(), TransactionResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, e.getMessage());
            LOGGER.log(Level.INFO, "Transaction initialization failed");
        }

        return null;
    }

    public TransactionResponse verifyTransaction(String transactionRef, String bearerSecret) {
        FSFlightAgent fsFlightAgent = new FSFlightAgent();
        fsFlightAgent.addHeader(HttpHeaders.AUTHORIZATION, bearerSecret);
        fsFlightAgent.addHeaders(flightAgentHeaderMap);
        HttpResponse httpResponse = fsFlightAgent.httpGet(PaystackConstant.VERIFICATION_URL + "/" + transactionRef);
        HttpEntity httpEntity = httpResponse.getEntity();

        JacksonJsonConverter<TransactionResponse> responseJacksonJsonConverter =
                new JacksonJsonConverter<>();
        try {

            return responseJacksonJsonConverter.getPojoFromJson(httpEntity.getContent(), TransactionResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.log(Level.INFO, e.getMessage());
        }
        return null;
    }

    /**
     * Set all neccessary http header using a key, value
     * using an HashMap.
     * This should be set first before calling
     * the initializeTransaction()
     * if there are neccessary header to user
     * @param paymentHeader
     */
    public void setPaymentHeader(Map<String,String> paymentHeader) {
        this.flightAgentHeaderMap = paymentHeader;
    }


}