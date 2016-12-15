package com.flexisaf.sdk.paystack;

import com.flexisaf.sdk.paystack.json.TransactionJson;

import java.util.UUID;

/**
 *  * Created by peter on 12/15/16.
 */
public class Mock{

    public static TransactionJson mockTansactionjson() {
        TransactionJson transactionJson = new TransactionJson();
        transactionJson.setAmount(10000.0);
        transactionJson.setReference(UUID.randomUUID().toString());
        transactionJson.setEmail("fr33wayz@gmail.com");
        return transactionJson;
    }
}
