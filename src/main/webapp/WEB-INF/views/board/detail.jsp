<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ include file="../layout/header.jsp"%>
<!-- ------------------- <header> --------------------------------------- -->
<%-- <tiles:insertAttribute name="header" /> --%>
<div class="container">
    <button id="btn-board-list" class="btn btn-secondary" onclick="href='/'">돌아가기</button>
    <c:if test="${ board.user.id == principal.user.id }">
        <!-- <button id="btn-upadte" class="btn btn-warning">수정</button> -->
        <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
        <button id="btn-delete" class="btn btn-danger">삭제</button>
    </c:if>
    <hr />
    <div>
        글번호 : <span id="id">${ board.id }</span> 작성자 : <span id="id">${ board.user.username }</span>
    </div>
    <hr />
    <div class="form-group">
        <h3>${ board.title }</h3>
    </div>
    <hr />
    <div class="form-group">
        <div>${ board.content }</div>
    </div>
    <hr />

    <div class="card">
        <form>
            <input type="hidden" id="userId" value="${ principal.user.id }" />
            <input type="hidden" id="boardId" value="${ board.id }" />
            <div class="card-body">
                <textarea id="reply-content" class="form-control" rows="1" cols=""></textarea>
            </div>
            <div class="card-footer">
            </div>
            <button id="btn-reply-save" type="button" class="btn btn-primary">등록</button>
        </form>
    </div>
    <br/>
    <div class="card">
        <div class="card-header">댓글 리스트</div>
        <ul id="reply--box" class="list-group">
            <c:forEach var="reply" items="${ board.replys }">
                <li id="reply--1" class="list-group-item d-flex justify-content-between">
                    <div>${ reply.content }</div>
                    <div class="d-flex">
                        <div class="font-italic">작성자 : ${ reply.user.username } &nbsp;</div>
                        <button  class="badge">삭제</button>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<script type="application/javascript" src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
<!-- ------------------- <footer> --------------------------------------- -->
<%-- <tiles:insertAttribute name="footer" /> --%>