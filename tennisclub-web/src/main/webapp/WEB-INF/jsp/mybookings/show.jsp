<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:message var="title" key="mybookings.show.title"><fmt:param value="${user.name}"/></fmt:message>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">

	<div class="buttons">
		<form method="post" action="${pageContext.request.contextPath}/show/all/{user.id}">
	        <button type="submit" class="btn btn-primary">All</button>
	    </form>
	    <form method="post" action="${pageContext.request.contextPath}/show/lastweek/{user.id}">
	        <button type="submit" class="btn btn-primary">Last Week</button>
	    </form>
	    <form method="post" action="${pageContext.request.contextPath}/show/lastmonth/{user.id}">
	        <button type="submit" class="btn btn-primary">Last Month</button>
	    </form>
	    <form method="post" action="${pageContext.request.contextPath}/show/lastyear/{user.id}">
	        <button type="submit" class="btn btn-primary">Last Year</button>
	    </form>
	</div>

    <div class="row">
        <table class="table">
	        <thead>
	        <tr>
	            <th>id</th>
	            <th>idCourt</th>
	            <th>user1</th>
	            <th>user2</th>
	            <th>dateOfBooking</th>
	            <th>hourOfBooking</th>
	        </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${bookings}" var="booking">
	            <tr>
	                <td>${booking.id}</td>
	                
	                <td><c:out value="${booking.idCourt}"/></td>
	                <td><c:out value="${booking.user1}"/></td>
	                <td><c:out value="${booking.user2}"/></td>
	                <td><fmt:formatDate value="${booking.dateOfBooking}" pattern="yyyy-MM-dd"/></td>
	                <td><c:out value="${booking.hourOfBooking}"/></td>
	                <td>
	                    <my:a href="/booking/view/${booking.id}" class="btn btn-primary">View</my:a>
	                </td>
	                <td>
	                    <form method="post" action="${pageContext.request.contextPath}/booking/delete/${booking.id}">
	                        <button type="submit" class="btn btn-primary">Delete</button>
	                    </form>
	                </td>
	            </tr>
	        </c:forEach>
	        </tbody>
	    </table>
    </div>

</jsp:attribute>
</my:pagetemplate>