<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Product Administration">
<jsp:attribute name="body">

    <form method="post" action="${pageContext.request.contextPath}/product/delete/${product.idBooking}">
        <button type="submit" class="btn btn-primary">Delete</button>
    </form>


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
            <tr>
               	<td>${booking.id}</td>
                <td><c:out value="${booking.idCourt}"/></td>
                <td><c:out value="${booking.user1}"/></td>
                <td><c:out value="${booking.user2}"/></td>
                <td><fmt:formatDate value="${booking.dateOfBooking}" pattern="yyyy-MM-dd"/></td>
                <td><c:out value="${booking.hourOfBooking}"/></td>            
            </tr>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>