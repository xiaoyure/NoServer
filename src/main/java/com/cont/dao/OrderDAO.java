package com.cont.dao;

import java.util.List;

import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.model.OrderDetailModel;
import com.cont.model.OrderModel;


/**
 * GoodsDAO
 */
//DAO只能穿一个参数进来，一个对象或者一个字符串
public interface OrderDAO {
	
	//订单展示
	List<OrderModel> orderDisplay();
	
	//订单详情展示
	List<OrderDetailModel> orderDetailDisplay(OrderDetailModel ordm);
	//订单更新
	int orderUpdateSum();
	
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
	void goodsBack(OrderModel ord);//订单表修改状态
	void goodsBackAdd(OrderModel ord);//新增退货表
	//顾客收货操作
	List<OrderModel> goodsReceive(OrderModel ord);
	//顾客评价操作
	void goodsComment(OrderModel ord);//订单表修改状态
	void goodsCommentAdd(OrderModel ord);//新增评价表
	//管理员发货操作
	int goodsSend(OrderModel ord);
	
}



