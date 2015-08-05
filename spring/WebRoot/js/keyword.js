var keyWord = {
	falg : true,
	add_edit : function(id) {
		var url;
		if (id == "") {
			url = "addkeyWord.htm";
		} else {
			url = "editkeyWord.htm";
		}
		if(keyWord.falg)
			keyWord.vailProvinces();
		var data = {"provinces":"北京市"};
		if(keyWord.falg){
			$.ajax({
				url : url,
				type : "post",
				data : $("#myForm").serialize(),
				dataType : "json",
				cache : false,
				success : function(data) {
					alert(data.msg);
					if (data.msg == "添加成功" || data.msg == "修改成功")
						window.location.href = "tokeyWord.htm";
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					//XMLHttpRequest.alert("Error：");
					alert();
				}
			});
			$("input[name='id']").val("");
		}else{
			alert("数据错误");
		}
	},
	reset : function() {
		$("select[name='provinces']").val("未选择");
		$("input[name='id']").val("");
		$("#vailProvinces").text("");
		$("#vailReplyKey").text("");
		$("input[name='shieldKey']").each(function() {
			$(this).val("");
		});
		$("input[name='uploadKey']").each(function() {
			$(this).val("");
		});
		$("input[name='replyKey']").each(function() {
			$(this).val("");
		});
	},
	deleteKeyWord : function(obj) {
		$.ajax({
			url : "deleteKeyWord.htm",
			type : "post",
			data : {
				id : obj.attr("id")
			},
			context : obj,
			cache : false,
			dataType : "json",
			success : function(data) {
				if (data.msg == "删除成功") {
					//alert(data.msg);
					obj.parent().parent().remove();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("Error：" + "删除失败");
			}
		});
	},
	editKeyWord : function(obj) {
		$.ajax({
			url : "editKeyWordUI.htm",
			type : "post",
			data : {
				id : obj.attr("id")
			},
			context : obj,
			cache : false,
			dataType : "json",
			success : function(data) {
				keyWord.setValue(data.keyWord);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("Error：");
			}
		});
	},
	setValue : function(data) {
		$("input[name='id']").val(data.id);
		$("select[name='provinces']").val(data.provinces);
		keyWord.setInputValue("shieldKey", data.shieldKey);
		keyWord.setInputValue("uploadKey", data.uploadKey);
		keyWord.setInputValue("replyKey", data.replyKey);
	},
	setInputValue : function(name, value) {
		
		$("input[name=" + name + "]").val("");
		if (value) {
			var str = value.split(",");
			$("input[name=" + name + "]").each(function(index) {
				if (index < str.length) {
					$(this).val(str[index]);
				} else {
					return false;
				}

			})
		}
	},
	vailProvinces : function() {
		$("#vailProvinces").text("");
		if ($("select[name='provinces']").val() == "未选择") {
			keyWord.falg = false;
			$("#vailProvinces").text("省份未选择");
		}else{
			keyWord.falg = true;
		}
		
			
	},
	vailReplyKey : function(value){
		var re = /^[\s|\S]+\@[\s|\S]+$/;
		$("#vailReplyKey").text("");
		if(!re.test(value)&&$.trim(value)!=""){
			$("#vailReplyKey").text("格式错误");
			keyWord.falg = false;
		}else{
			keyWord.falg = true;
		}
		
	}

}

$().ready(function() {
	$("#add_edit").click(function() {
		var id = $("input[name='id']").val();
		keyWord.add_edit(id);
	});
	
	$("input[name='reset']").click(function() {
		keyWord.reset();
	});
	
	$("a[name='delete']").click(function() {
		keyWord.deleteKeyWord($(this));
	});
	
	$("a[name='edit']").click(function() {
		keyWord.editKeyWord($(this));
	});
	
	$("select[name='provinces']").blur(function(){
		keyWord.vailProvinces();
	});
	
	$("input[name='replyKey']").blur(function(){
		keyWord.vailReplyKey($(this).val());
	})
	
});




