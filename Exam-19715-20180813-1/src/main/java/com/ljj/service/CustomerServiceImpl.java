package com.ljj.service;

import com.ljj.dao.CustomerDao;
import com.ljj.dao.CustomerDaoImpl;
import com.ljj.util.ConnectionFactory;

import java.sql.Connection;
import java.util.Map;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao= new CustomerDaoImpl();
    private Connection connection = ConnectionFactory.getInstance().makeConnection();

    @Override
    public Map<String, Object> getCustomer(String customerName) {

        return customerDao.getCustomer(connection,customerName);
    }
}
