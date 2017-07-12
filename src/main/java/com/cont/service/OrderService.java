package com.cont.service;

import java.util.List;
import com.cont.model.OrderDetailModel;
import com.cont.model.OrderModel;

/**
 * Created by lz on 2017/6/24.
 */
public interface OrderService {
	
	//店铺订单展示
	List<OrderModel> orderDisplay();
	
	//店铺订单详情展示
	List<OrderDetailModel> orderDetailDisplay(OrderDetailModel ordm);
	
	//顾客订单展示
	List<OrderModel> informationDisplay(OrderModel ord);
	
	//顾客待收货订单展示
	List<OrderModel> receiveDisplay(OrderModel ord);
	//顾客待发货展示
	List<OrderModel> sendDisplay(OrderModel ord);
	//顾客待评价展示
	List<OrderModel> CommentDisplay(OrderModel ord);
	//顾客退货展示
	List<OrderModel> goodsBackDisplay(OrderModel ord);
	
	//顾客退货操作
	//订单表状态修改
	void goodsBack(OrderModel ord);
	//新增退货表
	void goodsBackAdd(OrderModel ord);
	//顾客收货操作
	List<OrderModel> goodsReceive(OrderModel ord);
	//顾客评价操作
	//修改订单表状态
	void goodsComment(OrderModel ord);
	//评价表新增
	void goodsCommentAdd(OrderModel ord);
	
	//管理员发货操作
	int goodsSend(OrderModel ord);
	
	
}
