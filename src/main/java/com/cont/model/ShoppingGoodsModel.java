package com.cont.model;
import java.util.List;

import com.cont.utils.SuperModel;


/**
 * Created by lq on 2017/5/18.
 */
public class ShoppingGoodsModel extends SuperModel {
	private int goodsId;			//商品id
	private String goodsName;		//商品名
	private double goodsPrice;		//商品价格
	private String goodsImage;		//商品图片
	private int goodsNum;			//商品购买数量
	
	
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
	
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
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
}
