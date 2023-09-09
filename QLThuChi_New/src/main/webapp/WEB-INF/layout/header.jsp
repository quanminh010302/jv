<%-- 
    Document   : header
    Created on : Sep 8, 2023, 1:40:43 AM
    Author     : MTriet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">QUẢN LÝ THU CHI</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <c:url value="/" var="homeUrl" />
                    <a class="nav-link" href="${homeUrl}">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/user"/>">User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/list_type"/>">Danh mục</a>
                </li>
                <c:forEach items="${categories}" var="c">
                    <c:url value="/" var="searchUrl">
                        <c:param name="cateId" value="${c.id}"></c:param>
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${searchUrl}">${c.name}</a>
                    </li>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.name != null}">
                            <li class="nav-item">

                                <a class="nav-link" href="<c:url value="/"/>">${pageContext.request.userPrincipal.name}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">

                                <a class="nav-link" href="<c:url value="/login"/>">Đăng Nhập</a>
                            </li>
                        </c:otherwise>
                    </c:choose>



                
            </ul>
            <c:url value="/" var="action"/>
            <form class="d-flex" action="${action}">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ tìm kiếm">
                <input class="form-control me-2" type="date" name="fromDate" placeholder="Từ ngày">
                <input class="form-control me-2" type="date" name="toDate" placeholder="Đến ngày">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>

        </div>
    </div>
</nav>
