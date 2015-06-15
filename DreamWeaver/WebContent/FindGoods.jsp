<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/backcss/checkgoods.css">
<link rel="stylesheet" type="text/css" href="css/backcss/myCss.css">
<script type="text/javascript" src="js/checkgoods.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#goodsbt").click(function(){
		if($("#number").val()==""){
			alert("亲,您忘了输入货物编号");
		}else{
			location.href="goodsUser?number="+$("#number").val()+"&pt="+${param.pt};
		}
	});
	$("#userbt").click(function(){
	if($("#code").val()==""){
			alert("亲,您忘了输入代理商编号");
		}else{
			location.href="goodsUser?code="+$("#code").val()+"&pt="+${param.pt};	
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
        <td align="center" >
          <span class="STYLE3"><s:if test="#parameters.pt[0]==0">请输入要查找的货物编号:<span class="kw"><input  class="kuang" type="text" id="number" ></span><input class="mybt" type="button" value="查找一下" id="goodsbt"></s:if><s:else>请输入要查找的代理商信息！</s:else></span>
         </td>
         <td align="center">
         <s:if test="#parameters.pt[0]==0">
           </span>
           </s:if>
           <s:else>
           <span class="STYLE3">用户信息：<input id="code" type="text" height="25" placeholder="编号/姓名/微信/手机" width="100">
             <input class="btn" type="button" id="userbt" value="查找">
           </span>
           </s:else>
         </td>
         <td align="center" width="300">
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
         <s:if test="user!=null">
          <tr>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">用户编号</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">用户名</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">手机号码</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">微信账号</div></th>
          </tr>
          </s:if>
          <s:if test="goods!=null">
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物编号</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物名称</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">授权代理</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">修改时间</div></th>
          </s:if>
        <s:if test="user!=null">
			<tr style="height: 25px;background:#ffffff ;">
			<td><div align='center' class='STYLE1'><a href="pcImage.jsp?code=${user.code}">${user.code}</a></div></td>
			<td><div align='center' class='STYLE1'>${user.username}</div></td>
			<td><div align='center' class='STYLE1'>${user.phone}</div></td>
			<td><div align='center' class='STYLE1'>${user.weixin}</div></td>
			</tr>
          </s:if>
          <s:if test="goods!=null">
			<tr style="height: 25px;background:#ffffff ;">
			<td><div align='center' class='STYLE1'>${goods.number}</div></td>
			<td><div align='center' class='STYLE1'>${goods.name}</div></td>
			<td><div align='center' class='STYLE1'>${goods.username}</div></td>
			<td><div align='center' class='STYLE1'>${goods.time}</div></td>
			</tr>
          </s:if>
          </table>
      </td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
      </s:if>
    </table>
    </td>
  </tr>
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
            <s:else><span class="STYLE2">尊敬的用户您好:欢迎您使用筑美货物跟踪系统!</span></s:else>
            </span>
           </td>
              </table>
               <td width='14'><img src="images/tab_22.gif" height="29"></td>
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
	<div align="center"><img  alt="" src="zs/${user.code}.jpg"></div>
	</s:if>
  </td>
  </tr>
  <!-- 以上是表格的尾部 -->
</table>
</body>
</html>
