package com.cont.dao;

import java.util.List;

import com.cont.model.BackModel;
import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;


/**
 * GoodsDAO
 */
//DAO只能穿一个参数进来，一个对象或者一个字符串
public interface BackDAO {
	//退货表展示
	List<BackModel> backDisplay();
	//退货表处理
	int backDeal(BackModel cus);
	int backDeal2(BackModel cus);
	int updateGoods(BackModel cus);
}



