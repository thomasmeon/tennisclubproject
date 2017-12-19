
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Date,java.text.SimpleDateFormat,java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>

<my:pagetemplate title="New booking">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/booking/create"
               modelAttribute="bookingCreate" cssClass="form-horizontal">
        <div class="form-group">
            <form:label path="idCourt" cssClass="col-sm-2 control-label">Which Court do you want to book ? </form:label>
            <div class="col-sm-10">
                <form:select path="idCourt" cssClass="form-control">
                    <c:forEach items="${courts}" var="c">
                        <form:option value="${c.idCourt}">${c.idCourt} ${c.type}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="idCourt" cssClass="error"/></p>
            </div>
        </div>
        <div class="form-group">
            <form:label path="hourOfBooking" cssClass="col-sm-2 control-label"> Hour of your booking ? (Each reservation is for one hour) </form:label>
            <div class="col-sm-10">
                <form:select path="hourOfBooking" cssClass="form-control">
                    <c:forEach items="${hour24}" var="h">
                        <form:option value="${h}">${h}</form:option>
                    </c:forEach>
                </form:select>
                <form:errors path="hourOfBooking" cssClass="error"/>
            </div>
       </div>
<<<<<<< HEAD
       
       <div class="form-group ${date_error?'has-error':''}">
            <form:label path="dateOfBooking" cssClass="col-sm-2 control-label">Day of your booking ? (yyyy/mm/dd)</form:label>
            <div class="col-sm-10">
                <form:input path="dateOfBooking" type="text" cssClass="form-control"/>
                <form:errors path="dateOfBooking" cssClass="help-block"/>
            </div>
        </div>
        
=======
               
       <div class="form-group">
       		<form:label path="dateOfBooking" cssClass="col-sm-2 control-label"> Day of the booking ? </form:label>
<<<<<<< HEAD
  			<input type="date" max="2020-01-01" min="2017-12-24" name="dateOfBooking" required pattern = "yyyy-mm-dd"">
  			<span class="validity"></span>	
    	    <div class="col-sm-10">
=======
  			<div class="col-sm-10">
  			<form:input cssClass="control" path="dateOfBooking" name="dateOfBooking" type="date""/> 
    	    </div>
>>>>>>> 2caf1424ed07caaebea2d031cb9524faf4520e17
    	    <form:errors path="dateOfBooking" cssClass="error"/>

       </div>
          
>>>>>>> cef3ac5ef0a671e7484bc894576fd0f2230ad717
	    <div class="form-group">
            <form:label path="idUser1" cssClass="col-sm-2 control-label">Player 1</form:label>
            <div class="col-sm-10">
                <form:select path="idUser1" cssClass="form-control">
                    <c:forEach items="${users}" var="u">
                        <form:option value="${u.id}">${u.surname} ${u.name}</form:option>
                    </c:forEach>
                </form:select>
                 <p class="help-block"><form:errors path="idUser1" cssClass="error"/></p>
            </div>
        </div>
        
        <div class="form-group">
            <form:label path="idUser2" cssClass="col-sm-2 control-label">Player 2</form:label>
            <div class="col-sm-10">
                <form:select path="idUser2" cssClass="form-control">
                    <c:forEach items="${users}" var="u">
                        <form:option value="${u.id}">${u.surname} ${u.name}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="idUser2" cssClass="error"/></p>
            </div>
        </div>
        
        	    

        <button class="btn btn-primary" type="submit">Create booking</button>
    </form:form>
    

</jsp:attribute>
</my:pagetemplate>