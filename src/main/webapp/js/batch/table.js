function getTableUser() {
    $("#tableUser").bootstrapTable('refresh');
}

$("#tableUser").bootstrapTable({ // 对应table标签的id
    url: "tableUser.ajax",  // 获取表格数据的url

    striped: true,  //显示斑马纹
    clickToSelect: true,    //点击即选中

    sortable: true, //启用排序
    sidePagination: 'server', // 设置为服务器端分页
    pagination: true, // 在表格底部显示分页组件，默认false
    pageList: [10, 20, 50, 100, 200], // 设置页面可以显示的数据条数

    queryParams: function (params) {
        return {
            pageSize: params.limit, // 每页要显示的数据条数
            pageNumber: params.offset, // 每页显示数据的开始行号

            sortName: params.sort, // 要排序的字段
            sortOrder: params.order, // 排序规则

            userName: $("#userName-search").val(), //额外添加的参数
            loginName: $("#loginName-search").val(), //额外添加的参数
        }
    },
    columns: [
        {
            field: 'Number',
            title: '序号',
            width: 20,
            formatter: function (value, row, index) {
                return index + 1;
            }
        },
        {
            checkbox: true,     // 显示一个勾选框
            align: 'center',    // 居中显示
            valign: 'middle',   // 上下居中
        }, {
            field: 'userName', // 返回json数据中的name
            title: '用户姓名',  // 表格表头显示文字
            align: 'center',
            valign: 'middle',
            sortable: true,
        }, {
            field: 'loginName',
            title: '用户登录名',
            align: 'center',
            valign: 'middle',
            sortable: true,
        },
    ],
    onLoadSuccess: function () {  //加载成功时执行
        console.info("加载成功");
    },
    onLoadError: function () {  //加载失败时执行
        console.info("加载数据失败");
    },
});


//隐藏显现
$("#hideShowSwitch").click(function () {
    if ($("#hideShowSwitch").attr("class") == "fa fa-chevron-down") {
        $("#hideShowSwitch").removeClass("fa fa-chevron-down").addClass("fa fa-chevron-up")
    }
    else {
        $("#hideShowSwitch").removeClass("fa fa-chevron-up").addClass("fa fa-chevron-down")
    }
    $("#hideShowDiv").slideToggle(500);
});