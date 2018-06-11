package com.ingd.pa.dao;

import com.ingd.pa.domain.Customer;
import java.util.Date;

/**
 * This class has implementation of CRUD operations.
 *
 */
public class CustomerDao {

    /**
     * instance of account dao.
     */
    private AccountDao accountDao = new AccountDao();

    /**
     * THis method returns instance of Customer for given customerId.
     * @param customerId customer id.
     * @return instance of Customer
     */
    public Customer getCustomer(int customerId) {
        Customer customer = new Customer();
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
    public Customer getCustomer(int customerId, Date startDate, Date endDate) {
        Customer customer = new Customer();
        customer.setAccounts(accountDao.getAccounts(customerId, startDate, endDate));
        return customer;
    }
}
