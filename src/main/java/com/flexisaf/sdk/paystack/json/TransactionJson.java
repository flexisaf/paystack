package com.flexisaf.sdk.paystack.json;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author peter
 */

public class TransactionJson {


    private String reference;
    private String amount;
    private String email;
    @JsonProperty("callback_url")
    private String callbackUrl;

    public String getReference() {
        return this.reference;
    }

    public void setReference(String ref) {
        this.reference = ref;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String geAmount() {
        return this.amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}