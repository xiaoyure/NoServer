package com.cont.model;

import com.cont.utils.SuperModel;

public class CommentModel extends SuperModel {
	private int commentId;			//评论ID
	private int customerId;			//顾客ID
	private String customerName;	//顾客姓名
	private int customerCreditLevel;//顾客信用级别
	private int goodsId;			//商品ID
	private String commentStatus;		//评论状态
	private int commentLevel;		//评论星级
	private String commentContent;	//评论内容
	private String commentTime;		//评论时间
	
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
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
	
	public int getCustomerCreditLevel() {
		return customerCreditLevel;
	}
	public void setCustomerCreditLevel(int customerCreditLevel) {
		this.customerCreditLevel = customerCreditLevel;
	}
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	public String getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	
	public int getCommentLevel() {
		return commentLevel;
	}
	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}
	
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	
}
