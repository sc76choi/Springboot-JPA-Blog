<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ include file="../layout/header.jsp"%>
<!-- ------------------- <header> --------------------------------------- -->
<%-- <tiles:insertAttribute name="header" /> --%>
<div class="container">
    <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
    <button id="btn-upadte" class="btn btn-warning">수정</button>
    <button id="btn-delete" class="btn btn-danger">삭제</button>
    <hr/>
    <div class="form-group">
        <h3>${ board.title }</h3>
    </div>
    <hr/>
    <div class="form-group">
        <div>
            ${ board.content }
        </div>
    </div>
    <hr/>
</div>
<script type="application/javascript" src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
<!-- ------------------- <footer> --------------------------------------- -->
<%-- <tiles:insertAttribute name="footer" /> --%>