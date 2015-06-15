<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
 	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	<script type="text/javascript" src="js/baidujs.js"></script>
 	<link href="css/backcss/baiducss.css" rel="stylesheet" type="text/css" />
     <title>筑美一下</title>
<script type="text/javascript" src="js/checkgoods.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#goodsbt").click(function(){
		if($("#number").val()==""){
			alert("亲,您忘了输入货物编号");
		}else{
			location.href="goodsUser?number="+$("#number").val()+"&pt="+${param.pt};;
		}
	});
	$("#userbt").click(function(){
	if($("#code").val()==""){
			alert("亲,您忘了输入代理商编号");
		}else{
			location.href="goodsUser?code="+$("#code").val()+"&pt="+${param.pt};;	
		}
	});
	
});
</script>
  </head>
  <body class="background1">
  	
  	 <table border="0" align="right" cellpadding="0" cellspacing="0" height="5%" width="30%">
  	 	<tr align="right">
  	 		<td>
  	 			<a href="http://huangfei.gotoip55.com/alcatron/">筑美首页</a>
  	 		</td>
  	 		<td>
  	 			<a href="index.jsp">代理登陆</a>
  	 		</td>
  	 		<td>
  	 		<s:if test="#parameters.pt[0]==1">
  	 		<a href="Search.jsp?pt=0">防伪查询</a>
  	 		</s:if>
  	 		<s:else><a href="Search.jsp?pt=1">授权查询</a></s:else>
  	 		</td>
  	 		<td>
  	 			<a href="http://appmfl.com/j.htm?ZfqiFBAmri">筑美APP</a>
  	 		</td>
  	 		<!-- <td>
  	 			<a href="#">贴吧</a>
  	 		</td>
  	 		<td>
  	 			<a href="#">登录</a>
  	 		</td>
  	 		<td>
  	 			<a href="#">设置</a>
  	 		</td> -->
  	 	</tr>
  	 </table>
  	</br>
  	</br>
  	</br>
  	<div id="middleDivId">
       <table border="0" align="center" cellpadding="0" cellspacing="0" height="30%" width="100%">
       	   <tr align="center">
       	   	<td width="10%">
       	   		
       	   	</td>
       	   	<td width="80%" >
       	   		 <img src="images/baidu_log.png"/>
       	   	</td>
       	   	 <td width="10%">
       	   	 	
       	   	 </td>
       	   </tr>
       	   <tr align="center">
       	   	 <td width="10%"></td>
       	   	 <td width="80%">
       	   	 <s:if test="#parameters.pt[0]==1">
       	   	 <input id="code" placeholder="请输入代理商的代理编号/姓名/手机号/微信号" class="text2" type="text" name="code" >
       	   	 <input class="submitstyle"  id="userbt" type="button"  value="">
       	   	 </s:if>
       	   	 <s:else><input id="number" placeholder="请输入货物防伪码" class="text2" type="text" name="code" >
       	   	 <input class="submitstyle" id="goodsbt" type="button"  value="">
       	   	 </s:else>	
       	   	 </td>
       	   	 <td width="10%"></td>
       	   </tr>
       	    <s:if test="msg!=null"><tr><td></td><td align="center"><span class="STYLE3">${msg}</span></td></tr></s:if>
       	   <!-- 下面是查询信息 -->
       	   <s:if test="goodses!=null||user!=null">
  <tr align="center">
  <td width="10%">
       	   	</td>
    <td width="80%">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td bgcolor="#e5f1d6">
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CECECE"  id="userinformation" onmouseover="changeto()"  onmouseout="changeback()" >
          <s:if test="goodses!=null">
          <tr>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物编号</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物名称</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">授权代理</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">修改时间</div></th>
			</tr>	
			<s:iterator value="goodses" var="goods">
			<tr style="height: 25px;background:#ffffff ;">
			<td><div align='center' class='STYLE1'>${goods.number}</div></td>
			<td><div align='center' class='STYLE1'>${goods.name}</div></td>
			<td><div align='center' class='STYLE1'>${goods.username}(${goods.code})</div></td>
			<td><div align='center' class='STYLE1'>${goods.time}</div></td>
			</tr>
			</s:iterator>
	          </s:if>
          </table>
      </td>
        <s:if test="user.code!=null">
	<div align="center"><img  alt="" src="imageaction?code=${user.code}"></div>
	</s:if>
      </tr>
    </table>
    </td>
  </tr>
 </s:if>
       </table>
  	</div>
  </body>
</html>