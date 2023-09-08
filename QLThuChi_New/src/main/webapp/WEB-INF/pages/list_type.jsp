<%-- 
    Document   : list_type
    Created on : Sep 8, 2023, 6:26:00 PM
    Author     : MTriet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container">
    <h1 class="text-center text-info mt-1">DANH SÁCH DANH MỤC</h1>
    <a href="<c:url value="/type" />" class="btn btn-info">Thêm danh mục</a>

    <table class="table">
        <thead class="table-dark">
            <tr>

                <th>STT</th>
                <th>Tên danh mục</th>

                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${type}" var = "t">
                <tr>

                    <td>${t.id}</td>
                    <td>${t.name}</td>

                    <td>
                        <c:url value="/api/type/${t.id}" var = "apiDel" />
                        <a href="<c:url value="/type/${t.id}"/>" class="btn btn-success" ">Cập nhật </a>
                        <button class="btn btn-danger" onclick="del('${apiDel}',${t.id})" >Xóa</button>
                    </td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
    

    <c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="<c:url value="list_type" />">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="list_type" var="pageUrl">
                        <c:param name="page" value="${i}"></c:param>
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>
</section>
    <script src="<c:url value="/js/main.js"/>"></script> 