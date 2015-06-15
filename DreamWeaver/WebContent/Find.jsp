<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>物业管理系统</title>
</head>
<%session.removeAttribute("user"); %><!-- 移除 -->
<frameset rows="10%,86%,4%" frameborder="no" border="0" framespacing="0">
  <frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frame src="FindGoods.jsp?pt=${param.pt}" name="GoodsAndUser.jsp" id="centerFrame" />
</frameset>
</html>
