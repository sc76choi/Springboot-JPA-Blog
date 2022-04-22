<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ include file="../layout/header.jsp"%>
<!-- ------------------- <header> --------------------------------------- -->
<%-- <tiles:insertAttribute name="header" /> --%>
<div class="container">
    <form>
        <div class="form-group">
            <label for="userName">Title:</label> <input type="text" class="form-control" placeholder="Enter title" id="title">
        </div>
        <div class="form-group">
            <label for="content">content:</label>
            <textarea class="form-control summernote" rows="5" id="content"></textarea>
        </div>
    </form>
    <button id="btn-board-save" class="btn btn-primary">글쓰기 완료</button>
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