<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/backcss/myCss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公司入库</title>
<script type="text/javascript">
$(document).ready(function(){
$("#gb").click(function(){
	if($("#gcount").val()==""){
		alert("请填写数量");
	}
	if(!isNaN($("#gcount").val())){
		if(confirm("请再次确认是否入库"+$("#gcount").val()+"件"+$("#na").val()+"产品")){
			$("#af").submit();
		}
	}else{
		alert("请规范填写");
	}
	});
}
);
</script>
</head>
<body>
			<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">  
			<img src="image/blue.jpg" height="100%" width="100%"/>  
			</div> 
<div align="center">
<body >
			<form action="addgoods" method="post" id="af" >
        <br>
			<table border="0" align="center" cellpadding="10" cellspacing="10"
              >
			      <tr>
                      <th width:20% align="right"></th>
                      <th width:40% align="center"> <p align="center" class="font3">货物入库</p></th>
                      <th width:40% align="left"></th>
                  </tr>            			 
             <!--第七行头 -->
			<tr>
				<td>
				     <span class="font1">商品名：</span>
           </td>
           <td>
            <select id="na" class="text" name="out.gname">
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
             <input class="text" type="text" name="out.count" id="gcount" 
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
             <input class="btn" type="button" id="gb" value="确定" >
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