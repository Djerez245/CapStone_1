package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    LocalTime time;
    LocalDate date;
    String description;
    String vendor;
    double amount;

    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.time = time;
        this.date = date;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%.2f", fmtDate.format(date), fmtTime.format(time), description, vendor, amount);
    }
    public String toStringForConsole(){
        return String.format("Date: %-1s|Time: %-1s|Description: %-16s|Vendor: %-12s|Amount: %.2f", fmtDate.format(date), fmtTime.format(time), description, vendor, amount);
    }
    static DateTimeFormatter fmtDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static DateTimeFormatter fmtTime = DateTimeFormatter.ofPattern("HH:mm:ss");
}

