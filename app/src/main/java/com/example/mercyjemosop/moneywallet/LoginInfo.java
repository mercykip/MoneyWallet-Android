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
    @SerializedName("response_user")
    @Expose
    private String responseUser;
    @SerializedName("response_pin")
    @Expose
    private String responsePin;

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

    public String getResponseUser() {
        return responseUser;
    }

    public void setResponseUser(String responseUser) {
        this.responseUser = responseUser;
    }

    public String getResponsePin() {
        return responsePin;
    }

    public void setResponsePin(String responsePin) {
        this.responsePin = responsePin;
    }
}


