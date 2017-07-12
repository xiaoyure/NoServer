package com.cont.service;



import java.util.List;

import com.cont.model.BackModel;
import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;

/**
 * Created by lz on 2017/6/24.
 */
public interface BackService {
	
	//退货单展示
	List<BackModel> backDisplay();
	//退货处理
	int backDeal(BackModel cus);
	
	
}
