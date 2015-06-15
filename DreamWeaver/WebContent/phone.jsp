<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" href="css/appcss/jquery.mobile-1.4.5.min.css">
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/jquery.mobile-1.4.5.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/backcss/checkgoods.css">
<script type="text/javascript" src="js/checkgoods.js"></script>
<script type="text/javascript">
$.mobile.page.prototype.options.domCache = true;
$(document).ready(function(){
	$("#goodsbt").click(function(){
		if($("#number").val()==""){
			alert("亲,您忘了输入货物编号");
		}else{
			location.href="goodsUser?number="+$("#number").val()+"&pt="+0+"&p="+1;
		}
	});
	$("#userbt").click(function(){
	if($("#code").val()==""){
			alert("亲,您忘了输入代理商编号");
		}else{
			location.href="goodsUser?code="+$("#code").val()+"&pt="+1+"&p="+1;	
		}
	});
	
});
</script>
<title>筑美查询</title>
</head>
<body>
<!-- 第一个页面,两个按钮 -->
<div data-role="page" id="first" data-dom-cache="true">
<div data-role="header">
				<s:if test="msg==null">
				<h1>欢迎使用筑美查询系统</h1>
				</s:if>
				<s:else>
				<h1>${msg}</h1>
				</s:else>
</div>
<div data-role="content">
<a href="#hw" data-role="button" data-transition="flow">货物查询</a>
<br><br>
<a href="#sq" data-role="button" data-transition="flow">授权查询</a>
</div>
<div align="center" data-type="footer">
<s:if test="#request.goods!=null||#request.user!=null">
      <table  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td >
          <table  border="1" align="center" cellpadding="0" cellspacing="1"  >
         <s:if test="user!=null">
          <tr>
            <th ><div align="center" class="STYLE1">用户编号</div></th>
            <th ><div align="center" class="STYLE1">用户名</div></th>
            <th ><div align="center" class="STYLE1">手机号码</div></th>
            <th ><div align="center" class="STYLE1">微信账号</div></th>
          </tr>
          </s:if>
          <s:if test="goods!=null">
           <th   >货物编号</div></th>
            <th   ><div align="center" class="STYLE1">货物名称</div></th>
            <th   ><div align="center" class="STYLE1">授权代理</div></th>
            <th   ><div align="center" class="STYLE1">修改时间</div></th>
          </s:if>
        <s:if test="user!=null">
			<tr >
			<td><div align='center' ><a href="pcImage.jsp?code=${user.code}">${user.code}</a></div></td>
			<td><div align='center' >${user.username}</div></td>
			<td><div align='center' >${user.phone}</div></td>
			<td><div align='center' >${user.weixin}</div></td>
			</tr>
          </s:if>
          <s:if test="goods!=null">
			<tr >
			<td><div align='center' >${goods.number}</div></td>
			<td><div align='center' >${goods.name}</div></td>
			<td><div align='center' >${goods.username}</div></td>
			<td><div align='center' >${goods.time}</div></td>
			</tr>
          </s:if>
          </table>
      </td>
      </tr>
      </table>
      <s:if test="user.code!=null">
       <div align="center"><img id="im" width="100%" alt="" src="image?code=${user.code}"></div>
	</s:if>
      </s:if>
</div>
</div>
<div data-role="page" id="hw" data-dom-cache="true">
<div data-role="header">
	<a href="#first" data-role="button" data-transition="flow">返回</a>
	<h1>货物查询</h1>
</div>
<div data-role="content">
<label for="number"><span class="STYLE3">货物编号:</span></label>
<input type="text" id="number"  >
<input type="button" value="查找" id="goodsbt">
</div>
</div>
<div data-role="page" id="sq" data-dom-cache="true">
<div data-role="header">
	<a href="#first" data-role="button" data-transition="flow">返回</a>
	<h1>授权查询</h1>
</div>
<div data-role="content">
<label for="code"><span class="STYLE3">代理信息:</span></label>
<input type="text" id="code"  >
<input type="button" value="查找" id="userbt">
</div>
</div>
</body>
</html>