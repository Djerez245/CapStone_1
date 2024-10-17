package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LedgerMethods {

    public static void sortArray(){
        Comparator<Transaction> comparator = (d1,d2) -> {return (d1.getDate()).compareTo(d2.getDate()); };
        Collections.sort(Main.accountLedger,comparator.reversed());
    }



    public static void printAllTransactions(){
        for (Transaction ledger : Main.accountLedger) {
            System.out.println(ledger.toStringForConsole());
        }
    }


    public static void printDeposits() {
        for (Transaction deposits : Main.accountLedger) {
            if (deposits.getAmount() > 0) {
                sortArray();
                System.out.println(deposits.toStringForConsole());
            }

        }
    }

    public static void printPayments(){
        for (Transaction payments : Main.accountLedger) {
            if (payments.getAmount() < 0) {
                sortArray();
                System.out.println(payments.toStringForConsole());
            }
        }
    }

    public static void monthToDate(){
        for (Transaction mtd : Main.accountLedger) {
            if (mtd.getDate().getMonth().equals(LocalDate.now().getMonth())) {
                sortArray();
                System.out.println(mtd.toStringForConsole());
            }
        }
    }

    public static void yearToDate(){
        for (Transaction ytd : Main.accountLedger){
            if (ytd.getDate().getYear() == LocalDate.now().getYear()) {
                sortArray();
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
                sortArray();
                System.out.println(search.toStringForConsole());
            }
    }

    public static void previousYear(){
        for (Transaction previousYear : Main.accountLedger){
            if (previousYear.getDate().getYear() == (LocalDate.now().getYear())-1){
                sortArray();
                System.out.println("\n" + previousYear.toStringForConsole());
            }
        }
    }

    public static void previousMonth(){
        for (Transaction previousMonth : Main.accountLedger) {
            int a = Integer.parseInt(LocalDate.now().format(Main.fmt3));
            int b = Integer.parseInt(previousMonth.getDate().format(Main.fmt3));
            if ( b == a - 1){
                sortArray();
                System.out.println("\n" + previousMonth.toStringForConsole());
            }
        }
    }
    public static void customSearch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start date(yyyy-MM-dd): ");
        String startDateInput = scanner.nextLine();
        System.out.println("Enter end date(yyyy-MM-dd): ");
        String endDateInput = scanner.nextLine();
        System.out.println("Enter Description: ");
        String description = scanner.nextLine();
        System.out.println("Enter Vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter amount: ");
        String amountString = scanner.nextLine();
        double amount = 0.0;
        LocalDate startDate = null;
        LocalDate endDate = null;


        if (!startDateInput.isEmpty()){
            startDate = LocalDate.parse(startDateInput);
        }
        if (!endDateInput.isEmpty()){
            endDate = LocalDate.parse(endDateInput);
        }
        for (Transaction t : Main.accountLedger){
            LocalDate searchDate = t.getDate();
            String searchDescription = t.getDescription();
            String searchVendor = t.getVendor();
            double searchAmount = t.getAmount();

            boolean dateMatches = true;
            boolean descriptionMatches = true;
            boolean vendorMatches = true;
            boolean amountMatches = true;

            if (startDate != null && searchDate.isBefore(startDate)){
                dateMatches = false;
            }
            if (endDate != null && searchDate.isAfter(endDate)){
                dateMatches = false;
            }
            if (!description.isEmpty() && !searchDescription.equalsIgnoreCase(description)){
                descriptionMatches = false;
            }
            if (!vendor.isEmpty() && !searchVendor.equalsIgnoreCase(vendor)){
                vendorMatches = false;
            }
            if (searchAmount != amount){
                amountMatches = false;
            }
            if(dateMatches && descriptionMatches && vendorMatches && amountMatches){
                System.out.println(t.toStringForConsole());
            }


        }
    }

}
//        try{
//            amount = Double.parseDouble(amountString);
//        }
//        catch (Exception e) {
//        }
//        try{
//        startDate = LocalDate.parse(startDateInput); // made sure dates where entered correctly and easier to write the code
//        endDate = LocalDate.parse(endDateInput); }
//        catch(DateTimeParseException e){
//        }
//        for (Transaction t : Main.accountLedger){
//            LocalDate searchDate = t.getDate(); // made the code easier to write because of headaches
//            String searchDescription = t.getDescription(); // made the code easier to write because of headaches
//            double searchAmount = t.getAmount(); // made the code easier to write because of headaches
//            String stringSearchAmount = String.valueOf(searchAmount);
//
//            if ((startDate == null) || (searchDate.isAfter(startDate) || (searchDate.isEqual(startDate))) && // Make sure start date falls under the correct parameters
//                    ((endDate == null) || (searchDate.isBefore(endDate) || (searchDate.isEqual(endDate)) && // Make sure end date falls under the correct parameters
//                    (description.equals("")) || (searchDescription.equalsIgnoreCase(description)) &&
//                            (amount == 0) || (searchAmount == amount)))) { // make sure the description and amount falls under the correct parameters
//                System.out.println(t.toStringForConsole()); // print out search
//            }
//        }
