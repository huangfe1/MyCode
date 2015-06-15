<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="css/backcss/myCss.css" rel="stylesheet" type="text/css" />
<title>证书</title>
</head>
<body bgcolor="CDD6E5" >
<div align="center">
<s:if test="user.code!=null"><!-- 添加用户Action的code生成证书 -->
<s:if test="user.status==1"><!-- 是否被激活 -->
<img alt="" src="imageaction?code=${user.code}">
</s:if>
<s:else>
<!-- 没有激活,不显示证书,显示table -->
<table style="margin-top: 10%"  border="1"  cellpadding="10" cellspacing="0">
			            <tr >
                      <th colspan="2" width:40% align="center"> <p align="center" class="font3">添&nbsp;加&nbsp;成&nbsp;功</p></th>
                  </tr>
			 <tr>
				<td>
				     <span class="font1">用&nbsp;户&nbsp;名：</span>
           </td>
           <td>
            <span class="font1">${user.username}</span>
				</td>
			</tr>
			<tr>
				<td>
				     <span class="font1">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
           </td>
           <td>
               <span class="font1">${user.password}</span>
				</td>
			</tr>
           <tr>
				<td>
				     <span class="font1">电话号码：</span>
           </td>
           <td>
              <span class="font1">${user.phone}</span>
				</td>
			</tr>
			<tr>
			<td>
				     <span class="font1">微&nbsp;信&nbsp;号：</span>
           </td>
           <td>
           <span class="font1">${user.weixin}</span>
			</td>
			
			</tr>
				<tr>
			<td>
				     <span class="font1">身&nbsp;份&nbsp;证&nbsp;号:</span>
           </td>
           <td>
              <span class="font1">${user.idcard}</span>
			</td>
			
			</tr>
			<!-- 如果是公司用户,指定推荐人 -->
			<s:if test="#session.user.type==0">
			<tr>
			<td><span class="font1">供货代理：&nbsp;</span></td>
			<td>
			<span class="font1">${user.fname}</span></td>
			</tr>
			</s:if>
			<tr>
				<td>
				     <span class="font1">用户级别：&nbsp;</span>
           </td>
           <td>
            <span class="font1">${user.level}</span>
			    </td>
			</tr>
			</table>
</s:else>
</s:if>
<s:else><!-- 直接通过code传过来的 -->
<!-- <img alt="" src="zs/${param['code']}.jpg"> -->
<img alt="" src="imageaction?code=${param['code']}">
</s:else>
</div>
</body>
</html>