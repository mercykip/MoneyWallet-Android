package com.example.mercyjemosop.moneywallet;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class WithdthrawInfo {
    //@SerializedName("response_status")
    private Integer customer_id;
    @Expose
    private Boolean responseStatus;

    public Integer getCustomer_id() {
        return customer_id;
    }

    @SerializedName("response_message")
    @Expose
    private String responseMessage;
    @SerializedName("response_tax")
    @Expose
    private Integer responseTax;
    @SerializedName("response_charges")
    @Expose
    private Integer responseCharges;
    @SerializedName("response_balance")
    @Expose
    private Integer responseBalance;

//    public Boolean getResponseStatus() {
//        return responseStatus;
//    }

//    public void setResponseStatus(Boolean responseStatus) {
//        this.responseStatus = responseStatus;
//    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Integer getResponseTax() {
        return responseTax;
    }

    public void setResponseTax(Integer responseTax) {
        this.responseTax = responseTax;
    }

    public Integer getResponseCharges() {
        return responseCharges;
    }

    public void setResponseCharges(Integer responseCharges) {
        this.responseCharges = responseCharges;
    }

    public Integer getResponseBalance() {
        return responseBalance;
    }

    public void setResponseBalance(Integer responseBalance) {
        this.responseBalance = responseBalance;
    }

}
