package com.example.mercyjemosop.moneywallet.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginInfo {
    @SerializedName("response_status")
    @Expose
    private Boolean responseStatus;
    @SerializedName("response_message")
    @Expose
    private String responseMessage;
    @SerializedName("response_customerId")
    @Expose
    private Integer responseCustomerId;
    @SerializedName("response_username")
    @Expose
    private String responseUsername;
    @SerializedName("response_pin")
    @Expose
    private Integer responsePin;


    public LoginInfo(Integer responseCustomerId, String responseUsername, Integer responsePin) {
        this.responseCustomerId = responseCustomerId;
        this.responseUsername = responseUsername;
        this.responsePin = responsePin;
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

    public Integer getResponseCustomerId() {
        return responseCustomerId;
    }

    public void setResponseCustomerId(Integer responseCustomerId) {
        this.responseCustomerId = responseCustomerId;
    }

    public String getResponseUsername() {
        return responseUsername;
    }

    public void setResponseUsername(String responseUsername) {
        this.responseUsername = responseUsername;
    }

    public Integer getResponsePin() {
        return responsePin;
    }

    public void setResponsePin(Integer responsePin) {
        this.responsePin = responsePin;
    }
}



