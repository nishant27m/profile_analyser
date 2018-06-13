package com.ingd.pa.dao;

import com.ingd.pa.domain.Account;
import com.ingd.pa.util.CommonUtility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class implements CRUD operations for Account.
 */
public class AccountDao {

    private static final String FILE_PATH = "./data/account.csv";

    Function<String, Account> mapper = line ->  {
        String[] data = line.split(",");
        Account account = null;
        try {
            account = new Account(Integer.parseInt(data[0]), Integer.parseInt(data[1]), CommonUtility.getDate(data[2], CommonUtility.SIMPLE_FORMAT),
                                 Double.parseDouble(data[3]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    };

    /**
     * instance of transaction Dao.
     */
    private TransactionDao transactionDao = new TransactionDao();

    /**
     * This method returns list of accounts for given customer id.
     * @param customerId customer id.
     * @return list of accounts.
     */
    public List<Account> getAccounts(int customerId) throws Exception {
        List<Account> accounts = Files.lines(Paths.get(FILE_PATH)).skip(1).map(mapper)
                .filter(cust -> cust.getCustomerId() == customerId).collect(Collectors.toList());
        accounts.forEach(account -> {
            try {
                account.setTransactions(transactionDao.getTransactions(account.getAccountId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return accounts;
    }

    /**
     * This method returns list of accounts for given customer id with given date range.
     * @param customerId customer id.
     * @param startDate start date.
     * @param endDate end date.
     * @return list of accounts.
     */
    public List<Account> getAccounts(int customerId, Date startDate, Date endDate) throws Exception{
        List<Account> accounts = Files.lines(Paths.get(FILE_PATH)).skip(1).map(mapper)
                .filter(cust -> cust.getCustomerId() == customerId).collect(Collectors.toList());
        accounts.forEach(account -> {
            try {
                account.setTransactions(transactionDao.getTransactions(account.getAccountId(), startDate, endDate));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return accounts;
    }
}
