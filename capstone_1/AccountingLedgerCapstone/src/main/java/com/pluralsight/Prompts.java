package com.pluralsight;

public class Prompts {
    public static void printPrompt(String p) {
        System.out.print(p);
    }

    public static String homeScreen = """
            =======================================
               Welcome to the Accounting Ledger
            =======================================
            (D) Add Deposit
            (P) Make Payment
            (L) Ledger
            (X) Exit
            """;
    public static String ledger = """
            ===========================
                      Ledger
            ===========================
            (A) All
            (D) Deposits
            (P) Payments
            (R) Reports
            (S) Custom Search
            (H) Go back to home page
            """;
    public static String reports = """
            ===========================
                      Reports
            ===========================
            (1) Month to Date
            (2) Previous Month
            (3) Year to Date
            (4) Previous year
            (5) Search by Vendor
            (0) Back
            """;
    public static String addDepositDescription = "Enter description: ";

    public static String addDepositAmount = "Enter Amount of deposit: ";

    public static String addDepositVendor = "Enter the vendor : ";

    public static String makePaymentDescription = "What was the payment for? ";

    public static String makePaymentAmount = "how much was the payment? ";

    public static String addPaymentVendor = "Enter the vendor : ";



}
