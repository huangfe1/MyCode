<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
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
	color: #FFFFFF;
}
.STYLE3 {
	font-family: "Arial","Microsoft YaHei","黑体","宋体",sans-serif;
}
-->
</style>
<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #ffffff; POSITION: relative; TOP: 2px 
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #FFCC00; POSITION: relative; TOP: 2px
}

</style>
<script>
//跳转页面
function t(path){
	var r = Math.random();
	//跳转页面
	window.parent.frames[1].location.href=path+"noCache="+r;
}
var he=document.body.clientHeight-105
document.write("<div id=tt style=height:"+he+";overflow:hidden>");
</script>

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
								<s:if test="#session.user.type!=0&&#session.user.type!=1">
											<!--管理员权限-->
  <tr>
    <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="image/main_47.gif" id="imgmenu1" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(1)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="18%">&nbsp;</td>
                <td width="82%" class="STYLE1">管理员权限</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td background="image/main_51.gif" id="submenu1">
			 <div class="sec_menu" >  
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
           
				  <!--编号录入-->
                  <tr>
                    <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="enterGoodsjsp" target="I2"><span class="STYLE3">编号录入</span></a></td>
                        </tr>
                    </table></td>
                  </tr>
                  <!--录入记录-->
					   <tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="#" onclick="t('mygoods?type=1&')"><span class="STYLE3">录入记录</span></a></td>
                              </tr>
                          </table></td>
                        </tr>
                  <!-- 所有用户 -->
					<tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="#" onclick="t('checkAllUser?')" ><span class="STYLE3">所有用户</span></a></td>
                              </tr>
                          </table></td>
					   </tr>
                        
					
				  <!--结束-->
                </table></td>
              </tr>
              <tr>
                <td height="5"><img src="image/main_52.gif" width="151" height="5" /></td>
              </tr>
            </table></div></td>
          </tr>
        </table></td>
      </tr>
								</s:if>
	<s:else>				
									<!--交易管理-->
  <tr>
    <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="image/main_47.gif" id="imgmenu1" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(1)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="18%">&nbsp;</td>
                <td width="82%" class="STYLE1">交易管理</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td background="image/main_51.gif" id="submenu1">
			 <div class="sec_menu" >  
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <!--货物入库-->
			  <tr>
                <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
               
                 <s:if test="#session.user.type==0"> 
                  <tr>
                    <td width="16%" height="25"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                    <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                         <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="addGoodsjsp" target="I2"><span class="STYLE3">货物入库</span></a></td>	  
                        </tr>
                    </table></td>
                  </tr>
			</s:if>
				  
				  <!--货物转出-->
                  <tr>
                    <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="outGoodsjsp" target="I2"><span class="STYLE3">货物转出</span></a></span></td>
                        </tr>
                    </table></td>
                  </tr>
				  
				  <!--申请发货-->
                  <tr>
                    <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="applyGoodsjsp" target="I2"><span class="STYLE3">申请发货</span></a></span></td>
                        </tr>
                    </table></td>
                  </tr>

				  <!--编号录入-->
                  <tr>
                    <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="enterGoodsjsp" target="I2"><span class="STYLE3">编号录入</span></a></td>
                        </tr>
                    </table></td>
                  </tr>
			  <!--代理申请--> <!-- 代理没有下级申请 -->
		       <s:if test="#session.user.type==0"> 
						<tr>
                          <td width="16%" height="25"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="#" onclick="t('myapply?type=1&')" ><span class="STYLE3">代理申请</span></a></td>
                              </tr>
                          </table></td>
                        </tr>
                        </s:if>
                        <!--发货明细-->
						<tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="#" onclick="t('myapply?type=0&')" ><span class="STYLE3">发货明细</span></a></span></td>
                              </tr>
                          </table></td>
                        </tr>
						<!--转货明细-->
					   <tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="myout" target="I2"><span class="STYLE3">转货明细</span></a></span></td>
                              </tr>
                          </table></td>
                        </tr>
				  <!--结束-->
                </table></td>
              </tr>
              <tr>
                <td height="5"><img src="image/main_52.gif" width="151" height="5" /></td>
              </tr>
            </table></div></td>
          </tr>
        </table></td>
      </tr>
	  <!--库存管理-->
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="image/main_47.gif" id="imgmenu2" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(2)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">库存管理</td>
                </tr>
            </table></td>
          </tr>
		
          <tr>
            <td background="image/main_51.gif" id="submenu2"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
				 <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                       
						   <!--我的库存-->
				 <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a  href="#" onclick="t('mykc?type=3&')"><span class="STYLE3">我的库存</span></a></td>
                              </tr>
                          </table></td>
                        </tr>
						
                        <!--我的编号-->
						<tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a  href="#" onclick="t('mygoods?type=0&')"><span class="STYLE3">货物编号</span></a></span></td>
                              </tr>
                          </table></td>
                        </tr>
						<!--录入记录-->
					   <tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="#" onclick="t('mygoods?type=1&')"><span class="STYLE3">录入记录</span></a></td>
                              </tr>
                          </table></td>
                        </tr>
					   <!--
					   <tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">网站维护</span></td>
                              </tr>
                          </table></td>
                        </tr>	
                     -->
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"><img src="image/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table>          </td>
      </tr>
	  <!--产品管理 -->
	  <!-- 公司用户 -->
		 <s:if test="#session.user.type==0">
    <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="image/main_47.gif" id="imgmenu4" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(4)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">产品管理</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td background="image/main_51.gif"  id="submenu4"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
					<!--查看类型-->
				 <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="#" onclick="t('conName!check?')" ><span class="STYLE3">查看类型</span></a></td>
                              </tr>
                          </table></td>
                        </tr>
						
                        <!--增加类型-->
						<tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="addNamesjsp" target="I2"><span class="STYLE3">增加类型</span></a></span></td>
                              </tr>
                          </table></td>
                        </tr>
						<!--
                        <tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3">网站维护</span></td>
                              </tr>
                          </table></td>
                        </tr>
						-->
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"><img src="image/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table>          </td>
      </tr>
	  </s:if>
	  <!--用户管理-->
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="image/main_47.gif" id="imgmenu3" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(3)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;</td>
                  <td width="82%" class="STYLE1">用户管理</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td background="image/main_51.gif" id="submenu3" ><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <!--市场管理-->
						<tr>
                          <td width="16%" height="25"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="#" onclick="t('checklevel?')" ><span class="STYLE3">市场管理</span></a></td>
                              </tr>
                          </table></td>
                        </tr>
                         <!--市场余存-->
						<tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="#" onclick="t('checkkc?')" ><span class="STYLE3">市场余存</span></a></td>
                              </tr>
                          </table></td>
                        </tr>
                        <!--我的用户-->
						<tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="#" onclick="t('checkUser?')"><span class="STYLE3">我的用户</span></a></td>
                              </tr>
                          </table></td>
                        </tr>

                        <!--所有用户-->
						<!-- 公司用户 -->
						<s:if test="#session.user.type==0">
						<tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="#" onclick="t('checkAllUser?')" ><span class="STYLE3">所有用户</span></a></td>
                              </tr>
                          </table></td>
					   </tr>
					   </s:if>
					          <!--增加用户-->
						<tr>
                          <td height="23"><div align="center"><img src="image/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><a href="addUserjsp" target="I2"><span class="STYLE3">增加用户</span></a></td>
                              </tr>
                          </table></td>
					   </tr>
					   <!--结束-->
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"><img src="image/main_52.gif" width="151" height="5" /></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table></td>
      </tr> 
      </s:else>		
      <!-- 结束 -->
      
      
    </table></td>
  </tr>

  <tr>
    <td height="18" background="image/main1_58.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="18" valign="bottom"><div align="center" class="STYLE3">版本:心伤之痕</div></td>
      </tr>
    </table></td>
  </tr>
</table>
<script>




function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
imgmenu = eval("imgmenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
imgmenu.background="image/main_47.gif";
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
imgmenu.background="image/main_48.gif";
}
}

</script>