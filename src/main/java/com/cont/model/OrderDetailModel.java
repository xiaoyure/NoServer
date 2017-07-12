package com.cont.model;
import java.util.List;

import com.cont.utils.SuperModel;
/**
 * Created by lq on 2017/5/18.
 */
public class OrderDetailModel extends SuperModel {
	private String orderGoodsAddress;	//商品图片地址
	private String orderGoodsName;		//商品名称
	private int orderGoodsId;			//商品订单ID
	private double orderGoodsPrice;		//商品单价
	private int orderGoodsNum;			//商品数量
	private double orderGoodsSumPrice;	//商品总价
	
	public String getOrderGoodsAddress() {
		return orderGoodsAddress;
	}
	public void setOrderGoodsAddress(String orderGoodsAddress) {
		this.orderGoodsAddress = orderGoodsAddress;
	}
	
	public String getOrderGoodsName() {
		return orderGoodsName;
	}
	public void setOrderGoodsName(String orderGoodsName) {
		this.orderGoodsName = orderGoodsName;
	}
	
	public int getOrderGoodsId() {
		return orderGoodsId;
	}
	public void setOrderGoodsId(int orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}
	
	public double getOrderGoodsPrice() {
		return orderGoodsPrice;
	}
	public void setOrderGoodsPrice(double orderGoodsPrice) {
		this.orderGoodsPrice = orderGoodsPrice;
	}
	
	public int getOrderGoodsNum() {
		return orderGoodsNum;
	}
	public void setOrderGoodsNum(int orderGoodsNum) {
		this.orderGoodsNum = orderGoodsNum;
	}
	
	public double getOrderGoodsSumPrice() {
		return orderGoodsSumPrice;
	}
	public void setOrderGoodsSumPrice(double orderGoodsSumPrice) {
		this.orderGoodsSumPrice = orderGoodsSumPrice;
	}
	
}
