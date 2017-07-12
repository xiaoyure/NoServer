<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jquery上传文件图片等</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/messages_zh.js"></script>
<script>
$(function(){
	/* $("#commentForm").validate({
		submitHandler: function(form) {  //form->dom对象
			//form.submit();
			//var param = $("#commentForm").serialize();  
			//var formData = new FormData($("#commentForm")[0]);
			var formData = new FormData(form);//FormData//dom对象;
			$.ajax({
				url : "jqueryAjaxUploadServlet",  
				type : "post",  
				dataType : "json",  
				data: formData,//$("#commentForm").serialize(),//serializeArray(),
				contentType: false, //必须false才会避开jQuery对 formdata 的默认处理, XMLHttpRequest会对 formdata 进行正确的处理 
	       		processData: false, //必须false才会自动加上正确的Content-Type
				success : function(data){
					if(data.status=='0') {  
					        alert("上传成功");
					} else {  
						 alert("上传失败"); 
					}  
				}  
			});  
			}  
			
		});   */
		$(":button").click(function(){
			var form = $("#commentForm")[0];
			var formData = new FormData(form);//1.FormData//dom对象;
			$.ajax({
				url : "jqueryAjaxUploadServlet",  
				type : "post",  
				dataType : "json",  
				data: formData,//2.$("#commentForm").serialize(),//serializeArray()
				contentType: false, //3.必须false才会避开jQuery对 formdata 的默认处理, XMLHttpRequest会对 formdata 进行正确的处理 
	       		processData: false, //4.必须false才会自动加上正确的Content-Type
				success : function(data){
					if(data=='0') {  
					        alert("上传成功");
					} else {  
						 alert("上传失败"); 
					}  
				}  
			});  
		});
});
</script>
</head>
<body>
<form class="cmxform" id="commentForm" method="post"  enctype="multipart/form-data">
  <fieldset>
    <legend>输入您的名字，邮箱，URL，备注。</legend>
    <p>
      <label for="cname">Name (必需, 最小两个字母)</label>
      <input id="cname" name="name" minlength="2" type="text" required>
    </p>
    <p>
      <label for="cpassword">密码 (必需, 最小6个字母)</label>
      <input id="cpassword" name="password" minlength="6" type="password" required>
    </p>
    <p>
      <label for="cconfirmpassword">确认密码 (必需, 最小6个字母)</label>
      <input id="cconfirmpassword" name="confirmpassword" minlength="6"   type="password" equalTo="#cpassword" required>
    </p>
    <p>
      <label for="cemail">E-Mail (必需)</label>
      <input id="cemail" type="email" name="email" required>
    </p>
    <p>
      <label for="curl">URL (可选)</label>
      <input id="curl" type="url" name="url">
    </p>
    <p>
      <label for="cfile">文件:</label>
      <input id="cfile" type="file" name="file">
    </p>
    <p>
      <label for="ccomment">备注 (必需)</label>
      <textarea id="ccomment" name="comment" required></textarea>
    </p>
    <p>
    
      <input class="submit" type="button" value="Submit">
    </p>
  </fieldset>
</form>
</body>
</html>