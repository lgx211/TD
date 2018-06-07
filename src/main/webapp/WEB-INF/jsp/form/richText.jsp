<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>

    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="plugin/summernote/summernote.css"/>

    <link type="text/css" rel="stylesheet" href="css/form/richText.css"/>
    <link rel="stylesheet" href="css/common/button.css">

</head>
<body>
<div class="richText">
    <div id="summernote-write" name="summernote-write">
    </div>
</div>

<div class="operate">
    <button class="button_blue" onclick="summernoteWrite()">写入</button>
    <button class="button_blue" onclick="summernoteRead()">读取</button>
</div>

<div class="richText">
    <div id="summernote-read" name="summernote-read" >
    </div>
</div>

<script type="text/javascript" src="js/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="plugin/summernote/summernote.js"></script>
<script type="text/javascript" src="plugin/summernote/summernote-zh-CN.js"></script>

<script type="text/javascript" src="js/form/richText.js"></script>

</body>
</html>
