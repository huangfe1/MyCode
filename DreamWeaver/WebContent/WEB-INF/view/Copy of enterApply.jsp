return "toLogin";<%@ page language="java" contentType="text/html; charset=utf-8"
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
		</head>
		<body >
			<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">  
			<img src="images/bg11.jpg" height="100%" width="100%"/>  
			</div> 
			<div class="" style="width:100%;height:100%">
		   <form id="form" action="enterapply" method="post" >
		   <input type="hidden" name="aid" value="${aid}" />
		   <input type="hidden" id="type" name="type" value="${type}" >
	       <table border='0' cellspacing='0' cellpadding='0'  align='center' width="95%" height="100%" >
	         	
	         	 <tr>
                  	<td colspan="6">
                  	<p align="center" class="font3">
                  	<s:if test="type==0">串号录入表单</s:if>
                  	<s:else>单号录入表单</s:else>
                  	</p>
                  	</td>
                  </tr>
	         	  <tr id="nstd" align="center">
	         	     <td  align='left' valign="bottom">
	         	     <s:if test="type==0"><!-- 串号录入 -->
	         	     <span class='font1'>头&nbsp;编&nbsp;号：</span>
	         	     </s:if>
	         	     </td>
	         	     <c:forEach begin="0" end="3" var="i"> 
	         	     <td align="left" valign="bottom" >
	         	     <c:forEach begin="${1+i*3}" end="${3+i*3}" var="j" >
	         	     <input type='text' class='text4' id='f${j}' name="list"  >
	         	     </c:forEach>
	         	     </td>	
	         	       </c:forEach>
	         	  </tr>
                  <tr align="center" style="height:0 ;" >
                  	<td align="left">
                  	<s:if test="type==1">
	         	     <span class='font1'>货物编号：</span>
	         	    </s:if>
                  	</td>
                  	<s:if test="type==1">
                  	<td colspan="4"></td>
                  	 </s:if>
                  	 <s:else><!-- 串号录入 -->
                  	 <c:forEach begin="0" end="3" var="i"> 
	         	     <td align="center" valign="top" >
	         	     <c:forEach begin="${1+i*3}" end="${3+i*3}" var="j" >
	         	   	 <div style="width: 33%;float: left;"><img align="center" id="m${j}"  src="images/xiangxia-3.png"></div>
	         	     </c:forEach>
	         	     </td>	
	         	       </c:forEach>
                  	</s:else>
                  </tr>
	         	  <tr align="center">
	         	     <td align='left' valign="top">
	         	     <s:if test="type==0">
	         	     <span class='font1'>尾&nbsp;编&nbsp;号：</span>
	         	     </s:if>
	         	     </td>
	         	      <c:forEach begin="0" end="3" var="i"> 
	         	     <td align="left" valign="top" >
	         	     <c:forEach begin="${1+i*3}" end="${3+i*3}" var="j" >
	         	     <input type='text' class='text4' id='e${j}' name="list"  >
	         	     </c:forEach>
	         	     </td>	
	         	       </c:forEach>
	         	     <!-- <td align='left' valign="top">
	         	     	<input type='text' class='text4' id='e1' name="list" >
	         	       </td>
	         	       <td valign="top">
	         	     	<input type='text' class='text4' id='e2' name="list" >
	         	       </td>
	         	       <td valign="top">
	         	     	<input type='text' class='text4' id='e3' name="list" >
	         	     	</td>
	         	     	<td align='right' valign="top">
	         	     	<input type='text' class='text4' id='e4' name="list" >
	         	     </td> -->
	         	  </tr>
	         	      <tr align="center">
	         	  		<td align='left' >
						<span class='font1'>物流单号：</span>
						</td>
						<td colspan="4" align="left">
						<span class='font1'><input name="wid" type="text" class="text3"></span>
						</td>
	         	  </tr>
                  <tr align="center">
	         	  		<td align='left' >
						<span class='font1'>收货人：</span>
						</td>
						<td colspan="4" align="left">
						<span class='font1'><s:property  value="name"/></span>
						</td>
	         	  </tr>
	         	  <tr align="center" style="height: 0"> 
	         	     
	         	     <td align='left' >
	         	     	<span class='font1'>产&nbsp;品&nbsp;名：</span>
	         	     	</td>
	         	     	<td colspan="2" align="left">
					<span class="font1"><s:property  value="gname"/></span>
	         	     	</td>
	         	 </tr>
				  <tr>
				     <td colspan="6" align="center">
				     	<input class="btn" style="display: none;" id="lastbt" type="button" value="返回修改"  >
				 	    <input class="btn" id="nextbt" type="button" value="下一步"  >
				          <span class='font1'>
				     	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				          </span>
				         <input class="btn" type="reset" id="res" value="重置">
				         <input class="btn" style="display: none;" type="button" id="sub" value="确认录入">
				    </td>
			      </tr>
			      <tr><td colspan="6"  align="center"><span class="font1" style="color:red"><s:property value="msg"/></span></td></tr>
	         </table>
		   </form>
		   </div>
		</body>
		</html>