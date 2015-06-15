<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
		<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>
		</title>
		<link href="css/backcss/myCss.css" rel="stylesheet" type="text/css" />
		 <link href="css/backcss/myCss2.css" rel="stylesheet" type="text/css" />
		 <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	     <script type="text/javascript" src="js/addAgent.js"></script>
	   	 <script type="text/javascript" src="js/dlselect.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			$("#bt").click(function(){
				if($("#phone").val()==""){
					alert("亲,请填写电话");
				}else
				if($("#place").val()==""){
					alert("亲,请填写手机");
				}else
				if($("#gcount").val()==""){
					alert("亲,请填写数量");
				}else{
					if(!isNaN($("#gcount").val())){//如果填写的是数字
							$("#af").submit();//提交表单
					}else{
						alert("请规范填写");
					}
				}
			});
		});
		</script>
		</head>
			<body >
			<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">  
			<img src="image/blue.jpg" height="100%" width="100%"/>  
			</div> 
			<form action="applygoods" method="post" id="af" >
        <br>
			<table border="0" align="center" cellpadding="10" cellspacing="10"
              >
			      <tr>
                      <th width:20% align="right"></th>
                      <th width:40% align="center"> <p align="center" class="font3">申请发货</p></th>
                      <th width:40% align="left"></th>
                  </tr>            			 
			 <!--第四行头 -->
           <tr>
				<td>
				     <span class="font1">收货人：</span>
           </td>
           <td>
            <select id="level"  class="text3" >
						 <option >我的代理</option>
						 <option >输入编号</option>
						  <option >普通客户</option>
						 </select>
						 <select  style="margin-left:1%" id="info" name="uid" class="text3" >
						 <s:iterator value="users" status="sta" var="user" >
						 <!-- 用户等级 -->
						  <!-- 用户等级 -->
						 <s:if test="#user.uid!=1"><!-- 不是zmz -->
						 <option id="${user.level}" value="${user.uid}" >${user.username}${user.code}</option>
						 </s:if>
						 </s:iterator>
						 </select>
						 <input   name="dlname" id="dlname" style=" 
					margin-left:30%;
					display:none;
					width:35%;
					border: 1px solid #ccc;
                     padding: 2px;
                     font-size: 1.2em;
                     color: #000000;
                     background-color: #eeeeee;" type="text" 
            placeholder="代理姓名">
				</td>
				<td> <span style="color:red;font-size:15" >*</span></td>
			</tr>
			 <!--第五行头 -->
			<tr>
				<td>
				     <span class="font1">联系方式：</span>
           </td>
           <td>
             <input value="${apply.phone}" class="text" type="text" name="apply.phone" id="phone" >
				</td>
				<td>
					 <span style="color:red;font-size:15" id="receivePhoneSpan1">*</span>
				</td>
			</tr>
             <!--第六行头 -->
			<tr>
	         	  	    <td>
						<span class='font1'>收货地址：</span>
						</td>

					 <td>
             <input  value="${apply.place}" class="text" type="text" name="apply.place" id="place" >
				</td>
				<td>
					 <span style="color:red;font-size:15" id="receivePhoneSpan1">*</span>
				</td>
	         	  </tr>
             <!--第七行头 -->
			<tr>
				<td>
				     <span class="font1">商品名：</span>
           </td>
           <td>
            <select class="text3" name="apply.gname">
	         	     	<s:iterator value="names" var="name" status="sta">
	         	     	<option value="${name}">
	         	     		   ${name}	
	         	     		</option>
	         	     	</s:iterator>
	         	     	</select>
				</td>
				<td>
				</td>
			</tr>
             <!--第八行头 -->
			<tr>
				<td>
				     <span class="font1">商品数量：</span>
           </td>
           <td>
             <input  value="${apply.gcount}" class="text" type="text" name="apply.gcount" id="gcount" 
             onblur="checkgoodsNumber('goodsNumberID','goodsNumberSpan1','goodsNumberSpan2','goodsNumberSpan3')" onclick="clickInput2('goodsNumberSpan1','goodsNumberSpan2','goodsNumberSpan3')">
				</td>
				<td width="90">
					 <span style="color:red;font-size:15" id="goodsNumberSpan1">*</span>
				</td>
			</tr>
			<tr><td><span align="center"><s:if test="msg!=null">${msg}</if></s:if></span></td></tr>
			 <!--第九行头 -->
			<tr>
        <td>
        </td>
				<td>
				     <br>
             <input class="btn" type="button" id="bt" value="确定" >
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