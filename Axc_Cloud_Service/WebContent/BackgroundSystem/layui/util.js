/*是否带有小数*/
function    isDecimal(strValue )  {  
   var  objRegExp= /^\d+\.\d+$/;
   return  objRegExp.test(strValue);  
}  

/*校验是否中文名称组成 */
function ischina(str) {
    var reg=/^[\u4E00-\u9FA5]{2,4}$/;   /*定义验证表达式*/
    return reg.test(str);     /*进行验证*/
}

/*校验是否全由8位数字组成 */
function isStudentNo(str) {
    var reg=/^[0-9]{8}$/;   /*定义验证表达式*/
    return reg.test(str);     /*进行验证*/
}

/*校验电话码格式 */
function isTelCode(str) {
    var reg= /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
    return reg.test(str);
}

/*校验邮件地址是否合法 */
function IsEmail(str) {
    var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
    return reg.test(str);
}
/*密码字母或者是数字，也可以是组合，8-20位*/
function isPassword(str){
    var reg =/^[A-Za-z0-9]{8,20}$/;
    return reg.test(str);
}
/*密码字母数字组合，不小于8位,必须包含数字加字母 不能包含特殊符号等*/
function isPassword2(pass){
    var str = pass;
    if(str==null || str.length<8){
            return false;
    }
     var reg1 = new RegExp(/^[0-9A-Za-z]+$/);
    if (!reg1.test(str)) {
        return false;
    }
    var reg = new RegExp(/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/);
    if (reg.test(str)) {
        return true;
    } else {
        return false;
    }
}


function  fun1(){
    if(!isStudentNo(document.getElementById("sno").value)){
        alert("学生编号是8位数字");
        document.getElementById("sno").focus();
        return false;
    }
    if(!ischina(document.getElementById("username").value)){
        alert("学生姓名必须填写中文");
        document.getElementById("username").focus();
        return false;  
    }
    if (!isPassword(document.getElementById("pass").value)) {
        alert("密码必须为字母或者是数字，也可以是组合，8-20位");
        document.getElementById("pass").focus();
        return false;
    }
    if (!isPassword2(document.getElementById("pass2").value)) {
        alert("密码必须为字母数字，不能有特殊字符8-20位");
        document.getElementById("pass").focus();
        return false;
    }
    if(!IsEmail(document.getElementById("email").value)){
        alert("无效的邮箱地址");
        document.getElementById("email").focus();
        return false;  
    }

    if(!isTelCode(document.getElementById("tel").value)){
        alert("电话号码不对");
        document.getElementById("tel").focus();
        return false;  
    }

    /*运行到这里说明验证通过返回true    submit提交按钮起作用提交表单*/
    alert("提交成功")
    return true;
}