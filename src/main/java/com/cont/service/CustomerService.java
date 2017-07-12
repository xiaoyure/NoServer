package com.cont.service;



import java.util.List;

import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.model.ShoppingGoodsModel;

/**
 * Created by lz on 2017/5/18.
 */
public interface CustomerService {
	//顾客登录
	List<CustomerModel> customerLogin(String cus_name, String cus_password);
	//顾客注册
	int customerRegister(CustomerModel cus);
    //顾客展示
	List<CustomerModel> customerDisplay();
	
	//顾客收藏夹
	List<GoodsModel> collectDisplay(GoodsModel model);
	//顾客收藏夹删除物品
	List<GoodsModel> collectDelete(GoodsModel model);
	//个人中心顾客信息展示
	List<CustomerModel> customerBack(CustomerModel ord);
	//顾客信息修改
	void customerUpdate(CustomerModel ord);
	//顾客密码修改
	int PasswordUpdate(CustomerModel ord);
	
	//加入购物车
	int addShopping(GoodsModel goods);
	//加入收藏
	int addCollect(GoodsModel goods);
}
