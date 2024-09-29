package com.crud.pojo;

public class Customer {

	private int cid;
	private String cfname;
	private String clname;
	private String cgen;
	private String cemail;
	private String ccontact;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer( String cfname, String clname, String cgen, String cemail, String ccontact) {
		super();
		this.cfname = cfname;
		this.clname = clname;
		this.cgen = cgen;
		this.cemail = cemail;
		this.ccontact = ccontact;
	}
	
	public Customer(int cid, String cfname, String clname, String cgen, String cemail, String ccontact) {
		super();
		this.cid = cid;
		this.cfname = cfname;
		this.clname = clname;
		this.cgen = cgen;
		this.cemail = cemail;
		this.ccontact = ccontact;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCfname() {
		return cfname;
	}

	public void setCfname(String cfname) {
		this.cfname = cfname;
	}

	public String getClname() {
		return clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public String getCgen() {
		return cgen;
	}

	public void setCgen(String cgen) {
		this.cgen = cgen;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCcontact() {
		return ccontact;
	}

	public void setCcontact(String ccontact) {
		this.ccontact = ccontact;
	}
   
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cfname=" + cfname + ", clname=" + clname + ", cgen=" + cgen + ", cemail="
				+ cemail + ", ccontact=" + ccontact + "]";
	}

	public static void main(String[] args) {

	}

}
