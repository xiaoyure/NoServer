package com.cont.model;
import java.util.List;

import com.cont.utils.SuperModel;
/**
 * Created by lq on 2017/5/18.
 */
public class OrderModel extends SuperModel {
	private String orderCustomerName;	//顾客姓名
	private String orderUserName;		//顾客昵称
	private int orderId;				//订单id
	private String orderStatus;			//订单状态
	private double orderSumPrice;		//订单总价
	private String orderCreateTime;		//订单创建时间
	private String orderBackTime;       //订单退货时间
	private String reason;              //退货原因
	private String comment;             //订单评价
	private int score;                  //评论级别
	private String status;              //是否匿名
	
	
	public String getOrderBackTime() {
		return orderBackTime;
	}
	public void setOrderBackTime(String orderBackTime) {
		this.orderBackTime = orderBackTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderCustomerName() {
		return orderCustomerName;
	}
	public void setOrderCustomerName(String orderCustomerName) {
		this.orderCustomerName = orderCustomerName;
	}
	
	public String getOrderUserName() {
		return orderUserName;
	}
	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public double getOrderSumPrice() {
		return orderSumPrice;
	}
	public void setOrderSumPrice(double orderSumPrice) {
		this.orderSumPrice = orderSumPrice;
	}
	
	public String getOrderCreateTime() {
		return orderCreateTime;
	}
	public void setOrderCreateTime(String orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}
	
}
