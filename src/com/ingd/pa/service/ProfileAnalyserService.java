package com.ingd.pa.service;

import com.ingd.pa.dao.CustomerDao;
import com.ingd.pa.domain.Type;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class ProfileAnalyserService {

    private CustomerDao customerDao = new CustomerDao();

    public List<Type> getCustomerType() {
        return new ArrayList<>();
    }

    public void doAnalysis(int customerId, Date date) {
        

    }
}
