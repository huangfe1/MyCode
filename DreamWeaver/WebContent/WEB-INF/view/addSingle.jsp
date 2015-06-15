<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
		<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>
		单号录入表
		</title>
		<link href="css/backcss/myCss.css" rel="stylesheet" type="text/css" />
		 <script type="text/javascript" src="js/dlselect.js"></script>
		
			<script type="text/javascript" src="js/calendar.js"></script>
	    <script type="text/javascript"src="js/addAgent.js"></script>
	    
	   
		</head>
		<body onload="loadData()" >
			<div class="background1" style="width:100%;height:100%">
		   <form action="" method="post" onsubmit='return onSubmit1()'>
		   	
	         

	       <table border='0' cellspacing='1' cellpadding='1'  align='center' width="80%" height="100%" >
	         	
	         	
	         	
	         	 	
	         	 <tr>
                  	<td colspan="6">
                  		
                  			<p align="center" class="font3">单号录入表单</p>
                  		
                  	</td>
                  </tr>
                  
	         	 
	         	  <tr align="center">
	         	    
	         	     <td align='left' valign="bottom">
	         	     </td>
	         	     <td align='left' valign="bottom">
	         	     	<input type='text' class='text4' id='firstId'  style="ime-mode:disabled;" onpaste="return false" onkeydown="return check(event)">
	         	       </td>
	         	       <td valign="bottom">
	         	     	<input type='text' class='text4' id='firstId'  style="ime-mode:disabled;" onpaste="return false" onkeydown="return check(event)">
	         	       </td>
	         	       <td valign="bottom">
	         	     	<input type='text' class='text4' id='firstId'  style="ime-mode:disabled;" onpaste="return false" onkeydown="return check(event)">
	         	     	</td>
	         	     	<td align='right' valign="bottom" >	         	       
	         	     	<input type='text' class='text4' id='firstId'  style="ime-mode:disabled;" onpaste="return false" onkeydown="return check(event)">
	         	     	
	         	     </td>
	         	     
	         	  </tr>

                  <tr align="center" style="height:0 ;" >
                  	<td align="left">
                  			<span class='font1'>单个编号：</span>
                  	</td>
                  	<td >
                  	</td>
                  	<td >
                  	</td>
                  	<td >
                  	</td>
                  	<td >
                  	</td>
                  	
                  </tr>

	         	  <tr align="center">
	         	     <td align='left' valign="top">
	         	     </td>
	         	     <td align='left' valign="top">
	         	     	<input type='text' class='text4' id='endId' style="ime-mode:disabled;" onpaste="return false" onkeydown="return check(event)">
	         	       </td>
	         	       <td valign="top">
	         	     	<input type='text' class='text4' id='endId'  style="ime-mode:disabled;" onpaste="return false" onkeydown="return check(event)">
	         	       </td>
	         	       <td valign="top">
	         	     	<input type='text' class='text4' id='endId'  style="ime-mode:disabled;" onpaste="return false" onkeydown="return check(event)">
	         	     	</td>
	         	     	<td align='right' valign="top">
	         	     	<input type='text' class='text4' id='endId'  style="ime-mode:disabled;" onpaste="return false" onkeydown="return check(event)">
	         	     	
	         	     </td>
	         	     
	         	  </tr>
                

                  <tr align="center">
	         	  	 
	         	  	    <td align='left'>
	         	  	 	
						<span class='font1'>代&nbsp;&nbsp;&nbsp;理：</span>
						</td>

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
                    
                        
	         	  	
	         	  </tr>

	         	
                  
	         	  <tr align="center" style="height: 0"> 
	         	     
	         	     <td align='left' >
	         	     	<span class='font1'>产&nbsp;品&nbsp;名：</span>
	         	     	</td>
	         	     	<td colspan="2">
	         	     		<span class='font1'>代理公司：</span><span class='font1'>
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
				 	    <input class="btn" type="submit" value="下一步" onclick="" >
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