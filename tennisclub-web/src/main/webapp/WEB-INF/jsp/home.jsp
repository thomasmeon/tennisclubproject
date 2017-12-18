<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate>
<jsp:attribute name="body">

    <div class="jumbotron">
        <h1>Welcome to Tennis Club !</h1>
        <p class="lead">On this website, we can book a court, have your statistics, and more :). </p>
        <p><a class="btn btn-lg btn-success" href="${pageContext.request.contextPath}/mybookings/home"
              role="button">Go Booking</a></p>
    </div>

</jsp:attribute>
</my:pagetemplate>
