package com.cont.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cont.dao.GoodsDAO;
import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.model.NumModel;
import com.cont.model.ShoppingGoodsModel;
import com.cont.service.GoodsService;
import com.cont.utils.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lz on 2017/6/24.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDAO goodsDAO;

	@Override
	//商品上架
	public List<GoodsModel> goodsOnsell(String goodsName, String stock, String price, String category, String path, String description) {
		// TODO Auto-generated method stub
		
		GoodsModel model = new GoodsModel();
		model.setGoodsName(goodsName);
		model.setGoodsStock(Integer.parseInt(stock));
		model.setGoodsPrice(Double.parseDouble(price));
		model.setGoodsCategoryId(Integer.parseInt(category));
		model.setGoodsImage(path);
		model.setGoodsDescription(description);
		
		List<GoodsModel> resultList = goodsDAO.goodsOnsell(model);
		return resultList;
	}
	
	
	@Override
	//商品展示
	public List<GoodsModel> goodsDisplay() {
		List<GoodsModel> resultList = goodsDAO.goodsDisplay();
		return resultList;
	}
	
	@Override
	//商品下架
	public List<GoodsModel> goodsSoldout(GoodsModel cus){
		List<GoodsModel> resultList = goodsDAO.goodsSoldout(cus);
		return resultList;
	}
	
	@Override
	//顾客商品展示，返回条目数
	public int countGoods(GoodsModel goods){
		int cnt = goodsDAO.selectCount(goods);
		return cnt;
	}
	
	@Override
	//顾客商品展示，返回具体
	public Page<GoodsModel> backDisplay(GoodsModel goods) {
		Page<GoodsModel> page = new Page<GoodsModel>(0, null);
		int count = goodsDAO.selectCount(goods);
		List<GoodsModel> list = new ArrayList<GoodsModel>();
		//如果记录数大于0，则查列表
		if(count>0){
			list = goodsDAO.backDisplay(goods);
		}
		page.setResults(count);
		page.setRows(list);
		return page;
	}
	
	//商品详情	
	public List<GoodsModel> goodsDetailDisplay(GoodsModel goods) {
		List<GoodsModel> resultList = goodsDAO.goodsDetailDisplay(goods);
		return resultList;
	}
	
	@Override
	//根据名字模糊搜索商品id
	public List<String> goodsSearch(String count) {
		// TODO Auto-generated method stub
		List<String> searchList = goodsDAO.goodsSearch(count);
		return searchList;
	}

	@Override
	//根据商品Id返回商品数据
	public GoodsModel goodsSearchDisplay(String key) {
		// TODO Auto-generated method stub
		GoodsModel cus = goodsDAO.goodsSearchDisplay(key);
		return cus;
	}
	
	//通过客户用户名找到购物车信息
	@Override
	public List<ShoppingGoodsModel> shoppingcartDisplay(CustomerModel cus) {
		// TODO Auto-generated method stub
		List<ShoppingGoodsModel> resultList = goodsDAO.shoppingcartDisplay(cus);
		return resultList;
	}

	//删除购物车内物品
	@Override
	public List<ShoppingGoodsModel> shoppingcartDelete(String cus_username, String shoppinggoodsId) {
		// TODO Auto-generated method stub
		HashMap<String,String> maps = new HashMap<String,String>();
		maps.put("shoppinggoodsId", shoppinggoodsId);
		maps.put("cus_username", cus_username);
		List<ShoppingGoodsModel> resultList = goodsDAO.shoppingcartDelete(maps);
		return resultList;
	}
	
	//商品下架双击变上架
	@Override
	public int updateonsell(GoodsModel ord) {
		int flag = goodsDAO.updateonsell(ord);
		return flag;
	}

	//总展示
	@Override
	public NumModel alldisplay() {
		int customerNum = goodsDAO.customerNum();
		int goodsNum = goodsDAO.goodsNum();
		int orderNum = goodsDAO.orderNum();
		int sumNum = goodsDAO.sumNum();
		NumModel resultList = new NumModel();
		resultList.setCustomerNum(customerNum);
		resultList.setGoodsNum(goodsNum);
		resultList.setOrderNum(orderNum);
		resultList.setPriceSum(sumNum);
		return resultList;
	}
}
