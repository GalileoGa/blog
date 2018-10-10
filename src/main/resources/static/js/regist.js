//登陆的方法
function regist() {
    var loginaccount = document.getElementById("loginaccount").value;
    var username = document.getElementById("username").value;
    var loginpassword1 = document.getElementById("loginpassword1").value;
    var loginpassword2 = document.getElementById("loginpassword2").value;
    alert(loginaccount + "::" + loginpassword1+"::"+username+"::"+loginpassword2)
    $.ajax({
        url: '/user/login',
        type: "POST",
        data: {"loginName": loginaccount, "password": loginpassword},
        success: function (data) {
            var retCode = JSON.parse(data.RETURNCODE)
            if (retCode.code == '000000') {
                window.location.href = 'http://localhost:8080/index'
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