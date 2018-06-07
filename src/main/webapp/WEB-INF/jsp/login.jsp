<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <title>登录</title>

    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

    <script src="js/jquery/jquery-3.2.1.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>

    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <link rel="stylesheet" href="css/login.css">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" id="loginForm" action="/main.do" method="post">
                <span class="heading">
                    <img src="image/user/jobs.jpg" class="img-circle"/>
                </span>
                <div class="form-group">
                    <input type="text" class="form-control" name="userName" placeholder="用户名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" name="userPassword" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" name="rememberCheckbox" id="rememberCheckbox" name="check"/>
                        <label for="rememberCheckbox"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
                <span class="foot">
                    <div class="col-md-3">
                    </div>
                    <div class="col-md-2">
                        <img src="image/logo/QQ.png" class="img-rounded"/>
                    </div>
                    <div class="col-md-2">
                        <img src="image/logo/WeChat.png" class="img-rounded"/>
                    </div>
                    <div class="col-md-2">
                        <img src="image/logo/WeiBo.png" class="img-rounded"/>
                    </div>
                    <div class="col-md-3">
                    </div>
                </span>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<script>

    function loginaaaaa() {

        var loginName = $("#loginName").val();
        var password = $("#password").val();
        var rememberCheckbox = $("#rememberCheckbox").get(0).checked;

        $.ajax({
            //数据的提交路径
            url: 'main.do',
            //是否支持异步刷新，默认是true
            async: true,
            //数据的提交方式 ：get和post
            type: 'post',
            //服务器返回数据的类型，例如xml,String,Json等
            dataType: 'json',
            //需要提交的数据。这是json格式。也可以是已经拼接好的json数据，类似一个参数param。
            data: {
                loginName: loginName,
                password: password,
                rememberCheckbox: rememberCheckbox,
            },
            //请求成功后的回调函数
            success: function (data) {
                if (data.result) {
                    swal(data.message);
                } else {
                    swal(data.message);
                }
            },
            //请求失败后的回调函数
            failure: function (data) {
                swal(data.message);
            }
        });
    }

</script>