<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<title>用户上传图片页面</title>  
 <base href="<%=basePath%>">  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<script src="js/jquery-3.2.1.min.js"></script>
</head>  
<body>  
    <center>  
        
            <input id="file" type="file" name="file" />   
            <script type="text/javascript">
            	$(document).ready(function(){
            		$("#btn").click(function(){
            			var c = $("#file").val()
            			alert(c)
            		})
            	})
            </script>
            <input id="btn" type="button" value="上 传" />  
       
        <h5>上传结果：</h5>  
        <img alt="暂无图片" src="${fileUrl}" />  
    </center>  
</body>  
</html>  