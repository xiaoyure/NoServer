package com.cont.model;
import com.cont.utils.SuperModel;
/**
 * Created by lq on 2017/5/18.
 */
public class CustomerModel extends SuperModel {
	private int customerId;				//顾客id
	private String customerCname;		//顾客姓名
	private int customerSex;			//顾客性别
	private String customerPhone;		//顾客电话
	private String customerEmail;		//顾客邮箱
	private int customerCreditLevel;	//顾客信用级别
	private String customerName;		//顾客登录名
	private String customerPassword;	//顾客密码
	private String newcustomerPassword; //顾客新密码
	private String customerAddress;     //顾客地址
	
	public String getNewcustomerPassword() {
		return newcustomerPassword;
	}
	public void setNewcustomerPassword(String newcustomerPassword) {
		this.newcustomerPassword = newcustomerPassword;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerCname() {
		return customerCname;
	}
	public void setCustomerCname(String customerCname) {
		this.customerCname = customerCname;
	}
	
	public int getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(int customerSex) {
		this.customerSex = customerSex;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public int getCustomerCreditLevel() {
		return customerCreditLevel;
	}
	public void setCustomerCreditLevel(int customerCreditLevel) {
		this.customerCreditLevel = customerCreditLevel;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
}
