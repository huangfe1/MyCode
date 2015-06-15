<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
		<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>
		串号录入表
		</title>
		<link href="css/backcss/myCss.css" rel="stylesheet" type="text/css" />
		 <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		 <script type="text/javascript" src="js/dlselect.js"></script>
		 <script type="text/javascript" src="js/calendar.js"></script>
	     <script type="text/javascript"src="js/addAgent.js"></script>
	   
		</head>
		<body onload="loadData()" >
			<div class="background1" style="width:100%;height:100%">
		   <form action="" method="post" onsubmit='return onSubmit1()'>
		   <input type="text" id="uid" name="uid">
	       <table border='0' cellspacing='1' cellpadding='1'  align='center' width="80%" height="100%" >
	         	 <tr>
                  	<td colspan="6">
                  			<p align="center" class="font3">串号录入表单</p>
                  	</td>
                  </tr>
	         	  <tr align="center">
	         	     <td align='left' valign="bottom">
	         	     	<span class='font1'>头&nbsp;编&nbsp;号：</span>
	         	     </td>
	         	     <td align='left' valign="bottom">
	         	     	<input type='text' class='text4' id='f1' name="ns[1]" style="ime-mode:disabled;" >
	         	       </td>
	         	       <td valign="bottom">
	         	     	<input type='text' class='text4' id='f2' name="ns[2]" style="ime-mode:disabled;" >
	         	       </td>
	         	       <td valign="bottom">
	         	     	<input type='text' class='text4' id='f3' name="ns[3]" style="ime-mode:disabled;" >
	         	     	</td>
	         	     	<td align='right' valign="bottom" >	         	       
	         	     	<input type='text' class='text4' id='f4' name="ns[4]" style="ime-mode:disabled;" >
	         	     </td>
	         	  </tr>
                  <tr align="center" style="height:0 ;" >
                  	<td>
                  	</td>
                  	<td >
                  	<div style="width: 45%" align="left">  <img align="center" src="images/xiangxia-3.png" ></div> 
                  	</td>
                  	<td >
                  		<img src="images/xiangxia-3.png">
                  	</td>
                  	<td >
                  		<img src="images/xiangxia-3.png">
                  	</td>
                  	<td >
                  		<div style="width: 50%" align="right">  <img align="center" src="images/xiangxia-3.png" ></div> 
                  	</td>
                  </tr>
	         	  <tr align="center">
	         	     <td align='left' valign="top">
	         	     	<span class='font1'>尾&nbsp;编&nbsp;号：</span>
	         	     </td>
	         	     <td align='left' valign="top">
	         	     	<input type='text' class='text4' id='ns[5]' name="e1" >
	         	       </td>
	         	       <td valign="top">
	         	     	<input type='text' class='text4' id='ns[6]' name="e2" >
	         	       </td>
	         	       <td valign="top">
	         	     	<input type='text' class='text4' id='ns[7]' name="e3" >
	         	     	</td>
	         	     	<td align='right' valign="top">
	         	     	<input type='text' class='text4' id='ns[8]' name="e4" >
	         	     </td>
	         	  </tr>
                  <tr align="center">
	         	  		<td align='left'>
						<span class='font1'>指定代理：</span>
						</td>
						
						 <td colspan="5"  >
						 <div  class='scroll' style="width: 760px;"> 
						 <div id="sdiv" style="width:400px;" > <!--刚好是上级div的宽度-->
						 <!-- 一级代理 --> 
						 <div id="sd"  >
						 <select id="s0"  class="text3" >
						 <option >请选择</option>
						 <option value="1"  style="display:none; ">代理一一一一一</option>
						 </select>
						 </div>
						 </div>
						 </div> 
						 </td>
						<%--
						<td align="left" colspan="2">	
						<select id="selProvance"  onchange="chgProvinces('selProvance','selCity','selArea')" 
						class="text3" >
						<option >省</option>
						</select>
						</td>
						<td align="right">
						<select id="selCity" onchange="chgCitys('selCity','selArea')" class="text3" value="市">
						<option>市</option>
						</select>
						</td>
						<td align="right">
						<select id="selArea" class="text3" >
						<option>县</option>
						</select>
                        </td>    
                        --%>
                        
	         	  	
	         	  </tr>

	         	
                  
	         	  <tr align="center" style="height: 0"> 
	         	     
	         	     <td align='left' >
	         	     	<span class='font1'>产&nbsp;品&nbsp;名：</span>
	         	     	</td>
	         	     	<td colspan="2">
	         	     		<span class='font1'>代理公司：</span>
	         	     	</td>
	         	     	<td colspan="2">
	         	     		<span class='font1'>美&nbsp;容&nbsp;院：</span>
	         	     	</td>

	         	 </tr>
	         	 <tr align="center">
	         	 	<td align="left">
	         	 		
	         	     	<select class="text6">
	         	     		<option value="manfoods">
	         	     		   男士护肤品	
	         	     		</option>
	         	     	<option value="womenfoods">
	         	     		   女士护肤品	
	         	     		</option>
	         	     	</select>
	         	    </td>
	         	    <td colspan="2">
	         	     	
                   <input type='text' class='text5' id='agentId'>
	         	     	
	         	    </td>
	         	    <td colspan="2">
	         	     	<input type='text' class='text5' id='beautyId'>
	         	    </td>
	         	    
                     
	         	  </tr>
	         	
                  
	         	   
				  <tr>
				     <td colspan="6" align="center">
				 	    <input class="btn" id="bt" type="button" value="下一步"  >
				          <span class='font1'>
				     	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				          </span>
				         <input class="btn" type="reset" value="重置">
				    </td>
				    
			      </tr>
           

	         </table>
            
		   </form>
		   </div>
		</body>
		</html>