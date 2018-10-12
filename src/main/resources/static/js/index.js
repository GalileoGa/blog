//进入主页加载数据库中的优秀博客
window.onload = function () {
    $.ajax({
        url: '/blog/Tips/UserTips',
        type: 'POST',
        data: {id: 5},
        success: function (data) {
            var blgsdiv = $(".blogsbox");
            var blogtext = "";
            var blog = data.tipsList;
            for (let i = 0; i < blog.length; i++) {
                var tipsid = blog[i].tipsid;
                var title = blog[i].title;
                var content = blog[i].content;
                var imgs = blog[i].imgs;
                var author = blog[i].author;
                var time = blog[i].time;
                var like = blog[i].like;
                var dislike = blog[i].dislike;
                var weight = blog[i].weight;
                var imgs_url = "";
                imgs_url += "<span class=\"bplist\"><a href=\"/\" title=\"\">";
                if (imgs.length > 1) {
                    for (let j = 0; j < imgs.length; j++) {
                        imgs_url += "<li><img src=\"" + imgs[j] + "\" alt=\"\"></li>";
                    }
                } else {
                    imgs_url += "<a href=\"/\" title=\"\"><img src=\"" + imgs + "\" alt=\"\"></a>";
                }
                imgs_url += "</a></span>"
                blogtext += "<div class=\"blogs\" data-scroll-reveal=\"enter bottom over 1s\">";
                blogtext += "<h3 id=\"blogtitle\" class=\"blogtitle\"><a href=\"/\" target=\"_blank\">" + title + "</a></h3>";
                blogtext += imgs_url;
                blogtext += "<p id=\"blogtext\" class=\"blogtext\">" + content + "</p>";
                blogtext += "<div class=\"bloginfo\">";
                blogtext += "<ul>";
                blogtext += "<li class=\"author\"><a href=\"/\">" + author + "</a></li><li class=\"timer\">" + time + "</li>";
                blogtext += "<li class=\"view\"><span>" + weight + "</span>已阅读</li><li onclick=\"ilikethis(this," + tipsid + ") \" class=\"like\">" + like + "</li>";
                blogtext += "<li onclick=\"idislikethis(this," + tipsid + ")\" class=\"lmname\">" + dislike + "</li>";
                blogtext += "</ul>";
                blogtext += "</div>";
                blogtext += "</div>";
            }
            blgsdiv.html(blogtext);
        },
        error: function () {
            alert("网络错误！！我兄弟巨没面子！！");
        }
    })
}

//我喜欢这个tips
function ilikethis(like, tipsid) {
    $.ajax({
        url: "/blog/Tips/like",
        type: "POST",
        data: {"tipsid": tipsid},
        success: function (data) {
            var retCode = JSON.parse(data.RETURNCODE)
            if (retCode.code == '000000') {
                var likeNum = document.createTextNode(data.like);
                like.removeChild(like.firstChild);
                like.appendChild(likeNum);
            } else {
                alert("我兄弟没面子")
            }

        },
        error: function () {
            alert("我兄弟没面子")
        }
    })
}

//我不喜欢这个tips
function idislikethis(dislike, tipsid) {
    $.ajax({
        url: "/blog/Tips/dislike",
        type: "POST",
        data: {"tipsid": tipsid},
        success: function (data) {
            var retCode = JSON.parse(data.RETURNCODE)
            if (retCode.code == '000000') {
                var disLikeNum = document.createTextNode(data.dislike);
                dislike.removeChild(dislike.firstChild);
                dislike.appendChild(disLikeNum);
            } else {
                alert("我兄弟没面子")
            }
        },
        error: function () {
            alert("我兄弟没面子")
        }
    })
}