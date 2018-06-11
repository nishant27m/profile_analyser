package com.ingd.pa.service;

import com.ingd.pa.dao.CustomerDao;
import com.ingd.pa.dao.TransactionDao;
import com.ingd.pa.domain.Customer;
import com.ingd.pa.domain.Type;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * This service will analyse customer data and make classification based on their expense.
 *
 */
public class ProfileAnalyserService {

    /**
     * instance of customer Dao.
     */
    private CustomerDao customerDao = new CustomerDao();

    /**
     * instance of transaction dao.
     */
    private TransactionDao transactionDao = new TransactionDao();

    /**
     * THis function perform analysis on given customer records and returns classification.
     * @param customerId customer id.
     * @param date till date.
     * @return list of customer classification.
     */
    public  List<Type> doAnalysis(int customerId, Date date) {
        Customer customer = customerDao.getCustomer(customerId, date);
        double balance = transactionDao.getBalance(customerId, date);
        return new ArrayList<>();
    }
}
