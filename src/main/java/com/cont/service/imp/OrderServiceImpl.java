package com.cont.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cont.dao.OrderDAO;
import com.cont.model.OrderDetailModel;
import com.cont.model.OrderModel;
import com.cont.service.OrderService;
/**
 * Created by lz on 2017/5/18.
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
    private OrderDAO orderDAO;
	
	@Override
	//订单展示
	public List<OrderModel> orderDisplay() {
		List<OrderModel> resultList = orderDAO.orderDisplay();
		return resultList;
	}
	
	@Override
	//订单详情展示
	public List<OrderDetailModel> orderDetailDisplay(OrderDetailModel ordm) {
		orderDAO.orderUpdateSum();
		List<OrderDetailModel> resultList = orderDAO.orderDetailDisplay(ordm);
		return resultList;
	}
	
	//顾客订单展示
	public List<OrderModel> informationDisplay(OrderModel ord) {
		List<OrderModel> resultList = orderDAO.informationDisplay(ord);
		return resultList;
	}
	
	//顾客待收货展示
	public List<OrderModel> receiveDisplay(OrderModel ord) {
		List<OrderModel> resultList = orderDAO.receiveDisplay(ord);
		return resultList;
	}
	//顾客待发货展示
	@Override
	public List<OrderModel> sendDisplay(OrderModel ord) {
		List<OrderModel> resultList = orderDAO.sendDisplay(ord);
		return resultList;
	}
	//顾客待评价展示
	@Override
	public List<OrderModel> CommentDisplay(OrderModel ord) {
		List<OrderModel> resultList = orderDAO.CommentDisplay(ord);
		return resultList;
	}
	
	//顾客退货展示
	public List<OrderModel> goodsBackDisplay(OrderModel ord) {
		List<OrderModel> resultList = orderDAO.goodsBackDisplay(ord);
		return resultList;
	}
	
	//顾客退货操作
	@Override//订单表状态修改
	public void goodsBack(OrderModel ord) {
		orderDAO.goodsBack(ord);
	}
	@Override//新增退货表
	public void goodsBackAdd(OrderModel ord) {
		orderDAO.goodsBackAdd(ord);	
	}
	//顾客收货操作
	@Override
	public List<OrderModel> goodsReceive(OrderModel ord) {
		List<OrderModel> resultList = orderDAO.goodsReceive(ord);
		return resultList;
	}
	//顾客评价操作
	@Override//修改订单表状态
	public void goodsComment(OrderModel ord) {
		orderDAO.goodsComment(ord);
	}
	@Override//评价表新增
	public void goodsCommentAdd(OrderModel ord) {
		orderDAO.goodsCommentAdd(ord);	
	}
	
	//管理员发货操作
	@Override
	public int goodsSend(OrderModel ord) {
		int flag = orderDAO.goodsSend(ord);
		return flag;
	}


}
