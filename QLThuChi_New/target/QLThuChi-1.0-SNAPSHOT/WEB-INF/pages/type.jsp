<%-- 
    Document   : type
    Created on : Sep 8, 2023, 12:46:28 PM
    Author     : MTriet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1 class="text-center text-info mt-1">DANH MỤC THU CHI</h1>
<c:url value="/type" var="action" />
<form:form method="post" action="${action}"  modelAttribute="type"  class="form-inline mb-3">

    <form:errors path="name" element="div" cssClass="text-danger"/>
    <form:hidden path="id"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name" id="name" placeholder="Nhập danh mục" />
        <label for="name">Nhập danh mục mới</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="categories" name="categories" path="categoryId">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${c.id == type.categoryId.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>

        <label for="sel1" class="form-label">Chọn phiếu:</label>
    </div>
    <div>
        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${type.id == null}">Thêm danh mục</c:when>
                <c:otherwise>Cập nhật danh mục</c:otherwise>
            </c:choose>
        </button>
    </div>
    <form:hidden path="id"/>
</form:form>




