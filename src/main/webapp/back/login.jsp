<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登陆</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="https://ajax.aspnetcdn.com/ajax/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="statics/css/style.default.css" id="theme-stylesheet">
</head>
<body>
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>欢迎登录</h1>
                            </div>
                            <p>班级管理系统</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form method="post"  class="form-validate" id="loginFrom">
                                <div class="form-group">
                                    <input id="login-username" type="text" name="name" required data-msg="请输入用户名" placeholder="用户名" value="admin" class="input-material">
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="password" required data-msg="请输入密码" placeholder="密码" class="input-material">
                                </div>
                                <div class="form-group">
                                    <input id="login-code" style="width: 60%;float: left" type="text" name="code" required data-msg="请输入验证码" placeholder="验证码" class="input-material">
                                    <img src="${pageContext.request.contextPath}/user/getImage" id="image">
                                </div>
                                
                                
                                <button id="logBtn" type="button" class="btn btn-primary">登录</button>
                                <div style="margin-top: -40px;">
                                    <!-- <input type="checkbox"  id="check1"/>&nbsp;<span>记住密码</span>
                                    <input type="checkbox" id="check2"/>&nbsp;<span>自动登录</span> -->
                                    <div class="custom-control custom-checkbox " style="float: right;">
                                        <input type="checkbox" class="custom-control-input" id="check2" >
                                        <label class="custom-control-label" for="check2">自动登录</label>
                                    </div>
                                    <div class="custom-control custom-checkbox " style="float: right;">
                                        <input type="checkbox" class="custom-control-input" id="check1" >
                                        <label class="custom-control-label" for="check1">记住密码&nbsp;&nbsp;</label>
                                    </div>
                                </div>
                            </form>
                            <br>
                            <br>
                            <small>没有账号?</small><a href="regist.jsp" class="signup">&nbsp;注册</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<!-- JavaScript files-->
<script src="statics/js/jquery.min.js"></script>
<script src="statics/layui/layui.js"></script>
<script src="statics/js/bootstrap.min.js"></script>
<script src="statics/vendor/jquery-validation/jquery.validate.min.js"></script><!--表单验证-->
<script>


    $(function () {
        // 绑定登陆按钮的单击事件
        $("#logBtn").click(function () {
            $.post("${pageContext.request.contextPath}/user/login",$("#loginFrom").serialize(),function (res) {
                if (res.statue) {
                    layui.use("layer",function () {
                        layer.alert(res.msg+",点击确定跳转至主页", {
                            skin: 'layui-layer-molv' //样式类名
                            ,closeBtn: 0
                        });

                        // var layer=layui.layer;
                        // layer.alert(res.msg+",点击确定跳转至主页");
                    });
                    location.href = "${pageContext.request.contextPath}/back/index.jsp";

                }else(
                    layui.use("layer",function () {
                        var layer=layui.layer;
                        layer.msg(res.msg, {icon: 5});
                    })
                )
            })
        });

        //更换验证码
        $("#image").click(function () {
            $("#image").attr("src","${pageContext.request.contextPath}/user/getImage");
        })
    });


    $(function(){

        /*判断上次是否勾选记住密码和自动登录*/
        var check1s=localStorage.getItem("check1");
        var check2s=localStorage.getItem("check2");
        var oldName=localStorage.getItem("userName");
        var oldPass=localStorage.getItem("passWord");
        if(check1s=="true"){
            $("#login-username").val(oldName);
            $("#login-password").val(oldPass);
            $("#check1").prop('checked',true);
        }else{
            $("#login-username").val('');
            $("#login-password").val('');
            $("#check1").prop('checked',false);
        }
        if(check2s=="true"){
            $("#check2").prop('checked',true);
            $("#loginFrom").submit();
            //location="https://www.baidu.com?userName="+oldName+"&passWord="+oldPass;//添加退出当前账号功能
        }else{
            $("#check2").prop('checked',false);
        }
        $("#login").click(function(){
            var userName=$("#login-username").val();
            var passWord=$("#login-password").val();
            /*获取当前输入的账号密码*/
            localStorage.setItem("userName",userName)
            localStorage.setItem("passWord",passWord)
            /*获取记住密码  自动登录的 checkbox的值*/
            var check1 = $("#check1").prop('checked');
            var check2 = $('#check2').prop('checked');
            localStorage.setItem("check1",check1);
            localStorage.setItem("check2",check2);
        })

        /*$("#check2").click(function(){
            var flag=$('#check2').prop('checked');
            if(flag){
                var userName=$("#login-username").val();
                var passWord=$("#login-password").val();
                $.ajax({
                    type:"post",
                    url:"http://localhost:8080/powers/pow/regUsers",
                    data:{"userName":userName,"passWord":passWord},
                    async:true,
                    success:function(res){
                        alert(res);
                    }
                });
            }
        })*/
    })
</script>