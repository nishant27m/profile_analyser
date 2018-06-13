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
        System.out.println("Enter month (e.g. July): ");
        String sDate = reader.next();
        System.out.println("Enter year (e.g. 2018): ");
        String sYear = reader.next();
        Date startDate = CommonUtility.getFirstDate(sDate, sYear);
        Date endDate = CommonUtility.getLastDate(sDate, sYear);
        reader.close();
        ProfileAnalyserService  paService = new ProfileAnalyserService();
        Output output = paService.doAnalysis(customerId, startDate, endDate);
        printOutput(output);
    }

    private static void printOutput(Output output) throws Exception {
        DecimalFormat df2 = new DecimalFormat(".##");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Classification : ");
        output.getClassifications().stream().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------");

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Account Balance : "+ df2.format(output.getBalance()));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %10s %10s", "Transaction Id", "Date", "Amount", "Account Id", "Type");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(Transaction transaction : output.getTransactions()){
            System.out.format("%10d %20s %20.3f %10d %10s",
                    transaction.getTransactionId(), CommonUtility.getDateInString(transaction.getTransactionDate(), CommonUtility.SIMPLE_FORMAT)
                    , transaction.getAmount()
                    , transaction.getAccountId(), transaction.getTransactionType());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

}
