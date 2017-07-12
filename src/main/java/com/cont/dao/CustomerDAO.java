package com.cont.dao;

import java.util.List;

import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;



/**
 * CompanyDAO
 */
public interface CustomerDAO {
	
	//客户登录
	List<CustomerModel> customerLogin(CustomerModel model);
	
	//客户注册
	int customerRegister(CustomerModel model);
	int customerRegister2(CustomerModel cus);
	//管理员客户信息展示
	List<CustomerModel> customerDisplay();
	
	//个人中心顾客信息展示
	List<CustomerModel> customerBack(CustomerModel ord);
	//顾客信息修改
	void customerUpdate(CustomerModel ord);
	//顾客密码修改
	int PasswordUpdate(CustomerModel ord);
	
	//顾客收藏夹
	List<GoodsModel> collectDisplay(GoodsModel model);
	//顾客收藏夹删除物品
	List<GoodsModel> collectDelete(GoodsModel model);
	//加入购物车
	int addShopping1(GoodsModel model);
	int addShopping2(GoodsModel model);
	int addShopping3(GoodsModel model);
	//加入收藏夹
	int addCollect(GoodsModel model);
	
}



