package com.cont.service;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cont.model.AddressModel;


/**
 * Created by lz on 2017/6/24.
 */
@Transactional
public interface CommitOrderService {
	
	//返回顾客地址
	List<AddressModel> addressChosen(AddressModel addr);
	
	//提交订单
	void submitOrder(String username);

}
