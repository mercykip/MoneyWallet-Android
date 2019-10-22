package com.example.mercyjemosop.moneywallet;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Balance {


    @SerializedName("response_status")
    @Expose
    private Boolean responseStatus;
    @SerializedName("response_message")
    @Expose
    private String responseMessage;
    @SerializedName("response_password")
    @Expose
    private String responsePassword;
    @SerializedName("response_form_password")
    @Expose
    private String responseFormPassword;
    @SerializedName("response_amount")
    @Expose
    private Integer responseAmount;

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

    public String getResponsePassword() {
        return responsePassword;
    }

    public void setResponsePassword(String responsePassword) {
        this.responsePassword = responsePassword;
    }

    public String getResponseFormPassword() {
        return responseFormPassword;
    }

    public void setResponseFormPassword(String responseFormPassword) {
        this.responseFormPassword = responseFormPassword;
    }

    public Integer getResponseAmount() {
        return responseAmount;
    }

    public void setResponseAmount(Integer responseAmount) {
        this.responseAmount = responseAmount;
    }
}
