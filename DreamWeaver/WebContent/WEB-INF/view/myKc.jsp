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
         &nbsp;货&nbsp;物&nbsp;余&nbsp;存<s:if test="msg!=null">(${msg})</s:if>
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
         </td>
          <td align="center">
              <span class="STYLE1">
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
           <s:if test="#session.user.type==0"><!-- 公司用户 -->
          	<th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物种类</div></th>
           	  <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">入库总量</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">公司余存</div></th>
                 <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">市场余存</div></th>
                   <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">发货总量</div></th>
                        <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">库房余存</div></th>
           </s:if>
          <s:else>
          	  <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">货物种类</div></th>
           <th  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE1">我的余存</div></th>
          </s:else>
          </tr>
            <s:if test="#session.user.type==0"><!-- 公司用户 -->
              <s:iterator value="kfs" status="sta" var="kf">
             <tr style="height: 25px;background:#ffffff ;">
			<td><div align='center' class='style1'>${kf.gname}</div></td> 
			<td><div align='center' class='STYLE1'>${kf.allcount}</div></td>
			<td><div align='center' class='STYLE1'>${kf.gscount}</div></td>
			<td><div align='center' class='STYLE1'>${kf.dlcount}</div></td>
			<td><div align='center' class='STYLE1'>${kf.fscount}</div></td>
			<td><div align='center' class='STYLE1'>${kf.nowcount}</div></td>
			</tr>
               </s:iterator>
            </s:if>
            <s:else>
          <s:iterator value="kc.gnames" status="sta" >
			<tr style="height: 25px;background:#ffffff ;">
			<td><div align='center' class='STYLE1'><s:property value="key"/></div></td>
			<td><div align='center' class='STYLE1'><s:property value="value"/></div></td>
			</tr>
          </s:iterator>
          </s:else>
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
            <s:if test="#session.user.type==1">
            <s:if test="kc==null">没有余存</s:if>
            </s:if>
            </span>
           </td>
            <td width="50%" valign="top" class="STYLE1">
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
