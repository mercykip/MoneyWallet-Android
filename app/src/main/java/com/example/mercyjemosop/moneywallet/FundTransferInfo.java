package com.example.mercyjemosop.moneywallet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FundTransferInfo {

    @SerializedName("response_status")
    @Expose
    private Boolean responseStatus;
    @SerializedName("response_message")
    @Expose
    private String responseMessage;
    @SerializedName("ReceiverAccountNumber")
    @Expose
    private String receiverAccountNumber;
    @SerializedName("SendingAmount")
    @Expose
    private Integer sendingAmount;
    @SerializedName("ReceiverBalance")
    @Expose
    private Integer receiverBalance;
    @SerializedName("SenderBalance")
    @Expose
    private Integer senderBalance;

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

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public Integer getSendingAmount() {
        return sendingAmount;
    }

    public void setSendingAmount(Integer sendingAmount) {
        this.sendingAmount = sendingAmount;
    }

    public Integer getReceiverBalance() {
        return receiverBalance;
    }

    public void setReceiverBalance(Integer receiverBalance) {
        this.receiverBalance = receiverBalance;
    }

    public Integer getSenderBalance() {
        return senderBalance;
    }

    public void setSenderBalance(Integer senderBalance) {
        this.senderBalance = senderBalance;
    }
}
