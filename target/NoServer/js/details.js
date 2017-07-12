//动态加载js
document.write("<script src='js\/jqPaginator.js'><\/script>")
//加载details
$(document).ready(function(){
	var goodsId = getUrlParam("goodsId");
	$.ajax({
		type:"get",
		url:"Api/customer/goodsDetail",
		dataType:"json",
		data:{
			"goodsId":goodsId
		},
		success:function(data){
			//alert("success")
			$(".desc1").find("h3").eq(0).text(data[0].goodsName)
			$(".desc1").find("p").eq(0).text("￥"+data[0].goodsPrice)
			$(".desc1").find("p").eq(1).text(data[0].goodsStock)
			$(".single-bottom1").find("p").eq(0).text(data[0].goodsDescription)
			$("#etalage").find("img").each(function(){
				$(this).attr("src",data[0].goodsImage)
			})
		},
		error:function(){
			alert("error")
		}
	});
	
})
//加载评论
$(document).ready(function(){
	
	var goodsId = getUrlParam('goodsId');
	var commentNum;
	
	$.ajax({
		type:"get",
		url:"Api/comment/commentCount",
		dataType:"json",
		data:{
			"goodsId":goodsId,
			
		},
		success:function(data){
			commentNum = data;
			//分页
			$('#Page').jqPaginator({
				totalCounts: commentNum,
				pageSize: 12,
				visiblePages: 10,
				currentPage: 1,
				prev:0,
				next:0,
				onPageChange: function (num, type) {
			    	$.ajax({
			    		type:"get",
			    		url:"Api/comment/commentDisplay",
			    		dataType:"json",
			    		data:{
			    			"pageIndex":num,
			    			"goodsId":goodsId
			    		},
			    		success:function(data){
			    			
		    				var commentLevel;
		    				var p=0;
			    			$(".product").each(function(){
			    				if(p<data.rows.length){
				    				if(data.rows[p].commentStatus!="匿名")
										$(this).find('p').eq(0).text(data.rows[p].customerName);
									else
										$(this).find('p').eq(0).text("匿名");
									$(this).find('p').eq(1).text(data.rows[p].customerCreditLevel);
									if(data.rows[p].commentLevel==1)
										commentLevel = "非常不满意"
									else if(data.rows[p].commentLevel==2)
										commentLevel = "不满意"
									else if(data.rows[p].commentLevel==3)
										commentLevel = "中等"
									else if(data.rows[p].commentLevel==4)
										commentLevel = "满意"
									else if(data.rows[p].commentLevel==5)
										commentLevel = "非常满意"
									$(this).find('a').eq(0).text(commentLevel);
									$(this).find('p').eq(2).text(data.rows[p].commentContent);
									$(this).find('p').eq(3).text(data.rows[p].commentTime);
			    				}
			    				else
			    					$(this).hide();
			    				p++;
			    			})
			    			
			    		},
			    		error:function(){
			    			alert("出错");
			    		}
			    	})
			    }
			});
		},
		error:function(){
			alert("error");
		}
	})
	
	
	
});

//购买 加入购物车 收藏
$(document).ready(function(){
	
	var username = $.cookie('username')
	var goodsId = getUrlParam('goodsId');
	
	
	$("#purchase").click(function(){
		var stock = $(".det_nav").find("p").eq(0).text()
		var goodsNum = $("#number").val();
		if(parseInt(goodsNum)>parseInt(stock)){
			alert("购买数量超过库存")
			return;
		}
			
		$.ajax({
			type:"post",
			url:"Api/customer/addShopping",
			dataType:"json",
			data:{
				"customerName":username,
				"goodsId":goodsId,
				"goodsStock":goodsNum
				
			},
			success:function(data){
				window.location = "shoppingcart.html"
			},
			error:function(){
				alert("购买error");
			}
		})
		
	})
	
	$("#addToCart").click(function(){
		var stock = $(".det_nav").find("p").eq(0).text()
		var goodsNum = $("#number").val();
		if(parseInt(goodsNum)>parseInt(stock)){
			alert("购买数量超过库存")
			return;
		}
		$.ajax({
			type:"post",
			url:"Api/customer/addShopping",
			dataType:"json",
			data:{
				"customerName":username,
				"goodsId":goodsId,
				"goodsStock":goodsNum
			},
			success:function(data){
				alert("已加入购物车")
			},
			error:function(){
				alert("加入购物车error");
			}
		})
		
	})
	
	if($("#loginButton").find('span').eq(0).text()==username){
		$("#collect").find('span').eq(0).text("收藏")
		$("#collect").click(function(){
			$.ajax({
				type:"post",
				url:"Api/customer/addCollect",
				dataType:"json",
				data:{
					"customerName":username,
					"goodsId":goodsId,
				},
				success:function(data){
					alert("已加入收藏")
				},
				error:function(){
					alert("加入收藏error");
				}
			})
		})
	}
});

