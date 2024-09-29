package com.crud.dao;
import java.util.*;
import com.crud.pojo.Customer;

public interface CustomerDao {
    boolean addCustomer(Customer cobj);
    boolean updateCustomer(Customer cobj);
    boolean deleteCustomer(int cid);
    List<Customer>showCustomerList();
    Customer searchCustomerById(int cid);
    Customer searchCustomerByEmail(String cemail);
   

}
