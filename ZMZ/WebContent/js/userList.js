$(document).ready(function(){//防止函数库没有加载完就执行方法
	var lmap={}; //等级map
	var map ={};//用户map
	//首先遍历其所有的用户
	$("#agents").children().each(function(n,a){
		var lv=$(this).attr("id");//获取agents的option的id
		lmap[lv]="1";//存储在等级map的key中
	});
	//遍历map创建等级option,遍历agents将用户分级存储
	for(var key in lmap){
		if(key=='admin'){
			//用户本身
			$("<option value="+key+">"+"选择自己"+"</option>").appendTo($("#agentslevel"));
		}else{
		$("<option value="+key+">"+key+"代理"+"</option>").appendTo($("#agentslevel"));
		}
		var options=new Array();
		$("#agents").children("#"+key).each(function(n,a){
			var text=$(this).text();
			var value=$(this).val();
			var option=[value,text];//数组储存option的
			options.push(option);
		});
		map[key]=options;//等级
	}
	$("#agentslevel").change(function(){//等级添加监听
		var id=$(this).val();//获取等级
		$("#agents").children().remove();//移除所有
		if(id=="我的代理"){//取出所有代理
			for(var key in map){
				var  options=map[key];
				for(var i=0;i<options.length;i++){   z
					var vt=options[i];
					$("<option value="+vt[0]+">"+vt[1]+"</option>").appendTo($("#agents"));
				}
			}
			$("#agents").show();
			$("#agentparam").val("");
			$("#agentparam").hide();
		}else if(id=="输入编号"){
			$("#agentparam").attr("name","agentcode");
			$("#agentparam").attr("placeholder","代理编号");
			$("#agentparam").show();//姓名框显示
			$("#agents").hide();//隐藏选择框
		}else if(id=="普通客户"){
			$("#agentparam").show();//姓名框显示
			$("#agents").hide();//隐藏选择框
			$("#agentparam").attr("name","cname");
			$("#agentparam").attr("placeholder","客户姓名");
		}else{
			$("#agents").show();
			$("#agentparam").val("");
			$("#agentparam").hide();
			var options=map[id];
			for(var i=0;i<options.length;i++){
				var vt=options[i];
				$("<option value="+vt[0]+">"+vt[1]+"</option>").appendTo($("#agents"));
			}
		}
	});
	//number数量
	var ns=$("#nstd").find("input").length+1;
	//下一步添加监听
	$("#nextbt").click(function(){
		if($("#agents").children().length!=0||$("#agents").val()!=""){
		check();
		}else{
			alert("亲,您还没有选择任何代理商");
		}
			});
	
 //function结束符
});
