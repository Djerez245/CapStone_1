package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;



//public class DisplayMethods {


//    static FileWriter fileWriter = new FileWriter("transactions.csv");
//    static BufferedWriter buffWriter = new BufferedWriter(fileWriter);
//
//    public DisplayMethods() throws IOException {
//    }
//
//
//    public static void addDeposit() {
//        Scanner scanner = new Scanner(System.in);
//        Prompts.printPrompt(Prompts.addDepositDescription);
//        String d = scanner.nextLine();
//        Prompts.printPrompt(Prompts.addDepositAmount);
//        double a = scanner.nextDouble();
//        Prompts.printPrompt(Prompts.addDepositVendor);
//        String v = scanner.nextLine();
//        LocalDateTime dateTime = LocalDateTime.now();
//
//        Transaction deposit = new Transaction(dateTime.toLocalDate(), dateTime.toLocalTime(), d, v, a);
//        Main.accountLedger.add(deposit);
//        buffWriter.write(deposit.toString()); //this depends on transaction having a toString method
//        buffWriter.close();
//
//    }
//
//    public static void addPayment() throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        Prompts.printPrompt(Prompts.makePaymentDescription);
//        String d = scanner.nextLine();
//        Prompts.printPrompt(Prompts.makePaymentAmount);
//        double a = scanner.nextDouble();
//        Prompts.printPrompt(Prompts.addPaymentVendor);
//        String v = scanner.nextLine();
//        LocalDateTime dateTime = LocalDateTime.now();
//        Transaction payment = new Transaction(dateTime.toLocalDate(), dateTime.toLocalTime(), d, v, a);
//        Main.accountLedger.add(payment);
//        buffWriter.write(payment.toString());
//        buffWriter.close();
//
//
//    }
//}
