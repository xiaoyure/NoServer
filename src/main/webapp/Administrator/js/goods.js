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
				
				$tbody.append("<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\"><td>"+data[p].goodsId+"</td><td>"+data[p].goodsName+"</td><td>"+goodsState+"</td><td>"+data[p].goodsStock+"</td><td>"+goodsCategoryId+"</td><td>"+data[p].goodsPrice+"</td></tr>");
			}
			
		},
		error:function(){
			alert("出错");
		}
	});
}

$(document).ready(function(){
	jiazai();
})