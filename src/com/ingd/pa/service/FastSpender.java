package com.ingd.pa.service;

import com.ingd.pa.dao.CustomerDao;
import com.ingd.pa.domain.Classification;
import com.ingd.pa.domain.Customer;

import java.util.Map;

/**
 * This class will check for following classification.
 * Spends over 75% of any deposit within 7 days of making it
 */
public class FastSpender implements IExecuteRule {

    CustomerDao customerDao = new CustomerDao();

    @Override
    public Classification execute(Map<String, Object> context) {
        int customer_id = (Integer) context.get("customer_id");
        boolean isFastSpender = false;
        return isFastSpender ? Classification.Fast_Spender : null;
    }
}
