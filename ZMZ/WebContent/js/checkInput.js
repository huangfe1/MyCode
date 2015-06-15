
/*$(document).ready(function(){
	$("#sub").click(function(){
		var canSub=true;
		//先判断是否为空
		var values=['name','phone','wechat','paw','idcard','info'];
		for(var i=0;i<values.length;i++){
			var id=values[i];
			if($("#"+id).val()==""){
				alert("带*的地方为必填选项");
				$("#"+id).focus();
				canSub=false;
				break;
			}else{
				//验证电话号码
				if(id="phone"){
					var phone=$("#"+id).val();
					if(phone.length<11){
						alert("手机号码格式不正确!");
						$("#"+id).focus();
						canSub=false;
						break;
					}
					//验证手机号码格式是否正确
					var myreg =/^0?1[3|4|5|8][0-9]\d{8}$/;
			        if(!myreg.test(phone))
			        {
			        	$("#"+id).focus();
			            alert('请输入有效的手机号码！');
			            canSub=false;
			        	break;
			        }
				}
				//验证密码
				if(id=="paw"){
					if(	$("#paw").val()!=$("#repaw").val()){
						alert("抱歉两次输入的密码不相同");
						canSub=false;
					}
				}
			}
		}
		//提交表单
		if(canSub){
			$("#myform").submit();
		}
	});
	//
});*/
function checkEmpty(values,form){
	var canSub=true;
	//先判断是否为空
//	var values=['name','phone','wechat','paw','idcard','info'];
	for(var i=0;i<values.length;i++){
		var id=values[i];	
		if($("#"+id).val()==""){
			alert("带*的地方为必填选项");
			$("#"+id).focus();
			canSub=false;
			break;
		}else{
   			//验证电话号码
			if(id=="phone"){
				var phone=$("#"+id).val();
				if(phone.length<11){
					alert("手机号码格式不正确!");
					$("#"+id).focus();
					canSub=false;
					break;
				}
				//验证手机号码格式是否正确
				var myreg =/^0?1[3|4|5|8][0-9]\d{8}$/;
		        if(!myreg.test(phone))
		        {
		        	$("#"+id).focus();
		            alert('请输入有效的手机号码！');
		            canSub=false;
		        	break;
		        }
			}
			//验证密码
			if(id=="repaw"){
				if(	$("#paw").val()!=$("#repaw").val()){
					alert("抱歉两次输入的密码不相同");
					canSub=false;
				}
			}
			
		}
	}
	//提交表单
	if(canSub){
		$("#"+form).submit();
	}
}