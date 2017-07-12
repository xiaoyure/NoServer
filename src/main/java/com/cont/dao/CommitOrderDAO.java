package com.cont.dao;

import java.util.List;

import com.cont.model.AddressModel;



/**
 * GoodsDAO
 */
//DAO只能穿一个参数进来，一个对象或者一个字符串
public interface CommitOrderDAO {
	
	//返回顾客地址
	List<AddressModel> addressChosen(AddressModel addr);
	
	//提交订单
	void insertOrder(String username);
	void insertOrderDetail(String username);
	void updateGoods(String username);
	void deleteShoppingDetails(String username);
	void deleteShopping(String username);
}



