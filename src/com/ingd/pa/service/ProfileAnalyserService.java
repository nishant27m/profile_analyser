package com.ingd.pa.service;

import com.ingd.pa.dao.CustomerDao;
import com.ingd.pa.dao.TransactionDao;
import com.ingd.pa.domain.Classification;
import com.ingd.pa.domain.Output;

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
        Map<String, Object> properties = new HashMap<>();
        properties.put("customer", customerDao.getCustomer(customerId, startDate, endDate));
        properties.put("balance", transactionDao.getBalance(customerId, startDate));
        properties.put("customer_id", customerId);
        Set<Classification> classifications = getAllRules().stream().map(rule -> rule.execute(properties))
                .filter(value -> value != null).collect(Collectors.toSet());
        Output output = new Output();
        output.setClassifications(classifications);
        output.setBalance(transactionDao.getBalance(customerId, new Date()));
        output.setTransactions(customerDao.getCustomer(customerId).getAccounts().get(0).getTransactions());
        return output;
    }

    /**
     * This method returns rules to be processed.
     * @return list of rules.
     */
    private List<IExecuteRule> getAllRules() {
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
