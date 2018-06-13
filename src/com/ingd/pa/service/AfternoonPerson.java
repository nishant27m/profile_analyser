package com.ingd.pa.service;

import com.ingd.pa.domain.Classification;

import java.util.Map;

/**
 * This class will check for following classification.
 * Afternoon Person	Makes over 50% of their transactions in the month after midday (count of transactions)
 */
public class AfternoonPerson implements IExecuteRule {

    @Override
    public Classification execute(Map<String, Object> context) {
        return null;
    }
}
