/**
 * Copyright(c) Beijing Kungeek Science & Technology Ltd. 
 */
package com.cont.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

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
public class MD5 {
	
	private static final Log log = LogFactory.getLog(MD5.class);
	private  final static String   key="iandtop";
	 // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    private static final Charset defaultCharset = StandardCharsets.UTF_8;

    public MD5() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bByte.length; i++) {
            sb.append(byteToArrayString(bByte[i]));
        }
        return sb.toString();
    }

    /**
     * @param str
     * @param charset
     * @return
     */
    public static String encrypt(String str, Charset charset) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            return byteToString(md.digest((key+str).getBytes(charset)));
        } catch (Exception ex) {
        	log.error("MD5加密失败！", ex);
        }
        return "";
    }
    
    public static String encrypt(String str) {
        return encrypt(str, defaultCharset);
    }


    /**
     * 生成唯一ID
     */
    public static String MD5UUID(){
        Random ra=new Random();
        long L1 = new Date().getTime() - 1300000000000L;
        long L2=ra.nextInt(Math.abs(((int) L1)+ra.nextInt(99999)));
        return String.valueOf(L2);
    }

}
