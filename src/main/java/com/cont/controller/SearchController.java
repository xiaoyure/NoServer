package com.cont.controller;

import edu.fudan.nlp.cn.tag.CWSTagger;
import java.util.HashMap;
import java.util.*;

import com.cont.model.GoodsModel;
import com.cont.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller
 */
@Controller
@RequestMapping("/Goods")
public class SearchController {
	@Autowired
    private GoodsService goodsService;
	
    @ResponseBody
    @RequestMapping("/goodssearch")  //搜索商品
    public List<GoodsModel> goodsSearchDisplay(HttpServletRequest request, HttpServletResponse response) throws Exception { 	
	   	String search_get = request.getParameter("search");
		String str = search_get+" ";
		CWSTagger tag = new CWSTagger("./src/models/seg.m");
		String s = tag.tag(str);
		String Count[] = s.split(" ");
		Map<String,Integer> maps = new HashMap<String, Integer>();  
		for(int i=0; i<Count.length; i++){
	   	 	List<String> List = goodsService.goodsSearch(Count[i]);
	   	 	System.out.println(List);
	   	 	for(int j=0; j<List.size(); j++){
	   	 		String re = List.get(j);
	   	 		if(maps.containsKey(re)){
	   	 			int cur_num = maps.get(re);
	   	 			cur_num++;
	   	 			maps.put(re, cur_num);
	   	 		}
	   	 		else 	maps.put(re, 1);
	   	 	}
	   	}
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(maps.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
            //降序排序  
            @Override  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                return o2.getValue().compareTo(o1.getValue());  
            }
        });  
        List<GoodsModel> goodsModelList = new ArrayList<GoodsModel>();
        for (Map.Entry<String, Integer> mapping : list) {  
             GoodsModel cus = goodsService.goodsSearchDisplay(mapping.getKey());
             goodsModelList.add(cus);
        }
        for (int i = 0; i < goodsModelList.size(); ++i)
        	System.out.println(goodsModelList.get(i).getGoodsName());
	   	return goodsModelList;
    } 
}



