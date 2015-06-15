<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
				<html>
			<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
			<link href="css/backcss/myCss.css" rel="stylesheet" type="text/css" />

			<script type="text/javascript" src="js/addUser.js">
      </script>

			</head>
			<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">  
			<img src="image/blue.jpg" height="100%" width="100%"/>  
			</div> 
			<body class="background2">
			<form action="conName" method="post" id="addUserForm" onsubmit="return onSubmit()">
      
        <br>
			<table border="0" align="center" cellpadding="10" cellspacing="10"
              >
			            <tr>
                      <th width:20% align="right"></th>
                      <th width:40% align="center"> <p align="center" class="font3">类&nbsp;型&nbsp;添&nbsp;加</p></th>
                      <th width:40% align="left"></th>
                  </tr>
            <tr>
				<td>
				     <span class="font1">产&nbsp;品&nbsp;类&nbsp;型：</span>
           </td>
           <td>
             <input class="text" type="text" name="name" id="username" onblur="checkUserName()" onclick="clickUserName()">
				</td>
				<td width="90">
					<span id="usernameSpan1" style="color:red;font-size:15">*</span>

				     <span id="usernameSpan" style="color:red;font-size:15;display:none">*不能为空</span>
				</td>
			</tr>
			<tr>
        <td>
          
        </td>
				<td>
				<div align="center" >${msg}</div>
				     <br>
             <input class="btn" type="submit" value="确认添加" >
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			         <input class="btn" type="reset" value="重置">
				</td>
        <td>
          
        </td>
			</tr>
			</table>
			</form>
			

			</body>
			</html>