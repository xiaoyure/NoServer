<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>用户登录</title>
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/login.css" rel="stylesheet">
    <!-- jquery -->
    <script src="js/jquery-3.2.1.min.js"></script>

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">请登录</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" id = "username" placeholder="用户名或手机号码" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id = "passwod" placeholder="密码" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">记住我
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <a href="#" onclick="login();" class="btn btn-lg btn-primary btn-block">登录</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <script>
    
    	function login(){
    		//取用户名
    		var username = $("#username").val();
    		
    		//取密码
    		var password = $("#passwod").val();
    		//ajax验证
    		//jquery,$.post(),$.get(),$.ajax()
    		$.ajax({
    			url:"Api/user/login",//后台接收的地址
    			type:"post",
    			data:{uname:username,pass:password},//传向后台的参数
    			dataType:"json",//text,xml,html,script
    			success:function(data){//data是指后台响应回来的数据它的数据格式取决于dataType
    				if(data.success==true){
    					alert("login success");
    					location.href = "main.jsp";
    				}else{
    					alert("username or password error!");
    				}
    				//console.log(data);
    			},
    			error:function(){
    				alert("location error!");
    			}
    		});
    	}
    </script>
</body>
</html>
