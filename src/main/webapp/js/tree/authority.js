//用户树结构配置信息
var userSetting = {
    //不显示连接线
    view: {
        showLine: false
    },
    //回调函数
    callback: {
        onClick: clickUserTree,
    }
};
//用户树结构节点信息
var userTreeNodes;

//权限树结构配置信息
var authoritySetting = {
    //不显示连接线
    view: {
        showLine: false
    },
    //显示CheckBox
    check: {
        enable: true
    },
};
//权限树结构节点信息
var authorityTreeNodes;

//初始化树
$(function () {
    //用户树
    $.ajax({
        url: 'userTree.ajax',
        type: 'post',
        dataType: 'json',
        success: function (data) {
            userTreeNodes = data;
            $.fn.zTree.init($("#userTree"), userSetting, userTreeNodes);
        },
    });
    //权限树
    getAuthorityTree();
});

//点击用户树节点
function clickUserTree(event, treeId, treeNode) {
    //如果点击的是用户
    if (treeNode.id > 0) {
        getAuthorityTree(treeNode.id);
    } else {
        alert("请点击用户，以查看其对应的权限");
    }
}

//加载权限树
function getAuthorityTree(userID) {
//权限树
    $.ajax({
        url: 'authorityTree.ajax',
        type: 'post',
        dataType: 'json',
        data: {
            userID: userID,
        },
        success: function (data) {
            authorityTreeNodes = data;
            $.fn.zTree.init($("#authorityTree"), authoritySetting, authorityTreeNodes);
        },
    });

}