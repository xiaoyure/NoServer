//加载
$(document).ready(function(){
	var search = getUrlParam('search');
	
	if(search){
		$.ajax({
			url: "Api/Goods/goodssearch",
			type: "post",
			dataType:"json",
			data:{
				"search": search,
			},
			success: function(data) {
				$('#Page').jqPaginator({
					totalCounts: data.length,
					pageSize: 12,
					visiblePages: 10,
					currentPage: 1,
					//prev:0,
					//next:0,
					onPageChange: function (num, type) {
				    	
		    			//alert(place);
		    			//alert(nCategory);
		    			$("div.content_box").each(function(){
		    				//alert(p.goodsName)
							$(this).find("a").eq(1).text("");
							$(this).find("a").eq(0).attr("href","");
							$(this).find("img").eq(0).attr("src","");
							$(this).find("img").eq(0).attr("style","");
							$(this).find("p").eq(0).text("");
						});
		    						    			
		    			var i = 0;
		    			$("div.content_box").each(function(){
		    				//alert(p.goodsName)
		    				if(i<((data.length - (num-1)*12)>12?12:data.length - (num-1)*12)){
								$(this).find("a").eq(1).text(data[(num-1)*12+i].goodsName);
								$(this).find("a").eq(0).attr("href","details.html?goodsId="+data[(num-1)*12+i].goodsId);
								$(this).find("img").eq(0).attr("src",data[(num-1)*12+i].goodsImage);
								$(this).find("img").eq(0).attr("style","width:460px;height:260px");
								$(this).find("p").eq(0).text("￥"+data[(num-1)*12+i].goodsPrice);
		    				}
		    				i++;
						});
				    	
		    			$('#Page').jqPaginator('option', {
		    			    currentPage: 1
		    			});
				    }
				});
			},
			error: function(){
				alert("error!");
			}
		});
	}
	else{
		var place = getUrlParam('place');
		var category = getUrlParam('category');
		var nCategory;
		var goodsNum;
		
		if(category=="主板"){
			nCategory = 1;
		}
		else if(category=="CPU")
			nCategory = 2;
		else if(category=="内存")
			nCategory = 3;
		else if(category=="硬盘")
			nCategory = 4;
		else if(category=="显卡")
			nCategory = 5;
		else if(category=="电源")
			nCategory = 6;
		else if(category=="外设")
			nCategory = 7;
		
		$.ajax({
			type:"get",
			url:"Api/customer/backCount",
			dataType:"json",
			data:{
				"goodsName":place,
				"goodsCategoryId":nCategory
			},
			success:function(data){
				goodsNum = data;
				//分页
				//alert(goodsNum);
				$('#Page').jqPaginator({
					totalCounts: goodsNum,
					pageSize: 12,
					visiblePages: 10,
					currentPage: 1,
					//prev:0,
					//next:0,
					onPageChange: function (num, type) {
				    	$.ajax({
				    		type:"get",
				    		url:"Api/customer/backDisplay",
				    		dataType:"json",
				    		data:{
				    			"pageIndex":num,
				    			"goodsOrder":0,
				    			"goodsName":place,
				    			"goodsCategoryId":nCategory
				    		},
				    		success:function(data){
				    			//alert(place);
				    			//alert(nCategory);
				    			$("div.content_box").each(function(){
				    				//alert(p.goodsName)
									$(this).find("a").eq(1).text("");
									$(this).find("a").eq(0).attr("href","");
									$(this).find("img").eq(0).attr("src","");
									$(this).find("img").eq(0).attr("style","");
									$(this).find("p").eq(0).text("");
								});
				    						    			
				    			var i = 0;
				    			$("div.content_box").each(function(){
				    				//alert(p.goodsName)
				    				if(i<data.rows.length){
										$(this).find("a").eq(1).text(data.rows[i].goodsName);
										$(this).find("a").eq(0).attr("href","details.html?goodsId="+data.rows[i].goodsId);
										$(this).find("img").eq(0).attr("src",data.rows[i].goodsImage);
										$(this).find("img").eq(0).attr("style","width:460px;height:260px");
										$(this).find("p").eq(0).text("￥"+data.rows[i].goodsPrice);
				    				}
				    				i++;
								});
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
	}
});