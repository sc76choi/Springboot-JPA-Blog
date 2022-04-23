<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ include file="../layout/header.jsp"%>
<!-- ------------------- <header> --------------------------------------- -->
<%-- <tiles:insertAttribute name="header" /> --%>
<div class="container">
    <form>
    <input type="hidden" id="id" value="${ board.id }">
        <div class="form-group">
            <input value="${ board.title }" type="text" class="form-control" placeholder="Enter title" id="title">
        </div>
        <div class="form-group">
            <textarea class="form-control summernote" rows="5" id="content">${ board.content }</textarea>
        </div>
    </form>
    <button id="btn-update" class="btn btn-primary">글수정 완료</button>
</div>
<script>
	$('.summernote').summernote({
		placeholder : 'Hello Bootstrap 5',
		tabsize : 2,
		height : 100
	});
</script>
<script type="application/javascript" src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
<!-- ------------------- <footer> --------------------------------------- -->
<%-- <tiles:insertAttribute name="footer" /> --%>