/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd. 
 */
package com.cont.utils;

/**
 * <pre>
 * Rest 单、多数据响应信息封装类。
 * </pre>
 * 
 * @author lq
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
public class APIRestResponse {
	
	/**
	 * 结果标志。
	 */
	private boolean success;
	
	/**
	 * 错误代码。
	 */
	private String errCode;
	
	/**
	 * 操作码。
	 */
	private String operateCode;
	
	/**
	 * 结果消息。
	 */
	private String message = "";
	
	/**
	 * 数据信息。
	 */
	private Object data;
	
	/**
	 * 构造。
	 */
	public APIRestResponse() {
	}
	
	/**
	 * 获取实例工厂方法。
	 * @param json Json字符串
	 * @return RestResponse
	 */
//	public static APIRestResponse getInstance(String json){
//		if(json.isEmpty(json))
//		{
//			return new APIRestResponse();
//		}
//		return AlsdJsonUtil.parseToJSONObject(json, APIRestResponse.class);
//	}

	/**
	 * 是否成功。
	 * @return boolean
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * 设置是否成功。
	 * @param success 成功标志
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 获取错误代码。
	 * @return String
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * 设置错误代码。
	 * @param errorCode 错误代码
	 */
	public void setErrCode(String errorCode) {
		this.errCode = errorCode;
	}

	/**
	 * 获取操作代码。
	 * @return String
	 */
	public String getOperateCode() {
		return operateCode;
	}

	/**
	 * 设置操作代码。
	 * @param operateCode 操作代码
	 */
	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}

	/**
	 * 获取提示消息。
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置提示消息。
	 * @param message 提示消息。
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 获取数据。
	 * @return Map<String, Object>
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 设置数据。
	 * @param data 响应数据
	 */
	public void setData(Object data) {
		this.data = data;
	}

	
	
}
