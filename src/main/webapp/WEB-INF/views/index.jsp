<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- ------------------- <header> --------------------------------------- -->
<tiles:insertAttribute name="header" />
<div class="container">
<c:forEach var="board" items="${boards.content}">
    <div class="card m-2">
        <!--  <img class="card-img-top" src="img_avatar1.png" alt="Card image"> -->
        <div class="card-body">
            <h4 class="card-title">${board.title}</h4>
            <a href="#" class="btn btn-primary">상세 보기</a>
        </div>
    </div>
</c:forEach>

<ul class="pagination justify-content-center">
    <c:choose>
        <c:when test="${ boards.first }">
            <li class="page-item disabled"><a class="page-link" href="?page=${ boards.number - 1 }">Previous</a></li>
        </c:when>
        <c:otherwise>
            <li class="page-item"><a class="page-link" href="?page=${ boards.number - 1 }">Previous</a></li>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${ boards.last }">
            <li class="page-item disabled"><a class="page-link" href="?page=${ boards.number + 1 }">Next</a></li>
        </c:when>
        <c:otherwise>
            <li class="page-item"><a class="page-link" href="?page=${ boards.number + 1 }">Next</a></li>
        </c:otherwise>
    </c:choose>
</ul>

</div>
<!-- ------------------- <footer> --------------------------------------- -->
<tiles:insertAttribute name="footer" />