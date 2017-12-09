<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Date,java.text.SimpleDateFormat,java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>

<my:pagetemplate title="New product">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/product/create"
               modelAttribute="productCreate" cssClass="form-horizontal">
        <div class="form-group">
            <form:label path="courtId" cssClass="col-sm-2 control-label">Court</form:label>
            <div class="col-sm-10">
                <form:select path="courtId" cssClass="form-control">
                    <c:forEach items="${courts}" var="c">
                        <form:option value="${c.id}">${c.id} ${c.type}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="courtId" cssClass="error"/></p>
            </div>
        </div>
        <div class="form-group">
            <form:label path="userId" cssClass="col-sm-2 control-label">User 1</form:label>
            <div class="col-sm-10">
                <form:select path="userId" cssClass="form-control">
                    <c:forEach items="${users}" var="u">
                        <form:option value="${u.id}">${u.mail}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="userId" cssClass="error"/></p>
            </div>
        </div>
        <div class="form-group">
            <form:label path="userId" cssClass="col-sm-2 control-label">User 2</form:label>
            <div class="col-sm-10">
                <form:select path="userId" cssClass="form-control">
                    <c:forEach items="${users}" var="u">
                        <form:option value="${u.id}">${u.mail}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="userId" cssClass="error"/></p>
            </div>
        </div>
        <div class="form-group">
            <form:label path="name" cssClass="col-sm-2 control-label">Date</form:label>
            <div class="col-sm-10">
                <form:input type="date" path="dateTemp" cssClass="form-control"/>
                <%
					String dateStr = request.getParameter("dateTemp");
					SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
					Date dateOfBooking = formater.parse(dateStr);         
                %>
            </div>
        </div>
        
        <div class="form-group">
            <form:label path="hourOfBookingId" cssClass="col-sm-2 control-label">Hour of Booking</form:label>
            <div class="col-sm-10">
                <form:select path="hourOfBookingId" cssClass="form-control">
                    <c:forEach items="${hourOfBookings}" var="h">
                        <form:option value="${c.id}">${h}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="hourOfBookingId" cssClass="error"/></p>
            </div>
        </div>

        <button class="btn btn-primary" type="submit">Create product</button>
    </form:form>

</jsp:attribute>
</my:pagetemplate>