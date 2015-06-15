<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="css/backcss/myCss.css" rel="stylesheet" type="text/css" />
<title>证书</title>
</head>
<body >
<div align="center">
<s:if test="#session.user.type==1"><!-- 代理用户不直接看到 -->
<table border="0" align="center" cellpadding="10" cellspacing="10">
			 <tr>
				<td>
				     <span class="font1">用&nbsp;户&nbsp;名：</span>
           </td>
           <td>
            <span class="font1">user.username</span>
				</td>
			</tr>
			<tr>
				<td>
				     <span class="font1">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
           </td>
           <td>
               <span class="font1">user.password</span>
				</td>
			</tr>
           <tr>
				<td>
				     <span class="font1">电话号码：</span>
           </td>
           <td>
              <span class="font1">user.phone</span>
				</td>
			</tr>
			<tr>
			<td>
				     <span class="font1">微&nbsp;信&nbsp;号：</span>
           </td>
           <td>
           <span class="font1">user.weixin</span>
			</td>
			
			</tr>
				<tr>
			<td>
				     <span class="font1">身&nbsp;份&nbsp;证&nbsp;号:</span>
           </td>
           <td>
              <span class="font1">user.id</span>
			</td>
			
			</tr>
			<!-- 如果是公司用户,指定推荐人 -->
			<s:if test="#session.user.type==0">
			<tr>
			<td><span class="font1">指定推荐人：&nbsp;</span></td>
			<td>
			<span class="font1">指定推荐人：&nbsp;</span></td>
			</td>
			</tr>
			</s:if>
			<tr>
				<td>
				     <span class="font1">用户级别：&nbsp;</span>
           </td>
           <td>
            <span class="font1">user.level</span>
			    </td>
			</tr>
			<tr>
        <td>
        </td>
        <td>
        </td>
			</tr>
			</table>
</s:if>
<s:if test="user.code!=null">
<img alt="" src="zs/${user.code}.jpg">
</s:if>
</div>
</body>
</html>