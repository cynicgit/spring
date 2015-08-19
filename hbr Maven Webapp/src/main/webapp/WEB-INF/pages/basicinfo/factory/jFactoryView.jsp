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
		预览生产厂家信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">排序号：</td>
	            <td class="tableContent">${factory.orderNo}</td>
	            <td class="columnTitle">验货员：</td>
	            <td class="tableContent">${factory.inspector}</td>
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">厂家名称：</td>
	            <td class="tableContent">${factory.fullName}</td>
	            <td class="columnTitle_mustbe">简称：</td>
	            <td class="tableContent">${factory.factoryName}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">联系人：</td>
	            <td class="tableContent">${factory.contacts}</td>
	            <td class="columnTitle_mustbe">电话：</td>
	            <td class="tableContent">${factory.phone}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">手机：</td>
	            <td class="tableContent">${factory.mobile}</td>
	            <td class="columnTitle">传真：</td>
	            <td class="tableContent">${factory.fax}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">备注：</td>
	            <td class="tableContent"><pre>${factory.cnote}</pre></td>
	        </tr>

		</table>
	</div>

 
 
</form>
</body>
</html>

