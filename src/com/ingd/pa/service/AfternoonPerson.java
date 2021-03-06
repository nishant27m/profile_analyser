package com.ingd.pa.service;

import com.ingd.pa.domain.Classification;
import com.ingd.pa.domain.Customer;
import com.ingd.pa.domain.Transaction;
import com.ingd.pa.domain.TransactionType;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * This class will check for following classification.
 * Afternoon Person	Makes over 50% of their transactions in the month after midday (count of transactions)
 */
public class AfternoonPerson implements IExecuteRule {

    @Override
    public Classification execute(Map<String, Object> context) {
        Customer customer = (Customer) context.get("customer");
        List<Transaction> transactions = customer.getAccounts().get(0).getTransactions();
        long totalTransactions = transactions.size();
        long pmTransaction = transactions.stream().filter(transaction -> transaction.getTransactionType() == TransactionType.DEBIT)
                             .filter(transaction -> {
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(transaction.getTransactionDate());
                                    int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
                                    return (timeOfDay >= 12 && timeOfDay < 16);
                               }).count();
        long percentage = (pmTransaction / totalTransactions) * 100;
        return percentage > 50 ? Classification.Afternoon_Person : null;
    }
}
