package com.bcsg.card;

import java.time.YearMonth;

public class CreditCard {

    private String bankName;
    private String pan;
    private String maskedPan;
    private YearMonth expiryDate;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public YearMonth getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(YearMonth expiryDate) {
        this.expiryDate = expiryDate;
    }

    public CreditCard(String bankName, String pan, YearMonth expiryDate) {
        this(bankName, pan, null, expiryDate);
    }

    public CreditCard(String bankName, String pan, String maskedPan, YearMonth expiryDate) {
        this.bankName = bankName;
        this.pan = pan;
        this.maskedPan = maskedPan;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard that = (CreditCard) o;

        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (pan != null ? !pan.equals(that.pan) : that.pan != null) return false;
        return !(expiryDate != null ? !expiryDate.equals(that.expiryDate) : that.expiryDate != null);

    }

    @Override
    public int hashCode() {
        int result = bankName != null ? bankName.hashCode() : 0;
        result = 31 * result + (pan != null ? pan.hashCode() : 0);
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "bankName='" + bankName + '\'' +
                ", pan='" + pan + '\'' +
                ", maskedPan='" + maskedPan + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }

    public String prettyPrint() {
        return bankName + " " + pan + " " + maskedPan + " " + expiryDate;
    }
}
