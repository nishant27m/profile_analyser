package com.ingd.pa.dao;

import com.ingd.pa.domain.Customer;
import com.ingd.pa.util.CommonUtility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.function.Function;


/**
 * This class has implementation of CRUD operations.
 *
 */
public class CustomerDao {

    private static final String FILE_PATH = "data/customer.csv";

    Function<String, Customer> mapper = line ->  {
        String[] data = line.split(",");
        Customer customer = null;
        try {
            customer = new Customer(Integer.parseInt(data[0]), data[1], data[2], CommonUtility.getDate(data[3].trim(), CommonUtility.SIMPLE_DATE));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    };


    /**
     * instance of account dao.
     */
    private AccountDao accountDao = new AccountDao();

    /**
     * THis method returns instance of Customer for given customerId.
     * @param customerId customer id.
     * @return instance of Customer
     */
    public Customer getCustomer(int customerId) throws Exception {
        Customer customer = Files.lines(Paths.get(ClassLoader.getSystemResource(FILE_PATH).toURI())).skip(1).map(mapper)
                           .filter(cust -> cust.getCustomerId() == customerId).findFirst().get();
        customer.setAccounts(accountDao.getAccounts(customerId));
        return customer;
    }

    /**
     * This methhod return instance of Customer based on customer id and account transaction for given date range.
     * @param customerId customer id.
     * @param startDate start date
     * @param endDate end date
     * @return instance of Customer.
     */
    public Customer getCustomer(int customerId, Date startDate, Date endDate) throws Exception {
        Customer customer = Files.lines(Paths.get(ClassLoader.getSystemResource(FILE_PATH).toURI())).skip(1).map(mapper)
                           .filter(cust -> cust.getCustomerId() == customerId).findFirst().get();
        customer.setAccounts(accountDao.getAccounts(customerId, startDate, endDate));
        return customer;
    }

}
