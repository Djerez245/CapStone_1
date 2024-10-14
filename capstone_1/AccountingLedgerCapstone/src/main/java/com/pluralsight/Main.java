package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {

    FileWriter fileWriter = new FileWriter();
    BufferedWriter buffWriter = new BufferedWriter(fileWriter);
    private static Scanner scanner;


    public static void printPrompt(String p) {
        System.out.println(p);
    }
    private static String homeScreen = """
            =======================================
               Welcome to the Accounting Ledger
            =======================================
            1. Add Deposit
            2. Make Payment
            3. Ledger
            4. Exit
            """;
    private static String ledger = """
            ===========================
                      Ledger
            ===========================
            1. All
            2. Deposits
            3. Payments
            4. Reports
            5. Back to Home Screen
            """;
    private static String reports = """
            ===========================
                      Reports
            ===========================
            1. Month to Date
            2. Previous Month
            3. Year to Date
            4. Previous Month
            5. Search by Vendor
            0. Back
            """;
    private static void createEntries() throws IOException {
        FileReader fileReader = new FileReader();
        BufferedReader buffReader = new BufferedReader(fileReader);

        String input;
        while ((input = buffReader.readLine()) != null){
            String[] entry = input.split("\\|");
            String date = entry[0];
            String time = entry[1];
            String description = entry[2];
            String vendor = entry[3];
            String amount = entry[4];
            Ledger ledgerEntries = new Ledger(date, time, description, vendor, amount);

        }
    }

    public static void main(String[] args) throws IOException {

        boolean ledger = true;

        while (ledger) {

            createEntries();
            String userInput = homeScreen;
            scanner.nextLine();

            switch (userInput){
                case "1":
            }




        }


    }
}
