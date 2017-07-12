//地址加载
$(document).ready(function(){
	var username = $.cookie('username');
	//var username="101@qq.com";
	
	$.ajax({
		url:"Api/order/addressChosen",
		type:"post",
		dataType:"json",
		data:{
			"customerName":username
		},
		success:function(data){
			//alert("地址success");
			for(p in data){
				$("#address-list").append(	"<li class='J_Addr J_MakePoint clearfix  J_DefaultAddr' >"+
										"<s class='J_Marker marker'></s>"+
										"<span class='marker-tip'>寄送至</span>"+
										"<div class='address-info'>"+
											"<input name='address' class='J_MakePoint ' type='radio' style='float: left;'"+status+">"+
											"<label class='user-address' style='float: left;'>"+data[p].addressLocation+"</label>"+
										"</div>"+
									"</li>"
				)
			}
			$("#address-list").find("input").each(function(){
				$(this).click(function(){
					$("#J_AddrConfirm").text($(this).parent().children('label').text());
				})
			})
			$("#J_AddrNameConfirm").text(data[0].customerCname)
		},
		error:function(){
			alert("地址error")
		}
	})
	
	
	

	//订单加载
	
	$.ajax({
		type:"post",
		url:"Api/customer/shoppingcartDisplay",
		dataType:"json",
		data:{
			"customerName":username
		},
		success:function(data){
			//alert("确定")
			var sum=0;
			for(p in data){
				sum += data[p].goodsPrice*data[p].goodsNum;
				$("#J_OrderTable tbody").append("<tr class='item' data-pointRate='0'>"+
						"<td class='s-title'>"+
							"<a href='details.html?goodsId="+data[p].goodsId+"' target='_blank' class='J_MakePoint'>"+
								"<img src='"+data[p].goodsImage+"' style='height:100px;width:100px'><span>"+data[p].goodsName+"</span>"+
							"</a>"+
						"</td>"+
						"<td class='s-price'>"+

							"<span class='price '>"+
								"<em class='style-normal-small-black J_ItemPrice'  >"+data[p].goodsPrice+"</em>"+
							"</span>"+
						"</td>"+
						"<td class='s-amount' data-point-url=''>"+
							"<p>"+data[p].goodsNum+"</p>"+
						"</td>"+
						"<td class='s-total'>"+

							"<span class='price '>"+
								"<em class='style-normal-bold-red J_ItemTotal '  >"+data[p].goodsPrice*data[p].goodsNum+"</em>"+
						"</span>"+
						"</td>"+
					"</tr>")
			}
			$("#J_OrderTable tbody").append("<tr class='shop-total blue-line'>"+
												"<td colspan='5'>店铺合计："+
													"<span class='price g_price '>"+
															"<span>&yen;</span>"+
															"<em class='style-middle-bold-red J_ShopTotal'>"+sum+"</em>"+
													"</span>"+
												"</td>"+
											"</tr>")
			
			
		},
		error:function(){
			alert("error")
		}
	});
	
	$("#J_Go").click(function(){
		$.ajax({
			url:"Api/order/submitOrder",
			type:"post",
			dataType:"json",
			data:{
				"username":username
			},
			success:function(data){
				alert("提交订单成功")
				window.location.href="index.html";
			},
			error:function(){
				alert("提交订单错误")
			}
		})
	})
	
})