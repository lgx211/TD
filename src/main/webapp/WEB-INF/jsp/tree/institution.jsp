<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="plugin/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="css/tree/institution.css">
    <link rel="stylesheet" href="css/common/widget_tree.css">
    <link rel="stylesheet" href="css/common/button.css">

    <link rel="stylesheet" href="plugin/zTree/metroStyle/metroStyle.css">

    <script src="js/jquery/jquery-3.2.1.js"></script>
    <script src="plugin/zTree/js/jquery.ztree.core.js"></script>
    <script src="js/tree/institution.js"></script>

    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


</head>
<body>
<!--左侧布局开始-->
<div class="left">
    <div class="title">
        <i class="fa fa-search-plus"></i>
        <h5>机构树定位显示</h5>
    </div>
    <div class="score-content">
        <ul id="institutionTree" class="ztree"></ul>
    </div>
</div>
<!--左下侧布局结束-->
</div>
<!--左侧布局结束-->

<div class="right">
    <div class="right-top">
        <div class="title">
            <i class="fa fa-search"></i>
            <h5>机构树查询条件</h5>
        </div>
        <div class="fixed-content">
            <input class="search-text" id="institutionName-search" type="text" placeholder="搜索从这里开始...">
            <button class="search-icon" onclick="locateInstitution()"><i class="fa fa-search"></i></button>
        </div>
    </div>
    <div class="right-bottom">
        <div class="title">
            <i class="fa fa-edit"></i>
            <h5>机构树功能操作</h5>
        </div>
        <div class="score-content">
            <table class="showContent">
                <tr>
                    <td align="right" width="30%">机构名称：</td>
                    <td align="left" width="70%"><input type="text" id="institutionName-show" name=""/></td>
                </tr>
                <tr>
                    <td align="right" width="30%">父机构名称：</td>
                    <td align="left" width="70%"><input type="text" id="parentInstitutionName-show" name=""/></td>
                </tr>
                <tr>
                    <td align="right" width="30%"></td>
                    <td align="left" width="70%">
                        <button class="button_blue">添加</button>
                        <button class="button_blue">修改</button>
                        <button class="button_blue">删除</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
