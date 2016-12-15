package com.flexisaf.sdk.paystack.json;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author peter
 */

public class TransactionJson {
    private String reference;
    @JsonProperty("amount")
    private Double amount;
    private String email;
    @JsonProperty("callback_url")
    private String callbackUrl;
    @JsonProperty("plan")
    private String plan;
    @JsonProperty("transaction_charge")
    private Integer transactionCharge;


    public Integer getTransactionCharge() {
        return transactionCharge;
    }

    public void setTransactionCharge(Integer transactionCharge) {
        this.transactionCharge = transactionCharge;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String ref) {
        this.reference = ref;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonProperty("amount")
    public Double geAmount() {
        return this.amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}