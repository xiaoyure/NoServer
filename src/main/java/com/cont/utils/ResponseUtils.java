/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd. 
 */
package com.cont.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author lq
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ResponseUtils {
	
	
	
	/** 获取成功对象 Map数据。
	 * @param code String
	 * @param msg String
	 * @param operCode String
	 * @param data Map<String, Object>
	 * @return APIRestResponse
	 */
	public static APIRestResponse getSuccess(Boolean success,String code, String msg, String operCode, Map<String, Object> data){
		APIRestResponse reponse = new APIRestResponse();
		reponse.setSuccess(success);
		reponse.setErrCode(code);
		reponse.setOperateCode(operCode);
		reponse.setMessage(msg);
		reponse.setData(data);
		return reponse;
	}
	
	/** 获取成功对象 List数据。
	 * @param code String
	 * @param msg String
	 * @param operCode String
	 * @param data List<Object>
	 * @return RestResponse
	 */
	public static APIRestResponse getSuccess(boolean Success,String code, String msg, String operCode, List<Object> data){
		APIRestResponse reponse = new APIRestResponse();
		reponse.setSuccess(Success);
		reponse.setErrCode(code);
		reponse.setOperateCode(operCode);
		reponse.setMessage(msg);
		reponse.setData(data);
		return reponse;
	}
	
	
	
	/**获取成功对象。
	 * @param msg String
	 * @param operCode String
	 * @param pr PagedResult<?>
	 * @return APIRestResponse
	 */
//	public static APIRestResponse getSuccess(String msg, String operCode, PagedResult<?> pr){
//
//		APIRestResponse reponse = new APIRestResponse();
//		reponse.setSuccess(true);
//		reponse.setErrCode("");
//		reponse.setOperateCode(operCode);
//		reponse.setMessage(msg);
//
//		APIResultPagedData apd = new APIResultPagedData();
//		apd.setPageIndex(pr.getInfo().getPageIndex());//当前页
//		apd.setPageSize(pr.getInfo().getPageSize());//每页显示记录数
//		apd.setTotal(pr.getTotal());//总记录数
//		apd.setList(pr.getData());//数据
//
//		reponse.setData(apd);
//		return reponse;
//	}
	
	/** 无code 获取成功对象 List数据。
	 * @param msg String
	 * @param operCode String
	 * @param data List<Object>
	 * @return  RestResponse
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static APIRestResponse getSuccess(boolean Success,String msg, String operCode, List data){
		return getSuccess(Success,"", msg, operCode, data);
	}
	
	/** 无code 获取成功对象 。
	 * @param msg String
	 * @param operCode String
	 * @param obj Object
	 * @return  RestResponse
	 */
	public static APIRestResponse getSuccess(boolean success,String msg, String operCode,Object obj){
		APIRestResponse reponse = new APIRestResponse();
		reponse.setSuccess(success);
		reponse.setOperateCode(operCode);
		reponse.setMessage(msg);
		reponse.setData(obj);
		return reponse;
	}
	
	/** 无数据 获取成功对象。
	 * @param msg String
	 * @param operCode  String
	 * @return APIRestResponse
	 */
	public static APIRestResponse getSuccessAPI(boolean success,String msg, String operCode){
		return getSuccess(success,"", msg, operCode, new HashMap<String, Object>());
	}
	
	/**
	 * 有返回码 无数据 获取成功对象。
	 * @param code String
	 * @param msg String
	 * @param operCode String
	 * @return APIRestResponse
	 */
	public static APIRestResponse getSuccessAPI(boolean success,String code, String msg, String operCode){
		return getSuccess(success,code, msg ,operCode, new HashMap<String, Object>());
	}
	
	/**   获取失败对象 Map数据。
	 * @param code String
	 * @param msg String
	 * @param operCode String
	 * @param data Map<String, Object>
	 * @return APIRestResponse
	 */
	public static APIRestResponse getFailed(String code, String msg, String operCode, Map<String, Object> data){
		APIRestResponse reponse = new APIRestResponse();
		reponse.setSuccess(false);
		reponse.setErrCode(code);
		reponse.setOperateCode(operCode);
		reponse.setMessage(msg);
		reponse.setData(data);
		return reponse;
	}
	
	
	/** 无数据 获取失败对象。
	 * @param code String
	 * @param msg String
	 * @param operCode String
	 * @return RestResponse
	 */
	public static APIRestResponse getFailed(String code, String msg, String operCode){
		return getFailed(code, msg, operCode, new HashMap<String, Object>());
	}
	
	/** 无数据 获取成功对象。
	 * @param msg String
	 * @param operCode  String
	 * @return APIRestResponse
	 */
	public static APIRestResponse getSuccess(boolean success,String msg, String operCode){
		return getSuccess(success,"", msg, operCode, new HashMap<String, Object>());
	}
	
	/**
	 * 有返回码 无数据 获取成功对象。
	 * @param code String
	 * @param msg String
	 * @param operCode String
	 * @return APIRestResponse
	 */
	public static APIRestResponse getSuccess(boolean success,String code, String msg, String operCode){
		return getSuccess(success,code, msg ,operCode, new HashMap<String, Object>());
	}

	
	/**有返回码 获取成功对象。
	 * @param msg String
	 * @param operCode String
	 * @param dataParams Map<String, Object>
	 * @return APIRestResponse
	 */
	public static APIRestResponse getSuccess(boolean success,String msg, String operCode,
			Map<String, Object> dataParams) {
 
		return getSuccess(success,"", msg, operCode,dataParams);
	}


	/**有返回码 获取成功对象。
	 * @param msg String
	 * @param code String
	 * @param data Object
	 * @return APIRestResponse
	 */
	public static APIRestResponse getSuccessAPI(Boolean status,String msg, String code,
			Object data) {
		APIRestResponse reponse = new APIRestResponse();
		reponse.setSuccess(status);
		reponse.setErrCode("");
		reponse.setOperateCode(code);
		reponse.setMessage(msg);
		reponse.setData(data);
		return reponse;
	}
}
