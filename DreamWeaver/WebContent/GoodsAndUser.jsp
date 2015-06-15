<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/backcss/checkgoods.css">
<script type="text/javascript" src="js/checkgoods.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#goodsbt").click(function(){
		if($("#number").val()==""){
			alert("亲,您忘了输入货物编号");
		}else{
			location.href="goodsUser?number="+$("#number").val();
		}
	});
	$("#userbt").click(function(){
	if($("#code").val()==""){
			alert("亲,您忘了输入代理商编号");
		}else{
			location.href="goodsUser?code="+$("#code").val();	
		}
	});
	
});
</script>
</head>
<body bgcolor='#bbffbb'>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <!-- 以下是表格的头部 -->
  <tr>
    <td height="35">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="35">
          <img src="images/tab_03.gif" width="15" height="35" />
        </td>
        <td background="images/tab_05.gif">
          <img src="images/311_2.jpg" width="20" height="20" /> 
          <span class="STYLE3">&nbsp;用&nbsp;户&nbsp;与&nbsp;货&nbsp;物&nbsp;查&nbsp;询</span>
        </td>
        <td width="14"><img src="images/tab_07.gif" width="14" height="35" /></td>
      </tr>
      </table>
    </td>
  </tr>

  <tr >
    <td height="30">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff" height="30">
      <tr>
        <td width="9" background="images/tab_12.gif"></td>
        <td align="left" >
          <%--  <span class="style1">&nbsp;&nbsp;全选<input onclick="checkAll(this.checked)" name="checkbox" type="checkbox"  value="checkbox" id="checkall"/>
           </span> --%>
         </td>
         <td align="center">
           <span class="STYLE1">查找货物：<input type="text" id="number" height="25" width="100">
             <input class="btn" type="button" value="查找" id="goodsbt">
           </span>
         </td>
         <td align="center">
           <span class="STYLE1">查找用户：<input id="code" type="text" height="25" placeholder="编号/姓名/微信/手机" width="100">
             <input class="btn" type="button" id="userbt" value="查找">
           </span>
         </td>
         <td align="center" width="300">
          <%--  <span class="STYLE2"><a href="#" >删除所选</a></span> --%>
         </td>
        <td width="9" background="images/tab_16.gif"></td>
      </tr>
      </table>
    </td>
  </tr>
  <!-- 以上是表格的头部 -->
  <!-- 下面是表格的中部 -->
  <s:if test="goods!=null||user!=null">
  <tr>
    <td>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#e5f1d6">
          
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CECECE"  id="userinformation" onmouseover="changeto()"  onmouseout="changeback()" >
          <s:if test="goodses!=null">
            <tr>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物编号</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物名称</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">授权代理</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">修改时间</div></th>
           </tr>
           
           <s:iterator value="goodses" var="gs">
           	<tr style="height: 25px;background:#ffffff ;">
			<td><div align='center' class='STYLE1'>${gs.number}</div></td>
			<td><div align='center' class='STYLE1'>${gs.name}</div></td>
			<td><div align='center' class='STYLE1'>${gs.username}</div></td>
			<td><div align='center' class='STYLE1'>${gs.time}</div></td>
			</tr>
           </s:iterator>
           
          </s:if>
          </table>
      </td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>
 </s:if>
  <!-- 上面是表格的中部 -->
  <!-- 以下是表格的尾部 -->
  <tr>
    <td height="29">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
        <td background="images/tab_21.gif">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <td width="50%" height="29">
            <span class="STYLE1">
            <s:if test="msg!=null">${msg }</s:if>
            <s:else>尊敬的用户您好:欢迎您使用筑美货物跟踪系统!</s:else>
            </span>
           </td>
              </table>
              <td width="14">
          <img src="images/tab_22.gif" width="14" height="29" />
        </td>
          </tr>
        </table>
      </td>
      </tr>
    </table>
  </td>
  </tr>
  <tr align="center">
  <td align="center">
	<s:if test="user.code!=null">
	<div align="center"><img  alt="" src="imageaction?code=${user.code}"></div>
	</s:if>
  </td>
  </tr>
  <!-- 以上是表格的尾部 -->
</table>
</body>
</html>
