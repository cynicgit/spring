var article = {
	falg : true,
	vailEmail : function(value){
		var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
		$("#vailEmail").text("");
		article.falg = true;
		if(!re.test(value)){
			$("#vailEmail").text("邮箱格式错误");
			article.falg = false;
		}
	},
	vailTittle : function(value){
		var re = /^[\u4E00-\u9FA5\w\d\-\_]+\@[\u4E00-\u9FA5\w\d\-\_,]+$/;
		$("#vailTittle").text("");
		article.falg = true;
		if(!re.test(value)){
			$("#vailTittle").text("必须为数字");
			article.falg = false;
		}
	},
	vailContent : function(value){
		$("#vailContent").text("");
		article.falg = true;	
		if($.trim(value)==""){
			$("#vailContent").text("内容不能为空");
			article.falg = false;
		}
	},
	submit : function(){
		var path = window.location.href;
		var url = "";
		if(path.indexOf("articleUI")>0){
			url = "user/postArticle.htm"
		}else{
			url = "user/editArticle.htm"
		}
		
		$.ajax({
			url:url,
			type:"post",
			data:$("#articleForm").serialize(),
			dataType:"json",
			cache:false,
			success:function(data){
				alert(data.msg);
				 if(data.msg=="添加成功"||data.msg=="修改成功")
					window.location.href = "user/articles.htm";
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert("Error："+textStatus);
				}
		});
	}
}

$().ready(function(){
	$("#email").blur(function(){
		article.vailEmail($.trim($(this).val()));
	});
	
	$("#content").blur(function(){
		article.vailContent($(this).val());
	});
	
	$("#tittle").blur(function(){
		article.vailTittle($.trim($(this).val()));
	});
	
	$("#submit").click(function(){
		article.vailEmail($.trim($("#email").val()));
		article.vailTittle($.trim($("#tittle").val()));
		article.vailContent($("#content").val());
		if(article.falg){
			article.submit();
		}
	});
	
	
})