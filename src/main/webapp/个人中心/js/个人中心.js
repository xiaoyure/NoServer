//评价
function comment(btn){
	var $tbody = $(btn).parent().parent().find('tbody');
	var orderId = $tbody.find('.s1').eq(0).find('td').eq(0).text();
	if(!orderId){
		alert("请选择要评价的订单");
		return ;
	}
	$("#Comment").css('visibility', 'visible');
	$("#comment_btn").click(function(){
		var score = $(this).parent().parent().find('.fenshu').text();
		var comment = $("#textarea").val();
		var status = $(this).parent().parent().find('input').eq(0).is(':checked');
		var Status;
		if(status)
			Status = "匿名"
		else
			Status = "未匿名"
		$.ajax({
			type:"post",
			url:"/NoServer/Api/information/goodsComment",
			dataType:"json",
			data:{
				"orderId":orderId,
				"comment":comment,
				"status":Status,
				"score":score
			},
			success:function(data){
				$tbody.find('.s1').remove();
				$(".table tbody").find('tr').each(function(){
					//alert($(this).find('p').eq(0).text())
					if($(this).find('p').eq(0).text()==orderId)
						$(this).find('span').eq(0).text("完成");
				})
				$("#Comment").css('visibility', 'hidden');
			},
			error:function(){
				alert("评价error");
			}
			
		});
	})
}
//五角星评分
function scoreFun(object, opts) {
	// 默认属性
	var defaults = {
		fen_d: 16, // 每个a的宽度
		ScoreGrade: 10, // a的个数
		types: ["很不满意",
			"差得太离谱，与卖家描述的严重不符，非常不满",
			"不满意",
			"部分有破损，与卖家描述的不符，不满意",
			"一般",
			"质量一般",
			"没有卖家描述的那么好",
			"满意",
			"质量不错，与卖家描述的基本一致，还是挺满意的",
			"非常满意",
			"很差",
			"差",
			"一般",
			"好",
			"很好"
		],
		nameScore: "fenshu",
		parent: "star_score",
		attitude: "attitude"
	};
	options = $.extend({}, defaults, opts);

	var startParent = object.find("." + options.parent); // 找到名为“star_score”的类
	var now_cli;
	var fen_cli;
	var atu;
	var fen_d = options.fen_d; // 每个a的宽度
	var len = options.ScoreGrade; // 把a的个数赋值给len
	startParent.width(fen_d * len); //包含a的div盒子的宽度
	var preA = (5 / len);
	for(var i = 0; i < len; i++) {
		var newSpan = $("<a href='javascript:void(0)'></a>"); // 不整体刷新页面的情况下，可以使用void(0)
		newSpan.css({
			"left": 0,
			"width": fen_d * (i + 1),
			"z-index": len - i
		}); // 设置a的宽度、层级
		newSpan.appendTo(startParent)
	} //  把a放到类名为“star_score”的div里
	startParent.find("a").each( // each（）方法
		function(index, element) {
			$(this).click(function() { // 点击事件
				now_cli = index; // 当前a的索引值
				show(index, $(this)) //  调用show方法
			});
			$(this).mouseenter(function() {
				/* mouseenter事件(与 mouseover 事件不同，只有在鼠标指针穿过被选元素时，
		  	                                 才会触发 mouseenter 事件。如果鼠标指针穿过任何子元素，同样会触发 mouseover 事件。) */
				show(index, $(this))
			});
			$(this).mouseleave(function() { // mouseleave事件 
				if(now_cli >= 0) {
					var scor = preA * (parseInt(now_cli) + 1); // 评分
					startParent.find("a").removeClass("clibg"); // 清除a的“clibg”类
					startParent.find("a").eq(now_cli).addClass("clibg"); // eq()选择器，选取索引值为“now_cli”的a，给它加上“clibg”类
					var ww = fen_d * (parseInt(now_cli) + 1); // 当前a的宽度
					startParent.find("a").eq(now_cli).css({
						"width": ww,
						"left": "0"
					}); // 给索引值为“now_cli”的a加上宽度“ww”和left值
					var countScore = $("#fenshu")
					if(countScore) {
						countScore.text(scor)
					}
				} else {
					startParent.find("a").removeClass("clibg");
					if(countScore) {
						countScore.text("")
					}
				}
			})
		});

	// show方法
	function show(num, obj) {
		var n = parseInt(num) + 1;
		var lefta = num * fen_d;
		var ww = fen_d * n;
		var scor = preA * n; // 评分
		object.find("a").removeClass("clibg"); // 清除所有a的“clibg”类
		obj.addClass("clibg"); // 给当前a添加“clibg”类
		obj.css({
			"width": ww,
			"left": "0"
		}); // 给当前a添加宽度“ww”和left值
		$(".fenshu").text(scor)
	}
};
//收货
function receive(btn){
	var $tbody = $(btn).parent().parent().find('tbody');
	var orderId = $tbody.find('.s1').eq(0).find('td').eq(0).text();
	if(!orderId){
		alert("请选择要收货的订单");
		return ;
	}
	$.ajax({
		type:"post",
		url:"/NoServer/Api/information/goodsReceive",
		dataType:"json",
		data:{
			"orderId":orderId
		},
		success:function(data){
			$tbody.find('.s1').remove();
			$(".table tbody").find('tr').each(function(){
				//alert($(this).find('p').eq(0).text())
				if($(this).find('p').eq(0).text()==orderId)
					$(this).find('span').eq(0).text("待评价");
			})
		},
		error:function(){
			alert("收货出错")
		}
	});
}
//退款
function refund(btn){
	var $tbody = $(btn).parent().parent().find('tbody');
	$("#money").text($tbody.find('.s1').eq(0).find('td').eq(1).text());
	var orderId = $tbody.find('.s1').eq(0).find('td').eq(0).text();
	if(!orderId){
		alert("请选择要退款的订单");
		return ;
	}
	$("#refund_orderId").text(orderId)
	$("#Refund").css('visibility', 'visible');
	//退款提交
	$("#refund_btn").click(function(){
		var reason = $("#refund_reason").val();
		$.ajax({
			type:"post",
			url:"/NoServer/Api/information/goodsBack",
			dataType:"json",
			data:{
				"orderId":orderId,
				"reason":reason
			},
			success:function(data){
				$tbody.find('.s1').remove();
				$(".table tbody").find('tr').each(function(){
					//alert($(this).find('p').eq(0).text())
					if($(this).find('p').eq(0).text()==orderId)
						$(this).find('span').eq(0).text("退货中");
				})
				$("#Refund").css('visibility', 'hidden');
			},
			error:function(){
				alert("退货error");
			}
			
		});
	})
}
//订单详情
function dbclick(Tr){
	var $tbody = $("#OrderDetail").find("tbody");
	var orderId = $(Tr).children('td').eq(0).text();
	//alert("df");
	
	$.ajax({
		type:"get",
		url:"/NoServer/Api/order/detailDisplay",
		data:{
			"orderGoodsId":orderId
		},
		dataType:"json",
		success:function(data){
			$($tbody).children('tr').each(function(){
				$(this).remove();
			})
			for(p in data){
				
				$tbody.append("<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\"><td><image src='"+data[p].orderGoodsAddress+"' style='height: 100px;width: 100px;'></image></td><td id='orderId'>"+data[p].orderGoodsName+"</td><td>"+data[p].orderGoodsPrice+"</td><td>"+data[p].orderGoodsNum+"</td><td>"+data[p].orderGoodsSumPrice+"</td></tr>");
			}
			$("#OrderDetail").css("visibility","visible");
		},
		error:function(){
			alert("出错");
		}
	});
}
//调整菜单高度
function tz(){
	var s = $("#div").height()
	$(".main-sidebar").height(s)
}

