<%-- 
    Document   : login
    Created on : Sep 9, 2023, 2:29:13 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/login" var="action" />
<form method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <input type="username" class="form-control" id="username" placeholder="Nhập username..." name="username">
        <label for="username">Tên đăng nhập</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <input type="password" class="form-control" id="pwd" placeholder="Nhập mật khẩu..." name="password">
        <label for="pwd">Mật khẩu</label>
    </div>
    
    <div class="form-floating mt-3 mb-3">
        <input type="submit" value="Đăng nhập" class="btn btn-danger" />
    </div>
</form>
