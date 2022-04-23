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
        <div class="card-body">
            <textarea class="form-control" rows="1" cols=""></textarea>
        </div>
        <div class="card-footer">
            <button class="btn btn-primary">등록</button>
        </div>
    </div>
    <br/>
    <div class="card">
        <div class="card-header">댓글 리스트</div>
        <ul id="comment--box" class="list-group">
            <li id="comment--1" class="list-group-item d-flex justify-content-between">
                <div>댓글 내용입니다.</div>
                <div class="d-flex">
                    <div class="font-italic">작성자 : sc &nbsp;</div>
                    <button  class="badge">삭제</button>
                </div>
            </li>
        </ul>
    </div>
</div>
<script type="application/javascript" src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
<!-- ------------------- <footer> --------------------------------------- -->
<%-- <tiles:insertAttribute name="footer" /> --%>