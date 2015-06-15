<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
				<html>
			<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
			<link href="css/backcss/myCss.css" rel="stylesheet" type="text/css" />
			 <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
				<script type="text/javascript" src="js/dlselect.js"></script>
			<script type="text/javascript" src="js/addUser.js"></script>
			</head>
			<body class="background2">
			<div id="Layer1" style="position:absolute; width:100%; height:150%; z-index:-1">  
			<img src="image/blue.jpg" height="100%" width="100%"/>  
			</div> 
			<form action="addUser" method="post" id="addUserForm" onsubmit="return onSubmit()">
        <br>
			<table border="0" align="center" cellpadding="10" cellspacing="10">
			            <tr>
                      <th width:20% align="right"></th>
                      <th width:40% align="center"> <p align="center" class="font3">添&nbsp;加&nbsp;用&nbsp;户</p></th>
                      <th width:40% align="left"></th>
                  </tr>
			<!-- 用户名 -->
			 <tr>
				<td>
				     <span class="font1">姓&nbsp;名：</span>
           </td>
           <td>
             <input class="text" value="${requestScope.user.username}" type="text" name="user.username" id="username" onblur="checkUserName()" onclick="clickUserName()">
				</td>
				<td width="90">
					 <span id="usernameSpan1" style="color:white;font-size:15">*</span>
				     <span id="usernameSpan" style="color:white;font-size:15;display:none">*不能为空</span>
				</td>
			</tr>
				<!-- 电话 -->
           <tr>
				<td>
				     <span class="font1">电话号码：</span>
           </td>
           <td>
             <input value="${requestScope.user.phone}" class="text" type="text" name="user.phone" id="phone" 
             onblur="checkPhone()" onclick="clickPhone()">
				</td>
				<td width="90">
					 <span style="color:white;font-size:15" id="phoneSpan1">*</span>
				     <span id="phoneSpan2" style="color:white;font-size:15;display:none">*不能为空</span>
				</td>
			</tr>
				<!-- 微信 -->
			<tr>
			<td>
				     <span class="font1">微&nbsp;信&nbsp;号：</span>
           </td>
           <td>
             <input value="${requestScope.user.weixin}" class="text" type="text" name="user.weixin" id="weixing" 
             onblur="checkweixing()" onclick="clickweixing()">
			</td>
			<td width="90">
					 <span style="color:white;font-size:15" id="weixingSpan1">*</span>
				     <span id="weixingSpan2" style="color:white;font-size:15;display:none">*不能为空</span>
			</td>
			</tr>
			<!--密码 -->
			<tr>
				<td>
				     <span class="font1">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
           </td>
           <td>
             <input class="text" type="password" name="user.password" id="userpassword" onblur="checkUserPassword()" onclick="clickUserPassword()">
				</td>
				<td width="90">
					 <span style="color:white;font-size:15" id="userpasswordSpan1">*</span>
				     <span id="userpasswordSpan" style="color:white;font-size:15;display:none">*不能为空</span>
				</td>
			</tr>
			<!-- 确认密码 -->
			<tr>
				<td>
				     <span class="font1">确认密码：</span>
           </td>
           <td>
             <input class="text" type="password" name="compassword" id="compassword" 
             onblur="checkcomPassword()" onclick="clickcomPassword()">
				</td>
				<td width="90">
					 <span style="color:white;font-size:15" id="compasswordSpan1">*</span>
				     <span id="compasswordSpan2" style="color:white;font-size:15;display:none">*密码不同</span>
				</td>
			</tr>
				<!-- 身份证 -->
				<tr>
			<td>
				     <span class="font1">身&nbsp;份&nbsp;证&nbsp;号:</span>
           </td>
           <td>
             <input value="${requestScope.user.idcard}" class="text" type="text" name="user.idcard" id="idcard" >
			</td>
			<td width="90">
					 <span style="color:white;font-size:15" id="weixingSpan1">*</span>
			</td>
			</tr>
			<!-- 汇款信息 -->
					<tr>
			<td>
				     <span class="font1">汇&nbsp;款&nbsp;信&nbsp;息:</span>
           </td>
           <td>
             <input placeholder="天使特约请填写不用交款" value="${requestScope.user.info}" class="text" type="text" name="user.info" id="userinfo" >
			</td>
			<td width="90">
					 <span style="color:white;font-size:15" >*</span>
			</td>
			</tr>
			<!-- 供货代理 -->
			<tr>
			<td><span class="font1">供货代理：&nbsp;</span></td>
			<td colspan="2">
		  	<select id="level"  class="text3" >
		 	<option >我的代理</option>
		 	<option >输入编号</option>
			</select>
			<select  id="info" name="fuid" class="text3" >
			<s:iterator value="users" status="sta" var="dluser" >
			<!-- 供货代理姓名 -->
							<option id="${dluser.level}" value="${dluser.uid}" >(${dluser.username})${dluser.code}</option>
			</s:iterator>
			</select>
			<input   name="dlname" id="dlname" style=" 
					display:none;
					width:35%;
					margin-left:20px;
					border: 1px solid #ccc;
                     padding: 2px;
                     font-size: 1.2em;
                     color: #000000;
                     background-color: #eeeeee;" type="text" 
            placeholder="代理编号">
			</td>
			</tr>
			<tr>
				<td>
				     <span class="font1">用户级别：&nbsp;</span>
           </td>
           <td>
             <!-- <input class="text" type="text" name="user.level"  > -->
			    <select class="text3" name="user.level">
			    <s:if test='%{#session.user.level=="CEO"||#session.user.level=="公司用户"}'>
			    <option>CEO</option>
			    <option>官方</option>
			    <option>总代</option>
			    <option>一级</option>
			    <option>二级</option>
			    <option>特约</option>
			    <option>天使</option>
			    </s:if>
			    <s:if test='%{#session.user.level=="官方"}'>
			    <option>官方</option>
			    <option>总代</option>
			    <option>一级</option>
			    <option>二级</option>
			    <option>特约</option>
			    <option>天使</option>
			    </s:if>
			    <s:if test='%{#session.user.level=="总代"}'>
			    <option>总代</option>
			    <option>一级</option>
			    <option>二级</option>
			    <option>特约</option>
			    <option>天使</option>
			    </s:if>
			    <s:if test='%{#session.user.level=="一级"}'>
			    <option>一级</option>
			    <option>二级</option>
			    <option>特约</option>
			    <option>天使</option>
			    </s:if>
			    <s:if test='%{#session.user.level=="二级"}'>
			    <option>二级</option>
			    <option>特约</option>
			    <option>天使</option>
			    </s:if>
			    <s:if test='%{#session.user.level=="特约"}'>
			    <option>特约</option>
			    <option>天使</option>
			    </s:if>
			     <s:if test='%{#session.user.level=="天使"}'>
			    <option>天使</option>
			    </s:if>
			    </select>
			    </td>
			</tr>
			<tr>
        <td>
        </td>
	         <td>
		     <br>
             <input class="btn" type="submit" value="添加用户" >
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 <input class="btn" type="reset" value="重置">
		     </td>
        <td>
        </td>
			</tr>
			<tr><td align="center"><span class="font1" style="color:white"><s:property value="msg"/></span></td></tr>
			</table>
			</form>
			</body>
			</html>