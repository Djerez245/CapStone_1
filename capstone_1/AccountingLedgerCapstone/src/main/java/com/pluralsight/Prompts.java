package com.pluralsight;

public class Prompts {
     static String reset = "\u001B[0m";
     static String red = "\u001B[0;31m";
     static String green = "\u001B[0;32m";
     static String blue = "\u001B[0;34m";



    public static void printPrompt(String p) {
        System.out.print(p);
    }

    public static String homeScreen =  blue +"""
            ==============================================
                  Welcome to the Accounting Ledger
            ==============================================
            (D) Add Deposit
            (P) Make Payment
            (L) Ledger
            (X) Exit
            """ +reset;
    public static String ledger = blue + """
            ===========================
                      Ledger
            ===========================
            (A) All
            (D) Deposits
            (P) Payments
            (R) Reports
            (S) Custom Search
            (H) Go back to home page
            """ + reset;
    public static String reports = blue + """
            ===========================
                      Reports
            ===========================
            (1) Month to Date
            (2) Previous Month
            (3) Year to Date
            (4) Previous year
            (5) Search by Vendor
            (0) Back
            """ + reset;

    public static String addDepositDescription = "Enter description: ";

    public static String addDepositAmount = "Enter Amount of deposit: ";

    public static String addDepositVendor = "Enter the vendor : ";

    public static String makePaymentDescription = "What was the payment for? ";

    public static String makePaymentAmount = "how much was the payment? ";

    public static String addPaymentVendor = "Enter the vendor : ";



}
