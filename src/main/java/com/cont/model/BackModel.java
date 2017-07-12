package com.cont.model;

public class BackModel {
	private int odetailsId;
	private int orderId;
	private int goodsId;
	private String goodsName;
	private int backNum;
	private int backCondition;
	private String backReason;
	private String createTime;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getOdetailsId() {
		return odetailsId;
	}
	public void setOdetailsId(int odetailsId) {
		this.odetailsId = odetailsId;
	}
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	public String getGoodsName(){
		return goodsName;
	}
	
	public void setGoodsName(String goodsName){
		this.goodsName=goodsName;
	}
	
	public int getBackNum(){
		return backNum;
	}
	
	public void setBackNum(int backNum){
		this.backNum=backNum;
	}
	
	public int getBackCondition() {
		return backCondition;
	}
	public void setBackCondition(int backCondition) {
		this.backCondition = backCondition;
	}
	
	public String getBackReason() {
		return backReason;
	}
	public void setBackReason(String backReason) {
		this.backReason = backReason;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
