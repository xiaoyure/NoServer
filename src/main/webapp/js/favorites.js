function Delete(btn){
	var username = $.cookie('username');
	var goodsId = $(btn).attr('text');
	//alert(goodsId);
	$.ajax({
		type:"post",
		url:"/NoServer/Api/information/collectDelete",
		dataType:"json",
		data:{
			"customerName":username,
			"goodsId":goodsId
		},
		success:function(data){
			alert("移除成功")
			$(btn).parent().parent().remove();
			var sum = 0;
			$(".main").find('.shoping_bag1').each(function(){
				sum += Number($(this).find('span').eq(1).text());
			})
			$("#sum").text(sum);
		},
		error:function(){
			alert("出错")
		}
	})
}

$(document).ready(function(){
	var username = $.cookie('username');
	$.ajax({
		type:"post",
		url:"/NoServer/Api/information/collectDisplay",
		dataType:"json",
		data:{
			"customerName":username
		},
		success:function(data){
			var sum=0;
			for(p in data){
				sum += data[p].goodsPrice*data[p].goodsNum;
				$(".main").append("<div class='shoping_bag1'>" +
									"<div class='shoping_left'>"+
										"<div class='shoping1_of_1'>"+
											"<a href='details.html?goodsId="+data[p].goodsId+"'><img src='"+data[p].goodsImage+"' class='img-responsive' alt='' />"+
										"</div>"+
										"<div class='shoping1_of_2'>"+
											"<h4><a href='details.html?goodsId="+data[p].goodsId+"'>"+data[p].goodsName+"</a> </h4>"+						
											"<ul class='s_icons'>"+	
												"<li>￥"+data[p].goodsPrice+"</li>"+	
											"</ul>"+	
										"</div>"+	
									"</div>"+
									"<div class='shoping_right'>"+
										"<input type='button' value='移除' onclick='Delete(this)' style='float:right' text='"+data[p].goodsId+"'>"+
									"</div>"+
									"<div class='clearfix'></div>"+
								"</div>")
			}
		},
		error:function(){
			alert("error")
		}
	});
})