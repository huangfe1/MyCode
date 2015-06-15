<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编号录入</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
	<div class="code_box">
		<h1>编号录入</h1>
		<form action="" method="post" >
		<table>
			<tr>
				<td>头编号：</td>
				<td>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<b></b>
					<b></b>
					<b></b>
					<b></b>
					<b></b>
					<b></b>
					<b></b>
					<b></b>
					<b></b>
					<b></b>
					<b></b>
					<b></b>
				</td>
			</tr>
			<tr>
				<td>尾编号：</td>
				<td>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
					<input type="text" class="text_sty"/>
				</td>
			</tr>
		</table>
		<div class="main_box no_mar">
			<ul>
				<li>
					<span class="word_box">商品名：</span>
					<span class="text_box">
						<select class="select_sty">
							<option value="gaofei">gaofei</option>
	         	     		<option value="筑美生态养护贴">筑美生态养护贴</option>
						</select>
					</span>
				</li>
				<li>
					<span class="word_box">指定代理：</span>
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
					<div class="btn_box">
						<input type="submit" class="btn_sty" value="提交"/>
						<input type="submit" class="btn_sty flo_rig" value="重置"/>
					</div>
				</li>
			</ul>
		</div>
		</form>
	</div>
</body>
</html>