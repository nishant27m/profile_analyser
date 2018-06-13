package com.ingd.pa.service;

import com.ingd.pa.domain.Classification;

import java.util.Map;

public interface IExecuteRule {

    Classification execute(Map<String, Object> context);

}


