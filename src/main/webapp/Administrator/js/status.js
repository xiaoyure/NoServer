//下架->上架
function dbclick(btn){
	var goodsId = $(btn).children('td').eq(0).text();
	if($(btn).children('td').eq(2).text()!="下架")
		return;
	//alert(orderId)
	$.ajax({
		type:"post",
		url:"/NoServer/Api/Admin/updateonsell",
		data:{
			"goodsId":goodsId
		},
		dataType:"json",
		success:function(data){
			$(btn).children('td').eq(2).text("上架")
		},
		error:function(){
			alert("出错");
		}
	});
}


//加载
function jiazai(){
	var $tbody = $("table tbody");
	$.ajax({
		type:"get",
		url:"/NoServer/Api/Admin/display",
		dataType:"json",
		success:function(data){
			for(p in data){
				var goodsState;
				
				if(data[p].goodsState==1)
					goodsState = "上架";
				else
					goodsState = "下架";
						
				if(data[p].goodsCategoryId==1)
					goodsCategoryId = "主板";
				else if(data[p].goodsCategoryId==2)
					goodsCategoryId = "CPU";
				else if(data[p].goodsCategoryId==3)
					goodsCategoryId = "内存";
				else if(data[p].goodsCategoryId==4)
					goodsCategoryId = "硬盘";
				else if(data[p].goodsCategoryId==5)
					goodsCategoryId = "显卡";
				else if(data[p].goodsCategoryId==6)
					goodsCategoryId = "电源";
				else if(data[p].goodsCategoryId==7)
					goodsCategoryId = "外设";
				
				
				$tbody.append("<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\" ondblclick=\"dbclick(this);\"><td>"+data[p].goodsId+"</td><td>"+data[p].goodsName+"</td><td>"+goodsState+"</td><td>"+data[p].goodsStock+"</td><td>"+goodsCategoryId+"</td><td>"+data[p].goodsPrice+"</td></tr>");
			}
			
		},
		error:function(){
			alert("出错");
		}
	});
}
//商品上架
$(document).ready(function(){
	$("#tijiao").click(function(){
		var goodsName = $("#goodsName").val();
		var status = $("#status").val();
		var stock = $("#stock").val();
		var price = $("#price").val();
		var img = $("#cfile").val();
	
		if(!goodsName){
			alert("商品名不能为空");
			return;
		}
		
		if(!stock){
			alert("库存不能为空");
			return;
		}
		
		if(!price){
			alert("价格不能为空");
			return;
		}
		
		var form = $("#goodsadd")[0];
		var formData = new FormData(form);//1.FormData//dom对象;
		$.ajax({
			url: "/NoServer/Api/Admin/onsell",  
			type: "post",  
			dataType: "json",  
			data: formData,
			contentType: false, //3.必须false才会避开jQuery对 formdata 的默认处理, XMLHttpRequest会对 formdata 进行正确的处理 
       		processData: false, //4.必须false才会自动加上正确的Content-Type
			success: function(data){
				if(data.success == true) {  
			        alert("上传成功");
			        $("table tbody tr").remove();
			        jiazai();
				} 
				else {  
					alert("上传失败"); 
				}  
			},  
			error:function(){
				alert("出错");
			}
		});  
		
	})
})



//加载商品表， 商品展示
$(document).ready(function(){
	jiazai();
})


//商品下架
$(document).ready(function(){
	$("#xiajia").click(function(){
		var GoodsId = $(".s1").find("td").eq(0).text();
		if(GoodsId==""){
			alert("请选中要下架的货物");
		}
		else{
			$.ajax({
				url:"/NoServer/Api/Admin/soldout",
				dataType:"json",
				data:{
					"goodsId":GoodsId
				},
				success:function(data){
					if(data.success){
						alert("下架成功");
						$(".s1").children('td').eq(2).text("下架")
					}
					else{
						alert("下架失败");
					}
				},
				error:function(){
					alert("出错");
				}
			})
			
		}
	})
})

