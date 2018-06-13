package com.ingd.pa.service;

import com.ingd.pa.dao.CustomerDao;
import com.ingd.pa.domain.Classification;
import com.ingd.pa.domain.Customer;
import com.ingd.pa.domain.Transaction;
import com.ingd.pa.domain.TransactionType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Calendar;

/**
 * This class will check for following classification.
 * Spends over 75% of any deposit within 7 days of making it
 */
public class FastSpender implements IExecuteRule {

    CustomerDao customerDao = new CustomerDao();

    @Override
    public Classification execute(Map<String, Object> context) {
        int customer_id = (Integer) context.get("customer_id");
        try {
            Customer customer = customerDao.getCustomer(customer_id);
            List<Transaction> transactions = customer.getAccounts().get(0).getTransactions().stream()
                    .filter(transaction -> transaction.getTransactionType() == TransactionType.CREDIT)
                    .collect(Collectors.toList());
            boolean isFastSpender = false;
            for(Transaction transaction : transactions) {
                Calendar c =  Calendar.getInstance();
                c.setTime(transaction.getTransactionDate());
                c.add(Calendar.DATE, 7);
                double amountSpent = customerDao.getCustomer(customer_id, transaction.getTransactionDate(), c.getTime())
                        .getAccounts().get(0).getTransactions().stream()
                        .filter(transaction1 -> transaction.getTransactionType() == TransactionType.DEBIT)
                        .mapToDouble(transaction2 -> transaction.getAmount()).sum();
                double percentage = (amountSpent / transaction.getAmount()) * 100;
                if(percentage >= 75) {
                    isFastSpender = true;
                    break;
                }
            }
            return isFastSpender ? Classification.Fast_Spender : null;
        }
        catch(Exception e) {
            return null;
        }

    }
}
