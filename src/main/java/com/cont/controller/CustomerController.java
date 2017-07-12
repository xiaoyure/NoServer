package com.cont.controller;

import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.model.ShoppingGoodsModel;
import com.cont.service.CustomerService;
import com.cont.service.GoodsService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("/login")  //登录
    public APIRestResponse login(HttpServletRequest request, HttpServletResponse response) {
    	
    	String cus_name = request.getParameter("username");
    	String cus_password = request.getParameter("password");
  
    	List<CustomerModel> customerList = customerService.customerLogin(cus_name, cus_password);
    	if(customerList!=null && customerList.size()>0){
    		//CustomerModel customerInfo = customerList.get(0);
    		//request.getSession().setAttribute("customerInfo", customerInfo);
    		return ResponseUtils.getSuccessAPI(true,"true", RestOperateCode.OP_LOGIN);
    	}
    	return ResponseUtils.getSuccessAPI(false,"false", RestOperateCode.OP_LOGIN);
    }
    
    @ResponseBody
    @RequestMapping("/register")  //注册
    public APIRestResponse register(CustomerModel cus) throws Exception {
		
    	int customerList = customerService.customerRegister(cus);
    	if(customerList == 1){
    		return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.OP_REGISTER);
    	}
    	return ResponseUtils.getSuccessAPI(false, "false", RestOperateCode.OP_REGISTER);
    }
    
    @ResponseBody
    @RequestMapping("/backCount")  //分页展示返回条目数
    public int backCount(GoodsModel goods) throws Exception {
    	GoodsModel miao = goods;
    	miao.setGoodsName("%" + goods.getGoodsName() + "%");
    	goods.setGoodsName(miao.getGoodsName());
    	int goodsCount = goodsService.countGoods(goods);
    	return goodsCount;
    }
    
    @ResponseBody
    @RequestMapping("/backDisplay")  //分页展示返回商品
    public Page<GoodsModel> backDisplay(GoodsModel goods) throws Exception {
    	GoodsModel miao = goods;
    	miao.setGoodsName("%" + goods.getGoodsName() + "%");
    	goods.setGoodsName(miao.getGoodsName());
    	Page<GoodsModel> goodsPage = goodsService.backDisplay(goods);
    	return goodsPage;
    }
    
    @ResponseBody
    @RequestMapping("/goodsDetail")  //商品详情界面
    public List<GoodsModel> goodsDetail(GoodsModel goods) throws Exception {
    	List<GoodsModel> goodsList = goodsService.goodsDetailDisplay(goods);
	   	return goodsList;
    }
    
    @ResponseBody
   	@RequestMapping("/shoppingcartDisplay")		//顾客的购物车
    public List<ShoppingGoodsModel> shoppingcartDisplay(CustomerModel cus) throws Exception { 
	   	List<ShoppingGoodsModel> goodsList = goodsService.shoppingcartDisplay(cus);
	   	return goodsList;
    } 
    
	@ResponseBody
   	@RequestMapping("/shoppingcartDelete")		//顾客从购物车移除商品
   	public APIRestResponse shoppingcartDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	String cus_username = request.getParameter("username");
    	String shoppinggoodsId = request.getParameter("goodsId");
		System.out.println(cus_username);
		System.out.println(shoppinggoodsId);
		List<ShoppingGoodsModel> goodsList = goodsService.shoppingcartDelete(cus_username,shoppinggoodsId);
	   	
	   	if(goodsList!=null && goodsList.size()>0){
	   		return ResponseUtils.getSuccessAPI(false, "false", RestOperateCode.DELETE_DATA);
	   	}
	   	return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.DELETE_DATA);
    }
	
	@ResponseBody
   	@RequestMapping("/addShopping")		//加入购物车
    public APIRestResponse addShopping(GoodsModel goods) throws Exception { 
	   	int customerList = customerService.addShopping(goods);
	   	if(customerList > 0){
    		return ResponseUtils.getSuccessAPI(true,"true", RestOperateCode.INSERT_DATA);
    	}
    	return ResponseUtils.getSuccessAPI(false,"false", RestOperateCode.INSERT_DATA);
    }
	
	@ResponseBody
   	@RequestMapping("/addCollect")		//加入收藏夹
    public APIRestResponse addCollect(GoodsModel goods) throws Exception { 
	   	int customerList = customerService.addCollect(goods);
	   	if(customerList > 0){
    		return ResponseUtils.getSuccessAPI(true,"true", RestOperateCode.INSERT_DATA);
    	}
    	return ResponseUtils.getSuccessAPI(false,"false", RestOperateCode.INSERT_DATA);
    }

    
}



