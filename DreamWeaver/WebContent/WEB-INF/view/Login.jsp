<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<link href="css/logincss/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="css/logincss/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
 <script type="text/javascript">  
        function myReload(){  
            document.getElementById("createCheckCode").src=document.getElementById("createCheckCode").src + "?nocache="+new Date().getTime();  
        }  
    </script>  
</head>
<body>
<%session.removeAttribute("user"); %>
<div class="header">
<div class="logo"></div>
<div id="headerNav">
<ul class="menu">
<li><a href="Search.jsp?pt=0">防伪查询</a></li>
<li><a href="Search.jsp?pt=1">授权查询</a></li>
<li><a href="http://huangfei.gotoip55.com/alcatron/">筑美官网</a></li>
</ul></div>
</div>
<div class="banner">
<div class="login-aside">
 <div class="login">
      <h1 >后台登录</h1>
      <form method="post" action="login">
        <p><input type="text" name="code" value="" placeholder="编号"></p>
      <p><input type="password" name="password" value="" placeholder="密码"></p>
         <p>
         <input   type="text"  style="width: 20% ;margin-top: 0px" name="yzm" value="" placeholder="验证码">
       	 <img  id="createCheckCode" src="yzm" align="top"    src="yzm" />   <a href="#" onclick="myReload()"><span style="color:white"> 看不清换一张</span></a>
         </p>
        <p class="remember_me">
          <label>
       <!--      <input type="checkbox" name="remember_me" id="remember_me"> -->
       			<s:if test="#msg==null">
           		<span id="welcomeInfo"  style="color:white ">欢迎使用筑美后台管理系统!</span>
       			</s:if>
       			<s:else>
       			<span id="wrongInfo" style="color:white ">${msg}</span>
       			</s:else>
          </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="登录"></p>
      </form>
    </div>
    </div>
	<div class="bd">
		<ul>
			<li style="background:url('themes/theme-pic1.jpg') #CCE1F3 center 0 no-repeat;"><a target="_blank" href="http://huangfei.gotoip55.com/alcatron/"></a></li>
			<li style="background: url('themes/theme-pic2.jpg') #BCE0FF center 0 no-repeat; "><a target="_blank" href="http://huangfei.gotoip55.com/alcatron/"></a></li>
		</ul>
	</div>

	<div class="hd"><ul></ul></div>
</div>

<div class="banner-shadow"></div>
</body>
</html>