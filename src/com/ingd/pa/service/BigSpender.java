package com.ingd.pa.service;

import com.ingd.pa.domain.Classification;

import java.util.Map;

/**
 * This class will check for following classification.
 * Spends over 80% of their deposits every month ($ value of deposits)
 */
public class BigSpender implements IExecuteRule {

    @Override
    public Classification execute(Map<String, Object> context) {
        return null;
    }
}
