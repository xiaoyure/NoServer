package com.cont.controller;

import com.cont.model.BackModel;
import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.model.NumModel;
import com.cont.model.OrderModel;
import com.cont.service.BackService;
import com.cont.service.CustomerService;
import com.cont.service.GoodsService;
import com.cont.service.OrderService;
import com.cont.utils.APIRestResponse;
import com.cont.utils.ResponseUtils;
import com.cont.utils.RestOperateCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller
 */
@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
    private GoodsService goodsService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BackService backService;
	
	@Autowired
	private OrderService orderService;


	
    @ResponseBody
    @RequestMapping("/Adminlogin")  //登录
    public APIRestResponse login(HttpServletRequest request, HttpServletResponse response) {
    	String aName = request.getParameter("user_name");
    	String aPassword = request.getParameter("pass_word");
    	
    	if (aName.equals("admin") && aPassword.equals("admin")) {
    		return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.OP_ADMINLOGIN);
    	}
    	return ResponseUtils.getSuccessAPI(false,"false", RestOperateCode.OP_ADMINLOGIN);
    }
  
    
    @ResponseBody
	@RequestMapping(value="/onsell",method=RequestMethod.POST)  //商品上架
    public APIRestResponse goodsOnsell(HttpServletRequest request, HttpServletResponse response) throws Exception { 

		String goodsName = request.getParameter("goodsName");
    	String stock = request.getParameter("goodsStock");
    	String price = request.getParameter("goodsPrice");
    	String category = request.getParameter("goodsCategoryId");
    	String description = request.getParameter("goodsDescription");
    	
    	List<GoodsModel> goodsList = new ArrayList<GoodsModel>();
        CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getSession().getServletContext());  
        if (cmr.isMultipart(request)) {  
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> files = mRequest.getFileNames();  
            while (files.hasNext()) {  
                MultipartFile mFile = mRequest.getFile(files.next()); 
          
                if (mFile != null) {  
                	String fname =mFile.getOriginalFilename();
                    String fileName = UUID.randomUUID() +""+ System.currentTimeMillis(); 
                    String extname = fname.substring(fname.indexOf("."));
                    String toPath = request.getServletContext().getRealPath("/upload");
                    File targetFile = new File(toPath);
                    if (!targetFile.exists() && !targetFile.isDirectory()) {
                    	targetFile.mkdir();
                    }
                    
                    /*String path = toPath+"/"+fileName+extname;  
                    File localFile = new File(path);  
                    mFile.transferTo(localFile);  */    
                    
                    String path2 = "F:/生产实习/NoServer/src/main/webapp/upload/"+fileName+extname;
                    String path3 = "/NoServer/upload/"+fileName+extname;
                    File localFile2 = new File(path2);  
                    mFile.transferTo(localFile2);
                    
                    goodsList = goodsService.goodsOnsell(goodsName, stock, price, category, path3, description);
                }  
            } 
        }  
        
        if (goodsList != null && goodsList.size() > 0) {
    		return ResponseUtils.getSuccessAPI(false, "false", RestOperateCode.SAVE_DATA);
    	}
    	return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.SAVE_DATA);  
    } 
    
    @ResponseBody
   	@RequestMapping("/display")		//商品展示
    public List<GoodsModel> goodsDisplay() throws Exception { 
	   	List<GoodsModel> goodsList = goodsService.goodsDisplay();
	   	return goodsList;
    } 
    
   
    @ResponseBody
    @RequestMapping("/soldout")		//商品下架
   	public APIRestResponse goodsSoldout(GoodsModel cus) throws Exception{
	   	List<GoodsModel> goodsList = goodsService.goodsSoldout(cus);
	   	
	   	if(goodsList!=null && goodsList.size()>0){
	   		return ResponseUtils.getSuccessAPI(false, "false", RestOperateCode.DELETE_DATA);
	   	}
	   	return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.DELETE_DATA);
   	
    }
    
    @ResponseBody
    @RequestMapping("/customerdisplay")		//客户信息展示
    public List<CustomerModel> customerDisplay() throws Exception { 
	   	List<CustomerModel> customerList = customerService.customerDisplay();
	   	return customerList;
    }
    
    @ResponseBody
    @RequestMapping("/backdisplay")			//退货展示
    public List<BackModel> backDisplay() throws Exception { 
	   	List<BackModel> backList = backService.backDisplay();
	   	return backList;
    } 
    
    @ResponseBody
    @RequestMapping("/backdeal")			//退货处理
   	public APIRestResponse backDeal(BackModel cus) throws Exception{
	   	int backList = backService.backDeal(cus);
	   	if(backList == 1){
	   		return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.DELETE_DATA);
	   	}
	   	return ResponseUtils.getSuccessAPI(false, "false", RestOperateCode.DELETE_DATA);
    }
    
    @ResponseBody
  	@RequestMapping(value="/updateonsell",method=RequestMethod.POST)  //商品下架双击变上架
    public APIRestResponse updateonsell(GoodsModel ord) throws Exception { 
	   	int  flag = goodsService.updateonsell(ord);
	   	if(flag != 0 && flag > 0) return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.UPDATE_DATA);
	   	else return ResponseUtils.getSuccessAPI(false, "false", RestOperateCode.UPDATE_DATA);
    }

   @ResponseBody
   	@RequestMapping("/alldisplay")		//总展示
    public NumModel alldisplay() throws Exception { 
	   	NumModel allList = goodsService.alldisplay();
	   	return allList;
    } 

	@ResponseBody
   	@RequestMapping("/goodsSend")		//管理员发货操作
    public APIRestResponse goodsSend(OrderModel ord) throws Exception { 
	   	int  flag = orderService.goodsSend(ord);
	   	if(flag != 0 && flag > 0) return ResponseUtils.getSuccessAPI(true, "true", RestOperateCode.DELETE_DATA);
	   	else return ResponseUtils.getSuccessAPI(false, "false", RestOperateCode.DELETE_DATA);
    }


    
}



