package com.pluralsight;

public class Ledger {
    String time;
    String date;
    String description;
    String vendor;
    double amount;

    public Ledger(String time, String date, String description, String vendor, double amount) {
        this.time = time;
        this.date = date;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

