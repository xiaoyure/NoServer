package com.cont.model;
import java.util.List;

import com.cont.utils.SuperModel;


/**
 * Created by lq on 2017/5/18.
 */
public class GoodsModel extends SuperModel {
	private int goodsId;			//商品id
	private String goodsName;		//商品名
	private int goodsState;			//商品状态
	private int goodsStock;			//商品库存
	private int goodsCategoryId;	//商品类别id
	private double goodsPrice;		//商品价格
	private String goodsImage;		//商品图片
	private int goodsOrder;			//商品浏览顺序
	private String goodsDescription;//商品详情
	private String customerName;	//顾客名字
	
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public int getGoodsState() {
		return goodsState;
	}
	public void setGoodsState(int goodsState) {
		this.goodsState = goodsState;
	}
	
	public int getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}
	
	public int getGoodsCategoryId() {
		return goodsCategoryId;
	}
	public void setGoodsCategoryId(int goodsCategoryId) {
		this.goodsCategoryId = goodsCategoryId;
	}
	
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
	public String getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	
	public int getGoodsOrder() {
		return goodsOrder;
	}
	public void setGoodsOrder(int goodsOrder) {
		this.goodsOrder = goodsOrder;
	}
	
	public String getGoodsDescription() {
		return goodsDescription;
	}
	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
