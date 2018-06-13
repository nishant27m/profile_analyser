package com.ingd.pa;

import com.ingd.pa.domain.Output;
import com.ingd.pa.domain.Transaction;
import com.ingd.pa.service.ProfileAnalyserService;
import com.ingd.pa.util.CommonUtility;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter customer id (1 / 2/ 3): ");
        int customerId = reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println("Enter date (e.g. July 2018): ");
        String sDate = reader.next();
        String[] dateSplit = sDate.split(" ");
        Date startDate = CommonUtility.getFirstDate(dateSplit[0], dateSplit[1]);
        Date endDate = CommonUtility.getLastDate(dateSplit[0], dateSplit[1]);
        reader.close();
        ProfileAnalyserService  paService = new ProfileAnalyserService();
        Output output = paService.doAnalysis(customerId, startDate, endDate);
        printOutput(output);
    }

    private static void printOutput(Output output) {
        DecimalFormat df2 = new DecimalFormat(".##");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Classification : ");
        output.getClassifications().stream().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------");

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Account Balance : "+ df2.format(output.getBalance()));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %30s %20s %10s %10s", "Transaction Id", "Date", "Amount", "Account Id", "Type");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(Transaction transaction : output.getTransactions()){
            System.out.format("%10d %30s %20d %10d %10s",
                    transaction.getTransactionId(), transaction.getTransactionDate(), transaction.getAmount()
                    , transaction.getAccountId(), transaction.getTransactionType());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

}
