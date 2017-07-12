package com.cont.model;

public class NumModel {
	private int customerNum;  //顾客总数
	private int goodsNum;     //商品总数
	private int orderNum;	  //订单总数
	private int priceSum;	  //价格总数
	public int getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getPriceSum() {
		return priceSum;
	}
	public void setPriceSum(int priceSum) {
		this.priceSum = priceSum;
	}
	
}
