<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate>
<jsp:attribute name="body">

    <form:form class="form-horizontal" role="form" method="post">
        
        <div class="form-group">
            <label class="control-label col-sm-2" for="usernameInput">Username:</label>
            <div class="col-sm-10">
                <form:input type="text" class="form-control" path="username" id="usernameInput" placeholder="Enter Mail"/>
                <form:errors path="username" cssClass="help-block"/>
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-10">
                <form:input type="password" path="password" class="form-control" id="password"
                            placeholder="Enter password"/>
                <form:errors path="password" cssClass="help-block"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </div>
    </form:form>
        
        
    <br /><hr><br />
    <h1>Credentials</h1>
    

</jsp:attribute>
</my:pagetemplate>