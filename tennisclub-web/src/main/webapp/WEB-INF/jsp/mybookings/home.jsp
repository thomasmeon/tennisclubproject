<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:message var="title" key="mybookings.show.title"><fmt:param value="${user.name}"/></fmt:message>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">

	<p class="lead">Welcome to your personnal page, click on the buttons below to see your bookings :</p>
	<div class="btn-group" role="group" aria-label="filter">
        <my:a href="/mybookings/show/all/${authenticatedUser.id}" class="btn btn-default ${filter=='all'?'active':''}">All</my:a>
        <my:a href="/mybookings/show/lastweek/${authenticatedUser.id}" class="btn btn-default ${filter=='lastweek'?'active':''}">Last Week</my:a>
        <my:a href="/mybookings/show/lastmonth/${authenticatedUser.id}" class="btn btn-default ${filter=='lastmonth'?'active':''}">Last Month</my:a>
        <my:a href="/mybookings/show/lastyear/${authenticatedUser.id}" class="btn btn-default ${filter=='lastyear'?'active':''}">Last Year</my:a>
    </div>

</jsp:attribute>
</my:pagetemplate>