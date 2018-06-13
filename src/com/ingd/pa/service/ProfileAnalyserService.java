package com.ingd.pa.service;

import com.ingd.pa.dao.CustomerDao;
import com.ingd.pa.dao.TransactionDao;
import com.ingd.pa.domain.Classification;
import com.ingd.pa.domain.Customer;
import com.ingd.pa.domain.Output;
import com.ingd.pa.domain.Type;

import java.util.*;
import java.util.stream.Collectors;

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
     * @param startDate starting date.
     * @param endDate ending date
     * @return list of customer classification.
     */
    public Output doAnalysis(int customerId, Date startDate, Date endDate) throws Exception {
        Output output = new Output();
        double asOfbalance = transactionDao.getBalance(customerId, new Date());
        output.setBalance(asOfbalance);
        Customer customer = customerDao.getCustomer(customerId, startDate, endDate);
        double balance = transactionDao.getBalance(customerId, startDate);
        Map<String, Object> properties = new HashMap<>();
        properties.put("customer", customer);
        properties.put("balance", balance);
        Set<Classification> classifications = getAllRules().stream().map(rule -> rule.execute(properties)).collect(Collectors.toSet());
        output.setClassifications(classifications);
        output.setBalance(asOfbalance);
        return output;
    }

    List<IExecuteRule> getAllRules() {
        List<IExecuteRule> rules = new ArrayList<>();
        rules.add(new AfternoonPerson());
        rules.add(new BigSpender());
        rules.add(new BigTicketSpender());
        rules.add(new FastSpender());
        rules.add(new MorningPerson());
        rules.add(new PotentialSaver());
        return rules;
    }

}
