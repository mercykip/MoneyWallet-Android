package com.example.mercyjemosop.moneywallet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Withdraw{
        @SerializedName("response_status")
        @Expose
        private Boolean responseStatus;
        @SerializedName("response_message")
        @Expose
        private String responseMessage;
        @SerializedName("Response_amount")
        @Expose
        private Integer responseAmount;
        @SerializedName("Response_accountNumber")
        @Expose
        private String responseAccountNumber;

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

        public Integer getResponseAmount() {
            return responseAmount;
        }

        public void setResponseAmount(Integer responseAmount) {
            this.responseAmount = responseAmount;
        }

        public String getResponseAccountNumber() {
            return responseAccountNumber;
        }

        public void setResponseAccountNumber(String responseAccountNumber) {
            this.responseAccountNumber = responseAccountNumber;
        }
}
