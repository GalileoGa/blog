//进入主页加载数据库中的优秀博客
window.onload=function () {
    $.ajax({
        url: '/blog/Tips/UserTips',
        type: 'POST',
        data: {id: 5},
        success: function (data) {
            var blog = data.userTipsList;
            for (let i = 0; i < blog.length; i++) {
                $("#blogtitle").html(blog[i].title);
                $("#blogtext").html(blog[i].content);
            }
        },
        error: function () {
            alert("网络错误！！我兄弟巨没面子！！");
        }
    })
}