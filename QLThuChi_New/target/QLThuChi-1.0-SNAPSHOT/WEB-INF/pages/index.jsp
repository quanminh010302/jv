

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản Lý Thu Chi</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">QUẢN LÝ THU CHI</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Danh muc cua phieu</a>
                        </li>
                        <c:forEach items="${categories}" var="c">
                            <c:url value="/" var="searchUrl">
                                <c:param name="cateId" value="${c.id}"></c:param>
                            </c:url>
                            <li class="nav-item">
                                <a class="nav-link" href="${searchUrl}">${c.name}</a>
                            </li>
                        </c:forEach>
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
        <section class="container">
            <h1 class="text-center text-info mt-1">DANH SÁCH NGƯỜI DÙNG</h1>
            <button class="btn btn-info">Thêm thu nhập/chi tiêu</button>
            <table class="table">
                <thead class="table-dark">
                    <tr>
                        <th>STT</th>
                        <th>Tên đăng nhập</th>
                        <th>Mật khẩu</th>
                        <th>Email</th>
                        <th>Cấp bậc</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var = "u">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.username}</td>
                            <td>${u.password}</td>
                            <td>${u.email}</td>
                            <td>${u.role}</td>
                            <td>
                                <a href="#" class="btn btn-success">Cập nhật</a>
                                <button class="btn btn-danger">Xóa</button>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </section>
    </body>
</html>
