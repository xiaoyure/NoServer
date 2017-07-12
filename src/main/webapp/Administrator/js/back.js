//加载
function jiazai(){
	var $tbody = $("table tbody");
	
	$.ajax({
		type:"get",
		url:"/NoServer/Api/Admin/backdisplay",
		dataType:"json",
		success:function(data){
			for(p in data){
				var backCondition;
				if(data[p].backCondition==1)
					backCondition = "未处理";
				else{
					backCondition = "已退货"
				}
				
				$tbody.append("<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\"><td>"+data[p].odetailsId+"</td><td>"+data[p].goodsName+"</td><td>"+backCondition+"</td><td>"+data[p].backNum+"</td><td>"+data[p].backReason+"</td><td>"+data[p].createTime+"</td></tr>");
			}
			
		},
		error:function(){	
			alert("出错");
		}
	});
}

$(document).ready(function(){
	jiazai();
	//处理
	$("#chuli").click(function(){
		var odetailsId = $(".s1").find("td").eq(0).text();
		var status = $(".s1").find("td").eq(2).text();
		if(!odetailsId){
			alert("请选中要处理退货单");
		}
		else if(odetailsId=="已退货"){
			alert("该单已退货");
		}
		else{
			$.ajax({
				url:"/NoServer/Api/Admin/backdeal",
				dataType:"json",
				data:{
					"odetailsId":odetailsId
				},
				success:function(data){
					if(data.success){
						alert("处理成功");
						$(".s1").children('td').eq(2).text("已退货");
					}
					else{
						alert("处理失败");
					}
				},
				error:function(){
					alert("出错");
				}
			})
		}
	})
})