package com.cont.model;

public class AddressModel {
	private int addressId;			//地址ID
	private int customerId;			//顾客ID
	private String customerName;	//顾客昵称
	private String customerCname;	//顾客真实姓名
	private String addressStatus;	//地址状态
	private String addressLocation;	//地址详情
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerCname() {
		return customerCname;
	}
	public void setCustomerCname(String customerCname) {
		this.customerCname = customerCname;
	}
	
	public String getAddressStatus() {
		return addressStatus;
	}
	public void setAddressStatus(String addressStatus) {
		this.addressStatus = addressStatus;
	}
	
	public String getAddressLocation() {
		return addressLocation;
	}
	public void setAddressLocation(String addressLocation) {
		this.addressLocation = addressLocation;
	}
	
	
}
