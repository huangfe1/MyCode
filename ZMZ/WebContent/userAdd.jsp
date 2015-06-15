<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
	<div class="main_box">
		<h1>添加用户</h1>
		<form action="" method="post" id="form">
		<ul>
			<li>
				<span class="word_box">姓名：</span>
				<span class="text_box">
					<input type="text" class="text_sty" name="agentName"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<span class="word_box">电话号码：</span>
				<span class="text_box">
					<input type="text" class="text_sty" name="agentPhone"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<span class="word_box">微信号：</span>
				<span class="text_box">
					<input type="text" class="text_sty" name="agentWechat"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<span class="word_box">密码：</span>
				<span class="text_box">
					<input type="password" class="text_sty" name="agentPassword"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<span class="word_box">确认密码：</span>
				<span class="text_box">
					<input type="password" class="text_sty" name="surePassword"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<span class="word_box">身份证号：</span>
				<span class="text_box">
					<input type="text" class="text_sty" name="agentIdcard"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<span class="word_box">汇款信息：</span>
				<span class="text_box">
					<input type="text" class="text_sty" name="agentInfo"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<span class="word_box">供货代理：</span>
				<span class="text_box">
					<select class="select_sty min_one">
						<option>所有代理</option>
					</select>
					<select class="select_sty min_two">
						<option>zmz12345</option>
					</select>
				</span>
			</li>
			<li>
				<span class="word_box">用户级别：</span>
				<span class="text_box">
					<select class="select_sty">
						<option value="gaofei">gaofei</option>
	         	     	<option value="筑美生态养护贴">筑美生态养护贴</option>
					</select>
				</span>
			</li>
			<li>
				<div class="btn_box">
					<input type="button" class="btn_sty" onclick="userAddClick()" value="提交"/>
					<input type="submit" class="btn_sty flo_rig" value="重置"/>
				</div>
			</li>
		</ul>
		</form>
	</div>
</body>
</html>