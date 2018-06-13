package com.ingd.pa.service;

import com.ingd.pa.domain.Classification;

import java.util.Map;

/**
 * This class will check for following classification.
 * Spends over 75% of any deposit within 7 days of making it
 */
public class FastSpender implements IExecuteRule {

    @Override
    public Classification execute(Map<String, Object> context) {
        return null;
    }
}
