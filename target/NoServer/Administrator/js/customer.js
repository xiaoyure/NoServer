//加载
function jiazai(){
	var $tbody = $("table tbody");
	$.ajax({
		type:"get",
		url:"/NoServer/Api/Admin/customerdisplay",
		dataType:"json",
		success:function(data){
			for(p in data){
				var sex;
				if(data[p].customerSex==1)
					sex = "男";
				else if(data[p].customerSex==2)
					sex = "女";
				else
					sex = "保密";
					
				$tbody.append("<tr onclick=\"$(this).addClass('s1').siblings().removeClass('s1');\"><td>"+data[p].customerName+"</td><td>"+data[p].customerCname+"</td><td>"+sex+"</td><td>"+data[p].customerPhone+"</td><td>"+data[p].customerEmail+"</td><td>"+data[p].customerCreditLevel+"</td></tr>");
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