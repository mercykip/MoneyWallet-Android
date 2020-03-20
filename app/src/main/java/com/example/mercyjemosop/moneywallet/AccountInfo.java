package com.example.mercyjemosop.moneywallet;

public class AccountInfo {
    private Integer amount;
    private Integer pin;



    private Integer tax;
    private Integer  charges;

    public AccountInfo(Integer amount, Integer tax, Integer charges,Integer pin) {
        this.amount = amount;
        this.tax = tax;
        this.charges = charges;
        this.pin = pin;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Integer getCharges() {
        return charges;
    }

    public void setCharges(Integer charges) {
        this.charges = charges;
    }
}
