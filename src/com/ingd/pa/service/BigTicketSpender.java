package com.ingd.pa.service;

import com.ingd.pa.domain.Classification;
import com.ingd.pa.domain.Customer;
import com.ingd.pa.domain.Transaction;
import com.ingd.pa.domain.TransactionType;

import java.util.List;
import java.util.Map;

/**
 * This class will check for following classification.
 * Big Ticket Spender	Makes one or more withdrawals over $1000 in the month
 */
public class BigTicketSpender implements IExecuteRule {

    @Override
    public Classification execute(Map<String, Object> context) {
        Customer customer = (Customer) context.get("customer");
        List<Transaction> transactions = customer.getAccounts().get(0).getTransactions();
        boolean isBigTicketSpender = transactions.stream()
                .anyMatch(transaction -> transaction.getTransactionType() == TransactionType.DEBIT && transaction.getAmount() > 1000);
        return isBigTicketSpender ? Classification.Big_Ticket_Spender : null;
    }
}
