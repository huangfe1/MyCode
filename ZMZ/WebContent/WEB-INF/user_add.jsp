<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/userList.js"></script>
<script type="text/javascript" src="js/checkInput.js"></script>
</head>
<body>
	<div class="main_box">
		<h1>添加用户</h1>
		<form action="user_add"  id="myform" method="post">
		<ul>
			<li><span class="word_box">姓名：</span> <span class="text_box">
					<input value="${agent.userName}" type="text" class="text_sty"  id="name" name="agent.userName"/>
			</span> <span class="imp_box">*</span></li>
			<li><span class="word_box">电话号码：</span> <span class="text_box">
					<input value="${agent.agentPhone }" type="text" class="text_sty"  id="phone" name="agent.agentPhone"/>
			</span> <span class="imp_box">*</span></li>
			<li><span class="word_box">微信号：</span> <span class="text_box">
					<input value="${agent.agentWechat }" type="text" class="text_sty"  id="wechat" name="agent.agentWechat"/>
			</span> <span class="imp_box">*</span></li>
			<li><span class="word_box">身份证号：</span> <span class="text_box">
					<input value="${agent.agentIdcard }" type="text" class="text_sty"  id="idcard" name="agent.agentIdcard"/>
			</span> <span class="imp_box">*</span></li>
			<li><span class="word_box">汇款信息：</span> <span class="text_box">
					<input value="${agent.agentInfo }" type="text" class="text_sty"  id="info" name="agent.agentInfo"/>
			</span> <span class="imp_box">*</span></li>
				<li><span class="word_box">密码：</span> <span class="text_box">
					<input  type="password" class="text_sty"  id="paw" name="agent.userPassword"/>
			</span> <span class="imp_box">*</span></li>
			<li><span class="word_box">确认密码：</span> <span class="text_box">
					<input type="password" class="text_sty"  id="repaw" />
			</span> <span class="imp_box">*</span></li>
			<li><span class="word_box">供货代理：</span> <span class="text_box">
					<!-- 代理等级列表 -->
					<select class="select_sty min_one" id="agentslevel" >
						<option>我的代理</option>
						<option>输入编号</option>
					<!-- 	<option>普通客户</option> -->
					</select> 
					<!-- 供货代理的id-->
					<select class="select_sty min_two" name="agent.agentUpId" id="agents" >
						<s:iterator value="agents" status="sta" var="a">
							<option id="${a.agentLevel.levelName}"
								value="${a.userId}">(${a.userName})${a.agentCode}</option>
						</s:iterator>
				</select>
				<!-- 其他信息框 -->
						<input type="text" class="text_sty"  id="agentparam"  style="display: none;" />
			</span></li>
			<li><span class="word_box">用户级别：</span> <span class="text_box">
				<!--用户级别  -->
					<select name="agent.agentLevel.levelName" class="select_sty">
						<s:iterator value="levels" var="l">
						<s:if test="#session.agent!=null"><!-- 是代理 -->
						<!-- 只能增加下面的代理 -->
						<s:if test="#session.agent.agentLevel.levelId<=#l.levelId">
							<option value="${l.levelId}">${l.levelName}</option>
						</s:if>
						</s:if>
						<s:else><!-- 是管理员 -->
						<option value="${l.levelId}">${l.levelName}</option>
						</s:else> 
						</s:iterator>
				</select>
			</span></li>
			<li><span style="color:red"><strong>${msg }</strong> </span> </li>
			<li>
				<div class="btn_box">
					<input type="button" id="sub" class="btn_sty" onclick="checkEmpty(['name','phone','wechat','idcard','info','paw','repaw'],'myform')" value="提交" />
					 <input type="reset" class="btn_sty flo_rig" value="重置" />
				</div>
			</li>
		</ul>
		</form>
	</div>
</body>
</html>