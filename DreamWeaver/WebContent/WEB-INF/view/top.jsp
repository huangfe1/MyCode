<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #000000;
}
.STYLE5 {font-size: 12}
.STYLE7 {font-size: 12px; color: #FFFFFF; }
-->
</style>
<script type="text/javascript">
//刷新
function refresh(){
window.top.location.href="mainjsp";
}
//前进后退
function bf(v){
history.go(v);
}
//获取当前时间
 function CurentTime()
    { 
        var now = new Date();
       
        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate();            //日
       
        var hh = now.getHours();            //时
        var mm = now.getMinutes();          //分

        var week=now.getDay();
       
        var clock = year + "-";
       switch(week)
       {
         case 0: week = "星期日"; break;
         case 1: week = "星期一"; break;
         case 2: week = "星期二"; break;
         case 3: week = "星期三"; break;
         case 4: week = "星期四"; break;
         case 5: week = "星期五"; break;
         case 6: week = "星期六"; break;
        }
        if(month < 10)
            clock += "0";
       
        clock += month + "-";
       
        if(day < 10)
            clock += "0";
           
        clock += day + " ";

        clock += week + " ";
       
        if(hh < 10)
            clock += "0";
           
        clock += hh + ":";
        if (mm < 10) clock += '0'; 
        clock += mm; 
        document.write(clock); 
    } 
	</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="57" background="image/main_03.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="378" height="57" background="image/main_01.gif">&nbsp;</td>
        <td>&nbsp;</td>
        <td width="281" valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="33" height="27"><img src="image/main_05.gif" width="33" height="27" /></td>
            <td width="248" background="image/main_06.gif"><table width="225" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="17"><div align="right"><a href="changePawjsp" target="I2"><img src="image/pass.gif" width="69" height="17" /></a></div></td>
                <td><div align="right"><a href="pcImage.jsp?code=${session.user.code}" target="I2"><img src="image/user.gif" width="69" height="17" /></a></div></td>
                <td><div align="right"><a href="LogOut" target="_top" ><img src="image/quit.gif" width="69" height="17" /></a></div></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="40" background="image/main_10.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="194" height="40" background="image/main_07.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="21"><img src="image/main_13.gif" width="19" height="14" /></td>
            <td width="35" class="STYLE7"><div align="center"><a target="top" href="http://huangfei.gotoip55.com/alcatron/"><span style="color:white">首页</sapn></a></div></td>
            <td width="21" class="STYLE7"><img src="image/main_15.gif" width="19" height="14" /></td>
            <td width="35" class="STYLE7"><div align="center"><a href="#" onclick="bf(-1)"><span style="color:white">后退</sapn></a></div></td>
            <td width="21" class="STYLE7"><img src="image/main_17.gif" width="19" height="14" /></td>
            <td width="35" class="STYLE7"><div align="center"><a href="#" onclick="bf(1)"><span style="color:white">前进</sapn></a></div></td>
            <td width="21" class="STYLE7"><img src="image/main_19.gif" width="19" height="14" /></td>
            <td width="35" class="STYLE7"><div align="center"><a href="#" onclick="refresh()"><span style="color:white">刷新</sapn></a></div></td>
            <td width="21" class="STYLE7"><img src="image/main_21.gif" width="19" height="14" /></td>
            <td width="35" class="STYLE7"><div align="center">帮助</div></td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td width="248" background="image/main_11.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="16%"><span class="STYLE5"></span></td>
            <td width="75%"><div align="center"><span class="STYLE7">时间：<script type="text/javascript">CurentTime()</script></span></div></td>
            <td width="9%">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="30" background="image/main_31.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" height="30"><img src="image/main_28.gif" width="8" height="30" /></td>
        <td width="147" background="image/main_29.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="24%">&nbsp;</td>
            <td width="43%" height="20" valign="bottom" class="STYLE1">管理菜单</td>
            <td width="33%">&nbsp;</td>
          </tr>
        </table></td>
        <td width="39"><img src="image/main_30.gif" width="39" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="20" valign="bottom"><span class="STYLE1">当前登录用户：${sessionScope.user.username} &nbsp;用户角色：${sessionScope.user.level }</span></td>
            <!--<td valign="bottom" class="STYLE1"><div align="right"><img src="image/sj.gif" width="6" height="7" /> IP：192.168.0.11       &nbsp; &nbsp;&nbsp;<img src="image/sj.gif" width="6" height="7" /> &nbsp;提供商：中国深圳 &nbsp; &nbsp; <img src="image/sj.gif" width="6" height="7" /> &nbsp;单位：深圳某单位</div></td>-->
          </tr>
        </table></td>
        <td width="17"><img src="image/main_32.gif" width="17" height="30" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
