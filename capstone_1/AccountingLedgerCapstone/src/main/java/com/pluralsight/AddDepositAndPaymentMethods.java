package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class AddDepositAndPaymentMethods {

    static FileWriter fileWriter;

    static {
        try {
            fileWriter = new FileWriter("transactions.csv", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedWriter buffWriter = new BufferedWriter(fileWriter);


    public static void addDeposit() throws IOException {
        Scanner scanner = new Scanner(System.in);
            Prompts.printPrompt(Prompts.addDepositDescription);
            String d = scanner.nextLine();
            Prompts.printPrompt(Prompts.addDepositAmount);
            double a = scanner.nextDouble();
            scanner.nextLine();
            Prompts.printPrompt(Prompts.addDepositVendor);
            String v = scanner.nextLine();
            LocalDateTime dateTime = LocalDateTime.now();
            Transaction deposit = new Transaction(dateTime.toLocalDate(), dateTime.toLocalTime(), d, v, a);
            Main.accountLedger.add(0, deposit);
            buffWriter.write(deposit.toString() + "\n"); //this depends on transaction having a toString method
            buffWriter.close();
            System.out.println("\nyour deposit has been successfully added!\n");
        }

        public static void addPayment() throws IOException {
            Scanner scanner = new Scanner(System.in);
            Prompts.printPrompt(Prompts.makePaymentDescription);
            String dp = scanner.nextLine();
            Prompts.printPrompt(Prompts.makePaymentAmount);
            double ap = scanner.nextDouble();
            scanner.nextLine();
            Prompts.printPrompt(Prompts.addPaymentVendor);
            String vp = scanner.nextLine();
            LocalDateTime dateTimePay = LocalDateTime.now();
            Transaction payment = new Transaction(dateTimePay.toLocalDate(), dateTimePay.toLocalTime(), dp, vp, -ap);
            Main.accountLedger.add(0, payment);
            buffWriter.write(payment.toString() + "\n");
            buffWriter.close();
            System.out.println("\nYour payment has been successfully added!\n");
        }

    public static void createTransactions() throws IOException {
        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader buffReader = new BufferedReader(fileReader);

        String input;
        while ((input = buffReader.readLine()) != null) {
            String[] entry = input.split("\\|");
            String date = entry[0];
            String time = entry[1];
            String description = entry[2];
            String vendor = entry[3];
            double amount = Double.parseDouble(entry[4]);
            Transaction transaction = new Transaction(LocalDate.parse(date, Main.fmtDate), LocalTime.parse(time, Main.fmtTime), description, vendor, amount);
            Main.accountLedger.add(transaction);
        }
    }


    }


































