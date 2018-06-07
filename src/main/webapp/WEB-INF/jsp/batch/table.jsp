<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="plugin/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="plugin/bootstrap-table/bootstrap-table.css">

    <link rel="stylesheet" href="css/common/widget_batch.css">
    <link rel="stylesheet" href="css/common/scrollbar_batch.css">
    <link rel="stylesheet" href="css/common/button.css">

    <link rel="stylesheet" href="css/batch/table.css">

</head>
<body>

<div class="panel">
    <div class="panel-heading">
        <span>查询条件</span>
        <i class="fa fa-chevron-down" id="hideShowSwitch"></i>
    </div>
    <div class="panel-body" id="hideShowDiv">
        <table class="queryContent">
            <tr>
                <td align="right" width="20%">用户姓名：</td>
                <td align="left" width="30%"><input type="text" id="userName-search" name="userName"/></td>
                <td align="right" width="20%">用户登录名：</td>
                <td align="left" width="30%"><input type="text" id="loginName-search" name="loginName"/></td>
            </tr>
            <tr>
                <td colspan="4" align="center" width="100%">
                    <button class="button_blue">清空</button>
                    <button class="button_blue" onclick="getTableUser()">查找</button>
                </td>
            </tr>
        </table>
    </div>
</div>

<div class="panel">
    <div class="panel-heading">
        <span>查询结果</span>
    </div>
    <div class="panel-body">
        <table id="tableUser" data-toggle="table">
        </table>
    </div>
</div>

<script src="js/jquery/jquery-3.2.1.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="plugin/bootstrap-table/bootstrap-table.js"></script>
<script src="plugin/bootstrap-table/bootstrap-table-zh-CN.js"></script>

<script src="js/batch/table.js"></script>

</body>
</html>
