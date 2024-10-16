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


    public Main() throws IOException {
    }


    private static void createTransactions() throws IOException {
        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader buffReader = new BufferedReader(fileReader);

        String input;
        while ((input = buffReader.readLine()) != null) {
            String[] entry = input.split("\\|");
            String date = entry[0];
            String time = entry[1];
            String description = entry[2];
            String vendor = entry[3];
            Double amount = Double.parseDouble(entry[4]);
            Transaction transaction = new Transaction(LocalDate.parse(date, fmtDate), LocalTime.parse(time, fmtTime), description, vendor, amount);
            accountLedger.add(transaction);
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("transactions.csv");
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        Scanner scanner = new Scanner(System.in);


        boolean ledgerRunning = true;
        createTransactions(); // loading transactions from csv file.
        Prompts.printPrompt(Prompts.homeScreen); // prints home screen


        while (ledgerRunning) {
            String userInput = scanner.nextLine(); // get user input

            switch (userInput) {
                case "D", "d":
                    Prompts.printPrompt(Prompts.addDepositDescription);
                    String d = scanner.nextLine();
                    Prompts.printPrompt(Prompts.addDepositAmount);
                    double a = scanner.nextDouble();
                    scanner.nextLine();
                    Prompts.printPrompt(Prompts.addDepositVendor);
                    String v = scanner.nextLine();
                    LocalDateTime dateTime = LocalDateTime.now();
                    Transaction deposit = new Transaction(dateTime.toLocalDate(), dateTime.toLocalTime(), d, v, a);
                    accountLedger.add(deposit);
                    buffWriter.write(deposit.toString() + "\n"); //this depends on transaction having a toString method
                    buffWriter.flush();
                    System.out.println("your deposit has been successfully added!");
                    break;
                case "P", "p":
                    Prompts.printPrompt(Prompts.makePaymentDescription);
                    String dp = scanner.nextLine();
                    Prompts.printPrompt(Prompts.makePaymentAmount);
                    double ap = scanner.nextDouble();
                    scanner.nextLine();
                    Prompts.printPrompt(Prompts.addPaymentVendor);
                    String vp = scanner.nextLine();
                    LocalDateTime dateTimePay = LocalDateTime.now();
                    Transaction payment = new Transaction(dateTimePay.toLocalDate(), dateTimePay.toLocalTime(), dp, vp, "-"ap);
                    accountLedger.add(payment);
                    buffWriter.write(payment.toString() + "\n");
                    buffWriter.flush();
                    System.out.println("Your payment has been successfully added!");
                    break;
                case "L", "l":
                    boolean inLedger = true;
                    while (inLedger) {
                        Prompts.printPrompt(Prompts.ledger);
                        String ledgerInput = scanner.nextLine();
                        if (ledgerInput.equalsIgnoreCase("a")) {
                            for (Transaction ledger : accountLedger) {
                                System.out.println(Prompts.ledger);
                            }
                        }
                        if (accountLedger.isEmpty()) {
                            System.out.println(" Oh no! your ledger is empty");
                            inLedger = false;
                        }

                        System.out.println("\nEnter X to back to home Screen");
                        String exit = scanner.nextLine();
                        if (exit.equalsIgnoreCase("x")) {
                            inLedger = false;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid input try again");
            }
            buffWriter.close();
        }
    }
}
