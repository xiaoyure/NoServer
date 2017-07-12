package com.cont.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cont.dao.CustomerDAO;
import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.model.ShoppingGoodsModel;
import com.cont.service.CustomerService;
import com.cont.utils.Encode;
import com.cont.utils.StatusCodeConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lz on 2017/5/18.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

	@Override  //客户登录
	public List<CustomerModel> customerLogin(String cus_name, String cus_password) {
		String password = Encode.encode(cus_password);
		CustomerModel model = new CustomerModel();
		model.setCustomerName(cus_name);
		model.setCustomerPassword(password);
	    List<CustomerModel> resultList = customerDAO.customerLogin(model);

	    return resultList;
	}

	@Override  //客户注册
	public int customerRegister(CustomerModel cus) {
		// TODO Auto-generated method stub
		String customerPassword = Encode.encode(cus.getCustomerPassword());
		cus.setCustomerPassword(customerPassword);
		cus.setCustomerCreditLevel(5);
		int resultList = customerDAO.customerRegister(cus);
		int re = customerDAO.customerRegister2(cus);
		if(re!=0&&resultList!=0) return 1;
		else return 0;
	}

	@Override  //管理员客户信息展示
	public List<CustomerModel> customerDisplay() {
		List<CustomerModel> resultList = customerDAO.customerDisplay();
		return resultList;
	}
	
	//个人中心顾客信息展示
	@Override
	public List<CustomerModel> customerBack(CustomerModel ord) {
		List<CustomerModel> resultList=customerDAO.customerBack(ord);
		return resultList;
	}
	//顾客信息修改
	@Override
	public void customerUpdate(CustomerModel ord) {
		customerDAO.customerUpdate(ord);
	}
	//顾客密码修改
	@Override
	public int PasswordUpdate(CustomerModel ord) {
		String newpassword = Encode.encode(ord.getNewcustomerPassword());
		String oldpassword = Encode.encode(ord.getCustomerPassword());
		ord.setNewcustomerPassword(newpassword);
		ord.setCustomerPassword(oldpassword);
		int resultList=customerDAO.PasswordUpdate(ord);
		return resultList;
	}
	
	@Override //顾客收藏夹
	public List<GoodsModel> collectDisplay(GoodsModel model) {
		List<GoodsModel> resultList = customerDAO.collectDisplay(model);
		return resultList;
	}
	
	@Override //顾客收藏夹删除物品
	public List<GoodsModel> collectDelete(GoodsModel model) {
		List<GoodsModel> resultList = customerDAO.collectDelete(model);
		return resultList;
	}
	
	//加入购物车
	public int addShopping(GoodsModel model) {
		int resultList1 = customerDAO.addShopping1(model);
		int resultList2 = customerDAO.addShopping2(model);
		int resultList3 = customerDAO.addShopping3(model);
		return resultList1 + resultList2 + resultList3;
	}
	
	//加入收藏
	public int addCollect(GoodsModel model){
		int resultList = customerDAO.addCollect(model);
		return resultList;
	}
	

}
