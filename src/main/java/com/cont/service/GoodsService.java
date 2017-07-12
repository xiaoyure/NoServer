package com.cont.service;



import java.util.List;

import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;
import com.cont.model.NumModel;
import com.cont.model.ShoppingGoodsModel;
import com.cont.utils.Page;

/**
 * Created by lz on 2017/6/24.
 */
public interface GoodsService {
	
	//商品上架
	List<GoodsModel> goodsOnsell(String goodsName, String stock, String price, String category, String path, String description);
	
	//商品展示
	List<GoodsModel> goodsDisplay();
	
	//商品下架
	List<GoodsModel> goodsSoldout(GoodsModel cus);
	
	//顾客商品展示，返回条目数
	int countGoods(GoodsModel goods);
	//顾客商品展示，返回具体
	Page<GoodsModel> backDisplay(GoodsModel goods);
	
	//商品详情界面展示
	List<GoodsModel> goodsDetailDisplay(GoodsModel goods);
	
	
	//根据名字模糊搜索商品id
	List<String> goodsSearch(String count);
	//根据商品Id返回商品数据
	GoodsModel goodsSearchDisplay(String key);
	

	//购物车
	List<ShoppingGoodsModel> shoppingcartDisplay(CustomerModel cus);
	//购物车删除
	List<ShoppingGoodsModel> shoppingcartDelete(String cus_username, String shoppinggoodsId);
	
	//商品下架双击变上架
	int updateonsell(GoodsModel ord);
	//总展示
	NumModel alldisplay();

	
}
