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
	var count=${count};//记录总数
    var np=${nowpage};//当前页数jihuo 
    var pc=Math.ceil(count/15);//总页数
	$("#pctext").html(""+pc);
	function a(a){
		if(a=='f'){//首页
			location.href="checkAllUser?count="+count+"&nowpage="+0;	
		}else if(a=='l'){//前一页
			if(np==1){//如果是第一页
				alert("亲,已经是第一页了");
			}else{
		np=np-2;
		location.href="checkAllUser?count="+count+"&nowpage="+np;		
			}
		}else if(a=='n'){//下一页
		if(np==pc){
			alert("亲,已经是最后一页了");
		}else{
			location.href="checkAllUser?count="+count+"&nowpage="+np;	
		}	
		}else if(a=='e'){//最后一页
			pc=pc-1;
			location.href="checkAllUser?count="+count+"&nowpage="+pc;
		}
		}
	//编号查询
	$("#codebt").click(function(){
		if($("#code").val()==""){
		alert("亲,您还没填写编号");
		}else{
		location.href="checkAllUser?code="+$("#code").val();
		}
	});
	//姓名查询
	$("#namebt").click(function(){
		if($("#name").val()==""){
		alert("亲,您还没有填写姓名");
		}else{
		location.href="checkAllUser?name="+$("#name").val();
		}
	});
	
	//翻页按钮设置监听
	$("#f").click(function(){
		a($(this).attr('id'));
	});
	$("#l").click(function(){
		a($(this).attr('id'));
	});
	$("#n").click(function(){
		a($(this).attr('id'));
	});
	$("#e").click(function(){
		a($(this).attr('id'));
	});
	//跳转翻页
	$("#npbt").click(function(){
		var nptext=parseInt($("#nptext").val());
		if(nptext<=0||nptext>pc||isNaN(nptext)){
			alert("输入错误");
		}else{
			pc=nptext-1;
		location.href="checkAllUser?count="+count+"&nowpage="+pc;
		}
	}	);
});
</script>
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
          <span class="STYLE3">&nbsp;所&nbsp;有&nbsp;用&nbsp;户&nbsp;列&nbsp;表</span><span >(${lvmsg})</span>
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
           <span class="STYLE1">按编号查找：<input id="code" type="text" height="25" width="100">
             <input id="codebt" class="btn" type="button" value="查找">
           </span>
         </td>
         <td align="center">
           <span class="STYLE1">按用户名查找：<input id="name" type="text" height="25" width="100">
             <input id="namebt" class="btn" type="button" value="查找">
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
  <tr>
    <td>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#e5f1d6">
          
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CECECE"  id="userinformation" onmouseover="changeto()"  onmouseout="changeback()" >
          <tr>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">用户编号</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">用户名</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">手机号码</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">微信账号</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">身份证号</div></th>
            <s:if test="#session.user.type==0"><!-- 公司用户显示密码 -->
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">用户密码</div></th>
            </s:if>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">代理等级</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">申请时间</div></th>
              <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">激活状态</div></th>
           <s:if test="#session.user.type==0"><!-- 公司用户授权 -->
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">备注</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">编辑</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">删除</div></th>
        	</s:if>
          </tr>
          <!-- 循环添加 -->
          <s:iterator value="users" status="sta" var="user">
          <s:if test="#user.fid!=0"><!-- 不显示普通用户 -->
			<tr style="height: 25px;background:#ffffff ;">
			<td><div align='center' class='STYLE1'><a href="pcImage.jsp?code=${user.code}">${user.code}</a></div></td>
			<td><div align='center' class='STYLE1'>${user.username}</div></td>
			<td><div align='center' class='STYLE1'>${user.phone}</div></td>
			<td><div align='center' class='STYLE1'>${user.weixin}</div></td>
			<td><div align='center' class='STYLE1'>${user.idcard}</div></td>
			<s:if test="#session.user.type==0">
			<td><div align='center' class='STYLE1'>${user.password}</div></td>
			</s:if>
			<td><div align='center' class='STYLE1'>${user.level}</div></td>
			<td><div align='center' class='STYLE1'>${user.time}</div></td>
			  	 <s:if test="#session.user.type==2">
			  	<td>
			<div align='center' class='STYLE1'>
			<s:if test="#user.status==1">已经激活</s:if><!-- 已经激活 -->
			<s:else>没有激活</s:else>
			</div>
			</td>
			</s:if>
			  <s:if test="#session.user.type==0">
			<td>
			<div align='center' class='STYLE1'>
			<s:if test="#user.status==1"><a href="activityUser?uid=${user.uid}&status=0&nowpage=${nowpage-1}&count=${count}&name=${name}&code=${code}">取消激活</a></s:if><!-- 已经激活 -->
			<s:else><a href="activityUser?uid=${user.uid}&status=1&nowpage=${nowpage-1}&count=${count}&name=${name}&code=${code}"><span style="color:blue">点击激活</span></a></s:else>
			</div>
			</td>
			<td><div align='center' class='STYLE1'>${user.fname}</div></td>
			<td><div align='center' class='STYLE1'><img src='images/037.gif' width='9' height='9' /><a href='changeUserjsp?uid=${user.uid}' class='STYLE2' >修改</a></div></td>
			<td><div align='center' class='STYLE1'><img src='images/010.gif' width='9' height='9' /> <a href='#' onclick="if(confirm('同时将删除此用户拥有的货物,请谨慎!')){location.href='deleteUser?uid=${user.uid}'}" class='STYLE2'>删除</a></div></td>
	</s:if>
			</tr>
				</s:if>
          </s:iterator>
          </table>
      </td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
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
          <tr>
            <td width="50%" height="29">
            <span class="STYLE1">
            <s:if test="count==0">没有相关记录</s:if>
            <s:else>共${count}条纪录，当前第${nowpage}/<span id="pctext"></span>页，每页最多15条纪录</s:else>
            </span>
           </td>
            <td width="50%" valign="top" class="STYLE1">
              <div align="right">
              <table width="400" height="20" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="62" height="22" valign="middle"><div align="center"><!-- <img src="images/first.gif" width="46" height="20" /> -->
                  <input id="f" class="btn1" type="button" >
                  </div></td>
                  <td width="50" height="22" valign="middle"><div align="center"><!-- <img src="images/back.gif" width="46" height="20" /> -->
                  <input id="l" class="btn2" type="button" >
                  </div></td>
                  <td width="54" height="22" valign="middle"><div align="center"><!-- <img src="images/next.gif" width="46" height="20" /> -->
                   <input id="n" class="btn3" type="button" >
                  </div></td>
                  <td width="49" height="22" valign="middle"><div align="center"><!-- <img src="images/last.gif" width="46" height="20" /> -->
                   <input id="e" class="btn4" type="button" >
                   </div></td>
                  <td width="59" height="22" valign="middle"><div align="center">转到第</div></td>
                  <td width="25" height="22" valign="middle"><span class="STYLE7">
                    <input id="nptext"  name="nptext" type="text" class="STYLE1" style="height:20px; width:50px;"  />
                  </span></td>
                  <td width="23" height="22" valign="middle">页</td>
                  <td width="30" height="22" valign="middle"><!-- <img src="images/g_page.gif" width="14" height="14" /> -->
                  <input class="btn5" id="npbt" type="button" >
                  </td>
                </tr>
              </table>
              </div>
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
