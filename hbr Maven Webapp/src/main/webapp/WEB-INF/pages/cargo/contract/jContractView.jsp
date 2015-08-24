<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
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
		修改购销合同信息
    </div> 
    </div>
    </div>
<div>
 	<input type="hidden" name="id" value="${contract.id }">
    <div>
		<table class="commonTable" cellspacing="1">
		    <tr>
	            <td class="columnTitle_mustbe">收购方：</td>
	            <td class="tableContent">${contract.offeror }</td>
	            <td class="columnTitle">打印版式：</td>
	            <td class="tableContentAuto">
	            	 <c:if test="${contract.printStyle==2}">两个货物</c:if>
	            	 <c:if test="${contract.printStyle==1}">一个货物</c:if>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">客户名称：</td>
	            <td class="tableContent">${contract.customName}</td>
	            <td class="columnTitle_mustbe">合同号：</td>
	            <td class="tableContent">${contract.contractNo}</td>
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">签单日期：</td>
	            <td class="tableContent">
						<fmt:formatDate value="${contract.signingDate}" pattern="yyyy-MM-dd"/>
	            </td>
	            <td class="columnTitle_mustbe">制单人：</td>
	            <td class="tableContent">${contract.inputBy}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">审单人：</td>
	            <td class="tableContent">${contract.checkBy}</td>
	            <td class="columnTitle_mustbe">验货员：</td>
	            <td class="tableContent">${contract.inspector}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">重要程度：</td>
	            <td class="tableContentAuto">
	            	<c:forEach begin="1" end="${contract.importNum}">
	            	★
	            	</c:forEach>
	            </td>
	            <td class="columnTitle_mustbe">交货期限：</td>
	            <td class="tableContent">
						<fmt:formatDate value="${contract.deliveryPeriod}" pattern="yyyy-MM-dd"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">船期：</td>
	            <td class="tableContent">
						<fmt:formatDate value="${contract.shipTime}" pattern="yyyy-MM-dd"/>
	            </td>
	            <td class="columnTitle_mustbe">贸易条款：</td>
	            <td class="tableContent">${contract.tradeTerms}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">要求：</td>
	            <td class="tableContent"><pre>${contract.crequest}</pre></td>
	            <td class="columnTitle">说明：</td>
	            <td class="tableContent"><pre>${contract.remark}</pre></td>

	        </tr>

		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

