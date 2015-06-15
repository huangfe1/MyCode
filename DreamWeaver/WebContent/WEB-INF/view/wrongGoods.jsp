<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/backcss/checkgoods.css">
<script type="text/javascript" src="js/checkgoods.js"></script>
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
          <span class="STYLE3">
          &nbsp;错&nbsp;误&nbsp;列&nbsp;表<s:if test="msg!=null">($msg)</s:if>
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
            <s:if test="#session.user.type==0||#session.user.type==2">您已修改以下货物,下面是原始信息</s:if> <s:else> 您可能不具备对当前货物的操作权限,或者货物不存在,请联系管理员！</s:else>
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
          <tr>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物编号</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物类型</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">授权代理</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">代理公司</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">美容院</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">修改时间</div></th>
          </tr>
          <!-- 循环添加 -->
          <s:iterator value="wgses" status="sta" var="goods">
			<tr style="height: 25px;background:#ffffff ;">
			<td><div align='center' class='STYLE1'>${goods.number}</div></td>
			<td><div align='center' class='STYLE1'>${goods.name}</div></td>
			<td><div align='center' class='STYLE1'>${goods.username}</div></td>
			<td><div align='center' class='STYLE1'>${goods.company}</div></td>
			<td><div align='center' class='STYLE1'>${goods.parlour}</div></td>
			<td><div align='center' class='STYLE1'>${goods.time}</div></td>
			</tr>
          </s:iterator>
           <s:iterator value="ngses" status="sta" var="goods">
			<tr style="height: 25px;background:#ffffff ;">
			<td><div align='center' class='STYLE1'>${goods.number}</div></td>
			<td><div align='center' class='STYLE1'>不存在</div></td>
			<td><div align='center' class='STYLE1'>不存在</div></td>
			<td><div align='center' class='STYLE1'>不存在</div></td>
			<td><div align='center' class='STYLE1'>不存在</div></td>
			<td><div align='center' class='STYLE1'>不存在</div></td>
			</tr>
          </s:iterator>
          </table>
      </td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>
  <!-- 上面是表格的中部 -->
</table>
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
