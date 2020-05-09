package com.example.mercyjemosop.moneywallet.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("response_status")
    @Expose
    private Boolean responseStatus;
    @SerializedName("response_message")
    @Expose
    private String responseMessage;
    @SerializedName("response_name")
    @Expose
    private String responseName;
    @SerializedName("response_address")
    @Expose
    private String responseAddress;
    @SerializedName("response_email")
    @Expose
    private String responseEmail;
    @SerializedName("response_account_number")
    @Expose
    private String responseAccountNumber;
    @SerializedName("response_gender")
    @Expose
    private String responseGender;
    @SerializedName("response_nationalid")
    @Expose
    private String responseNationalid;
    @SerializedName("response_user")
    @Expose
    private String responseUser;
    @SerializedName("response_phonenumber")
    @Expose
    private Integer responsePhonenumber;
    @SerializedName("response_confirmpin")
    @Expose
    private Integer responseConfirmpin;
    @SerializedName("response_pin")
    @Expose
    private Integer responsePin;

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

    public String getResponseName() {
        return responseName;
    }

    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }

    public String getResponseAddress() {
        return responseAddress;
    }

    public void setResponseAddress(String responseAddress) {
        this.responseAddress = responseAddress;
    }

    public String getResponseEmail() {
        return responseEmail;
    }

    public void setResponseEmail(String responseEmail) {
        this.responseEmail = responseEmail;
    }

    public String getResponseAccountNumber() {
        return responseAccountNumber;
    }

    public void setResponseAccountNumber(String responseAccountNumber) {
        this.responseAccountNumber = responseAccountNumber;
    }

    public String getResponseGender() {
        return responseGender;
    }

    public void setResponseGender(String responseGender) {
        this.responseGender = responseGender;
    }

    public String getResponseNationalid() {
        return responseNationalid;
    }

    public void setResponseNationalid(String responseNationalid) {
        this.responseNationalid = responseNationalid;
    }

    public String getResponseUser() {
        return responseUser;
    }

    public void setResponseUser(String responseUser) {
        this.responseUser = responseUser;
    }

    public Integer getResponsePhonenumber() {
        return responsePhonenumber;
    }

    public void setResponsePhonenumber(Integer responsePhonenumber) {
        this.responsePhonenumber = responsePhonenumber;
    }

    public Integer getResponseConfirmpin() {
        return responseConfirmpin;
    }

    public void setResponseConfirmpin(Integer responseConfirmpin) {
        this.responseConfirmpin = responseConfirmpin;
    }

    public Integer getResponsePin() {
        return responsePin;
    }

    public void setResponsePin(Integer responsePin) {
        this.responsePin = responsePin;
    }

}
