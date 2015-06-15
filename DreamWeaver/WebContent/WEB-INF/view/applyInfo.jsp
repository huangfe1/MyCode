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
		</head>
			<body >
			<form action="applygoods" method="post" id="af" >
        <br>
			<table border="0" align="center" cellpadding="10" cellspacing="10"
              >
			      <tr>
                      <th width:20% align="right"></th>
                      <th width:40% align="center"> <p align="center" class="font3">物流单号:<s:property value="apply.wid"/></p></th>
                      <th width:40% align="left"></th>
                  </tr>            			 
			 <!--第四行头 -->
           <tr>
				<td>
				     <span class="font1">收货人：</span>
           </td>
           <td>
            <span><s:property value="apply.sname"/></span>
			</tr>
			 <!--第五行头 -->
			<tr>
				<td>
				     <span class="font1">联系方式：</span>
           </td>
           <td>
           <span class="font1"><s:property value="apply.phone"/> </span>
				</td>
			</tr>
             <!--第六行头 -->
			<tr>
	         	  	    <td>
						<span class='font1'>收货地址：</span>
						</td>

					 <td>
               <span class="font1"><s:property value="apply.place"/> </span>
				</td>
	         	  </tr>
             <!--第七行头 -->
			<tr>
				<td>
				     <span class="font1">商品名：</span>
           </td>
           <td>
               <span class="font1"><s:property value="apply.gname"/> </span>
				</td>
			</tr>
             <!--第八行头 -->
			<tr>
				<td>
				     <span class="font1">商品数量：</span>
           </td>
           <td>
               <span class="font1"><s:property value="apply.gcount"/> </span>
				</td>
			</tr>
			 <!--第九行头 -->
			<tr>
        <td>
        </td>
				<!-- <td>
				     <br>
             <input class="btn" type="button" id="bt" value="确定" >
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			         <input class="btn" type="reset" value="重置">
				</td> -->
        <td>
        </td>
			</tr>
			</table>
			</form>
			</body>
		</html>