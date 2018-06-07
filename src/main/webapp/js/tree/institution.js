//树结构配置信息
var setting = {
    //不显示连接线
    view: {
        showLine: false
    },
    //回调函数
    callback: {
        onClick: clickInstitutionTree,
    }
};
//树结构节点信息
var treeNodes;

//初始化机构树
$(function () {
    $.ajax({
        url: 'institutionTree.ajax',
        type: 'post',
        dataType: 'json',
        success: function (data) {
            treeNodes = data;
            $.fn.zTree.init($("#institutionTree"), setting, treeNodes);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            // 状态码
            console.log(XMLHttpRequest.status);
            // 状态
            console.log(XMLHttpRequest.readyState);
            // 错误信息
            console.log(textStatus);
        },
    });
});


//定位某一个机构
function locateInstitution() {
    var institutionName = $("#institutionName-search").val();
    $.ajax({
        //数据的提交路径
        url: 'locateInstitution.ajax',
        //是否支持异步刷新，默认是true
        async: true,
        //数据的提交方式 ：get和post
        type: 'post',
        //服务器返回数据的类型，例如xml,String,Json等
        dataType: 'json',
        //需要提交的数据。这是json格式。也可以是已经拼接好的json数据，类似一个参数param。
        data: {
            institutionName: institutionName,
        },
        //请求成功后的回调函数
        success: function (data) {
            var treeObj = $.fn.zTree.getZTreeObj("institutionTree");
            var node = treeObj.getNodeByParam("id", data, null);
            treeObj.selectNode(node);
            clickInstitutionTree(event, '', node);
        },
        error: function (data) {
            alert("暂无该机构，请重新输入！");
        }
    });
}

//点击机构树，查询具体信息
function clickInstitutionTree(event, treeId, treeNode) {
    $.ajax({
        //数据的提交路径
        url: 'clickInstitutionTree.ajax',
        //是否支持异步刷新，默认是true
        async: true,
        //数据的提交方式 ：get和post
        type: 'post',
        //服务器返回数据的类型，例如xml,String,Json等
        dataType: 'json',
        //需要提交的数据。这是json格式。也可以是已经拼接好的json数据，类似一个参数param。
        data: {
            institutionID: treeNode.id,
        },
        //请求成功后的回调函数
        success: function (data) {
            $("#institutionName-show").val(data.institutionName);
            $("#parentInstitutionName-show").val(data.parentInstitutionName);
        },
    });
}

