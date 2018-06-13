package com.ingd.pa.service;

import com.ingd.pa.domain.Classification;

import java.util.Map;

/**
 * This class will check for following classification.
 * Spends less than 25% of their deposits every month ($ value of deposits.
 */
public class PotentialSaver implements IExecuteRule {

    @Override
    public Classification execute(Map<String, Object> context) {
        return null;
    }
}
