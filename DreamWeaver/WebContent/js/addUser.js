
function onSubmit () {
                  	var username = document.getElementById("username");
                  	var userpassword = document.getElementById("userpassword");
                    var comfirmpass = document.getElementById("compassword");
                    var phone = document.getElementById("phone");
                    var weixing = document.getElementById("weixing");
                  	var flag = 0;
                    if(username.value==""){
                     if(flag==0) flag = 1;
                      
                      document.getElementById("usernameSpan").style.display="";
                      document.getElementById("usernameSpan1").style.display="none";
                            
                    }
                    if(userpassword.value==""){
                       if(flag==0) flag = 1;
                       document.getElementById("userpasswordSpan").style.display="";
                       document.getElementById("userpasswordSpan1").style.display="none";
                    }
                    if(comfirmpass.value!=userpassword.value){
                       if(flag==0) flag = 1;
                       document.getElementById("compasswordSpan1").style.display="none";
                       document.getElementById("compasswordSpan2").style.display="";
                    }else{
                       document.getElementById("compasswordSpan2").style.display="none";
                       document.getElementById("compasswordSpan1").style.display="";
                    }
                    if(phone.value==""){
                      if(flag==0) flag = 1;
                      document.getElementById("phoneSpan1").style.display="none";
                      document.getElementById("phoneSpan2").style.display="";
                    }
                    if(weixing.value==""){
                      if(flag==0) flag = 1;
                      document.getElementById("weixingSpan1").style.display="none";
                      document.getElementById("weixingSpan2").style.display="";
                    }
                    if(flag == 1) return false;
                    else return true;
                  }

                    function checkUserName () {
                  		var username = document.getElementById("username").value;
                  		if(username==""){
                              document.getElementById("usernameSpan").style.display="";
                              document.getElementById("usernameSpan1").style.display="none";
                  		}
                  	}
                  	function clickUserName () {
                  		document.getElementById("usernameSpan").style.display="none";
                  		document.getElementById("usernameSpan1").style.display="";
                  	}


                  	function checkUserPassword () {
                  		var userpassword = document.getElementById("userpassword").value;
                  		if(userpassword==""){
                              document.getElementById("userpasswordSpan").style.display="";
                              document.getElementById("userpasswordSpan1").style.display="none";
                  		}
                  	}
                  	function clickUserPassword () {
                  		document.getElementById("userpasswordSpan").style.display="none";
                  		document.getElementById("userpasswordSpan1").style.display="";
                  	}

                   
                    function checkcomPassword () {
                      // body...
                      var comfirmpass = document.getElementById("compassword").value;
                      var password = document.getElementById("userpassword").value;
                      if(comfirmpass != password){
                      document.getElementById("compasswordSpan1").style.display="none";
                      document.getElementById("compasswordSpan2").style.display="";
                      }
                    }
                    function clickcomPassword () {
                      // body...
                       document.getElementById("compasswordSpan1").style.display="";
                      document.getElementById("compasswordSpan2").style.display="none";
                    }
                    function clickPhone () {
                      // body...
                      document.getElementById("phoneSpan2").style.display="none";
                      document.getElementById("phoneSpan1").style.display="";
                    }
                    function checkPhone () {
                      // body...
                      if(document.getElementById("phone").value == ""){
                         document.getElementById("phoneSpan1").style.display="none";
                         document.getElementById("phoneSpan2").style.display="";
                      }
                    }
                    function clickweixing () {
                      // body...
                      document.getElementById("weixingSpan2").style.display="none";
                      document.getElementById("weixingSpan1").style.display="";
                    }
                    function checkweixing () {
                      // body...
                      if(document.getElementById("weixing").value ==""){
                         document.getElementById("weixingSpan1").style.display="none";
                         document.getElementById("weixingSpan2").style.display="";
                      }
                    }

                  	function onSubmit1 () {
                       var foodsName = document.getElementById("foodsName").value;
                       if(foodsName==""){
                        document.getElementById("foodsNameSpan1").style.display="none";
                        document.getElementById("foodsNameSpan2").style.display="";
                        return false;
                       }
                       return true;
                    }
                    function  checkFoodsName () {
                       var foodsName = document.getElementById("foodsName").value;
                       if(foodsName==""){
                          document.getElementById("foodsNameSpan1").style.display="none";
                          document.getElementById("foodsNameSpan2").style.display="";
                       }
                    }
                    function  clickFoodsName () {
                        if(document.getElementById("foodsNameSpan1").style.display=="none"){
                          document.getElementById("foodsNameSpan2").style.display="none";
                          document.getElementById("foodsNameSpan1").style.display="";
                        }
                    }