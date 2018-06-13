package com.ingd.pa.dao;

import com.ingd.pa.domain.Transaction;
import com.ingd.pa.domain.TransactionType;
import com.ingd.pa.util.CommonUtility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class has implementation of Transaction Dao
 */
public class TransactionDao {

    private static final String FILE_PATH = "./data/transaction.csv";

    Function<String, Transaction> mapper = line ->  {
        String[] data = line.split(",");
        TransactionType type = "credit".equals(data[5]) ? TransactionType.CREDIT : TransactionType.DEBIT;
        Transaction transaction = null;
        try {
            transaction = new Transaction(Integer.parseInt(data[0])
                                                    , CommonUtility.getDate(data[1], CommonUtility.SIMPLE_FORMAT)
                                                    , Double.parseDouble(data[2])
                                                    , Integer.parseInt(data[3]), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transaction;
    };

    /**
     * This method will return all transactions for given account id.
     * @param accountId account id
     * @return list of transactions.
     */
    public List<Transaction> getTransactions(int accountId) throws Exception {
        List<Transaction> transactions =
        Files.lines(Paths.get(FILE_PATH)).skip(1).map(mapper)
                .filter(transaction -> transaction.getAccountId() == accountId)
                .collect(Collectors.toList());
        return transactions;
    }

    /**
     * THis method will return all transactions for given account id and in given date range.
     * @param accountId account id
     * @param startDate start date
     * @param endDate end date
     * @return list of transactions.
     */
    public List<Transaction> getTransactions(int accountId, Date startDate, Date endDate) throws Exception {
        List<Transaction> transactions =
        Files.lines(Paths.get(FILE_PATH)).skip(1).map(mapper)
                .filter(transaction -> transaction.getAccountId() == accountId
                                    && transaction.getTransactionDate().after(startDate)
                                    && transaction.getTransactionDate().before(endDate))
                .collect(Collectors.toList());
        return transactions;
    }

    /**
     * This method returns account balance as of date.
     * @param accountId account id
     * @param asofDate as of date
     * @return balance.
     */
    public double getBalance(int accountId, Date asofDate) throws Exception {
        double balance =
        Files.lines(Paths.get(FILE_PATH)).skip(1).map(mapper)
                .filter(transaction -> transaction.getAccountId() == accountId
                                    && transaction.getTransactionDate().before(asofDate)
                                    && transaction.getTransactionType() == TransactionType.CREDIT)
                .mapToDouble(transaction  -> transaction.getAmount()).sum();
        return balance;
    }

}
