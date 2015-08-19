<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
		<ul>
		<li id="save"><a href="#" onclick="formSubmit('update.action','_self');this.blur();">确 定 </a></li>
		<li id="back"><a href="list.action">返回</a></li>
		</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		新增生产厂家信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
    	<input type="hidden" name="id" value="${factory.id}">
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">排序号：</td>
	            <td class="tableContent"><input type="text" name="orderNo" value="${factory.orderNo}" dataType="整数" dispName="排序号"/></td>
	            <td class="columnTitle">验货员：</td>
	            <td class="tableContent"><input type="text" name="inspector" value="${factory.inspector}"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">厂家名称：</td>
	            <td class="tableContent"><input type="text" name="fullName" value="${factory.fullName}" dataType="中文" dispName="厂家名称"/></td>
	            <td class="columnTitle_mustbe">简称：</td>
	            <td class="tableContent"><input type="text" name="factoryName" value="${factory.factoryName}" dataType="非空字符串" dispName="简称"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">联系人：</td>
	            <td class="tableContent"><input type="text" name="contacts" value="${factory.contacts}" dataType="非空字符串" dispName="联系人"/></td>
	            <td class="columnTitle_mustbe">电话：</td>
	            <td class="tableContent"><input type="text" name="phone" value="${factory.phone}" dataType="非空电话" dispName="电话"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">手机：</td>
	            <td class="tableContent"><input type="text" name="mobile" value="${factory.mobile}" dataType="非空手机" dispName="手机"/></td>
	            <td class="columnTitle">传真：</td>
	            <td class="tableContent"><input type="text" name="fax" value="${factory.fax}" dataType="电话" dispName="传真"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle">备注：</td>
	            <td class="tableContent"><textarea name="cnote" style="width:100%;height:120px;">${factory.cnote}</textarea></td>
	        </tr>

		</table>
	</div>

 
 
</form>
</body>
</html>

