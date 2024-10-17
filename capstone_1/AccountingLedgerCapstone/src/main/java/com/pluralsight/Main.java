package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    private static Scanner scanner;
    static ArrayList<Transaction> accountLedger = new ArrayList<>();
    static LocalDateTime dateTime = LocalDateTime.now();
    static DateTimeFormatter fmtDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static DateTimeFormatter fmtTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    static DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("MM");

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("transactions.csv", true);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        Scanner scanner = new Scanner(System.in);


        boolean ledgerRunning = true;
        AddDepositAndPaymentMethods.createTransactions();// loading transactions from csv file.
        LedgerMethods.sortArray();

        while (ledgerRunning) {

            Prompts.printPrompt(Prompts.homeScreen);                 // prints home screen
            String userInput = scanner.nextLine();                   // get user input

            switch (userInput) {

                case "D", "d":
                    boolean addToDeposit = true;
                    while (addToDeposit) {
                        AddDepositAndPaymentMethods.addDeposit();   // Method for user to add a deposit
                        addToDeposit = false;
                    }
                    break;
                case "P", "p":
                    boolean addPayment = true;
                    while (addPayment) {
                        AddDepositAndPaymentMethods.addPayment();   // method for user to add a payment
                        addPayment = false;
                    }
                    break;
                case "L", "l":
                    boolean inLedger = true;
                    while (inLedger) {
                        Prompts.printPrompt(Prompts.ledger);                    // prints out the ledger screen
                        String ledgerInput = scanner.nextLine();                // gets user input for the ledger
                        if (ledgerInput.equalsIgnoreCase("a")) {
                            LedgerMethods.printAllTransactions();               // Method that prints all transactions
                            break;
                        }
                        if (ledgerInput.equalsIgnoreCase("d")) {
                            LedgerMethods.sortArray();
                            LedgerMethods.printDeposits();                      // Method that only prints deposits
                            break;
                        }
                        if (ledgerInput.equalsIgnoreCase("p")) {
                            LedgerMethods.sortArray();
                            LedgerMethods.printPayments();                      // method that only prints payments
                            break;
                        }
                        if (ledgerInput.equalsIgnoreCase("h")) {    // for user to go back to the home screen
                            break;
                        }
                        if (ledgerInput.equalsIgnoreCase("s")){
                            LedgerMethods.customSearch();                      // Method for user to do a custom Search
                        }
                        if (ledgerInput.equalsIgnoreCase("r"))
                            Prompts.printPrompt(Prompts.reports);             // Prints out the reports menu
                        int reportInput = scanner.nextInt();
                        scanner.nextLine();
                        if (reportInput == 1) {
                            LedgerMethods.monthToDate();   // Method to calculate month to date
                        }
                        if (reportInput == 2) {
                            LedgerMethods.previousMonth(); // Method to calculate previous month
                        }
                        if (reportInput == 3){
                            LedgerMethods.yearToDate();    // Method to calculate year to date
                        }
                        if (reportInput == 4){
                            LedgerMethods.previousYear();  // Method to calculate previous year
                        }
                        if (reportInput == 5){
                            LedgerMethods.vendorSearch();  // Method to search the ArrayList to find all transactions have the vendor that the user wants to search for
                        }                                  // DOESN'T SEARCH IF USER LEAVES AN INPUT BLANK
                        if (accountLedger.isEmpty()) {
                            System.out.println(Prompts.red + "\nOh no!  your ledger is empty\n" + Prompts.reset); // If user doesn't have anything in their ledger they will be prompted that their ledger is empty
                            inLedger = false;
                        }
                    }
                    break;
                case "X", "x":
                    ledgerRunning = false;  //Ends the program
                    break;
                default:
                    System.out.println(Prompts.red + "Invalid input try again" + Prompts.reset); // if the user inputs an incorrect input then they are prompted to try again.
            }
        }
        buffWriter.close();
    }

}
