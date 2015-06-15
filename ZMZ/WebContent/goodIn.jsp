<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货物入库</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/verify.js"></script>
<script type="text/javascript" src="js/btn.click.js"></script>
</head>
<body>
	<div class="main_box">
		<h1>货物入库</h1>
		<form action="" method = "post" id="form">
		<ul>
			<li><span class="word_box">商品名：</span>
				<span class="text_box">
					<select class="select_sty" name="storGoodsName">
						<option value="gaofei">gaofei</option>
	         	     	<option value="筑美生态养护贴">筑美生态养护贴</option>
					</select>
				</span>
			</li>
			<li>
				<span class="word_box">商品数量：</span>
				<span class="text_box">
					<input type="text" class="text_sty" name="storNum" id="goodsNum"/>
				</span>
				<span class="imp_box">*</span>
			</li>
			<li>
				<div class="btn_box">
					<input type="button" class="btn_sty" onclick="goodInClick()" value="提交"/>
					<input type="submit" class="btn_sty flo_rig" value="重置"/>
				</div>
			</li>
		</ul>
		</form>
	</div>
</body>
</html>