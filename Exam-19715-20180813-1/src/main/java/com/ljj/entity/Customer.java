package com.ljj.entity;

/**
 * @author bce1100
 * @date 2018/8/13.
 */
public class Customer {
    private short customerId;
    private String firstName;

    public short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
