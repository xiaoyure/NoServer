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

$(document).ready(function(){
	var text = GetUrlParms();
	if(text["email"]){
		$("#username").text(text["email"]);
		$("#login").attr("value","更换账户");
	}
	
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
		$("#loginForm").submit();
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