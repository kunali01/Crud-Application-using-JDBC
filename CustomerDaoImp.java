package com.crud.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.crud.pojo.Customer;
import com.crud.utility.DBConnection;

public class CustomerDaoImp implements CustomerDao {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	int result;

	public CustomerDaoImp() {
		try {
			conn = DBConnection.getConnect();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public boolean addCustomer(Customer cobj) {
		try {
			System.out.println("inside add customer dao");
			sql = "insert into customernew(fname,lname,contact,gender,email)values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cobj.getCfname());
			ps.setString(2, cobj.getClname());
			ps.setString(3, cobj.getCcontact());
			ps.setString(4, cobj.getCgen());
			ps.setString(5, cobj.getCemail());
			System.out.println("Query:" + ps);
			result = ps.executeUpdate();
			if (result > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer cobj) {
		try {
			System.out.println("inside add customer dao");
			sql = "update customernew set fname=?,lname=?,contact=?,gender=?,email=? where cid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cobj.getCfname());
			ps.setString(2, cobj.getClname());
			ps.setString(3, cobj.getCcontact());
			ps.setString(4, cobj.getCgen());
			ps.setString(5, cobj.getCemail());
			ps.setString(6, cobj.getCemail());
			System.out.println("Query:" + ps);
			result = ps.executeUpdate();
			if (result > 0)
				return true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int cid) {
		Customer c = searchCustomerById(cid);
		if (c != null) {
			sql = "delete from customernew where cid=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, cid);
				System.out.println("Query:" + ps);
				result = ps.executeUpdate();
				if (result > 0)
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<Customer> showCustomerList() {
		List<Customer> clist = new ArrayList<Customer>();
		try {

			sql = "select *from customernew";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
//				c=new Customer();
//				c.setCid(rs.getInt(1));
//				c.setCfname(rs.getString(2));
//				c.setClname(rs.getString(3));
//				c.setCcontact(rs.getString(4));
//				c.setCemail(rs.getString(5));
//				c.setCgen(rs.getString(6));
				Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				clist.add(c);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return clist;
	}

	@Override
	public Customer searchCustomerById(int cid) {
		Customer c = null;
		try {
			sql = "select *from customernew where cid=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			System.out.println("query:" + ps);
			rs = ps.executeQuery();
			if (rs.next()) {
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return c;
	}

	@Override
	public Customer searchCustomerByEmail(String cemail) {
		Customer c = null;
		try {
			sql = "select * from customernew where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cemail);
			System.out.println("query:" + ps);
			rs = ps.executeQuery();
			if (rs.next()) {
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
