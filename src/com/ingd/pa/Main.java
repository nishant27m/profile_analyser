package com.ingd.pa;

import  com.ingd.pa.service.ProfileAnalyserService;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        int customerId = 0;
        Date date = new Date();
        ProfileAnalyserService  paService = new ProfileAnalyserService();
        paService.doAnalysis(customerId, date);
    }
}
