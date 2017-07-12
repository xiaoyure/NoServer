$(document).ready(function(){
	var login = $("#Login");
	login.click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		var remember = $("#remember").val();
		
		if(!username){
			alert("用户名不能为空");
			return;
		}
		if(!password){
			alert("密码不能为空");
		}
		
		$.ajax({
			url: "/NoServer/Api/Admin/Adminlogin",
			type: "POST",
			dataType: "json",
			data:{
				"user_name":username,
				"pass_word":password
			},
			success: function(data){
				if(data.success){
					alert("登陆成功");
					if(remember.checked){
						$.cookie('username', username, { expires: 7 }); 
						$.cookie('password', password, { expires: 7 }); 
					}
					window.location="index.html";
				}
				else{
					alert("登陆失败");
				}
			},
			error: function(){
				alert("出错");
			}
		})
	})
})
