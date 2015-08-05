<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Info</title>
  </head>
  
  <body>
    <c:if test="${keyword ==null }">
    	没有此信息
    </c:if>
    <c:if test="${keyword !=null }">
    	省份:${keyword.provinces},屏蔽关键字：${keyword.shieldKey},上传关键字：${keyword.uploadKey}<br>
    	回复关键字:${keyword.replyKey}
    </c:if>
  </body>
</html>
