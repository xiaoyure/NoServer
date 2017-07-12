package com.cont.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cont.dao.BackDAO;
import com.cont.dao.CommitOrderDAO;
import com.cont.dao.CustomerDAO;
import com.cont.dao.GoodsDAO;
import com.cont.dao.OrderDAO;
import com.cont.model.AddressModel;
import com.cont.model.BackModel;
import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.model.OrderModel;
import com.cont.service.BackService;
import com.cont.service.CommitOrderService;
import com.cont.service.CustomerService;
import com.cont.service.GoodsService;
import com.cont.utils.Encode;
import com.cont.utils.StatusCodeConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lz on 2017/6/24.
 */
@Service
public class CommitOrderServiceImpl implements CommitOrderService {

	@Autowired
    private CommitOrderDAO commitOrderDAO;
	
	//返回顾客地址
	public List<AddressModel> addressChosen(AddressModel addr) {
		List<AddressModel> resultList = commitOrderDAO.addressChosen(addr);
		return resultList;
	}
	
	//提交订单
	public void submitOrder(String username){
		commitOrderDAO.insertOrder(username);
		commitOrderDAO.insertOrderDetail(username);
		commitOrderDAO.updateGoods(username);
		commitOrderDAO.deleteShoppingDetails(username);
		commitOrderDAO.deleteShopping(username);
	}
	
}
