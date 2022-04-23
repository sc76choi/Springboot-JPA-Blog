<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!-- ------------------- <header> --------------------------------------- -->
<!-- <tiles:insertAttribute name="header" /> -->
<div class="container">
    <form>
        <input type="hidden" id="id" value="${ principal.user.id }" />
        <div class="form-group">
            <label for="userName">User Name:</label> 
            <input value="${ principal.user.username }" type="text" class="form-control" placeholder="Enter username" id="username" readonly>
        </div>
        <div class="form-group">
            <label for="password">Password:</label> 
            <input value="" type="password" class="form-control" placeholder="Enter password" id="password">
        </div>
        <div class="form-group">
            <label for="email">Email address:</label> 
            <input value="${ principal.user.email }" type="email" class="form-control" placeholder="Enter email" id="email">
        </div>
        <!-- <div class="form-group form-check">
            <label class="form-check-label"> <input class="form-check-input" type="checkbox"> Remember me
            </label>
        </div> -->
    </form>
    <button id="btn-update" class="btn btn-primary">회원수정완료</button>
</div>

<script type="application/javascript" src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
<!-- ------------------- <footer> --------------------------------------- -->
<!-- <tiles:insertAttribute name="footer" /> -->