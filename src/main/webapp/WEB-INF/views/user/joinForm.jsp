<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!-- ------------------- <header> --------------------------------------- -->
<!-- <tiles:insertAttribute name="header" /> -->
<div class="container">
    <form>
        <div class="form-group">
            <label for="userName">User Name:</label> <input type="text" class="form-control" placeholder="Enter username" id="username">
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>
        <div class="form-group">
            <label for="email">Email address:</label> <input type="email" class="form-control" placeholder="Enter email" id="email">
        </div>
        <!-- <div class="form-group form-check">
            <label class="form-check-label"> <input class="form-check-input" type="checkbox"> Remember me
            </label>
        </div> -->
    </form>
    <button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>

<script type="application/javascript" src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
<!-- ------------------- <footer> --------------------------------------- -->
<!-- <tiles:insertAttribute name="footer" /> -->