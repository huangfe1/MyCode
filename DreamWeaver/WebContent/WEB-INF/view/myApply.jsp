<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/backcss/checkgoods.css">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/time.js"></script>
<script type="text/javascript" src="js/checkgoods.js"></script>
<script type="text/javascript">
var c = new Calendar("c");
document.write(c);
$(document).ready(function(){
	var sel="type="+${type};//jquery中获取当前的类型
	var st=$("#time").val();
	var sn=$("#name").val();
	//生成筛选条件
	if(sn!=""){
		sel=sel+"&sn="+sn;
	}
	if(st!=""){
		sel=sel+"&st="+st;
	}
	var count=${count};//记录总数
    var np=${nowpage};//当前页数
    var pc=Math.ceil(count/15);//总页数
	$("#pctext").html(""+pc);
    //首页,前进,后退
	function a(a){
		if(a=='f'){//首页
			location.href="myapply?count="+count+"&nowpage="+0+"&"+sel;	
		}else if(a=='l'){//前一页
			if(np==1){//如果是第一页
				alert("亲,已经是第一页了");
			}else{
		np=np-2;
		location.href="myapply?count="+count+"&nowpage="+np+"&"+sel;			
			}
		}else if(a=='n'){//下一页
		if(np==pc){
			alert("亲,已经是最后一页了");
		}else{
			location.href="myapply?count="+count+"&nowpage="+np+"&"+sel;		
		}	
		}else if(a=='e'){//最后一页
			pc=pc-1;
			location.href="myapply?count="+count+"&nowpage="+pc+"&"+sel;	
		}
		}
	//编号查找
	$("#selc").click(function(){
		if($("#nu").val()==""){
			alert("亲,请填写编号");
		}else{
			location.href="myapply?"+sel+"&number="+$("#nu").val();
		}
	});
	//时间姓名查找
	$("#selnt").click(function(){
		var st=$("#time").val();
		var sn=$("#name").val();
		var sel="&type="+${type};
			if(sn!="")
			sel=sel+"&sn="+sn;
			if(st!="")
			sel=sel+"&st="+st;
			location.href="myapply?"+sel;	
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
	//转到多少页
	$("#npbt").click(function(){
		var nptext=parseInt($("#nptext").val());
		if(nptext<=0||nptext>pc||isNaN(nptext)){
			alert("输入错误");
		}else{
			pc=nptext-1;
		location.href="myapply?count="+count+"&nowpage="+pc+"&"+sel;	
		}
	}	);
	//删除所选
	$("#dels").click(function(){
		if(confirm("确定删除所选?")){
			$("#checkform").submit();//表单提交
		}
	});
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
          <span class="STYLE3">
          <s:if test="type==0">&nbsp;我&nbsp;的&nbsp;申&nbsp;请</s:if>
          <s:else>&nbsp;下&nbsp;级&nbsp;申&nbsp;请<s:if test="msg!=null">(${msg})</s:if></s:else>
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
         <s:if test="type==1">
           <span class="STYLE1">代理商姓名：<input value="${sn }" id="name" type="text" height="25" width="100">
           </span>
         </s:if>
         </td>
          <td align="center">
              <span class="STYLE1">时间：
			 <input type="text" value="${st}" id='time' name="txt2" style="height:24px; width:143px" onfocus="c.showMoreDay = false;c.show(this);" />
             <input class="btn" type="button" id='selnt'  value="查找">
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
          <form id="checkform" action="backGoods" method="post">
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CECECE"  id="userinformation" onmouseover="changeto()"  onmouseout="changeback()" >
          <tr>
          <s:if test="type!=0">
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">申请人</div></th>
          </s:if>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">申请时间</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物种类</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">收货人</div></th>
                      <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">收货地址</div></th>
                      <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">联系电话</div></th>
                         <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物数量</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">处理状态</div></th>
          </tr>
          <!-- 循环添加 -->
          <s:iterator value="applys" status="sta" var="apply">
			<tr style="height: 25px;background:#ffffff ;">
			<s:if test="type!=0"><!-- 我的申请 -->
			<td><div align='center' class='STYLE1'>${apply.fname}(${apply.fcode})</div></td>
			</s:if>
			<td><div align='center' class='STYLE1'>${apply.time}</div></td>
			<td><div align='center' class='STYLE1'>${apply.gname}</div></td>
			<td><div align='center' class='STYLE1'><s:if test="#apply.uid!=0">${apply.sname}(${apply.scode})</s:if><s:else>${apply.cname}(普通用户)</s:else></div></td>
						<td><div align='center' class='STYLE1'>${apply.place}</div></td>
						<td><div align='center' class='STYLE1'>${apply.phone}</div></td>
							<td><div align='center' class='STYLE1'>${apply.gcount}</div></td>
			<td><div align='center' class='STYLE1'><s:if test="#apply.status==0"><s:if test="type==0"><a href="#" onclick="if(confirm('确定删除?')){location.href='deleteapply?aid=${apply.aid}'}">点击删除</a></s:if><s:else><span style="color:blue"><a  href='enterApplyjsp?aid=${apply.aid}&sname=${apply.sname}&gname=${apply.gname}&gcount=${apply.gcount}&place=${apply.place}&phone=${apply.phone}' class='STYLE2' ><span style="color:blue">未发货</span></a></span></s:else></s:if><s:else><span style="color:green"><a href="applyinfo?aid=${aid}">已发货</a></span></s:else></div></td>
			</tr>
          </s:iterator>
          </table>
           </form>
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
