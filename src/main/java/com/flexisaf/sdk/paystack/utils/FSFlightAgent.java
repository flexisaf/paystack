package com.flexisaf.sdk.paystack.utils;

import org.apache.http.client.methods.HttpPost;

/**
 * Created by peter on 12/15/16.
 */
public class FSFlightAgent {

    public void httpPost(String url, String bodyData, String httpHeader) {
        // todo check with regex that is a valid url
        HttpPost httpPost = new HttpPost(url);
    }
}
