<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/table.js" > </script>
<script type="text/javascript" src="js/time.js" > </script>
<script> 
$(document).ready(function(){	
	var sum=${sum}//总记录数
	var lvMsg=$("#lvMsg").val();//代理信息
    var pc=Math.ceil(sum/20);//总页数
    $("#pctext").html(pc+"");//显示总页数
    var cp=${currentPage};//当前页
	var action="user_list_alljsp?sum="+sum+"&&lvMsg="+lvMsg;//请求地址
	//自定义刷选条件
    $("#pbt").click(function(){//其他参数
    	var param=$("#param").val();//其它参数
    	if(param==""){
    		alert("亲,您没有填写任何东西");
    	}else{
    		action+="&&param="+param;
    		location.href=action;
    	}
    });
    $("#param").keydown(function(e){
    	if(e.keyCode=="13"){
    		var param=$("#param").val();//其它参数
        	if(param==""){
        		alert("亲,您没有填写任何东西");
        	}else{
        		action+="&&param="+param;
        		location.href=action;
        	}
    	}
    	});
	$("#ltbt").click(function(){//时间等级
		var stime=$("#stime").val();//时间
		var slevelId=$("#slevelId").val();//等级id
			action+="&&stime="+stime+"&&slevelId="+slevelId;
			location.href=action;
		}
	});
	
	  //首页,前进,后退
	function a(a){
		if(a=='f'){//首页
			location.href=action+"&&currentPage=0";	
		}else if(a=='b'){//前一页
			if(cp==1){//如果是第一页
				alert("亲,已经是第一页了");
			}else{
		cp=cp-2;
		location.href=action+"&&currentPage="+cp;			
			}
		}else if(a=='n'){//下一页
		if(cp==pc){
			alert("亲,已经是最后一页了");
		}else{
			location.href=action+"&&currentPage="+cp;				
		}	
		}else if(a=='l'){//最后一页
			cp=pc-1;
			location.href=action+"&&currentPage="+cp;			
		}
		}	
	//翻页按钮设置监听
	$("#f").click(function(){
		a($(this).attr('id'));
	});
	$("#b").click(function(){
		a($(this).attr('id'));
	});
	$("#n").click(function(){
		a($(this).attr('id'));
	});
	$("#l").click(function(){
		a($(this).attr('id'));
	});
	//转到多少页
	$("#npbt").click(function(){
		var nptext=parseInt($("#nptext").val());
		if(nptext<=0||nptext>pc||isNaN(nptext)){
			alert("输入错误");
		}else{
			cp=nptext-1;
		    location.href=action+"&&currentPage="+cp;	
		}
	}	);
});
</script>
</head>

<body>
<input type="hidden" id="lvMsg" value="${lvMsg}" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="tabimages/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="tabimages/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="tabimages/tb.gif" width="16" height="16" /></div></td>
                <td width="40%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[用户管理]-[所有用户]</td>
                <td width="55% " class="STYLE1"><div align="center">${lvMsg }</div></td>
              </tr>
            </table></td>
          <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
              <!-- 普通信息搜索 -->
             <td width="60"><input id="param" Placeholder="编码/姓名/微信/电话/身份证" size="15"   type="text"  /></td>
             <td width="60"><input id="pbt"  type="button" value="查询" /></td>
             <td width="60"></td>
               <!-- 时间等级搜索 -->
               <td width="60"><input id="stime" value="${stime}" Placeholder="时间" size="10"   type="text"   /></td>
               <td width="30"></td>
                <td width="60">
                <!-- 等级搜索 -->
                <select id="slevelId">
                <option value="-1">所有等级</option>
                <s:iterator value="levels" var="l">
                <s:if test="slevelId==#l.levelId">
                	 <option selected="selected" value="${l.levelId}">${l.levelName}</option>
                </s:if>
                <s:else>
                	<option value="${l.levelId}">${l.levelName}${slevelId}</option>
                </s:else>
				</s:iterator>
                </select> 
                </td>
              <td width="60"><input id="ltbt"  type="button" value="查询" /></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="tabimages/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="tabimages/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
				<td   background="tabimages/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">代理编号</span></div></td>
				<td   background="tabimages/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">代理姓名</span></div></td>
				<td  background="tabimages/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">手机号码</span></div></td>
				<td  background="tabimages/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">微信账号</span></div></td>
				<td  background="tabimages/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">身份证号</span></div></td>
				<td  background="tabimages/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">登陆密码</span></div></td>
				<td background="tabimages/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">代理等级</span></div></td>
				<td  background="tabimages/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">申请时间</span></div></td>
				<td  background="tabimages/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">备注</span></div></td>
				<td  background="tabimages/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">激活状态</span></div></td>
				<td   background="tabimages/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>
          </tr>
            <s:iterator value="agents" var="agent">
             <tr>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${agentCode }</span></div></td>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${userName }</span></div></td>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${agentPhone }</span></div></td>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${agentWechat }</span></div></td>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${agentIdcard}</span></div></td>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${userPassword }</span></div></td>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${agentLevel.levelName }</span></div></td>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${agentTime}</span></div></td>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${agentUpName}</span></div></td>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">
			<s:if test="#agent.userStatus==0"><a href="user_activity?code=${agentCode}">点击激活</a> </s:if>
			<s:else><a href="zsimage.jsp?code=${agentCode}">查看证书</a></s:else>
			</span></div></td>
			<td  bgcolor="#FFFFFF"><div align="center"><span class="STYLE4"><img src="tabimages/edt.gif" width="16" height="16" />编辑&nbsp; &nbsp;<img src="tabimages/del.gif" width="16" height="16" />删除</span></div></td>
          </tr>
   			</s:iterator>
        </table></td>
        <td width="8" background="tabimages/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="tabimages/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="tabimages/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">
               &nbsp;&nbsp;
              <s:if test="sum==0">没有相关记录</s:if>
              <s:else>共有 ${sum} 条记录,当前第${currentPage}/<span id="pctext"></span>页，每页最多20条纪录</s:else>
            </td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40"><img id="f" src="tabimages/first.gif" width="37" height="15" /></td>
                  <td width="45"><img id="b" src="tabimages/back.gif" width="43" height="15" /></td>
                  <td width="45"><img id="n" src="tabimages/next.gif" width="43" height="15" /></td>
                  <td width="40"><img id="l" src="tabimages/last.gif" width="37" height="15" /></td>
                  <td width="100"><div align="center"><span class="STYLE1">转到第
                    <input id="nptext" name="textfield" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 
                    页 </span></div></td>
                  <td width="40"><img id="npbt" src="tabimages/go.gif" width="37" height="15" /></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="tabimages/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
