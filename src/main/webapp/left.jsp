<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li class="list" current>
                <a href="${pageContext.request.contextPath}/index.action">
                    <i class="iconfont">&#xe761;</i>
                    控制台
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
            </li>
            <li class="list">
                <a href="javascript:;">
                    <i class="iconfont">&#xe6a3;</i>
                    用户管理
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu" style="display:none">
                    <c:if test="${sessionScope.user.userFlag==2}">
                        <li>
                            <a href="${pageContext.request.contextPath}/user/user-add.jsp">
                                <i class="iconfont">&#xe6a7;</i>
                                新增用户
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/user/userList.action">
                                <i class="iconfont">&#xe6a7;</i>
                                用户列表
                            </a>
                        </li>
                    </c:if>

                    <li>
                        <a href="${pageContext.request.contextPath}/user/myUser.action">
                            <i class="iconfont">&#xe6a7;</i>
                            个人信息
                        </a>
                    </li>
                </ul>
            </li>
            <li class="list">
                <a href="javascript:;">
                    <i class="iconfont">&#xe6a3;</i>
                    电费管理
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu" style="display:none">
                    <c:if test="${sessionScope.user.userFlag==1}">
                        <li>
                            <a href="${pageContext.request.contextPath}/meter/myMeter.action">
                                <i class="iconfont">&#xe6a7;</i>
                                我的电费
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/money/recharge.jsp">
                                <i class="iconfont">&#xe6a7;</i>
                                电费充值
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user.userFlag==2}">
                        <li>
                            <a href="${pageContext.request.contextPath}/price/price-add.jsp">
                                <i class="iconfont">&#xe6a7;</i>
                                发布电价
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/price/priceList.action">
                                <i class="iconfont">&#xe6a7;</i>
                                电价记录
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <a href="${pageContext.request.contextPath}/money/moneyList.action">
                            <i class="iconfont">&#xe6a7;</i>
                            缴费记录
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/use/useList.action">
                            <i class="iconfont">&#xe6a7;</i>
                            用电记录
                        </a>
                    </li>
                </ul>
            </li>
            <li class="list">
                <a href="javascript:;">
                    <i class="iconfont">&#xe6a3;</i>
                    系统管理
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu" style="display:none">
                    <c:if test="${sessionScope.user.userFlag==1}">
                        <li>
                            <a href="${pageContext.request.contextPath}/comment/comment-add.jsp">
                                <i class="iconfont">&#xe6a7;</i>
                                信息反馈
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user.userFlag==2}">
                        <li>
                            <a href="${pageContext.request.contextPath}/comment/commentList.action">
                                <i class="iconfont">&#xe6a7;</i>
                                用户反馈
                            </a>
                        </li>
                    </c:if>
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- 左侧菜单结束 -->