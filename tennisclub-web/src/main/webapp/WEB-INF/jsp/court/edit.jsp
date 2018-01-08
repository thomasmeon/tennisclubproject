<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Add a new court">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/court/edit"
               modelAttribute="courtEdit" cssClass="form-horizontal">
      
            <div class="form-group">
	            <form:label path="type" cssClass="col-sm-2 control-label"> Type of the court </form:label>
	            <div class="col-sm-10">
	                <form:select path="type" cssClass="form-control">
	                    <c:forEach items="${courtType}" var="t">
	                        <form:option value="${t}">${t}</form:option>
	                    </c:forEach>
	                </form:select>
	                <form:errors path="type" cssClass="error"/>
	            </div>
       		</div>
       		
       		<div class="form-group">
	            <form:label path="status" cssClass="col-sm-2 control-label"> Status of the court </form:label>
	            <div class="col-sm-10">
	                <form:select path="status" cssClass="form-control">
	                    <c:forEach items="${status}" var="s">
	                        <form:option value="${s}">${s}</form:option>
	                    </c:forEach>
	                </form:select>
	                <form:errors path="status" cssClass="error"/>
	            </div>
       		</div>
        </div>
        <button class="btn btn-primary" type="submit">Create Court</button>
    </form:form>

</jsp:attribute>
</my:pagetemplate>