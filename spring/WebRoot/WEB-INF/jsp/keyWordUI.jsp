<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>关键</title>
    <meta charset="UTF-8">
  	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script src="<%=basePath %>js/jquery-1.10.2.min.js"></script>
    <script src="<%=basePath %>js/plupload.full.min.js"></script>
	<script src="<%=basePath %>js/keyword.js"></script>
	<style type="text/css">
		body,td,th {font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 12px;color: #1d1007; line-height:24px} 
		
		.table>tbody>tr>td{
			border-top: none;
			padding: 2px;
			width: 100px;
		}
		.table>tbody>tr>td>input{
			width: 100px;
		}
	</style>
  </head>
  
  <body>
    <div id="a1" style="border: solid 1px black;color: gray;margin-top: 10px">
            <span  style="position: relative; top: -10px; left: 10px; background-color: White">
                添加配置</span>
            <form id="myForm">
            	<input type="hidden" name="id">
            	<div >
	            	<table class="table" style="width:700px">
	            		<tr>
	            			<td><span style="float: right;"> 省份:</span></td>
	            			<td colspan="5">
	            				<select name="provinces">
	            					 <option value="未选择">未选择</option>
	            					 <option value="北京市">北京市</option>
	                                 <option value="浙江省">浙江省</option>
	                                 <option value="天津市">天津市</option>
	                                 <option value="安徽省">安徽省</option>
	                                 <option value="上海市">上海市</option>
	                                 <option value="福建省">福建省</option>
	                                 <option value="重庆市">重庆市</option>
	                                 <option value="江西省">江西省</option>
	                                 <option value="山东省">山东省</option>
	                                 <option value="河南省">河南省</option>
	                                 <option value="湖北省">湖北省</option>
	                                 <option value="湖南省">湖南省</option>
	                                 <option value="广东省">广东省</option>
	                                 <option value="海南省">海南省</option>
	                                 <option value="山西省">山西省</option>
	                                 <option value="青海省">青海省</option>
	                                 <option value="江苏省">江苏省</option>
	                                 <option value="辽宁省">辽宁省</option>
	                                 <option value="吉林省">吉林省</option>
	                                 <option value="河北省">河北省</option>
	                                 <option value="贵州省">贵州省</option>
	                                 <option value="四川省">四川省</option>
	                                 <option value="云南省">云南省</option>
	                                 <option value="陕西省">陕西省</option>
	                                 <option value="甘肃省">甘肃省</option>
	                                 <option value="黑龙江省">黑龙江省</option>
	            				</select>
	            				<span id="vailProvinces" style="color: red;"></span>
	            			</td>
	            		</tr>
	            		<tr>
	            			<td><span style="float: right;">屏蔽关键字:</span></td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            		<tr>
	            		<tr>
	            			<td></td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            		<tr>
	            		<tr>
	            			<td></td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            			<td><input name="shieldKey"> </td>
	            		<tr>
	            		<tr>
	            			<td><span style="float: right;">上传关键字:</span></td>
	            			<td><input name="uploadKey"> </td>
	            			<td><input name="uploadKey"> </td>
	            			<td><input name="uploadKey"> </td>
	            			<td><input name="uploadKey"> </td>
	            			<td><input name="uploadKey"> </td>
	            		<tr>
	            		<tr>
	            			<td></td>
	            			<td><input name="uploadKey"> </td>
	            			<td><input name="uploadKey"> </td>
	            			<td><input name="uploadKey"> </td>
	            			<td><input name="uploadKey"> </td>
	            			<td><input name="uploadKey"> </td>
	            		<tr>
	            		<tr>
	            			<td><span style="float: right;">回复关键字:</span></td>
	            			<td><input name="replyKey"> </td>
	            			<td><input name="replyKey"> </td>
	            			<td><input name="replyKey"> </td>
	            			<td><input name="replyKey"> </td>
	            			<td><input name="replyKey"> </td>
	            		<tr>
	            		<tr>
	            			<td></td>        
	            			<td><input name="replyKey"> <span id="vailReplyKey" style="color: red;"></span></td>
	            			<td><input name="replyKey"> </td>
	            			<td><input name="replyKey"> </td>
	            			<td><input name="replyKey"> </td>
	            			<td>
	            				<input name="replyKey">
								<div style="color: gray">格式:XX@XX</div>
	            			</td>
	            		<tr>                
	            	</table>
	            	
	              </div>
	              		
		            	<div style="margin-left: 465px;margin-bottom: 5px;">
			            	<div class="wraper">
								<div class="btn-wraper">
									<input type="button" value="导入数据" id="browse" style="width: 72px;height: 30px;font-size: 4px; " class="btn btn-primary" />
									<input type="button" style="width: 72px;height: 30px;font-size: 4px; " class="btn btn-primary" name="reset" value="重置">
			            			<input type="button" style="width: 72px;height: 30px;font-size: 4px; " class="btn btn-primary" id="add_edit" value="添加/修改">
								</div>
							</div>
						</div>
	          
            </form>
     </div>
     <div style="margin-top:50px;" >
	     <table class="table table-striped table-bordered">
	     	<tr>
	     		<td>编号</td>
	     		<td>省份</td>
	     		<td>运营商</td>
	     		<td>屏蔽关键字</td>
	     		<td>上传关键字</td>
	     		<td>回复关键字</td>
	     		<td>操作</td>
	     	</tr>
	     	<c:forEach var="keyWord" items="${keyWordList}">
	    		<tr>
	    			<td>${keyWord.id}</td>
	    			<td>${keyWord.provinces}</td>
	    			<td>移动</td>
	    			<td>${keyWord.shieldKey}</td>
	    			<td>${keyWord.uploadKey}</td>
	    			<td>${keyWord.replyKey}</td>
	    			<td><a href="javascript:;" name="delete" id="${keyWord.id}"><span class="glyphicon glyphicon-remove" style="color: red"/></a>
	    			<a href="javascript:;" name="edit" id="${keyWord.id}"><span class="glyphicon glyphicon-pencil" /></a></td>
	    		</tr>
	    	</c:forEach>
	     </table>
     </div>
     <script type="text/javascript">
		   var uploader = new plupload.Uploader({ //实例化一个plupload上传对象
			    runtimes : "gears,flash,silverlight,browserplus,html5,html4",
			    browse_button : "browse",
		 		url : "<%=request.getContextPath() %>/testFileUpload.htm",
		 		flash_swf_url : "<%=basePath %>js/Moxie.swf",
		 		silverlight_xap_url : "<%=basePath %>js/Moxie.xap",
		 		filters: {
		 		  mime_types : [ //只允许上传图片文件和rar压缩文件
		 		    {title : "xls, xlsx文档", extensions : "xls,xlsx"}
		 		  ],
		 		  max_file_size : "100kb", //最大只能上传100kb的文件
		 		  prevent_duplicates : true //不允许队列中存在重复文件
		 		}
		 	});
		 	uploader.init(); //初始化
		
		 	//绑定文件添加进队列事件
		 	uploader.bind("FilesAdded",function(uploader,files){
		 		uploader.start(); //开始上传
		 		
		 	});
		 	uploader.bind("FileUploaded",function(uploader,file,responseObject){
		 		alert(responseObject.response);
		 		window.location.reload();
		 	});
		 	//上传按钮
			$("#upload-btn").click(function(){
				uploader.start(); //开始上传
			});
     </script>
  </body>
</html>
