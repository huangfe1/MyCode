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
	var st=$("#time").val();
	var gn=$("#gname").val();
	var sel="";
	//生成筛选条件
	if(st!=""){
		sel=sel+"&st="+st;
	}
	if(gn!="全部类型"){
		sel=sel+"&gn="+gn;
	}
	var count=${count};//记录总数
    var np=${nowpage};//当前页数
    var pc=Math.ceil(count/15);//总页数
	$("#pctext").html(""+pc);
    //首页,前进,后退
	function a(a){
		if(a=='f'){//首页
			location.href="myout?count="+count+"&nowpage="+0+"&"+sel;	
		}else if(a=='l'){//前一页
			if(np==1){//如果是第一页
				alert("亲,已经是第一页了");
			}else{
		np=np-2;
		location.href="myout?count="+count+"&nowpage="+np+"&"+sel;			
			}
		}else if(a=='n'){//下一页
		if(np==pc){
			alert("亲,已经是最后一页了");
		}else{
			location.href="myout?count="+count+"&nowpage="+np+"&"+sel;		
		}	
		}else if(a=='e'){//最后一页
			pc=pc-1;
			location.href="myout?count="+count+"&nowpage="+pc+"&"+sel;	
		}
		}
	//时间类型查找
	$("#selnt").click(function(){
		var st=$("#time").val();
		var gn=$("#gname").val();
			var sel="";
			if(st!="")
			sel=sel+"&st="+st;
			if(gn!="")
			sel=sel+"&gn="+gn;
			location.href="myout?"+sel;	
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
		location.href="myout?count="+count+"&nowpage="+pc+"&"+sel;	
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
         &nbsp;库&nbsp;存&nbsp;流&nbsp;动<s:if test="msg!=null">(${msg})</s:if>
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
         <span class="STYLE1">货物种类：
			<select style="height:24px; width:143px" id="gname" name="gname">
			<option>全部类型</option>
			<s:iterator value="names" >
			<s:if test='%{name==gn}'><!-- name已经加入valuestatck -->
			    <option selected="selected">${name}</option>
			</s:if> 
			<s:else>
			<option >${name}</option>
			</s:else>
			</s:iterator>
			</select>
           </span>
         </td>
          <td align="left">
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
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">发货人</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">收货人</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">发货时间</div></th>
            <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物种类</div></th>
                    	<th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">转/发数量</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">收货数量</div></th>
         	<th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">当前余存</div></th>
         	<th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">撤销操作</div></th>
          </tr>
          <!-- 循环添加 -->
          <s:iterator value="Outs" status="sta" var="out">
			<tr style="height: 25px;">
			<td><div align='center' class='STYLE1'>${out.fname}</div></td>
			<td><div align='center' class='STYLE1'>${out.sname}</div></td>
			<td><div align='center' class='STYLE1'>${out.time}</div></td>
			<td><div align='center' class='STYLE1'>${out.gname}</div></td>
			<s:if test="#out.fid==#session.user.uid&&#out.uid!=1"><!-- 发货 -->
			<td><div align='center' class='STYLE1'>${out.count}<s:if test="#out.type==1">(发货)</s:if><s:else>(转货)</s:else> </div></td>
			<td><div align='center' class='STYLE1'>--</div></td>
			<td><div align='center' class='STYLE1'>${out.fkucun}</div></td><!-- 当前货物余存 -->
			</s:if>
			<s:else>								 <!-- 收货 -->					
			<td><div align='center' class='STYLE1'>--</div></td>
			<td><div align='center' class='STYLE1'>${out.count}<s:if test="#out.type==1">(发货)</s:if><s:else>(转货)</s:else> </div></td>
			<td><div align='center' class='STYLE1'>${out.skucun}</div></td><!-- 当前货物余存 -->
			</s:else>
			<s:if test="#out.fid==#session.user.uid">
			<td><div align='center' class='STYLE1'>
			<s:if test="#session.user.type==0">
			<a href="#" onclick="if(confirm('确认删除?')){location.href='deleteout?oid=${out.oid}'}">点击撤销</a>
			</s:if>
			<s:else>
				<a href="#" onclick="alert('撤销请联系管理员')">点击撤销</a>
			</s:else>
			</div>
			</td>
			</s:if>
			<s:else>
			<td><div align='center' class='STYLE1'>入库记录</div></td>
			</s:else>
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
            <s:else><s:if test="%{#request.st==''||#request.st==null}">共${count}条纪录，当前第${nowpage}/<span id="pctext"></span>页，每页最多15条纪录&nbsp&nbsp</s:if><s:else>${st}当天${gn}的库存记录</s:else>(本页统计:入库${incount}&nbsp出库${outcount})</s:else>
            </span>
           </td>
            <td width="50%" valign="top" class="STYLE1">
            <!-- 按时间查询的话不用分页 -->
            <s:if test="%{#request.st==''||#request.st==null}">
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
              </s:if>
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
