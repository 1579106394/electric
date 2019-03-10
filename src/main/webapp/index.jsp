<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/Swiper/3.4.2/css/swiper.min.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>

    <script type="text/javascript">
        // ajax查询用户是否欠费，如果欠费就进行提醒
        $(function () {
            var url = '${pageContext.request.contextPath}/user/arrears.action'
            $.get(url, function (result) {
                if(result!=null) {
                    if(result.userMoney < 0) {
                        layer.open({
                            title: '欠费提醒',
                            content: '您已欠费，为不影响正常用电，请及时缴费！' //这里content是一个普通的String
                        });
                    }
                }
            })
        })
    </script>

</head>
<body>
<!-- 顶部开始 -->
<jsp:include page="/header.jsp"></jsp:include>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<div class="wrapper">
    <!-- 左侧菜单开始 -->
    <jsp:include page="/left.jsp"></jsp:include>
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
            <blockquote class="layui-elem-quote" style="color: #666666;">
                欢迎 ${sessionScope.user.userName} 进入电费管理系统
            </blockquote>
            <blockquote class="layui-elem-quote" style="color: #666666;">
                当前电费：${price.priceMoney} 元/度
            </blockquote>
            <c:if test="${meter.user.userMoney < 0}">
                <blockquote class="layui-elem-quote" style="color: red;">
                    您已欠费${-meter.user.userMoney}元，工作人员会在3个工作日内切断您的用电，为不影响您的用电，请及时缴费
                </blockquote>
            </c:if>


            <c:if test="${sessionScope.user.userFlag == 2}">
                <fieldset class="layui-elem-field layui-field-title site-title">
                    <legend><a name="default">欠费用户</a></legend>
                </fieldset>
                <table class="layui-table">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>账号</th>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>性别</th>
                        <th>手机号</th>
                        <th>欠费</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.userId}</td>
                            <td>${user.username}</td>
                            <td>${user.userName}</td>
                            <td>${user.userAge}</td>
                            <td>${user.userSex==1?"男":"女"}</td>
                            <td>${user.userPhone}</td>
                            <td>${-user.userMoney}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </c:if>

            <c:if test="${sessionScope.user.userFlag == 1}">
                <fieldset class="layui-elem-field layui-field-title site-title">
                    <legend><a name="default">我的电表</a></legend>
                </fieldset>
                <table class="layui-table">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>本月始码</th>
                        <th>当前止码</th>
                        <th>用电量</th>
                        <th>当前电费</th>
                        <th>电费余额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${meter.meterId}</td>
                        <td>${meter.user.userName}</td>
                        <td>${meter.meterStartNum}</td>
                        <td>${meter.meterCurrentNum}</td>
                        <td>${meter.meterNum}</td>
                        <td>${meter.meterMoney}</td>
                        <td>${meter.user.userMoney}</td>
                    </tr>
                    </tbody>
                </table>
            </c:if>
            <!-- 右侧内容框架，更改从这里结束 -->
        </div>
    </div>
    <!-- 右侧主体结束 -->
</div>
<!-- 中部结束 -->
<!-- 底部开始 -->
<jsp:include page="/footer.jsp"></jsp:include>
<!-- 底部结束 -->
<!-- 背景切换开始 -->
<jsp:include page="/bg.jsp"></jsp:include>
<!-- 背景切换结束 -->

</body>
</html>