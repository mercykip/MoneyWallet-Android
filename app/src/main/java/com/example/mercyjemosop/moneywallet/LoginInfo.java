package com.example.mercyjemosop.moneywallet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginInfo {
    @SerializedName("response_status")
    @Expose
    private Boolean responseStatus;
    @SerializedName("response_message")
    @Expose
    private String responseMessage;
    @SerializedName("customer_id")
    @Expose
    private Integer customerId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("pin")
    @Expose
    private Integer pin;

    public LoginInfo( Integer customerId, String username, Integer pin) {

        this.customerId = customerId;
        this.username = username;
        this.pin = pin;
    }

    public Boolean getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

}



