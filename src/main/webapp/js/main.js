//被鼠标点击选中的目录的元素
var previous;

$(function () {
    initAccordion();
    clickAccordion();
    $(".submenu a").tab();
});

function initAccordion() {

    var menuList = '';
    menuList += '<ul id="accordion" class="accordion">';
    //循环所有的一级目录
    $.each(menuArray.menus, function (i, n) {
        //一级目录
        menuList += '<li><div class="link"><i class="' + n.menuIcon + '"></i>' + n.menuName + '<i class="' + n.menuIcon2 + '"></i></div> ';
        menuList += '<ul class="submenu">';
        //循环该一级目录下的二级目录
        $.each(n.menus, function (j, o) {
            menuList += '<li><a href="' + o.menuUrl + '"><i class="' + o.menuIcon + '"></i>' + o.menuName + '</a></li>'
        })
        menuList += '</ul>';
        menuList+='</li>';
    })
    menuList += '</ul>';

    $(".side-navigation").append(menuList);
}

function clickAccordion() {
    var Accordion = function (el, multiple) {
        this.el = el || {};
        this.multiple = multiple || false;
        var links = this.el.find('.link');
        links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
    };

    Accordion.prototype.dropdown = function (e) {
        var $el = e.data.el;
        $this = $(this);
        $next = $this.next();

        $next.slideToggle();
        $this.parent().toggleClass('open');

        /* 只能开一个一级目录。个人不喜欢，故去除 */
        /*if (!e.data.multiple) {
            $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
        }*/
    };

    var accordion = new Accordion($('#accordion'), false);

    //去除上一个被选中的状态，给新的选中添加状态
    $('.submenu li').click(function () {
        if (previous == undefined) {
            $(this).addClass('current');
        } else {
            previous.removeClass('current');
            $(this).addClass('current');
        }
        previous = $(this);
    });
}