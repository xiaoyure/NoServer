//package com.iandtop.utils;
//
//import com.iandtop.model.pub.JquryDataTablesVO;
//import com.iandtop.model.pub.SuperModel;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * @author andyzhao
// */
//public class JqueryDataTablesUtil {
//    /**
//     * 过滤传递过来的参数
//     *
//     * @param vo
//     * @param request
//     */
//    public static SuperModel filterParam(SuperModel vo, HttpServletRequest request) {
//        String orderColumnIndex = request.getParameter("order[0][column]");
//        String orderColumnName = request.getParameter("columns[" + orderColumnIndex + "][data]");
//        String orderDir = request.getParameter("order[0][dir]");
//        vo.setOrderColumnName(orderColumnName);
//        vo.setOrderDir(orderDir);
//        return vo;
//    }
//
//    /**
//     * datatables表格返回数据
//     *
//     * @param count
//     * @param result
//     * @return
//     */
//    public static JquryDataTablesVO<SuperModel> madeJqueryDatatablesVO(Integer count, List result) {
//        JquryDataTablesVO<SuperModel> rtv = new JquryDataTablesVO<SuperModel>();
//        rtv.setRecordsTotal(count);
//        rtv.setRecordsFiltered(count);
//        rtv.setData(result);
//        return rtv;
//    }
//}
