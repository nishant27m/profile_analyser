package com.ingd.pa;

import com.ingd.pa.domain.Output;
import  com.ingd.pa.service.ProfileAnalyserService;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws Exception {
        int customerId = 0;
        Date date = new Date();
        ProfileAnalyserService  paService = new ProfileAnalyserService();
        Output output = paService.doAnalysis(customerId, date, date);

    }
}
