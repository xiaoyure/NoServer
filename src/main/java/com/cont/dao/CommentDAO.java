package com.cont.dao;

import java.util.List;

import com.cont.model.CommentModel;
import com.cont.model.CustomerModel;
import com.cont.model.GoodsModel;



/**
 * CompanyDAO
 */
public interface CommentDAO {
	
	//返回评论数量
	int commentCount(CommentModel goods);
	//返回评论具体内容
	List<CommentModel> commentDisplay(CommentModel goods);
	
	
}



