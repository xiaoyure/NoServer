$(document).ready(function(){
	var username = $.cookie('username')
	//var username = "101@qq.com"
	if(username){
		$("#table_username").text(username);
	}
	else{
		alert("cookie失效，请登陆后再进入个人中心")
		return ;
	}

	$("#SET").click(function(){
		$.ajax({
			type:"post",
			url:"/NoServer/Api/information/customerBack",
			dataType:"json",
			data:{
				"customerName":username
			},
			success:function(data){
				$("#table_name").val(data[0].customerCname)
				$("#table_sex").val(data[0].customerSex)
				$("#table_email").val(data[0].customerEmail)
				$("#table_tel").val(data[0].customerPhone)
				$("#table_address").val(data[0].customerAddress)
				
			},
			error:function(){
				alert("加载个人信息错误")
			}
		});
		$('#Setting').css('visibility', 'visible')
	})
	
	$("#informationChange").click(function(){
		var email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		var tel = /^1[3|4|5|7|8][0-9]{9}$/;
		var customerCname = $("#table_name").val()
		var customerSex = $("#table_sex").val()
		var customerEmail = $("#table_email").val()
		var customerPhone = $("#table_tel").val()
		var customerAddress = $("#table_address").val()
		if(customerEmail)
			if(!email.test(customerEmail)){
				alert("邮箱格式错误");
				return ;
			}
		
		if(customerPhone)
			if(!tel.test(customerPhone)){
				alert("手机号码格式错误")
				return ;
			}
		$.ajax({
			type:"post",
			url:"/NoServer/Api/information/customerUpdate",
			dataType:"json",
			data:{
				"customerName":username,
				"customerCname":customerCname,
				"customerSex":customerSex,
				"customerEmail":customerEmail,
				"customerPhone":customerPhone,
				"customerAddress":customerAddress
			},
			success:function(data){
				alert("修改个人信息成功")
			},
			error:function(){
				alert("修改个人信息错误")
			}
		});
		$('#Setting').css('visibility', 'hidden')
	})
	
	$("#passwordChange").click(function(){
		var password = $("#table_password").val()
		var newPassword = $("#table_newPassword").val()
		
		if(!newPassword){
			alert("password不能为空");
			return;
		}
		else{
			if(newPassword.length<6){
				alert("密码长度不能小于6位")
				return;
			}
			if(newPassword.length>18){
				alert("密码长度不能小于18位")
				return;
			}
			
		}
		$.ajax({
			type:"post",
			url:"/NoServer/Api/information/PasswordUpdate",
			dataType:"json",
			data:{
				"customerName":username,
				"customerPassword":password,
				"newcustomerPassword":newPassword
			},
			success:function(data){
				if(data.success)
					alert("修改密码成功")
				else
					alert("旧密码错误")
					
				password = $("#table_password").val("")
				newPassword = $("#table_newPassword").val("")
			},
			error:function(){
				alert("修改密码错误")
			}
			
		});
		$('#changePassword').css('visibility', 'hidden');
	})
	
	$("#exit").click(function(){
		$.cookie('username',"",{path:"/"});
		$.cookie('password', "",{path:"/"});
		window.location = "../index.html";
	})
})