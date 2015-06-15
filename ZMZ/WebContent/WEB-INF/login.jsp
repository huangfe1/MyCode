<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<link href="logincss/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="logincss/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
</head>
<body>
<div class="header">
 <h1 class="headerLogo"><a title="后台管理系统" target="_blank" href="${config.FRONT_URL }"><img 

alt="logo" src="${config.LOGO_URL }"></a></h1>
	<div class="headerNav">
		<a  href="${config.FRONT_URL }">${config.WEB_NAME }官网</a>
		<a target="_blank" href="consult.jsp">授权查询</a>
		<a target="_blank" href="consult.jsp">防伪查询</a>
		<s:if test="#parameters.pageType[0]==1">
			<a  href="index?pageType=0">代理商登陆</a>
			<s:set name="gn">公司</s:set>
		</s:if>
		<s:else>
			<a  href="index?pageType=1">公司登陆</a>
			<s:set name="gn">代理</s:set>
		</s:else>
	</div>
</div>

<div class="banner">
<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   
    <form method="post" action="user_login?pageType=${param.pageType}" id="LF">
   <div class="fm-item">
	   <label for="logonId" class="form-label">${gn }账号：</label>
	   <input type="text" placeholder="输入账号" maxlength="100" name="code" id="username" 

class="i-text">    
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label">${gn }密码：</label>
	   <input type="password" name="paw" placeholder="输入密码" maxlength="100" 

id="password" class="i-text" >    
       <div class="ui-form-explain"></div>
  </div>
  
  <div  class="fm-item pos-r">
	   <label for="logonId" class="form-label">${msg}</label>

  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label"></label>
	   <input type="submit" value="" tabindex="4" id="send-btn" class="btn-login"> 
       <div class="ui-form-explain"></div>
  </div>
  
  </form>
  
  </div>

</div>

	<div class="bd">
		<ul>
			<li style="background:url('themes/theme-pic1.jpg') #CCE1F3 center 0 no-repeat;"><a target="_blank" href="${config.FRONT_URL}"></a></li>
			<li style="background: url('themes/theme-pic2.jpg') #BCE0FF center 0 no-repeat; "><a target="_blank" href="${config.FRONT_URL}"></a></li>
		</ul>
	</div>

	<div class="hd"><ul></ul></div>
</div>

<div class="banner-shadow"></div>
</body>
</html>