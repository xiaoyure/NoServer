package com.cont.controller;

import com.cont.model.CommentModel;
import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping("/commentCount")  //评论分页数量
    public int commentCount(CommentModel goods) throws Exception {
    	int goodsCount = commentService.commentCount(goods);
    	//System.out.println(goodsCount);
    	return goodsCount;
    }
    
    @ResponseBody
    @RequestMapping("/commentDisplay")  //评论 分页展示详细
    public Page<CommentModel> commentDisplay(CommentModel goods) throws Exception {
    	Page<CommentModel> goodsPage = commentService.commentDisplay(goods);
    	System.out.println(goodsPage.getRows());
    	//System.out.println(goodsCount);
    	return goodsPage;
    }
    
}



