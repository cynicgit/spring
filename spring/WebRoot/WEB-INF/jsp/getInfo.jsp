<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'GetInfo.jsp' starting page</title>

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/addPhoneInfo.htm" method="get">
    	<table >
    		<tr>
    			<td>action:</td>
    			<td><input name="action" type="text"></td>
    		</tr>
    		<tr>
    			<td>imei:</td>
    			<td><input name="imei" type="text"></td>
    		</tr>
    		<tr>
    			<td>imsi:</td>
    			<td><input name="imsi" type="text"></td>
    		</tr>
    		<tr>
    			<td>sc:</td>
    			<td><input name="sc" type="text"></td>
    		</tr>
    		<tr>
    			<td>custom:</td>
    			<td><input name="custom" type="text"></td>
    		</tr>
    		<tr>
    			<td>phver:</td>
    			<td><input name="phver" type="text"></td>
    		</tr>
    		<tr>
    			<td>mocorver:</td>
    			<td><input name="mocorver" type="text"></td>
    		</tr>
    		<tr>
    			<td>ct:</td>
    			<td><input name="ct" type="text"></td>
    		</tr>
    		<tr>	
    			<td>cause:</td>
    			<td><input name="cause" type="text"></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="提交"></td>
    		</tr>
    	</table>
    </form>
    
    
  </body>
</html>
