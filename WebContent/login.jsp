<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>dwCms后台管理系统-登录</title>
    <link rel="stylesheet" type="text/css" href="./layui/css/layui.css" media="all" />
    <link rel="stylesheet" type="text/css" href="./css/login.css" />
</head>
<body class="beg-login-bg">
    <div class="beg-login-box">
        <header>
            <h1>dwCms后台管理系统</h1>
        </header>
        <div class="beg-login-main">
            <form action="loginServlet" class="layui-form" method="post">
                <div class="layui-form-item">
                    <label class="beg-login-icon">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
                    <input type="text" lay-verify="required" name="name" autocomplete="off" placeholder="这里输入账号" class="layui-input" lay-verType="tips">
                </div>
                <div class="layui-form-item">
                    <label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
                    <input type="password" lay-verify="required" name="password" autocomplete="off" placeholder="这里输入密码" class="layui-input" lay-verType="tips">
                </div>
                <div class="layui-form-item">
                    <div class="beg-pull">
                        <button type="button" class="layui-btn layui-btn-normal" style="width:100%;" lay-submit lay-filter="formDemo">
                            登　　录
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <footer>
            <p>power by dw © </p>
        </footer>
    </div>
    <script type="text/javascript" src="./js/jquery.min.js"></script>
    <script type="text/javascript" src="./layui/layui.js"></script>
    <script type="text/javascript" src="./js/login.js"></script>
</body>
</html>