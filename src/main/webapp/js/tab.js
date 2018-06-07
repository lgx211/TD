(function () {
    //左右滑动，每次移动多长距离
    var scrollSetp = 300,
        //固定的标签页所占用的宽度。比如左右滑动共占80PX
        fixedTabsWidth = 80,
        //标签栏放向左滑动图标所固定占用的
        leftTabWidth = 40,
        //打开标签页时间
        animatSpeed = 150,

        //点击激活状态与非激活状态
        linkframe = function (url, value) {
            //去掉已经激活的标签页
            $(".menu-list a.active").removeClass("active");
            //给新激活的标签页添加样式
            $(".menu-list a[data-url='" + url + "'][data-value='" + value + "']").addClass("active");
            //去掉之前的iframe内容
            $(".content-page iframe.active").removeClass("active");
            //显示新的iframe内容
            $(".content-page .iframe-content[data-url='" + url + "'][data-value='" + value + "']").addClass("active");
        },

        //定位并移动隐藏起来的标签
        positionAndMove = function (selectedTab) {
            var nav = $(".menu-list");

            //放标签页的那个隐藏起来的很长的区域距离左侧的距离
            var navLeftWidth = parseInt(nav.css("margin-left"));
            //选中的标签页距离左侧的距离。（这里减去导航栏的220px）
            var selectedTabLeftWidth = selectedTab.offset().left - 220;
            //中间放标签页的区域的宽度
            var contentTabsWidth = parseInt($(".content-tabs").width());

            if (selectedTabLeftWidth < 0 && selectedTabLeftWidth <= contentTabsWidth) {
                nav.animate({
                        "margin-left": (navLeftWidth - selectedTabLeftWidth + leftTabWidth) + "px"
                    },
                    animatSpeed)
            } else {
                if (selectedTabLeftWidth + selectedTab.width() > contentTabsWidth - fixedTabsWidth) {
                    nav.animate({
                            "margin-left": (navLeftWidth - selectedTabLeftWidth + contentTabsWidth - selectedTab.width() - fixedTabsWidth) + "px"
                        },
                        animatSpeed)
                }
            }
        },

        //移动非定位的其他标签页
        moveUnSelectedTabs = function () {
            var nav = $(".menu-list");

            var contentTabsWidth = parseInt($(".content-tabs").width());
            var navWidth = parseInt(nav.width());

            if (contentTabsWidth - fixedTabsWidth < navWidth) {
                nav.animate({
                        "margin-left": "-" + (navWidth - contentTabsWidth + fixedTabsWidth) + "px"
                    },
                    animatSpeed)
            }
        },

        //关闭标签
        closeTab = function () {
            $(this.parentElement).animate({
                    "width": "0",
                    "padding": "0"
                },
                0,
                function () {
                    var jthis = $(this);
                    //如果要关闭的这个标签页是被选中的状态
                    if (jthis.hasClass("active")) {
                        var liNext = jthis.next();
                        //如果它后面还有标签页，就激活紧邻后面的那个标签页
                        if (liNext.length > 0) {
                            liNext.click();
                            positionAndMove(liNext);
                        }
                        //如果它后面没有标签页，就激活它前面的那个标签页
                        else {
                            var liPrev = jthis.prev();
                            if (liPrev.length > 0) {
                                liPrev.click();
                                positionAndMove(liPrev);
                            }
                        }
                    }
                    ////如果要关闭的这个标签页不是被选中的状态，关闭。
                    this.remove();
                    $(".content-page .iframe-content[data-url='" + jthis.data("url") + "'][data-value='" + jthis.data("value") + "']").remove()
                });
            event.stopPropagation();
        },

        //滑动
        init = function () {
            //点击往左滑动标记
            $(".leftTab").bind("click",
                function () {
                    var nav = $(".menu-list");

                    var navLeftWidth = parseInt(nav.css("margin-left"));

                    if (navLeftWidth !== 0) {
                        nav.animate({
                                "margin-left": (navLeftWidth + scrollSetp > 0 ? 0 : (navLeftWidth + scrollSetp)) + "px"
                            },
                            animatSpeed)
                    }
                });
            //点击往右滑动标记
            $(".rightTab").bind("click",
                function () {
                    var nav = $(".menu-list");

                    var navWidth = parseInt(nav.width());
                    var navLeftWidth = parseInt(nav.css("margin-left"));
                    var contentTabsWidth = parseInt($(".content-tabs").width());
                    var allShowLeft = -(navWidth - contentTabsWidth + fixedTabsWidth);

                    if (allShowLeft !== navLeftWidth && navWidth > contentTabsWidth - fixedTabsWidth) {
                        var temp = (navLeftWidth - scrollSetp);
                        nav.animate({
                                "margin-left": (temp < allShowLeft ? allShowLeft : temp) + "px"
                            },
                            animatSpeed)
                    }
                });
        };


    $.fn.tab = function () {
        init();
        this.bind("click",
            function () {
                //URl地址
                var linkUrl = this.href;
                //标题
                var linkHtml = this.text.trim();
                var selectedTab = $(".menu-list a[data-url='" + linkUrl + "'][data-value='" + linkHtml + "']");

                if (selectedTab.length === 0) {

                    var closeIcon = $("<i>", {
                        "class": "menu-close"
                    }).bind("click", closeTab);

                    $("<a>", {
                        "html": linkHtml,
                        "href": "javascript:void(0);",
                        "data-url": linkUrl,
                        "data-value": linkHtml
                    }).bind("click",
                        function () {
                            var jthis = $(this);
                            linkframe(jthis.data("url"), jthis.data("value"))
                        }).append(closeIcon).appendTo(".menu-list");

                    $("<iframe>", {
                        "class": "iframe-content",
                        "data-url": linkUrl,
                        "data-value": linkHtml,
                        src: linkUrl
                    }).appendTo(".content-page");

                    moveUnSelectedTabs();
                } else {
                    positionAndMove(selectedTab);
                }
                linkframe(linkUrl, linkHtml);
                return false;
            });
        return this;
    }
})();