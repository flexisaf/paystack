package com.flexisaf.sdk.paystack.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by peter on 12/15/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    private Integer id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
}
