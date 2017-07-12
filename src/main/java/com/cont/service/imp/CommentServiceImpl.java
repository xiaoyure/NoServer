package com.cont.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cont.dao.CommentDAO;
import com.cont.dao.CustomerDAO;
import com.cont.model.CommentModel;
import com.cont.model.GoodsModel;
import com.cont.service.CommentService;
import com.cont.utils.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lz on 2017/5/18.
 */
@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
    private CommentDAO commentDAO;
	
	//返回评论数量
	public int commentCount(CommentModel goods) {
		int cnt = commentDAO.commentCount(goods);
		return cnt;
	}
	//返回评论具体内容
	public Page<CommentModel> commentDisplay(CommentModel goods) {
		Page<CommentModel> page = new Page<CommentModel>(0, null);
		int count = commentDAO.commentCount(goods);
		List<CommentModel> list = new ArrayList<CommentModel>();
		//如果记录数大于0，则查列表
		if (count > 0){
			list = commentDAO.commentDisplay(goods);
		}
		page.setResults(count);
		page.setRows(list);
		return page;
	}
    
}
