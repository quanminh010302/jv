<%-- 
    Document   : user
    Created on : Sep 8, 2023, 1:55:45 AM
    Author     : MTriet
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form method="post" modelAttribute="user">
    <section class="container">
        <h1 class="text-center text-info mt-1">DANH SÁCH NGƯỜI DÙNG</h1>
        
        <table class="table">
            <thead class="table-dark">
                <tr>

                    <th>Tên đăng nhập</th>
                    <th>Tên</th>
                    <th>Họ</th>
                    <th>Email</th>
                    <th>Cấp bậc</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var = "u">
                    <tr>

                        <td>${u.username}</td>
                        <td>${u.firstname}</td>
                        <td>${u.latename}</td>
                        <td>${u.email}</td>
                        <td>${u.role}</td>
                        <td>
                            <button href="#" class="btn btn-success" ">Xem phiếu </button>
                            <button class="btn btn-danger" >Xóa</button>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <c:if test="${counter > 1}">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="${action}">All</a></li>
                    <c:forEach begin="1" end="${counter}" var="i">
                        <c:url value="/" var="pageUrl">
                            <c:param name="page" value="${i}"></c:param>
                        </c:url>
                    <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                    </c:forEach>
            </ul>
        </c:if>
    </section>
</form:form>

<script src="<c:url value="/js/main.js"/>"></script>