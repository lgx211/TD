<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="plugin/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="css/tree/authority.css">
    <link rel="stylesheet" href="css/common/widget_tree.css">
    <link rel="stylesheet" href="plugin/zTree/metroStyle/metroStyle.css">

    <script src="js/jquery/jquery-3.2.1.js"></script>
    <script src="plugin/zTree/js/jquery.ztree.core.js"></script>
    <script src="plugin/zTree/js/jquery.ztree.excheck.js"></script>
    <script src="js/tree/authority.js"></script>

</head>
<body>
<!--左侧布局开始-->
<div class="left">
    <div class="title">
        <i class="fa fa-user"></i>
        <h5>用户树详细信息</h5>
    </div>
    <div class="score-content">
        <ul id="userTree" class="ztree"></ul>
    </div>
</div>
<!--左下侧布局结束-->
</div>
<!--左侧布局结束-->

<div class="right">
    <div class="title">
        <i class="fa fa-low-vision"></i>
        <h5>权限树详细信息</h5>
    </div>
    <div class="score-content">
        <ul id="authorityTree" class="ztree"></ul>
    </div>
</div>
</body>
</html>
