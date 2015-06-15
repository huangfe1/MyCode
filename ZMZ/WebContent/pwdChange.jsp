<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
	<div class="main_box">
		<h1>修改密码</h1>
		<form action="" method="post" id="form">
		<ul>
			<li>
				<span class="word_box">旧密码：</span>
				<span class="text_box">
					<input type="text" class="text_sty" name="oldPassword"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<span class="word_box">新密码：</span>
				<span class="text_box">
					<input type="text" class="text_sty" name="newPassword"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<span class="word_box">确认密码：</span>
				<span class="text_box">
					<input type="text" class="text_sty" name="surePassword"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<div class="btn_box">
					<input type="button" class="btn_sty" value="提交"/>
					<input type="submit" class="btn_sty flo_rig" value="重置"/>
				</div>
			</li>
		</ul>
		</form>
	</div>
</body>
</html>