/**
 * 表单的选择器
 */
form = "#form";
/**
 * 商品数量选择器
 */
goodNum = "#goodsNum";
/**
 * 电话号码选择器
 */
phone = "input[name='applyPhone']";
/**
 * 地址选择器
 */
address = "input[name='applyAddress']";
/**
 * 旧密码选择器
 */
oldPass = "input[name='oldPassword']";
/**
 * 新密码选择器
 */
newPass = "input[name='newPassword']";
/**
 * 确认密码选择器
 */
surePass = "input[name='surePassword']";
/**
 * 代理的密码框选择器
 */
agentPass = "input[name='agentPassword']";
/**
 * 能输入的最小商品数量
 */
minGoodsNum = 1;
/**
 * 密码的最大长度
 */
maxPassLen = 16;
/**
 * 代理的名字选择器
 */
agentName = "input[name='agentName']";
/**
 * 代理的电话选择器
 */
agentPhone = "input[name='agentPhone']";
/**
 * 代理的微信选择器
 */
agentWechat = "input[name='agentWechat']";
/**
 * 代理的身份证选择器
 */
agentIdcard = "input[name='agentIdcard']";
/**
 * 代理的汇款信息选择器
 */
agentInfo = "input[name='agentInfo']";

function goodInClick() {
	var isNum = verifyNum(goodNum);
	var compNum = verifyNumValue(goodNum, minGoodsNum);
	if (isNum == true && compNum == true) {
		submitForm(form);
	} else if (isNum == false) {
		alert("亲，商品数量需要填写纯数字哦！");
		getFocus(goodNum);
	} else if (compNum == false) {
		alert("亲，商品数量需要大于零哦！");
		getFocus(goodNum);
	} else {
		alert("不好啦，未知错误发生了！");
	}
}
function goodApplyClick() {
	var isPhone = verifyNull(phone);
	var isAddress = verifyNull(address);
	var truePhone = verifyPhone(phone);
	if (isPhone == true && isAddress == true && truePhone == true) {
		goodInClick();
	} else if (isPhone == false) {
		alert("亲，联系方式需要填写哦！");
		getFocus(phone);
	} else if (isAddress == false) {
		alert("亲，收货地址需要填写哦！");
		getFocus(address);
	} else if (truePhone == false) {
		alert("亲，联系方式填写要正确哦！例如:13415764179或0321-4816048");
		getFocus(phone);
	} else {
		alert("不好啦，未知错误发生了！");
	}
}
function pwdChangeClick() {
	var isOldP = verifyNull(oldPass);
	var isNewP = verifyNull(newPass);
	var isSureP = verifyNull(surePass);
	var isOLen = verifyLength(oldPass, maxPassLen);
	var isNLen = verifyLength(newPass, maxPassLen);
	var isSLen = verifyLength(surePass, maxPassLen);
	var isEqual = verifyEqual(newPass, surePass);
	if (isOldP == true && isNewP == true && isSureP == true) {
		if (isOLen == true && isNLen == true && isSLen == true) {
			if (isEqual == true) {
				submitForm(form);
			} else {
				alert("亲，新密码和确认密码不相同哦！");
				getFocus(surePass);
			}
		} else if (isOLen == false) {
			alert("亲，旧密码长度超过了哦！");
			getFocus(oldPass);
		} else if (isNLen == false) {
			alert("亲，新密码长度超过了哦！");
			getFocus(newPass);
		} else if (isSLen == false) {
			alert("亲，确认密码长度超过了哦！");
			getFocus(surePass);
		} else {
			alert("不好啦，未知错误发生了！");
		}
	} else if (isOldP == false) {
		alert("亲，旧密码需要填写哦！");
		getFocus(oldPass);
	} else if (isNewP == false) {
		alert("亲，新密码需要填写哦！");
		getFocus(newPass);
	} else if (isSureP == false) {
		alert("亲，确认密码需要填写哦！");
		getFocus(surePass);
	} else {
		alert("不好啦，未知错误发生了！");
	}
}
function userAddClick() {

	var isName = verifyNull(agentName);
	var isPhone = verifyNull(agentPhone);
	var isWechat = verifyNull(agentWechat);
	var isPass = verifyNull(agentPass);
	var isSurePass = verifyNull(surePass);
	var isIdcard = verifyNull(agentIdcard);
	var isInfo = verifyNull(agentInfo);

	var truePhone = verifyPhone(agentPhone);
	
	var isPLen = verifyLength(agentPass, maxPassLen);
	var isSLen = verifyLength(surePass, maxPassLen);

	var isEqual = verifyEqual(agentPass, surePass);
	if (isName == true && isPhone == true && isWechat == true 
			&& isPass == true && isSurePass == true && isIdcard == true
			&& isInfo == true) {
		if(isPLen == true && isSLen == true && truePhone == true){
			if(isEqual == true){
				submitForm(form);
			}else {
				alert("亲，新密码和确认密码不相同哦！");
				getFocus(surePass);
			}
		}else if(isPLen == false){
			alert("亲，密码长度超过了哦！");
			getFocus(agentPass);
		}else if(isSLen == false){
			alert("亲，确认密码长度超过了哦！");
			getFocus(surePass);
		}else if(truePhone == false){
			alert("亲，联系方式填写要正确哦！例如:13415764179或0321-4816048");
			getFocus(agentPhone);
		}else{
			alert("不好啦，未知错误发生了！");
		}
	}else if(isName == false){
		alert("亲，姓名需要填写哦！");
		getFocus(agentName);
	}else if(isPhone == false){
		alert("亲，电话号码需要填写哦！");
		getFocus(agentPhone);
	}else if(isWechat == false){
		alert("亲，微信需要填写哦！");
		getFocus(agentWechat);
	}else if(isPass == false){
		alert("亲，密码需要填写哦！");
		getFocus(agentPass);
	}else if(isSurePass == false){
		alert("亲，确认密码需要填写哦！");
		getFocus(surePass);
	}else if(isIdcard == false){
		alert("亲，身份证需要填写哦！");
		getFocus(agentIdcard);
	}else if(isInfo == false){
		alert("亲，汇款信息需要填写哦！");
		getFocus(agentInfo);
	}else{
		alert("不好啦，未知错误发生了！");
	}
}