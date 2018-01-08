<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="List of courts">
<jsp:attribute name="body">

    <table class="table">
  		<thead>
	   <tr>
            <th>Court's id</th>
            <th>type of the court</th>
            <th>longitude</th>
            <th>latitude</th>
            
        </tr>
        </thead>  
        
        <tbody>
        <c:forEach items="${courts}" var="court">
            <tr>
                <td>${court.idCourt}</td>
                <td><c:out value="${court.type}"/></td>
                <td><c:out value= "${court.longitude}"/></td>
                <td><c:out value= "${court.latitude}"/></td>
                <td>
                    <form method="post" action="${pageContext.request.contextPath}/court/delete/${court.idCourt}">
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </form>
                    
                <td>
                    <my:a href="/court/edit/${court.idCourt}" class="btn btn-primary">Edit</my:a>
                </td>
                </td>
            </tr>
        </c:forEach>
       </tbody>
    </table>
     <my:a href="/court/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        Create a new Court
    </my:a>


</jsp:attribute>
</my:pagetemplate>