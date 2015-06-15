var  highlightcolor='#d5f4fe';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
function checkAll (check) {
	// body...
	var checkAll = document.getElementsByName("checkbox1");
	
	
    if(check==true){
            for (var i = 0; i < checkAll.length; i++) {
            	checkAll[i].checked = 1;
            }
    }else{
    	for (var i = 0; i < checkAll.length; i++) {
    		checkAll[i].checked = 0;
    	}
    }
}
function adduser () {
	for (var i = 0; i < 5; i++) {
   var tr1=document.getElementById('userinformation').insertRow();
   var c0=tr1.insertCell(0);
   var c1=tr1.insertCell(1);
   var c2=tr1.insertCell(2);
   var c3=tr1.insertCell(3);
   var c4=tr1.insertCell(4);
   var c5=tr1.insertCell(5);
   var c6=tr1.insertCell(6);
   tr1.style.height="25px";
   tr1.style.background="#ffffff";
    c0.innerHTML="<div align='center' class='STYLE1'><input name='checkbox1' type='checkbox'  value='checkbox' id='checkbox1'/></div>";
    c1.innerHTML="<div align='center' class='STYLE1'>A001</div>";
    c2.innerHTML="<div align='center' class='STYLE1'>天天代理员</div>";
    c3.innerHTML="<div align='center' class='STYLE1'>123</div>";
    c4.innerHTML="<div align='center' class='STYLE1'>代理用户</div>";  
    c5.innerHTML="<div align='center' class='STYLE1'><img src='../../images/037.gif' width='9' height='9' /><a href='#' class='STYLE2'>编辑</a></div>";
    c6.innerHTML="<div align='center' class='STYLE1'><img src='../../images/010.gif' width='9' height='9' /> <a href='#' class='STYLE2'>删除</a></div>";
   };
}
function addfoods () {
	for (var i = 0; i < 5; i++) {

   var tr1=document.getElementById('foodsInf').insertRow();
   var c0=tr1.insertCell(0);
   var c1=tr1.insertCell(1);
   var c2=tr1.insertCell(2);
   var c3=tr1.insertCell(3);
   var c4=tr1.insertCell(4);
   var c5=tr1.insertCell(5);
   var c6=tr1.insertCell(6);
   var c7=tr1.insertCell(7);
   var c8=tr1.insertCell(8);
   var c9=tr1.insertCell(9);
   var c10=tr1.insertCell(10);
   tr1.style.height="25px";
   tr1.style.background="#ffffff";
   c0.innerHTML="<div align='center' class='STYLE1'><input name='checkbox1' type='checkbox'  value='checkbox'/></div>";
   c1.innerHTML="<div align='center' class='STYLE1'>A007</div>";
   c2.innerHTML="<div align='center' class='STYLE1'>男士护肤品</div>";
   c3.innerHTML="<div align='center' class='STYLE1'>2014-11-18</div>";
   c4.innerHTML="<div align='center' class='STYLE1'>湖南省</div>";
   c5.innerHTML="<div align='center' class='STYLE1'>长沙市</div>";
   c6.innerHTML="<div align='center' class='STYLE1'>岳麓区</div>";
   c7.innerHTML="<div align='center' ><a href='#'' class='STYLE2'>天天公司</a></div>";
   c8.innerHTML="<div align='center' ><a href='#'' class='STYLE2'>天天美容院</a></div>";
   c9.innerHTML="<div align='center'><img src='../../images/037.gif' width='9' height='9' /><a href='#' class='STYLE2'>编辑</a></div>";
   c10.innerHTML="<div align='center'><img src='../../images/010.gif' width='9' height='9' /><a href='#' class='STYLE2'>删除</a></div>";
	};
}
function addfoods2 () {
  for (var i = 0; i < 5; i++) {

   var tr1=document.getElementById('foodsInf').insertRow();
   var c0=tr1.insertCell(0);
   var c1=tr1.insertCell(1);
   var c2=tr1.insertCell(2);
   var c3=tr1.insertCell(3);
   var c4=tr1.insertCell(4);
   var c5=tr1.insertCell(5);
   var c6=tr1.insertCell(6);
   var c7=tr1.insertCell(7);
   var c8=tr1.insertCell(8);
   var c9=tr1.insertCell(9);
   var c10=tr1.insertCell(10);
   tr1.style.height="25px";
   tr1.style.background="#ffffff";
   c0.innerHTML="<div align='center' class='STYLE1'><input name='checkbox1' type='checkbox'  value='checkbox'/></div>";
   c1.innerHTML="<div align='center' class='STYLE1'>A007</div>";
   c2.innerHTML="<div align='center' class='STYLE1'>男士护肤品</div>";
   c3.innerHTML="<div align='center' class='STYLE1'>2014-11-18</div>";
   c4.innerHTML="<div align='center' class='STYLE1'>湖南省</div>";
   c5.innerHTML="<div align='center' class='STYLE1'>长沙市</div>";
   c6.innerHTML="<div align='center' class='STYLE1'>岳麓区</div>";
   c7.innerHTML="<div align='center' ><a href='#'' class='STYLE2'>天天代理商</a></div>";
   c8.innerHTML="<div align='center' ><a href='#'' class='STYLE2'>天天美容院</a></div>";
   c9.innerHTML="<div align='center'><img src='../../images/037.gif' width='9' height='9' /><a href='#' class='STYLE2'>编辑</a></div>";
   c10.innerHTML="<div align='center'><img src='../../images/010.gif' width='9' height='9' /><a href='#' class='STYLE2'>删除</a></div>";
  };
}
function addfoodsName () {
    for (var i = 0; i < 5; i++) {
        var tr1=document.getElementById("foodsNameInf").insertRow();
        tr1.style.height="25px";
        tr1.style.background="#ffffff";
        var c0=tr1.insertCell(0);
        var c1=tr1.insertCell(1);
        var c2=tr1.insertCell(2);
        var c3=tr1.insertCell(3);
        var c4=tr1.insertCell(4);
        c0.innerHTML="<div align='center' class='STYLE1'><input name='checkbox1' type='checkbox'  value='checkbox'/></div>";
        c1.innerHTML="<div align='center' class='STYLE1'>A001</div>";
        c2.innerHTML="<div align='center' class='STYLE1'>男士护肤品</div>";
        c3.innerHTML="<div align='center'><img src='../../images/037.gif' width='9' height='9' /><a href='#' class='STYLE2'>编辑</a></div>";
        c4.innerHTML="<div align='center'><img src='../../images/010.gif' width='9' height='9' /><a href='#' class='STYLE2'>删除</a></div>";

    };
}

