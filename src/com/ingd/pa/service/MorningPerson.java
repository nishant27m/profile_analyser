package com.ingd.pa.service;

import com.ingd.pa.domain.Classification;

import java.util.Map;

/**
 * This class will check for following classification.
 * Morning Person	Makes over 50% of their transactions in the month before midday (count of transactions)
 */
public class MorningPerson implements IExecuteRule {

    @Override
    public Classification execute(Map<String, Object> context) {
        return null;
    }
}
