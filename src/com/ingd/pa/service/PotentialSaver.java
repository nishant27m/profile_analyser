package com.ingd.pa.service;

import com.ingd.pa.domain.Classification;
import com.ingd.pa.domain.Customer;
import com.ingd.pa.domain.Transaction;
import com.ingd.pa.domain.TransactionType;

import java.util.List;
import java.util.Map;

/**
 * This class will check for following classification.
 * Spends less than 25% of their deposits every month ($ value of deposits.
 */
public class PotentialSaver implements IExecuteRule {

    @Override
    public Classification execute(Map<String, Object> context) {
        Customer customer = (Customer) context.get("customer");
        Double balance = (Double) context.get("balance");
        List<Transaction> transactions = customer.getAccounts().get(0).getTransactions();
        Double spentAmount = transactions.stream().filter(transaction -> transaction.getTransactionType() == TransactionType.DEBIT)
                .mapToDouble(transaction -> transaction.getAmount()).sum();
        Double percentage = spentAmount / balance * 100;
        return percentage < 25 ? Classification.Potential_Saver : null;
    }
}
