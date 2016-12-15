package com.flexisaf.sdk.paystack.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by peter on 12/15/16.
 */
public class TransactionResponse{

    private boolean status;
    private String message;
    @JsonProperty("data")
    private TransactionData transactionData;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TransactionData getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(TransactionData transactionData) {
        this.transactionData = transactionData;
    }

    @JsonProperty("status")
    public boolean isSuccessfull() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
