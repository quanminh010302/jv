

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section class="container">
    <h1 class="text-center text-info mt-1">DANH SÁCH THU CHI</h1>

    <table class="table">
        <thead class="table-dark">
            <tr>
                <th>User</th>
                <th>Phiếu</th>
                <th>Mô tả</th>
                <th>Số tiền(VNĐ)</th>
                <th>Thời gian</th>


                <th></th>
            </tr>
        </thead>
        <tbody>                  
            <c:forEach items="${expenses}" var = "e">
                <tr>
                    <td>${e.userId.username}</td>
                    <td>${e.categoryId.name}</td>
                    <td>${e.description}</td>
                    <td>    
                        <c:choose>
                            <c:when test="${e.categoryId.name == 'Thu nhập'}">+${e.amount}</c:when>
                            <c:when test="${e.categoryId.name == 'Chi tiêu'}">-${e.amount}</c:when>
                            <c:otherwise>${e.amount}</c:otherwise>
                        </c:choose></td>
                    <td>${e.date}</td>




                    <td>
                        <a href="<c:url value="/expenses/${e.id}"/>" class="btn btn-success ">Cập nhật</a>
                        <c:url value="/api/expenses/${e.id}" var="apiDel"/>
                        <button class="btn btn-danger" onclick="del('${apiDel}',${e.id})" >Xóa</button>

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
<script src="<c:url value="/js/main.js"/>"></script>
