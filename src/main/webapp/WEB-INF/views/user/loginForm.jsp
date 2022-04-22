<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ include file="../layout/header.jsp"%> --%>
<!-- ------------------- <header> --------------------------------------- -->
<tiles:insertAttribute name="header" />
<div class="container">
    <form action="#" method="POST">
        <div class="form-group">
            <label for="userName">User Name:</label> 
            <input type="text" class="form-control" placeholder="Enter username" name="userName" id="userName">
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label> 
            <input type="password" class="form-control" placeholder="Enter password" name="password" id="password">
        </div>
        <div class="form-group form-check">
            <label class="form-check-label"> 
            <input class="form-check-input" type="checkbox" name="remember"> Remember me
            </label>
        </div>
        <button id="btn-login" class="btn btn-primary">로그인</button>
    </form>
</div>
<!-- <script src="/js/user.js"></script> -->
<%-- <%@ include file="../layout/footer.jsp"%> --%>
<!-- ------------------- <footer> --------------------------------------- -->
<tiles:insertAttribute name="footer" />