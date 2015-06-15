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
		 <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		 <script type="text/javascript" src="js/calendar.js"></script>
	     <script type="text/javascript" src="js/addAgent.js"></script>
	   	 <script type="text/javascript" src="js/dlselect.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			$("#bt").click(function(){
				if($("#wid").val()==""){
					alert("请填写物流单号");
				}else{
					$("#form").submit();
				}
			});
			
		});
		</script>
		</head>
		<body >
			<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">  
			<img src="images/bg11.jpg" height="100%" width="100%"/>  
			</div> 
			<div  style="width:100%;height:100%;">
		   <form  id="form" action="enterapply" method="post" >
		   <input type="hidden" name="aid" value="${aid}" />
		   <input type="hidden" id="type" name="type" value="${type}" >
	     <table   border="0"  align="center" cellpadding="10" cellspacing="10">
			   	 <!--第四行头 -->
			   	 <tr></tr> <tr></tr><tr></tr>
           <tr>
				<td>
				     <span class="font1">物流单号：</span>
           </td>
           <td>
            <span><input type="text" name="wid" id="wid" class="font1"></span>
			</tr>           			 
			
			 <!--第四行头 -->
           <tr>
				<td>
				     <span class="font1">收货人：</span>
           </td>
           <td>
            <span><s:property value="#parameters.sname[0]"/></span>
			</tr>
			 <!--第五行头 -->
			<tr>
				<td>
				     <span class="font1">联系方式：</span>
           </td>
           <td>
           <span class="font1"><s:property value="#parameters.phone[0]"/> </span>
				</td>
			</tr>
             <!--第六行头 -->
			<tr>
	         	  	    <td>
						<span class='font1'>收货地址：</span>
						</td>

					 <td>
               <span class="font1"><s:property value="#parameters.place[0]"/> </span>
				</td>
	         	  </tr>
             <!--第七行头 -->
			<tr>
				<td>
				     <span class="font1">商品名：</span>
           </td>
           <td>
               <span class="font1"><s:property value="#parameters.gname[0]"/> </span>
				</td>
			</tr>
             <!--第八行头 -->
			<tr>
				<td>
				     <span class="font1">商品数量：</span>
           </td>
           <td>
               <span class="font1"><s:property value="#parameters.gcount[0]"/> </span>
				</td>
			</tr>
			 <!--第九行头 -->
			<tr>
        <td>
        </td>
				<td>
				     <br>
             <input class="btn" type="button" id="bt" value="确定" >
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        <!--  <input class="btn" type="reset" value="重置"> -->
				</td>
        <td>
        </td>
			</tr>
			</table>
		   </form>
		   </div>
		</body>
		</html>