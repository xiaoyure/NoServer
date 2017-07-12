function Delete(btn){
	var username = $.cookie('username');
	//var username = "101@qq.com";
	var goodsId = $(btn).attr('text');
	//alert(goodsId);
	$.ajax({
		type:"post",
		url:"Api/customer/shoppingcartDelete",
		dataType:"json",
		data:{
			"username":username,
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
	//var username="101@qq.com";
	
	
	//加载
	$.ajax({
		type:"post",
		url:"Api/customer/shoppingcartDisplay",
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
										"<p>数量：<span>"+data[p].goodsNum+"</span></p>"+
										"<p> 总价：￥<span>"+data[p].goodsPrice*data[p].goodsNum+"</span></p>"+
										"<input type='button' value='移除' onclick='Delete(this)' style='float:right' text='"+data[p].goodsId+"'>"+
									"</div>"+
									"<div class='clearfix'></div>"+
								"</div>")
			}
			
			$(".main").append("<div class='shoping_bag1'>" +
								"<div class='shoping_right'>"+
									"<p> 总价：￥<span id='sum'>"+sum+"</span></p>"+
									"<p><span></span></p>"+
									"<input id='submitOrder' type='button' value='提交订单' style='float:right'>"+
								"</div>"+
								"<div class='clearfix'></div>"+
							"</div>")
							
			//提交订单
			$("#submitOrder").click(function(){
				window.location = "submitOrder.html"
			})
		},
		error:function(){
			alert("error")
		}
	});
})

