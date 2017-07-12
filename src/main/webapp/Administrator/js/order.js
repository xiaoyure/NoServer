//订单详情展示
function dbclick(Tr){
	var $tbody = $("table tbody#dingdanxiangqing");
	$("table tbody#dingdanxiangqing tr").remove();
	var orderId = $(Tr).children('td').eq(1).text();
	//alert(orderId)
	$.ajax({
		type:"get",
		url:"/NoServer/Api/order/detailDisplay",
		data:{
			"orderGoodsId":orderId
		},
		dataType:"json",
		success:function(data){
			for(p in data){
				$tbody.append("<tr><td><image src='"+data[p].orderGoodsAddress+"' style='height: 100px;width: 100px;'></image></td><td id='orderId'>"+data[p].orderGoodsName+"</td><td>"+data[p].orderGoodsPrice+"</td><td>"+data[p].orderGoodsNum+"</td><td>"+data[p].orderGoodsSumPrice+"</td></tr>");
			}
			$("#myModal").css("visibility","visible");
		},
		error:function(){
			alert("出错");
		}
	});
}

//订单展示
function jiazai(){
	var $tbody = $("table tbody#dingdan");
	$.ajax({
		type:"get",
		url:"/NoServer/Api/order/display",
		dataType:"json",
		success:function(data){
			for(p in data){
				$tbody.append("<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\" ondblclick=\"dbclick(this);\"><td>"+data[p].orderCustomerName+"</td><td id='orderId'>"+data[p].orderId+"</td><td>"+data[p].orderStatus+"</td><td>"+data[p].orderSumPrice+"</td><td>"+data[p].orderCreateTime+"</td></tr>");
			}
		},
		error:function(){
			alert("加载出错");
		}
	});
}

$(document).ready(function(){
	jiazai();
	$("#fahuo").click(function(){
		var orderId = $(".s1").find("td").eq(1).text();
		var status = $(".s1").find("td").eq(2).text();
		if(!orderId){
			alert("请选中要发货的订单");
		}
		else if(status=="已发货"){
			alert("该单已发货");
		}
		else{
			$.ajax({
				url:"/NoServer/Api/Admin/goodsSend",
				dataType:"json",
				data:{
					"orderId":orderId
				},
				success:function(data){
					if(data.success){
						alert("发货成功");
						$(".s1").children('td').eq(2).text("已发货");
					}
					else{
						alert("发货失败");
					}
				},
				error:function(){
					alert("发货出错");
				}
			})
		}
	})
})