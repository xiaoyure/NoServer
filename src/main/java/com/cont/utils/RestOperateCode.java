/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd. 
 */
package com.cont.utils;

/**
 * <pre>
 * Rest操作代码。
 * </pre>
 * @author Klin
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public abstract class RestOperateCode {
	
	/**
	 * 登录操作。
	 */
	public final static String OP_LOGIN="00000100";
	
	/**
	 * 管理员登录操作。
	 */
	public final static String OP_ADMINLOGIN="00000300";
	
	/**
	 * 注册操作。
	 */
	public final static String OP_REGISTER="00000200";
	
	/**
	 * 获取数据。
	 */
	public final static String GET_DATA="00020010001";
	
	
	/**
	 * 修改数据。
	 */
	public final static String UPDATE_DATA="00020010002";
	
	/**
	 * 导入数据。
	 */
	public final static String IMPORT_DATA="00020010003";
	
	/**
	 * 删除数据。
	 */
	public final static String DELETE_DATA="00020010004";
	
	/**
	 * 导出数据。
	 */
	public final static String EXPORT_DATA="00020010005";
	/**
	 * 修改数据。
	 */
	public final static String SAVE_DATA="00020010006";
	
	/**
	 * 添加数据。
	 */
	public final static String INSERT_DATA="00020010007";
	
	/**
	 * 统计数据。
	 */
	public final static String COUNT_DATA="00020010008";
	
	/**
	 * 上传文件。
	 */
	public final static String OP_FILE_UPLOAD="00020010009";
	/**
	 * 下载文件。
	 */
	public final static String OP_FILE_DOWNLOAD="00020010010";
	
	
	
		
	
	
}
