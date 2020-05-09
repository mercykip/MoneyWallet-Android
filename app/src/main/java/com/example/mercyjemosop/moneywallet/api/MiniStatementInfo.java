package com.example.mercyjemosop.moneywallet.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class MiniStatementInfo {
    @SerializedName("transactionId")
    @Expose
    private Integer transactionId;
    @SerializedName("customerId")
    @Expose
    private Integer customerId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("accountBalance")
    @Expose
    private Integer accountBalance;
    @SerializedName("trasactionType")
    @Expose
    private String trasactionType;
    @SerializedName("charges")
    @Expose
    private Integer charges;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getTrasactionType() {
        return trasactionType;
    }

    public void setTrasactionType(String trasactionType) {
        this.trasactionType = trasactionType;
    }

    public Integer getCharges() {
        return charges;
    }

    public void setCharges(Integer charges) {
        this.charges = charges;
    }
}
