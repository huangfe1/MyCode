<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
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
	overflow:hidden;
}
-->
</style>
<script>
var isOpen=true;
function switchSysBar(){ 
var locate=location.href.replace('center.html','');//取得当前地址,并且去掉center.html
//var ssrc=document.all("img1").src.replace(locate,'');//去掉网页前缀,获得照片相对地址
/*if (ssrc=="images/main_18.gif")
{ 
document.all("img1").src="images/main_18_1.gif";
document.all("frmTitle").style.display="none" 
} 
else
{ 
document.all("img1").src="images/main_18.gif";
document.all("frmTitle").style.display="" 
} */
if(isOpen){
isOpen=false;
//document.all("img1").src="images/main_18_1.gif";
document.all("frmTitle").style.display="none" 
}else{
isOpen=true;
//document.all("img1").src="images/main_18.gif";
document.all("frmTitle").style.display="" 
}
} 

</script>

</head>

<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="7" bgcolor="#353c44"></td>
    <td width="147" id="frmTitle" valign="top"><iframe name="I1" height="100%" width="100%" border="0" frameborder="0" src="leftjsp"></iframe></td>
    <td width="10"  bgcolor="#add2da" onclick="switchSysBar()">&nbsp;</td>
    <td valign="top"><iframe name="I2" height="100%" width="100%" border="0" frameborder="0" src="hy.jsp"></iframe></td>
    <td width="8" bgcolor="#353c44"></td>
  </tr>
</table>
</body>
</html>
