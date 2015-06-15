<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
				<html>
			<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
			<link href="css/backcss/myCss.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
			<script type="text/javascript" src="js/addUser.js"></script>
			<script type="text/javascript" src="js/dlselect.js"></script>
			</head>
			<body class="background2">
			<div id="Layer1" style="position:absolute; width:100%; height:150%; z-index:-1">  
			<img src="image/blue.jpg" height="100%" width="100%"/>  
			</div> 
			<form action="changeUser" method="post" id="addUserForm" onsubmit="return onSubmit()">
      		<input type="hidden" name="user.code" value="${user.code}">
      		<input type="hidden" name="user.time" value="${user.time}">
      		<input type="hidden" name="user.uid" value="${user.uid}">
      		<input type="hidden" name="user.status" value="${user.status}">
        <br>
			<table border="0" align="center" cellpadding="10" cellspacing="10"
              >
			            <tr>
                      <th width:20% align="right"></th>
                      <th width:40% align="center"> <p align="center" class="font3">用&nbsp;户&nbsp;修&nbsp;改</p></th>
                      <th width:40% align="left"></th>
                  </tr>
            
			 <tr>
				<td>
				     <span class="font1">用&nbsp;户&nbsp;名：</span>
           </td>
           <td>
             <input class="text" type="text" name="user.username" id="username" value="${user.username}" onblur="checkUserName()" onclick="clickUserName()">
				</td>
				<td width="90">
					<span id="usernameSpan1" style="color:red;font-size:15">*</span>

				     <span id="usernameSpan" style="color:red;font-size:15;display:none">*不能为空</span>
				</td>
			</tr>
           <tr>
				<td>
				     <span class="font1">电话号码：</span>
           </td>
           <td>
             <input class="text" type="text" name="user.phone" value="${user.phone }" id="phone" 
             onblur="checkPhone()" onclick="clickPhone()">
				</td>
				<td width="90">
					 <span style="color:red;font-size:15" id="phoneSpan1">*</span>
				     <span id="phoneSpan2" style="color:red;font-size:15;display:none">*不能为空</span>
				</td>
			</tr>


			<tr>
				<td>
				     <span class="font1">微&nbsp;信&nbsp;号：</span>
           </td>
           <td>
             <input class="text" type="text" name="user.weixin" value="${user.weixin }" id="weixing" 
             onblur="checkweixing()" onclick="clickweixing()">
				</td>
				<td width="90">
					 <span style="color:red;font-size:15" id="weixingSpan1">*</span>
				     <span id="weixingSpan2" style="color:red;font-size:15;display:none">*不能为空</span>
				</td>
			</tr>
					<tr>
			<td>
				     <span class="font1">身&nbsp;份&nbsp;证&nbsp;号:</span>
           </td>
           <td>
             <input value="${user.idcard}" class="text" type="text" name="user.idcard" id="idcard" >
			</td>
			<td width="90">
					 <span style="color:red;font-size:15" id="weixingSpan1">*</span>
			</td>
			</tr>
			<tr>
				<tr>
			<td>
				     <span class="font1">汇&nbsp;款&nbsp;信&nbsp;息:</span>
           </td>
           <td>
             <input value="${user.info}" class="text" type="text" name="user.info" id="usernfo" >
			</td>
			<td width="90">
					 <span style="color:red;font-size:15" >*</span>
			</td>
			</tr>
			<!-- 如果是公司用户,指定推荐人 -->
			<s:if test="#session.user.type==0">
			<tr>
			<td><span class="font1">指定推荐人：&nbsp;</span></td>
			<td colspan="2">
		  	<select id="level"  class="text3" >
		 	<option >我的代理</option>
		 	<option selected="selected">输入编号</option>
			</select>
			<select  style="margin-left:23%;display:none "  id="info" name="fuid" class="text3" >
			<s:iterator value="users" status="sta" var="dluser" >
			<!-- 代理姓名 -->
			<s:if test="user.fid==#dluser.uid"><!-- 当前用户的fid等于代理的id -->
			<option selected="selected" id="${dluser.level}" value="${dluser.uid}" >${dluser.username}</option>
			</s:if>
			<s:else>
			<option id="${dluser.level}" value="${dluser.uid}" >(${dluser.username})${dluser.code}</option>
			</s:else>
			</s:iterator>
			</select>
			<input   name="dlname" id="dlname" style=" 
					width:35%;
					margin-left:20px;
					border: 1px solid #ccc;
                     padding: 2px;
                     font-size: 1.2em;
                     color: #000000;
                     background-color: #eeeeee;" type="text" 
                     value="${user.fcode}"
            placeholder="代理编号">
			</td>
			</tr>
			</s:if>
                 <!-- 不是公司用户,那么fuid就是自己 -->
			<s:else>
			<input type="hidden" value="${session.user.uid}" name="fuid"/>
			</s:else>		
			<tr>
			<tr>
				<td>
				     <span class="font1">用户级别：&nbsp;</span><!-- <input class="text" type="text" name="usertype" id="usertype" onblur="checkUserType()" onclick="clickUserType()"> -->
           </td>
           <td>
            <select class="text3" name="user.level">
            <s:iterator value="{'CEO','官方','总代','一级','二级','特约','天使'}" var="lv">
            	<s:if test="user.level ==#lv">
            	<option selected="selected">${lv}</option>
           <%--  	<s:if test="#session.user.level=='CEO'||#session.user.level=='官方'"><!-- 官方与CEO可以修改 -->
            		<!-- 如果当前修改用户的等级为特约或者天使 -->
            		<s:if test="user.level =='特约'">
            		<option>天使</option>
            		</s:if>
            		<s:if test="user.level =='天使'"><!-- 如果当前修改用户的等级为特约或者天使 -->
            		<option>特约</option>
            		</s:if>
            	</s:if> 
            	--%>
            	</s:if>
            	<s:else>
            	<s:if test="#session.user.type==0"><!-- 公司用户可以选择 -->
            	<option >${lv}</option>
            	</s:if>
            	</s:else>
            </s:iterator>
            </select>
			    </td>
				<td width="90">
					<%-- <span style="color:red;font-size:15" id="usertypeSpan1">*</span>
				     <span id="usertypeSpan" style="color:red;font-size:15;display:none">*不能为空</span> --%>
				</td>
			</tr>
			<tr>
        <td>
        </td>
				<td>
				     <br>
             <input class="btn" type="submit" value="修改用户" >
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			         <input class="btn" type="reset" value="重置">
				</td>
        <td>
        </td>
			</tr>
			<tr><td align="center"><span class="font1" style="color:red"><s:property value="msg"/></span></td></tr>
			</table>
			</form>
			</body>
			</html>