package com.flexisaf.sdk.paystack.json;


/**
 * @author peter
 */

public class TransactionJson {


    private String reference;
    private String amount;
    private String customerEmail;
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

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}