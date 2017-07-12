package com.cont.controller;

import com.cont.model.AddressModel;
import com.cont.model.OrderDetailModel;
import com.cont.model.OrderModel;
import com.cont.service.CommitOrderService;
import com.cont.service.OrderService;
import com.cont.utils.APIRestResponse;
import com.cont.utils.ResponseUtils;
import com.cont.utils.RestOperateCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
    private OrderService orderService;
	@Autowired
	private CommitOrderService commitOrderService;
	
	@ResponseBody
   	@RequestMapping("/display")		//订单展示
    public List<OrderModel> orderDisplay() throws Exception { 
	   	List<OrderModel> orderList = orderService.orderDisplay();
	   	return orderList;
    } 
	
	@ResponseBody
   	@RequestMapping("/detailDisplay")		//订单详情展示
    public List<OrderDetailModel> orderDetailDisplay(OrderDetailModel ordm) throws Exception { 
		List<OrderDetailModel> orderDetailList = orderService.orderDetailDisplay(ordm);
	   	return orderDetailList;
    } 
	
	@ResponseBody
   	@RequestMapping("/addressChosen")		//返回地址选择
    public List<AddressModel> addressChosen(AddressModel addr) throws Exception { 
		List<AddressModel> addressList = commitOrderService.addressChosen(addr);
	   	return addressList;
    } 
	
	@ResponseBody
   	@RequestMapping("/submitOrder")		//提交订单
    public APIRestResponse submitOrder(HttpServletRequest request) throws Exception { 
		String username = request.getParameter("username");
		commitOrderService.submitOrder(username);
		return ResponseUtils.getSuccessAPI(true,"true", RestOperateCode.OP_LOGIN);
    } 
    
}



