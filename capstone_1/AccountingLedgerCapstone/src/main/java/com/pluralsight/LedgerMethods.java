package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

public class LedgerMethods {

    public static void printAllTransactions(){
        for (Transaction ledger : Main.accountLedger) {
            System.out.println(ledger.toStringForConsole());
        }
    }


    public static void printDeposits() {
        for (Transaction deposits : Main.accountLedger) {
            if (deposits.getAmount() > 0) {
                System.out.println(deposits.toStringForConsole());
            }

        }
    }

    public static void printPayments(){
        for (Transaction payments : Main.accountLedger) {
            if (payments.getAmount() < 0) {
                System.out.println(payments.toStringForConsole());
            }
        }
    }

    public static void monthToDate(){
        for (Transaction mtd : Main.accountLedger) {
            if (mtd.getDate().getMonth().equals(LocalDate.now().getMonth())) {
                System.out.println(mtd.toStringForConsole());
            }
        }
    }

    public static void yearToDate(){
        for (Transaction ytd : Main.accountLedger){
            if (ytd.getDate().getYear() == LocalDate.now().getYear()) {
                System.out.println("\n" + ytd.toStringForConsole());
            }
        }
    }

    public static void vendorSearch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What vendor would you like to see?");
        String vSearch = scanner.nextLine();
        for(Transaction search : Main.accountLedger)
            if(search.getVendor().equalsIgnoreCase(vSearch)){
                System.out.println(search.toStringForConsole());
            }
    }

    public static void previousYear(){
        for (Transaction previousYear : Main.accountLedger){
            if (previousYear.getDate().getYear() == (LocalDate.now().getYear())-1){
                System.out.println("\n" + previousYear.toStringForConsole());
            }
        }
    }

    public static void previousMonth(){
        for (Transaction previousMonth : Main.accountLedger) {
            int a = Integer.parseInt(LocalDate.now().format(Main.fmt3));
            int b = Integer.parseInt(previousMonth.getDate().format(Main.fmt3));
            if ( b == a - 1){
                System.out.println("\n" + previousMonth.toStringForConsole());
            }
        }
    }

}
