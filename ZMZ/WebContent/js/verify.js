/**
 * 验证是否是数字，是返回true 否返回false
 * 
 * @param opt
 *            传入的jquery的选择器
 * @returns {Boolean}
 */
function verifyNum(opt) {
	var number = $(opt).val();
	var ret;
	if (isNaN(number) == true) {
		// 不是数字
		ret = false;
	} else {
		ret = true;
	}
	return ret;
}
/**
 * 提交表单
 * 
 * @param opt
 *            传入的jquery的选择器
 */
function submitForm(opt) {
	var form = $(opt);
	form.submit();
}
/**
 * jquery选择器中的数值大小比较
 * 
 * @param opt
 *            装有数字的jquery选择器
 * @param compNum
 *            比较的数值
 * @returns {Boolean} opt的是指大于compNum
 */
function verifyNumValue(opt, compNum) {
	var number = $(opt).val();
	var num = parseInt(number);
	var ret;
	if (num >= compNum) {
		ret = true;
	} else {
		ret = false;
	}
	return ret;
}
/**
 * 判断选择器中的值是否为空
 * 
 * @param opt
 *            jquery选择器
 * @returns {Boolean} 非空返回true
 */
function verifyNull(opt) {
	var value = $(opt).val();
	var ret;
	if (value == "") {
		ret = false;
	} else {
		ret = true;
	}
	return ret;
}
/**
 * 手机号验证
 * 
 * @param opt
 *            填写手机号的jquery选择器
 * @returns {Boolean} 符合返回true
 */
function verifyPhone(opt) {
	var isMobile = /^(?:13\d|15\d|18\d)\d{8}$/;
	// var isMobile = /^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; // 手机号码验证规则
	var isPhone = /^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/; // 座机验证规则
	var phone = $(opt).val();
	var ret;
	if (isMobile.test(phone) || isPhone.test(phone)) {
		ret = true;
	} else {
		ret = false;
	}
	return ret;
}
/**
 * 验证字符串是否超长
 * 
 * @param opt
 *            填写字符串的jquery 选择器
 * @param len
 *            比较长度
 * @returns {Boolean} 超过返回 false
 */
function verifyLength(opt, len) {
	var value = $(opt).val();
	var ret;
	if (value.length > len) {
		ret = false;
	} else {
		ret = true;
	}
	return ret;
}
/**
 * 判断jquery选择器中的值是否相等
 * @param optO 第一个jquery选择器
 * @param optT 第二个jquery选择器
 * @returns {Boolean} 相等返回true
 */
function verifyEqual(optO, optT) {
	var valueO = $(optO).val();
	var valueT = $(optT).val();
	var ret;
	if (valueO == valueT) {
		ret = true;
	}else {
		ret = false;
	}
	return ret;
}
/**
 * 输入文本框获得焦点
 * @param opt jquery选择器
 */
function getFocus(opt){
	var option = $(opt);
	option.focus();
	option.select();
	
}
