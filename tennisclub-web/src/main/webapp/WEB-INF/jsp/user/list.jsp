<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Users">
<jsp:attribute name="body">

    <table class="table">
        <caption>Users</caption>
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>surname</th>
            <th>mail</th>
            <th>phone</th>
            <th>dateOfBirth</th>
            <th>Admin?</th>
            <th>Teacher?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.surname}"/></td>
                <td><c:out value="${user.mail}"/></td>
                <td><c:out value="${user.phone}"/></td>
                <td><fmt:formatDate value="${user.dateOfBirth}" pattern="yyyy-MM-dd"/></td>
                <td>
                 <c:choose>
                    <c:when test="${user.admin}">
                        <span class="glyphicon glyphicon-ok"> </span>
                    </c:when>
                    <c:otherwise>
                        <span class="glyphicon glyphicon-remove"> </span>
                    </c:otherwise>
                    </c:choose>
            	</td>
            	<td>
                 <c:choose>
                    <c:when test="${user.teacher}">
                        <span class="glyphicon glyphicon-ok"> </span>
                    </c:when>
                    <c:otherwise>
                        <span class="glyphicon glyphicon-remove"> </span>
                    </c:otherwise>
                    </c:choose>
            	</td>
                <td>
                    <my:a href="/user/stats/${user.id}" class="btn btn-primary">Details</my:a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>