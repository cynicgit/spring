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
<li id="save"><a href="#" onclick="formSubmit('update.action','_self');this.blur();">确定</a></li>
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
	            <td class="tableContent"><input type="text" name="offeror" value="${contract.offeror }"/></td>
	            <td class="columnTitle">打印版式：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="printStyle" value="2" <c:if test="${contract.printStyle==2}">checked</c:if> class="input">两个货物
	            	<input type="radio" name="printStyle" value="1" <c:if test="${contract.printStyle==1}">checked</c:if> class="input">一个货物
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">客户名称：</td>
	            <td class="tableContent"><input type="text" name="customName" value="${contract.customName}"/></td>
	            <td class="columnTitle_mustbe">合同号：</td>
	            <td class="tableContent"><input type="text" name="contractNo" value="${contract.contractNo}"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">签单日期：</td>
	            <td class="tableContent">
						<input type="text" style="width:90px;" name="signingDate" readonly value="<fmt:formatDate value="${contract.signingDate}" pattern="yyyy-MM-dd"/>"
			             onclick="WdatePicker({lang:'zh-cn',el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	            <td class="columnTitle_mustbe">制单人：</td>
	            <td class="tableContent"><input type="text" name="inputBy" value="${contract.inputBy}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">审单人：</td>
	            <td class="tableContent"><input type="text" name="checkBy" value="${contract.checkBy}"/></td>
	            <td class="columnTitle_mustbe">验货员：</td>
	            <td class="tableContent"><input type="text" name="inspector" value="${contract.inspector}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">重要程度：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="importNum" value="3" <c:if test="${contract.importNum==3}">checked</c:if> class="input">★★★
	            	<input type="radio" name="importNum" value="2" <c:if test="${contract.importNum==2}">checked</c:if> class="input">★★
	            	<input type="radio" name="importNum" value="1" <c:if test="${contract.importNum==1}">checked</c:if> class="input">★
	            </td>
	            <td class="columnTitle_mustbe">交货期限：</td>
	            <td class="tableContent">
						<input type="text" style="width:90px;" name="deliveryPeriod" readonly value="<fmt:formatDate value="${contract.deliveryPeriod}" pattern="yyyy-MM-dd"/>"
			             onclick="WdatePicker({lang:'zh-cn',el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">船期：</td>
	            <td class="tableContent">
						<input type="text" style="width:90px;" name="shipTime" readonly value="<fmt:formatDate value="${contract.shipTime}" pattern="yyyy-MM-dd"/>"
			             onclick="WdatePicker({lang:'zh-cn',el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	            <td class="columnTitle_mustbe">贸易条款：</td>
	            <td class="tableContent"><input type="text" name="tradeTerms" value="${contract.tradeTerms}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle">要求：</td>
	            <td class="tableContent"><textarea name="crequest" style="width:100%;height:120px;">${contract.crequest}</textarea></td>
	            <td class="columnTitle">说明：</td>
	            <td class="tableContent"><textarea name="remark" style="width:100%;height:120px;">${contract.remark}</textarea></td>

	        </tr>

		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

