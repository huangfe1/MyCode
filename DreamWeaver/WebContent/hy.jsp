<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>This is my heart</title>

<style type="text/css">
@font-face {
	font-family: digit;
	src: url('digital-7_mono.ttf') format("truetype");
}
</style>

<link href="hycss/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="hyjs/jquery.js"></script>
<script type="text/javascript" src="hyjs/garden.js"></script>
<script type="text/javascript" src="hyjs/functions.js"></script>
</head>
<body>
<audio src="image/bg.mp3" loop="true" autoplay="true" style="display: none"></audio>
<div id="mainDiv" >
	<div id="content" >
		<div id="code">
			<span class="comments">/**</span><br />
			<span class="space"/><span class="comments">*2015—4-1,</span><br />
			<!--<span class="space"/><span class="comments">*2013-02-28.</span><br />-->
			<span class="space"/><span class="comments">*/</span><br />
			<!--My name = <span class="keyword">ZMZ</span><br />-->
			<span class="keyword">筑梦者致代理商:</span>
	    	<!--Girl name = <span class="keyword">Z</span> mm<br />-->
			<br /><br />
			<span class="comments">//不久前,筑美就像一个孩子,走进各位的世界. </span><br /><br />
			<!--The girl loved the boy;--> Long time ago,Zmz just like a children coming to you.<br /><br />
			<span class="comments">//有时候,做的不够完美,因为它还年经.</span><br /><br />
			<!--The boy can not be separated the girl;-->
			Zmz not do well sometimes because of youngth<br /><br />
			<span class="comments">// 还好,有你们给予它无限的包容和无私的呵护.</span><br /><br />
			<!--The girl can not be separated the boy;-->
			thanks for your caring<br /><br />
			<span class="comments"><!--// Both wind and snow all over the sky.-->//筑美在成长,就有如大家见证的一样</span><br /><br />
			<span class="keyword">Zmz</span> is <span class="keyword">growing in eyes of you</span>;<br /><br />
			<!--<span class="keyword">The girl</span> is also very <span class="keyword">happy</span>;<br />-->
			<span class="placeholder"/><span class="comments">//Tz曾说过,其实你只要等着就好,顺其自然！急之必反之..</span><br /><br />
			<span class="placeholder"/> A gril said to me you just need wait,everything will be ok or you will lose it<br /><br />
			<span class="comments">//感谢一路走来大家的关爱,渐渐的开始回馈大家..</span><br /><br />
			<br>
			<br>
			<!--Baby, I love you forever;-->
			<b>筑梦者携公司全体对您再次表示衷心的感谢!</b>
			<br />
		</div>
		<div id="loveHeart">
			<canvas id="garden"></canvas>
			<div id="words">
				<div id="messages">
					<!--亲爱的，这是我们相爱在一起的时光。-->
					筑美与您一起
				</div>
				<div id="loveu">
				 筑建美好生活！<br/>
					<div class="signature">--------------Writted By Zmz</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
var offsetX = $("#loveHeart").width() / 2;
var offsetY = $("#loveHeart").height() / 2 - 55;
var together = new Date();
together.setFullYear(2014, 3, 15);
together.setHours(20);
together.setMinutes(0);
together.setSeconds(0);
together.setMilliseconds(0);

if (!document.createElement('canvas').getContext) {
	var msg = document.createElement("div");
	msg.id = "errorMsg";
	msg.innerHTML = "Your browser doesn't support HTML5!<br/>Recommend use Chrome 14+/IE 9+/Firefox 7+/Safari 4+"; 
	document.body.appendChild(msg);
	$("#code").css("display", "none")
	$("#copyright").css("position", "absolute");
	$("#copyright").css("bottom", "10px");
	document.execCommand("stop");
} else {
	setTimeout(function () {
		startHeartAnimation();
	}, 5000);

	//timeElapse(together);
	setInterval(function () {
		//timeElapse(together);
	}, 500);

	adjustCodePosition();
	$("#code").typewriter();
}
</script>
<div style="text-align:center;clear:both">
<p></p>
</div>
</body>
</html>