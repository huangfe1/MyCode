function onSubmit1 () {
                   document.getElementById("firstIdSpan1").style.display="";
                      document.getElementById("firstIdSpan2").style.display="none";
                      document.getElementById("endIdSpan1").style.display="";
                      document.getElementById("endIdSpan2").style.display="none";
                       document.getElementById("duiyingIdSpan").style.display="none";
                       document.getElementById("goodsNameSpan1").style.display="";
                      document.getElementById("goodsNameSpan2").style.display="none";
                      
                 	var firstId = document.getElementsByName('firstId');
                  var endId = document.getElementsByName('endId');
                 	
                 	var agent = document.getElementById('agentId');
                 	var beauty = document.getElementById('beautyId');
                  var flag=0;
                  var flag2=0;
                   for (var i = 0; i < firstId.length; i++) {
                       if(firstId[i].value!="") flag2=1;
                  };
                 
                  if(flag2==0){
                     if(flag==0) flag=1;
                      document.getElementById("firstIdSpan1").style.display="none";
                      document.getElementById("firstIdSpan2").style.display="";
                  }
                  var flag3=0;
                  for (var i = 0; i < endId.length; i++) {
                       if(endId[i].value!="") flag3=1;
                  };
                  if(flag3==0){
                     if(flag==0) flag=1;
                      document.getElementById("endIdSpan1").style.display="none";
                      document.getElementById("endIdSpan2").style.display="";

                  }
                  var flag4=0;
                  if(flag2==1&&flag3==1){
                 
                  for (var i = 0; i < firstId.length; i++) {
                    
                       if((firstId[i].value!=""&&endId[i].value=="")||(endId[i].value!=""&&firstId[i].value=="")){
                                flag4=1;
                       }
                  }
                }
                 if(flag4==1){
                  if(flag==0) flag=1;
                   document.getElementById("duiyingIdSpan").style.display="";
                 }
                 
                 	if(agent.value==""){
                    if(flag==0) flag=1;
                      document.getElementById("goodsNameSpan1").style.display="none";
                      document.getElementById("goodsNameSpan2").style.display="";
                  }
                  if(beauty.value==""){
                    if(flag==0) flag=1;
                    document.getElementById("goodsNameSpan1").style.display="none";
                    document.getElementById("goodsNameSpan2").style.display="";
                  }
                 	if(flag==1)
                    return false;
                 	else 
                    return true;

                 }
                 function onSubmit2() {
                  document.getElementById("firstIdSpan1").style.display="";
                    document.getElementById("firstIdSpan2").style.display="none";
                     document.getElementById("goodsNameSpan1").style.display="";
                    document.getElementById("goodsNameSpan2").style.display="none";
                  var foodsId = document.getElementsByName('firstId');
                  var agent = document.getElementById('agentId');
                  var beauty = document.getElementById('beautyId');
                  
                  var flag = 0;
                  var flag2=0;
                  for (var i = 0; i < foodsId.length; i++) {
                    if(foodsId[i].value!=""){
                      flag2=1;
                    }
                  };
                  if(flag2==0){
                    if(flag==0) flag=1;
                    document.getElementById("firstIdSpan1").style.display="none";
                    document.getElementById("firstIdSpan2").style.display="";
                  }
                  
                  if(agent.value==""){
                    if(flag==0) flag=1;
                    document.getElementById("goodsNameSpan1").style.display="none";
                    document.getElementById("goodsNameSpan2").style.display="";
                  }
                  if(beauty.value==""){
                    if(flag==0) flag=1;
                    document.getElementById("goodsNameSpan1").style.display="none";
                    document.getElementById("goodsNameSpan2").style.display="";
                  }
                  if(flag==1)
                    return false;
                  else return true;

                 }
                
                 function  changeDisplay(id) {
                 	if(id.style.display=="none")
                 	id.style.display="";
                    else id.style.display="none";
                 }
                 function blurcheck(id,id1,id2) {
                 	var text = id.value;
                 	if(text==""){
                        changeDisplay(id1);
                        changeDisplay(id2);
                 	}
                 }
                 function clickcheck(id1,id2){
                 	if(id1.style.display=="none")
                 	changeDisplay(id1);
                    if(id2.style.display=="")
                    changeDisplay(id2);
                 }
                 
                 function checkfirstId() {
                    var firstId = document.getElementById("firstId").value;
                    if(firstId==""){
                      document.getElementById("firstIdSpan1").style.display="none";
                      document.getElementById("firstIdSpan2").style.display="";
                    }
                    else{
                       var endId = document.getElementById("endId").value;
                       if(endId!=""){
                          if(parseInt(firstId)>parseInt(endId)){
                            document.getElementById("firstIdSpan1").style.display="none";
                            document.getElementById("firstIdSpan3").style.display="";
                          }
                       }
                    }
                 }
                 function checkendId() {
                   var endId = document.getElementById("endId").value;
                    if(endId==""){
                      document.getElementById("endIdSpan1").style.display="none";
                      document.getElementById("endIdSpan2").style.display="";
                    }else{
                       var firstId = document.getElementById("firstId").value;
                       if(firstId!=""){
                          if(parseInt(endId) < parseInt(firstId)){
                            document.getElementById("endIdSpan1").style.display="none";
                            document.getElementById("endIdSpan3").style.display="";
                          }
                       }
                    }
                 }
                 function clickfirstId () {
                   // body...
                   if(document.getElementById("firstIdSpan1").style.display=="none"){
                       document.getElementById("firstIdSpan2").style.display="none";
                       document.getElementById("firstIdSpan3").style.display="none";
                       
                       document.getElementById("firstIdSpan1").style.display="";
                   }
                 }
                 function clickendId () {
                   // body...
                   if(document.getElementById("endIdSpan1").style.display=="none"){
                       document.getElementById("endIdSpan2").style.display="none";
                       document.getElementById("endIdSpan3").style.display="none";
                       
                       document.getElementById("endIdSpan1").style.display="";
                   }
                 }

                 function check(event) {   
  var e = window.event || event;   
  var target = e.srcElement || e.target;   
  var k = e.keyCode;   
  if(isFunKey(k)) {   
    return true;   
  }   
  var c = getChar(k);   
  if(target.value.length == '' && (c == '-' || c == '+')) {   
    return true;   
  }   
  if(isNaN(target.value + getChar(k))) {   
    return false;   
  }   
  return true;   
}   
  
function isFunKey(code) {   
  //  8 --> Backspace   
  // 35 --> End   
  // 36 --> Home   
  // 37 --> Left Arrow   
  // 39 --> Right Arrow   
  // 46 --> Delete   
  // 112~123 --> F1~F12   
  var funKeys = [8, 35, 36, 37, 39, 46];   
  for(var i = 112; i <= 123; i++) {   
    funKeys.push(i);   
  }      
  for(var i = 0; i < funKeys.length; i++) {   
    if(funKeys[i] == code) {   
      return true;   
    }   
  }   
  return false;   
}   
  
function getChar(k) {   
  if(k >= 48 && k <= 57) {   
    return String.fromCharCode(k);   
  }   

  return "#";   
}   

  