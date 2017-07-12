//动态加载	
document.write("<script src='js\/jquery.cookie.js'><\/script>")

$( document ).ready(function() {
$('#cssmenu > ul > li > a').click(function() {
  $('#cssmenu li').removeClass('active');
  $(this).closest('li').addClass('active');	
  var checkElement = $(this).next();
  if((checkElement.is('ul')) && (checkElement.is(':visible'))) {
    $(this).closest('li').removeClass('active');
    checkElement.slideUp('normal');
  }
  if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
    $('#cssmenu ul ul:visible').slideUp('normal');
    checkElement.slideDown('normal');
  }
  if($(this).closest('li').find('ul').children().length == 0) {
    return true;
  } else {
    return false;	
  }		
});
});


// Login Form
$(function() {
    var button = $('#loginButton');
    var box = $('#loginBox');
    var form = $('#loginForm');
    var username = $("#username");
    button.removeAttr('href');
    button.mouseup(function(login) {
        box.toggle();
        button.toggleClass('active');
    });
    form.mouseup(function() { 
        return false;
    });
    $(this).mouseup(function(login) {
        if(!($(login.target).parent('#loginButton').length > 0)) {
            button.removeClass('active');
            box.hide();
        }
    });
    
});
//登陆
$(document).ready(function(){
	$("#login").click(function(){
		var username = $("#email").val();
		var password = $("#password").val();
		if(!username){
			alert("用户名不能为空");
			return;
		}
		if(!password){
			alert("密码不能为空")
			return;
		}
		
		$.ajax({
			url:"Api/customer/login",
			type:"POST",
			dataType:"json",
			data:{
				"username":username,
				"password":password
			},
			success:function(data){
				if(data.success){
					alert("success")
					$("#loginButton").find('span').eq(0).text(username);
					$("#loginButton").attr("href","#")
					$('#loginBox').hide();
					$.cookie('username',username,{path:'/'});
					$.cookie('password',password,{path:'/'});
					$("#loginButton").click(function(){
						window.location = "个人中心/个人中心.html"
					})
				}
				else{
					alert(data.success);
				}
			},
			error:function(){
				alert("出错");
			}
		});
	})
});

function GetUrlParms()  
{
  var args=new Object();  
  var query=location.search.substring(1);//获取查询串  
  var pairs=query.split("&");//在逗号处断开  
  for(var  i=0;i<pairs.length;i++)  
  {  
     var pos=pairs[i].indexOf('=');//查找name=value  
     if(pos==-1)  continue;//如果没有找到就跳过  
     var argname=pairs[i].substring(0,pos);//提取name  
     var value=pairs[i].substring(pos+1);//提取value  
     args[argname]=unescape(value);//存为属性  
  }
  return args;
}

$(document).ready(function(){
	var box = $('#loginBox');
	var wdsc = $("#wdsc");
	wdsc.click(function(){
		box.toggle();
	});
});

//菜单
$(document).ready(function(){
	var women = $("a[href='women.html']");
	
	women.each(function(){
		$(this).attr("href","women.html?place="+$(this).text()+"&category="+$(this).parent().parent().parent().parent().parent().parent().parent().find("#CATEGORY").text());
	})
	
})
//获取url参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if(r != null) return decodeURI(r[2]);
	return null; //返回参数值
}

//验证
$(document).ready(function(){
	var username = $.cookie('username')
	if(username&&username!=null){
		//alert(username)
		$("#loginButton").find('span').eq(0).text(username);
		$("#loginButton").attr("href","#")
		$("#loginButton").click(function(){
			window.location = "个人中心/个人中心.html"
		})
	}
})

//搜索
$(document).ready(function(){
	$(".search").find("input").eq(1).click(function(){
		var search = $(".search").find("input").eq(0).val();

		if(search){
			if(search.length>30){
				alert("搜索字符不能大于30个");
				return ;
			}
			window.location = "women.html?search="+encodeURI(search);
		}
		else{
			alert("搜索不能为空")
		}
			
	})
})