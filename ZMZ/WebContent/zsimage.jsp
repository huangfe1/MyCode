<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>证书</title>
</head>
<body>
<div align="center">
<!-- 激活的用户-->
<s:if test="agent!=null&&agent.userStatus==1"></s:if>
<img align="middle" src="zsimage?code=${agent.agentCode}" alt="显示异常,联系客服">
</div>
</body>
</html>