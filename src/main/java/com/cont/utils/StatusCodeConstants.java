package com.cont.utils;


/**
 * Created by lz on 2017/3/17.
 */
public class StatusCodeConstants {

    /**
     * 系统内部错误
     */
    public static final int Sys_Error = 0;

    /**
     * 操作成功
     */
    public static final int Success = 1;

    /**
     * 操作失败
     */
    public static final int Fail = 2;

    /**
     * 卡号重复
     */
    public static final int Card_Code_Repeat = 3;

    /**
     * 人员已发卡
     */
    public static final int Psn_Card_Already_Issue = 4;

    /**
     * 未找到卡片信息
     */
    public static final int Not_Found_Card_Info = 5;

    /**
     * 未找到人员信息
     */
    public static final int Not_Found_Psn_Info = 6;

    /**
     * 挂失卡不能退卡
     */
    public static final int Lost_No_Return = 7;

    /**
     * 未挂失的卡不能补卡
     */
    public static final int No_Lost_No_Change = 8;

    /**
     * 此卡已发行
     */
    public static final int Card_Already_Issue = 9;

    /**
     * 此人在系统中有多张
     */
    public static final int Psn_Have_Multiple_Card = 10;

    /**
     *已挂失卡不能重复挂失
     */
    public static final int Not_Lost_Repeat = 11;

    /**
     * 正常状态卡不能解挂
     */
    public static final int Normal_Card_No_Unlost = 12;

    /**
     * 余额不足
     */
    public static final int Money_Not_Enough = 13;

    /**
     * 参数错误
     */
    public static final int Param_Error = 14;

    /**
     * 获取发卡参数错误
     */
    public static final int Get_Card_Params_Error = 15;

    /**
     * 编码重复
     */
    public static final int Code_Repeat = 16;

    /**
     * 未找到卡片信息或卡片已挂失
     */
    public static final int Not_Found_Card_Info_Or_Card_Lost = 19;

    /**
     * 密码错误
     */
    public static final int Pwd_Error = 21;

    /**
     * 卡片不是正常状态
     */
    public static final int Card_Not_Normal_State = 22;

}
