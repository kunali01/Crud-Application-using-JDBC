package com.crud.test;

import java.util.List;
import java.util.Scanner;
import com.crud.dao.CustomerDaoImp;
import com.crud.pojo.Customer;

public class CustomerTest {

    public static void main(String[] args) {
        int cid;
        String cfname, clname, cgen, cemail, ccontact;
        Scanner sc = new Scanner(System.in);
        Customer cobj = null;
        CustomerDaoImp cdao = new CustomerDaoImp();
        int choice;
        char ch;
        boolean result;
        List<Customer> clist;

        do {
            System.out.println("---- Customer Operations ----");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Show Customer List");
            System.out.println("5. Search Customer by ID");
            System.out.println("6. Search Customer by Email");
            System.out.println("-----------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("---- Add Customer ----");
                    System.out.print("Enter first name: ");
                    cfname = sc.next();
                    System.out.print("Enter last name: ");
                    clname = sc.next();
                    System.out.print("Enter email: ");
                    cemail = sc.next();
                    System.out.print("Enter contact: ");
                    ccontact = sc.next();
                    System.out.print("Enter gender: ");
                    cgen = sc.next();
                    cobj = new Customer(cfname, clname, cgen, cemail, ccontact);
                    result = cdao.addCustomer(cobj);
                    System.out.println(result ? "Customer added successfully" : "Customer not added");
                    break;

                case 2:
                    System.out.println("---- Update Customer ----");
                    System.out.print("Enter ID: ");
                    cid = sc.nextInt();
                    System.out.print("Enter first name: ");
                    cfname = sc.next();
                    System.out.print("Enter last name: ");
                    clname = sc.next();
                    System.out.print("Enter email: ");
                    cemail = sc.next();
                    System.out.print("Enter contact: ");
                    ccontact = sc.next();
                    System.out.print("Enter gender: ");
                    cgen = sc.next();
                    cobj = new Customer(cid, cfname, clname, cgen, cemail, ccontact);
                    result = cdao.updateCustomer(cobj);
                    System.out.println(result ? "Customer updated successfully" : "Customer not updated");
                    break;

                case 3:
                    System.out.println("---- Delete Customer ----");
                    System.out.print("Enter customer ID to delete: ");
                    cid = sc.nextInt();
                    result = cdao.deleteCustomer(cid);
                    System.out.println(result ? "Customer deleted" : "Customer not deleted");
                    break;

                case 4:
                    System.out.println("---- Show Customers ----");
                    clist = cdao.showCustomerList();
                    if (!clist.isEmpty()) {
                        for (Customer c : clist) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("Customer list is empty");
                    }
                    break;

                case 5:
                    System.out.println("---- Search Customer by ID ----");
                    System.out.print("Enter ID: ");
                    cid = sc.nextInt();
                    cobj = cdao.searchCustomerById(cid);
                    if (cobj != null) {
                        System.out.println(cobj);
                    } else {
                        System.out.println("Customer not present");
                    }
                    break;

                case 6:
                    System.out.println("---- Search Customer by Email ----");
                    System.out.print("Enter customer email: ");
                    cemail = sc.next();
                    cobj = cdao.searchCustomerByEmail(cemail);
                    if (cobj != null) {
                        System.out.println(cobj);
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.print("Do you want to continue? Yes - enter y, No - enter n: ");
            ch = sc.next().charAt(0);

        } while (ch == 'y' || ch == 'Y');

        System.out.println("---- Thank You ----");
        sc.close();
    }
}
