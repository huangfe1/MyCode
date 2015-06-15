<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
     <%@taglib prefix="d" uri="http://java.sun.com/jstl/core_rt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/backcss/checkgoods.css">
<script type="text/javascript" src="js/checkgoods.js"></script>
</head>

<body bgcolor='CDD6E5'>
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
          <span class="STYLE3">
          ${name }的&nbsp;市&nbsp;场&nbsp;情&nbsp;况
          </span>
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
         </td>
         <td align="center">
         </td>
         <td align="center">
         </td>
          <td align="center">
              <span class="STYLE1">
           	  </span>
         </td>
         <td align="center" >
         </td>
        <td width="9" background="images/tab_16.gif"></td>
      </tr>
      </table>
    </td>
  </tr>
  <!-- 以上是表格的头部 -->
  <tr>
    <td>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#e5f1d6">
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CECECE"  id="userinformation" onmouseover="changeto()"  onmouseout="changeback()" >
           <!-- 拥有的代理等级 -->
          <tr>
          <s:iterator value="hm"  var="s">
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">${s.key }</div></th>
          </s:iterator>
          </tr>
          <!-- 对应的数量 -->
       <tr style="height: 25px;background:#ffffff ;">
          <s:iterator value="hm"  var="s">
      	 <td><div align="center" class="STYLE1">${fn:length(s.value)} </div></td>
          </s:iterator>
          </tr>
          <!-- 循环添加用户-->
          <d:forEach begin="0" end="${uc-1}" var="v">
        	<tr style="height: 25px;background:#ffffff ;">
         <d:forEach items="${hm}" var="s">
          <td>
          <div align='center' class='STYLE1'>
       	<d:if test="${s.value[v]==null}">
       	                     --
       	</d:if>
       	<d:if test="${s.value[v]!=null}">
       	<d:if test="${s.value[v].status==0}"><!-- 没有激活 -->
       	   <a href="checklevel?uid=${s.value[v].uid}&name=${s.value[v].username}"><span style="color:blue">${s.value[v].username}(${s.value[v].code})</span></a> 
       </d:if>
         	<d:if test="${s.value[v].status==1}"><!-- 已激活 -->
       	   <a href="checklevel?uid=${s.value[v].uid}&name=${s.value[v].username}">${s.value[v].username}(${s.value[v].code})</a>       
       </d:if>
       </d:if>
          </div>
          </td>
       </d:forEach>
          </tr>
          </d:forEach>
         <%--  <s:iterator value="names" status="sta" var="n">
			<tr style="height: 25px;background:#ffffff ;">
			<td><div align='center' class='STYLE1'>${n.name}</div></td>
			<td><div align='center' class='STYLE1'>${n.time}</div></td>
			 <td><div align='center' class='style1'><img src='images/010.gif' width='9' height='9' /> <a href='#' onclick="if(confirm('确认删除')){location.href='conName!delete?name=${n.name}'}" class='style2'>删除</a></div></td> 
			 <td><div align='center' class='style1'><img src='images/037.gif' width='9' height='9' /><a href='changeNamesjsp?name=${n.name}' class='style2' >修改</a></div></td>
			</tr>
          </s:iterator>  --%>
          </table>
      </td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>
  <!-- 上面是表格的中部 -->
</table>
  <!-- 以下是表格的尾部 -->
  <tr>
    <td height="29">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
        <td background="images/tab_21.gif">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="50%" valign="top" class="STYLE1">
           </td>
          </tr>
        </table>
      </td>
        <td width="14">
          <img src="images/tab_22.gif" width="14" height="29" />
        </td>
      </tr>
    </table>
  </td>
  </tr>
  <!-- 以上是表格的尾部 -->
</table>
</body>
</html>
