//登陆的方法
function regist() {
    var loginaccount = document.getElementById("loginaccount").value;
    var username = document.getElementById("username").value;
    var loginpassword1 = document.getElementById("loginpassword1").value;
    var loginpassword2 = document.getElementById("loginpassword2").value;
    if(loginaccount == 'ACCOUNT' || username == 'NAME' || loginpassword1 == 'PASSWORD' || loginpassword2 == 'PASSWORD'){
        alert("请将信息填写完整！")
        return false;
    }
    if(loginpassword1 != loginpassword2){
        alert("两次输入密码不一致！")
        return false;
    }
    $.ajax({
        url: '/user/regist',
        type: "POST",
        data: {"loginName": loginaccount, "password": loginpassword1, "userName": username},
        success: function (data) {
            var retCode = JSON.parse(data.RETURNCODE)
            if (retCode.code == '000000') {
                window.location.href = 'http://localhost:8080/login'
            } else {
                var msgText = retCode.chineseDesc;
                var msg = document.getElementById("msg");
                var txt = document.createTextNode(msgText);
                msg.appendChild(txt);
                var index = 0;
                var word = msg.innerHTML;

                function type() {
                    document.getElementById("aa").innerText = word.substring(0, index++);
                }

                setInterval(type, 20);
            }
        },
        error: function (data) {

        }
    });
}

//回车键等于点击登陆按钮
$(document).keyup(function (event) {
    if (event.keyCode == 13) {
        $("#submit").trigger("click");
    }
});