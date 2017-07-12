package com.cont.controller;

import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.model.OrderModel;
import com.cont.service.CustomerService;
import com.cont.service.GoodsService;
import com.cont.service.OrderService;
import com.cont.utils.APIRestResponse;
import com.cont.utils.Page;
import com.cont.utils.ResponseUtils;
import com.cont.utils.RestOperateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import net.sf.json.JSONArray;  
import net.sf.json.JSONObject; 

/**
 * Controller
 */
@Controller
@RequestMapping("/information")
public class InformationController {
    
	@Autowired
    private OrderService orderService;
	
	@Autowired
    private CustomerService customerService;
	
	@ResponseBody
   	@RequestMapping("/display")		//顾客订单展示
    public List<OrderModel> orderDisplay(OrderModel ord) throws Exception { 
	   	List<OrderModel> orderList = orderService.informationDisplay(ord);
	   	return orderList;
    } 
	
	@ResponseBody
   	@RequestMapping("/receiveDisplay")		//顾客待收货展示
    public List<OrderModel> receiveDisplay(OrderModel ord) throws Exception { 
	   	List<OrderModel> orderList = orderService.receiveDisplay(ord);
	   	return orderList;
    } 
	@ResponseBody
   	@RequestMapping("/sendDisplay")		//顾客待发货展示
    public List<OrderModel> sendDisplay(OrderModel ord) throws Exception { 
	   	List<OrderModel> orderList = orderService.sendDisplay(ord);
	   	return orderList;
    } 
    
	@ResponseBody
   	@RequestMapping("/CommentDisplay")		//顾客待评价展示
    public List<OrderModel> CommentDisplay(OrderModel ord) throws Exception { 
	   	List<OrderModel> orderList = orderService.CommentDisplay(ord);
	   	return orderList;
    } 
	
	@ResponseBody
   	@RequestMapping("/goodsBackDisplay")		//顾客退货展示
    public List<OrderModel> goodsBackDisplay(OrderModel ord) throws Exception { 
	   	List<OrderModel> orderList = orderService.goodsBackDisplay(ord);
	   	return orderList;
    }
	
	@ResponseBody
   	@RequestMapping("/goodsBack")		//顾客退货操作
    public APIRestResponse goodsBack(OrderModel ord) throws Exception { 
	   	orderService.goodsBack(ord);
	   	orderService.goodsBackAdd(ord);
	   	return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.DELETE_DATA);
    }
	
	@ResponseBody
   	@RequestMapping("/goodsReceive")		//顾客收货操作
    public List<OrderModel> goodsReceive(OrderModel ord) throws Exception { 
	   	List<OrderModel> orderList = orderService.goodsReceive(ord);
	   	return orderList;
    }
	
	@ResponseBody
   	@RequestMapping("/goodsComment")		//顾客评价操作
    public APIRestResponse goodsComment(OrderModel ord) throws Exception { 
	   	orderService.goodsComment(ord);
	   	orderService.goodsCommentAdd(ord);
	   	return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.DELETE_DATA);
    }
	
	@ResponseBody
   	@RequestMapping("/customerBack")		//顾客信息展示
    public List<CustomerModel> customerBack(CustomerModel ord) throws Exception { 
		List<CustomerModel> resultList=customerService.customerBack(ord);
	   	return resultList;
    }
	
	@ResponseBody
   	@RequestMapping("/customerUpdate")		//顾客信息修改
    public APIRestResponse customerUpdate(CustomerModel ord) throws Exception { 
		customerService.customerUpdate(ord);
	   	return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.UPDATE_DATA);
    }
	
	@ResponseBody
   	@RequestMapping("/PasswordUpdate")		//顾客密码修改
    public APIRestResponse PasswordUpdate(CustomerModel ord) throws Exception { 
		int reusltList = customerService.PasswordUpdate(ord);
    	if(reusltList != 0 && reusltList>0){
    		return ResponseUtils.getSuccessAPI(true,"true", RestOperateCode.UPDATE_DATA);
    	}
    	return ResponseUtils.getSuccessAPI(false,"false", RestOperateCode.UPDATE_DATA);
    }

	@ResponseBody
   	@RequestMapping("/collectDisplay")		//顾客收藏夹展示
    public List<GoodsModel> collectDisplay(GoodsModel model) throws Exception { 
	   	List<GoodsModel> collectList = customerService.collectDisplay(model);
	   	return collectList;
    } 
	
	@ResponseBody
   	@RequestMapping("/collectDelete")		//顾客收藏夹删除物品
    public List<GoodsModel> collectDelete(GoodsModel model) throws Exception { 
	   	List<GoodsModel> collectList = customerService.collectDelete(model);
	   	return collectList;
    } 
}



