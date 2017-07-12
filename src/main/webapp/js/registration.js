$(document).ready(function(){
	$("#register-submit").click(function(){
		var email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		var customerName = $("#customerName").val();
		var customerEmail = $("#registEmail").val();
		var customerPassword = $("#customerPassword").val();
		var customerPassword2 = $("#customerPassword2").val();
		var sex1 = $("#sex1").attr("checked");
		var sex2 = $("#sex2").attr("checked");
		var sex3 = $("#sex3").attr("checked");		
		var sex;

		if(!customerName){
			alert("username不能为空");
			return;
		}
		else{
			if(customerName.length<6){
				alert("用户名长度不能小于6位")
				return;
			}
			if(customerName.length>20){
				alert("用户名长度不能小于20位")
				return;
			}
		}
		
		if(!customerEmail){
			if(!email.test(customerEmail)){
				alert("邮箱格式错误");
				return ;
			}
		}
		
		if(!customerPassword){
			alert("password");
			return;
		}
		else if(!customerPassword2){
			alert("重复密码不能为空");
			return
		}
		else{
			if(customerPassword.length<6){
				alert("密码长度不能小于6位")
				return;
			}
			if(customerPassword.length>18){
				alert("密码长度不能小于18位")
				return;
			}
			if(customerPassword != customerPassword2){
				alert("密码与重复密码不同");
				return;
			}	
		}
		if(sex1)		//男
			sex=3;				
		else if(sex2)	//女		
			sex=2;				
		else			//保密
			sex=1;				
		
		$.ajax({
			url: "Api/customer/register",
			type: "POST",
			dataType:"json",
			data:{
				"customerName": customerName,
				"customerPassword": customerPassword,
				"customerSex": sex,
				"customerEmail": customerEmail
			},
			success: function(data) {
				if (data.success == true) {
					alert("regist success~");
					window.location= "index.html";
				}
				else {
					alert("username already exist!");
				}
			},
			error: function(){
				alert("error!");
			}
		});
	})
})