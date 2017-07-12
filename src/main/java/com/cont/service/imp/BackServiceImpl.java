package com.cont.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cont.dao.BackDAO;
import com.cont.dao.CustomerDAO;
import com.cont.dao.GoodsDAO;
import com.cont.model.BackModel;
import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.service.BackService;
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
public class BackServiceImpl implements BackService {

    @Autowired
    private BackDAO backDAO;
	
	//退货订单展示
	public List<BackModel> backDisplay() {
		List<BackModel> resultList = backDAO.backDisplay();
		return resultList;
	}
	//退货订单处理
	@Override
	public int backDeal(BackModel cus) {
		int flag1 = backDAO.backDeal(cus);
		System.out.println(flag1);
		int flag2 = backDAO.backDeal2(cus);
		System.out.println(flag2);
		int flag3 = backDAO.updateGoods(cus);
		System.out.println(flag3);
		if(flag1!=0 && flag2!=0 && flag3!=0) return 1;
		else return 0;
	}

	
}
