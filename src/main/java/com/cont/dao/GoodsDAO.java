package com.cont.dao;

import java.util.HashMap;
import java.util.List;

import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.model.ShoppingGoodsModel;


/**
 * GoodsDAO
 */
//DAO只能穿一个参数进来，一个对象或者一个字符串
public interface GoodsDAO {
	
	//商品上架
	List<GoodsModel> goodsOnsell(GoodsModel modal);
	//商品展示
	List<GoodsModel> goodsDisplay();
	//商品下架
	List<GoodsModel> goodsSoldout(GoodsModel cus);
	
	//顾客商品展示，返回条目数
	public int selectCount(GoodsModel goods);
	//顾客商品展示，返回具体
	public List<GoodsModel> backDisplay(GoodsModel model);
	//商品详情
	List<GoodsModel> goodsDetailDisplay(GoodsModel goods);
	
	//商品搜索返回信息
	List<String> goodsSearch(String count);
	//通过商品Id返回数据
	GoodsModel goodsSearchDisplay(String key);
	
	//购物车
	List<ShoppingGoodsModel> shoppingcartDisplay(CustomerModel cus);
	//购物车删除
	List<ShoppingGoodsModel> shoppingcartDelete(HashMap<String,String> maps);
	//商品下架双击变上架
	int updateonsell(GoodsModel ord);
	//总展示
	int customerNum();
	int goodsNum();
	int orderNum();
	int sumNum();
	
}



