<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/Swiper/3.4.2/css/swiper.min.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">

    <script type="text/javascript">
        function list(p) {
            $("#currentPage").val(p);
            $("#staffForm").submit();
        }
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

            <form id="staffForm" class="layui-form xbs layui-form-pane"
                  action="${pageContext.request.contextPath}/user/userList.action" method="post">
                <input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"/>
                <div class="" style="text-align: center;">
                    <div class="layui-form-item" style="display: inline-block;">
                        <label class="layui-form-label xbs768">用户姓名</label>
                        <div class="layui-input-inline xbs768">
                            <input class="layui-input" name="params[userName]" value="${page.params.userName}"
                                   placeholder="用户姓名" id="LAY_demorange_s">
                        </div>
                        <div class="layui-input-inline" style="width:80px">
                            <button class="layui-btn" type="submit"><i
                                    class="layui-icon">&#xe615;</i></button>
                        </div>
                    </div>
                </div>
            </form>

            <xblock>
                <span class="x-right" style="line-height:40px">共有数据：${page.totalCount} 条</span></xblock>
            <table class="layui-table">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>账号</th>
                    <th>密码</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>手机号</th>
                    <th>剩余电费</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.list}" var="user">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.userName}</td>
                        <td>${user.userAge}</td>
                        <td>${user.userSex==1?"男":"女"}</td>
                        <td>${user.userPhone}</td>
                        <td>${user.userMoney}</td>
                        <td class="td-manage">
                            <a title="删除" href="javascript:;" onclick="deleteUser('${user.userId}')"
                               style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                            <a title="编辑"
                               href="${pageContext.request.contextPath}/user/toEdit.action?userId=${user.userId}"
                               style="text-decoration:none">
                                <i class="layui-icon">&#xe642;</i>
                            </a>
                            <a title="查看电表" href="javascript:;"
                               style="text-decoration:none" onclick="lookMeter('${user.userId}')">
                                <i class="layui-icon">&#xe615;</i>
                            </a>
                            <a title="预存电费" href="javascript:;"
                               style="text-decoration:none" onclick="addMoney('${user.userId}')">
                                <i class="layui-icon">&#xe65e;</i>
                            </a>
                            <a title="用电记录" href="javascript:;"
                               style="text-decoration:none" onclick="lookUse('${user.userId}')">
                                <i class="layui-icon">&#xe63c;</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div style="float: right;">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${page.currentPage == 1}">
                            <li>
                                <a class="disabled" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${page.currentPage != 1}">
                            <li>
                                <a href="javascript:void(0)" onclick="list(${page.currentPage - 1})"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach begin="1" end="${page.totalPage}" var="p">
                            <c:if test="${p == page.currentPage}">
                                <li class="active">
                                    <a href="javascript:void(0)">${p}</a>
                                </li>
                            </c:if>
                            <c:if test="${p != page.currentPage}">
                                <li>
                                    <a href="javascript:void(0)" onclick="list(${p})">${p}</a>
                                </li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${page.currentPage == page.totalPage}">
                            <li class="disabled">
                                <a aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${page.currentPage != page.totalPage}">
                            <li>
                                <a href="javascript:void(0)" onclick="list(${page.currentPage + 1})"
                                   aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                    </span>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- 右侧内容框架，更改从这里结束 -->
    </div>
</div>
<!-- 右侧主体结束 -->
</div>
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <jsp:include page="/footer.jsp"></jsp:include>
</div>
<!-- 底部结束 -->
<!-- 背景切换开始 -->
<jsp:include page="/bg.jsp"></jsp:include>
<!-- 背景切换结束 -->
<!-- 页面动态效果 -->
<script>
    /*删除*/
    function deleteUser(id) {
        layer.confirm('确认要删除吗？', function (index) {
            window.location.href = "${pageContext.request.contextPath}/user/deleteUser.action?userId=" + id
        });
    }

    /*预存电费*/
    function addMoney(id) {
        var content = `
            <div class="page-content">
            <div class="content">
            <form class="layui-form layui-form-pane"
            action="${pageContext.request.contextPath}/money/addMoney.action"
            method="post">
            <input type="hidden" name="user.userId" value="` + id + `"/>
            <div class="layui-form-item">
            <label for="L_staff_account" class="layui-form-label">
            金额
            </label>
            <div class="layui-input-inline">
            <input type="text" id="L_staff_account" name="MoneyMoney"
            required=""
            autocomplete="off" class="layui-input">
            </div>
            </div>
            <div class="layui-form-item">
            </label>
            <button class="layui-btn layui-btn-fluid" type="submit">
            存款
            </button>
            </div>
            </form>
            </div>
            </div>
            `

        layer.open({
            type: 1
            , title: '预存电费'
            , content: content //这里content是一个普通的String
        });
    }

    /*查看电表*/
    function lookMeter(id) {
        var params = {"userId": id}
        var url = '${pageContext.request.contextPath}/meter/lookMeter.action';
        $.post(url, params, function (data) {
            var content = '<table class="layui-table">' +
                '<thead>' +
                '   <tr>' +
                '       <th>电表号</th>' +
                '       <th>本月始码</th>' +
                '       <th>当前止码</th>' +
                '       <th>用电量</th>' +
                '       <th>当前电费</th>' +
                '   </tr>' +
                '</thead>' +
                '<tbody>' +
                '   <tr>' +
                '       <td>' + data.meterId + '</td>' +
                '       <td>' + data.meterStartNum + '</td>' +
                '       <td>' + data.meterCurrentNum + '</td>' +
                '       <td>' + data.meterNum + '</td>' +
                '       <td>' + data.meterMoney + '</td>' +
                '   </tr>' +
                '</tbody>' +
                '</table>'
            layer.open({
                type: 1
                , area: ['1000px', '500px']
                , content: content //这里content是一个普通的String
            });
        })
    }

    /*查看用电记录*/
    function lookUse(id) {
        var params = {"userId": id}
        var url = '${pageContext.request.contextPath}/use/lookUse.action';
        $.post(url, params, function (data) {
            console.log(data)
            var content = '<table class="layui-table">' +
                '<thead>' +
                '   <tr>' +
                '       <th>编号</th>' +
                '       <th>用户</th>' +
                '       <th>电费</th>' +
                '       <th>用电量</th>' +
                '       <th>月份</th>' +
                '   </tr>' +
                '</thead>' +
                '<tbody>'
            for (var i = 0; i < data.length; i++) {
                content += '   <tr>' +
                    '       <td>' + (i + 1) + '</td>' +
                    '       <td>' + data[i].user.userName + '</td>' +
                    '       <td>' + data[i].useMoney + '</td>' +
                    '       <td>' + data[i].useNumber + '</td>' +
                    '       <td>' + data[i].useTime + '</td>' +
                    '   </tr>'
            }

            content += '</tbody></table>'
            layer.open({
                type: 1
                ,title: '用电记录'
                , area: ['1000px', '500px']
                , content: content //这里content是一个普通的String
            });
        })
    }
</script>

</body>
</html>