//验证并加载
$(document).ready(function(){
	var username = $.cookie('username')
	//var username = "101@qq.com"
	if(username){
		$("#username").text(username);
	}
	else{
		alert("cookie失效，请登陆后再进入个人中心")
		return ;
	}

	//加载全部订单
	$.ajax({
		url:"/NoServer/Api/information/display",
		type:"post",
		dataType:"json",
		data:{
			"orderUserName":username
		},
		success:function(data){
			//alert("success");
			$(".table tbody").children('tr').each(function(){
				$(this).remove();
			})
			for(p in data){
				$(".table tbody").append(   "<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\" ondblclick=\"dbclick(this)\">"+
												"<td>"+
													"<p>"+data[p].orderId+"</p>"+
												"</td>"+
												"<td>"+data[p].orderSumPrice+"元</td>"+
												"<td><span>"+data[p].orderStatus+"</span></td>"+
												"<td>"+
													"<div class='parkbar' data-color='#00a65a' data-height='20'>"+data[p].orderCreateTime+"</div>"+
												"</td>"+
											"</tr>")
			}
			
			tz()
		},
		error:function(){
			alert("error")
		}
	})
	
	

	//订单功能

	//待收货
	$("#waitingForReceive").click(function(){
		var title=0;
		$(".box-title").each(function(){
			if($(this).text()=="待收货")
				title=1;
		})
		if(title==0){
			$(".content-wrapper").append(	"<div class='box box-info'>"+
												"<div class='box-header with-border'>"+
													"<h3 class='box-title'>待收货</h3>"+
							
													"<div class='box-tools pull-right'>"+
														"<button type='button' class='btn' onclick='$(this).parent().parent().parent().remove();'><i class='fa fa-times'>X</i></button>"+
													"</div>"+
												"</div>"+
												"<div class='box-body'>"+
													"<div class='table-responsive'>"+
														"<table id='table_WaitingForReceive' class='table no-margin'>"+
															"<thead>"+
																"<tr>"+
																	"<th>订单编号</th>"+
																	"<th>订单总价</th>"+
																	"<th>订单状态</th>"+
																	"<th>订单时间</th>"+
																"</tr>"+
															"</thead>"+
															"<tbody>"+
															"</tbody>"+
														"</table>"+
													"</div>"+											
												"</div>"+
												"<div class='box-footer clearfix'>"+
													"<a href='javascript:void(0)' class='btn btn-sm btn-info btn-flat pull-right' onclick='refund(this)' >退款</a>"+
													"<a href='javascript:void(0)' class='btn btn-sm btn-default btn-flat pull-right' onclick='receive(this)'>收货</a>"+
												"</div>"+
											"</div>")
		}
		
		//加载待收货
		$.ajax({
			url:"/NoServer/Api/information/receiveDisplay",
			type:"post",
			dataType:"json",
			data:{
				"orderUserName":username
			},
			success:function(data){
				//alert("success");
				$("#table_WaitingForReceive tbody").children('tr').each(function(){
					$(this).remove();
				})
				for(p in data){
					$("#table_WaitingForReceive tbody").append(   "<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\" ondblclick=\"dbclick(this)\">"+
													"<td>"+
														"<p>"+data[p].orderId+"</p>"+
													"</td>"+
													"<td>"+data[p].orderSumPrice+"</td>"+
													"<td><span>"+data[p].orderStatus+"</span></td>"+
													"<td>"+
														"<div class='parkbar' data-color='#00a65a' data-height='20'>"+data[p].orderCreateTime+"</div>"+
													"</td>"+
												"</tr>")
				}
				
				tz()
			},
			error:function(){
				alert("error")
			}
		})
		
		tz()
	})
	//待发货
	$("#waitingForSend").click(function(){
		var title=0;
		$(".box-title").each(function(){
			if($(this).text()=="待发货")
				title=1;
		})
		if(title==0){
			$(".content-wrapper").append(	"<div class='box box-info'>"+
												"<div class='box-header with-border'>"+
													"<h3 class='box-title'>待发货</h3>"+
							
													"<div class='box-tools pull-right'>"+
														"<button type='button' class='btn' onclick='$(this).parent().parent().parent().remove();'><i class='fa fa-times'>X</i></button>"+
													"</div>"+
												"</div>"+
												"<div class='box-body'>"+
													"<div class='table-responsive'>"+
														"<table id='teble_waitingForSend' class='table no-margin'>"+
															"<thead>"+
																"<tr>"+
																	"<th>订单编号</th>"+
																	"<th>订单总价</th>"+
																	"<th>订单状态</th>"+
																	"<th>订单时间</th>"+
																"</tr>"+
															"</thead>"+
															"<tbody>"+
															"</tbody>"+
														"</table>"+
													"</div>"+											
												"</div>"+
												"<div class='box-footer clearfix'>"+
													"<a href='javascript:void(0)' class='btn btn-sm btn-info btn-flat pull-right' onclick='refund(this)'>退款</a>"+
												"</div>"+
											"</div>")
		}
		//加载待发货
		$.ajax({
			url:"/NoServer/Api/information/sendDisplay",
			type:"post",
			dataType:"json",
			data:{
				"orderUserName":username
			},
			success:function(data){
				//alert("success");
				$("#teble_waitingForSend tbody").children('tr').each(function(){
					$(this).remove();
				})
				for(p in data){
					$("#teble_waitingForSend tbody").append(   "<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\" ondblclick=\"dbclick(this)\">"+
													"<td>"+
														"<p>"+data[p].orderId+"</p>"+
													"</td>"+
													"<td>"+data[p].orderSumPrice+"元</td>"+
													"<td><span>"+data[p].orderStatus+"</span></td>"+
													"<td>"+
														"<div class='parkbar' data-color='#00a65a' data-height='20'>"+data[p].orderCreateTime+"</div>"+
													"</td>"+
												"</tr>")
				}
				
				tz()
			},
			error:function(){
				alert("error")
			}
		})
		tz()
	})
	//待评价
	$("#waitingForComment").click(function(){
		var title=0;
		$(".box-title").each(function(){
			if($(this).text()=="待评价")
				title=1;
		})
		if(title==0){
			$(".content-wrapper").append(	"<div class='box box-info'>"+
												"<div class='box-header with-border'>"+
													"<h3 class='box-title'>待评价</h3>"+
							
													"<div class='box-tools pull-right'>"+
														"<button type='button' class='btn' onclick='$(this).parent().parent().parent().remove();'><i class='fa fa-times'>X</i></button>"+
													"</div>"+
												"</div>"+
												"<div class='box-body'>"+
													"<div class='table-responsive'>"+
														"<table id='table_waitingForComment' class='table no-margin'>"+
															"<thead>"+
																"<tr>"+
																	"<th>订单编号</th>"+
																	"<th>订单总价</th>"+
																	"<th>订单状态</th>"+
																	"<th>订单时间</th>"+
																"</tr>"+
															"</thead>"+
															"<tbody>"+
															"</tbody>"+
														"</table>"+
													"</div>"+											
												"</div>"+
												"<div class='box-footer clearfix'>"+
													"<a href='javascript:void(0)' class='btn btn-sm btn-info btn-flat pull-right' onclick='refund(this)'>退款</a>"+
													"<a href='javascript:void(0)' class='btn btn-sm btn-info btn-flat pull-right' onclick='comment(this)'>评价</a>"+
												"</div>"+
											"</div>")
		}
		//加载待评价
		$.ajax({
			url:"/NoServer/Api/information/CommentDisplay",
			type:"post",
			dataType:"json",
			data:{
				"orderUserName":username
			},
			success:function(data){
				//alert("success");
				$("#table_waitingForComment tbody").children('tr').each(function(){
					$(this).remove();
				})
				for(p in data){
					$("#table_waitingForComment tbody").append(   "<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\" ondblclick=\"dbclick(this)\">"+
													"<td>"+
														"<p>"+data[p].orderId+"</p>"+
													"</td>"+
													"<td>"+data[p].orderSumPrice+"元</td>"+
													"<td><span>"+data[p].orderStatus+"</span></td>"+
													"<td>"+
														"<div class='parkbar' data-color='#00a65a' data-height='20'>"+data[p].orderCreateTime+"</div>"+
													"</td>"+
												"</tr>")
				}
				
				tz()
			},
			error:function(){
				alert("error")
			}
		})
		tz()
	})
	//待退货
	$("#refund").click(function(){
		var title=0;
		$(".box-title").each(function(){
			if($(this).text()=="退款状态")
				title=1;
		})
		if(title==0){
			$(".content-wrapper").append(	"<div class='box box-info'>"+
												"<div class='box-header with-border'>"+
													"<h3 class='box-title'>退款状态</h3>"+
							
													"<div class='box-tools pull-right'>"+
														"<button type='button' class='btn' onclick='$(this).parent().parent().parent().remove();'><i class='fa fa-times'>X</i></button>"+
													"</div>"+
												"</div>"+
												"<div class='box-body'>"+
													"<div class='table-responsive'>"+
														"<table id='table_refund' class='table no-margin'>"+
															"<thead>"+
																"<tr>"+
																	"<th>订单编号</th>"+
																	"<th>订单总价</th>"+
																	"<th>订单状态</th>"+
																	"<th>订单时间</th>"+
																"</tr>"+
															"</thead>"+
															"<tbody>"+
															"</tbody>"+
														"</table>"+
													"</div>"+											
												"</div>"+
												"<div class='box-footer clearfix'>"+
												"</div>"+
											"</div>")
		}
		//加载退款
		$.ajax({
			url:"/NoServer/Api/information/goodsBackDisplay",
			type:"post",
			dataType:"json",
			data:{
				"orderUserName":username
			},
			success:function(data){
				//alert("success");
				$("#table_refund tbody").children('tr').each(function(){
					$(this).remove();
				})
				for(p in data){
					$("#table_refund tbody").append(   "<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\" ondblclick=\"dbclick(this)\">"+
													"<td>"+
														"<p>"+data[p].orderId+"</p>"+
													"</td>"+
													"<td>"+data[p].orderSumPrice+"元</td>"+
													"<td><span>"+data[p].orderStatus+"</span></td>"+
													"<td>"+
														"<div class='parkbar' data-color='#00a65a' data-height='20'>"+data[p].orderCreateTime+"</div>"+
													"</td>"+
												"</tr>")
				}
				
				tz()
			},
			error:function(){
				alert("error")
			}
		})
		tz()
	})
	
	
	
})