package com.cont.service;



import java.util.List;

import com.cont.model.CommentModel;
import com.cont.utils.Page;

/**
 * Created by lz on 2017/5/18.
 */
public interface CommentService {
	
	//返回评论数量
	int commentCount(CommentModel goods);
	//返回评论具体内容
	Page<CommentModel> commentDisplay(CommentModel goods);
	
	
}
