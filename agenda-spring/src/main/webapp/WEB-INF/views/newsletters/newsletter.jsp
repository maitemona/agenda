<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set scope="request" var="nombreApp" value="${nombreApp}"/>
<spring:message var="men" code="form.crear" text="Crear" />
<c:if test="${news.idnewsletter > 0}" >
	<spring:message var="men"  code="form.editar" text="Editar" />
</c:if> 
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class= "row">
		<c:url var="sendUrl" value="/newsletters/save"/>
		<c:url var="cancelUrl" value="/newsletters"/>
		<header class="col-xs-12 col-md-12">
			<h2 class="text-center text-capitalize"><spring:message code="newsletter.crear" text="Crear Newsletter"/></h2>
		</header>
		<div class="espacio"></div>
		<div class="container">
			<form:form action="${sendUrl}" method="POST" commandName="news" cssClass="form-horizontal" enctype="multipart/form-data">
				<c:if test="${!empty news}">
					<form:hidden path="idnewsletter" />
					<form:hidden path="activo" value="true"/>
				</c:if>
			   	<div class="form-group">
					<form:label path="titulo" cssClass="control-label  col-xs-2"><spring:message code="newsletter.nombre" text="Título"/></form:label>
					<div class="col-xs-4">
						<form:input type="text" path="titulo" cssClass="form-control" cssErrorClass="form-control text-danger"/>
					</div>
					<form:errors path="titulo" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="body" cssClass="control-label  col-xs-2">
						<spring:message code="newsletter.cuerpo" text="body"/></form:label>
					<div class="col-xs-4">
						<form:input type="text" path="body" cssClass="form-control" cssErrorClass="form-control text-danger"/>
					</div>
					<form:errors path="body" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="fcreacion" cssClass="control-label col-xs-2"><spring:message code="newsletter.fecha" text="F. de Creación"/></form:label>
					<div class="col-xs-4">
						<form:input type="text" required="required" path="fcreacion" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="fcreacion" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
         			<form:label path="archivo" cssClass="control-label  col-xs-2"><spring:message code="newsletter.boletin" text="Boletín"/></form:label>
         			<div class="col-xs-4">
						<form:input path="archivo" disabled="disabled" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="archivo" cssClass="text-danger col-xs-6"></form:errors>
              		<input type="file" id="fichero" name="fichero">
          		</div>			
				<div class="form-group">
					<div class= "col-xs-4"></div>
					<div class="col-xs-4">
						<button type="submit" class="btn btn-success">${men}</button>
						<a class="btn btn-warning" href="${cancelUrl}">Cancelar</a>
					</div>
					<div class= "col-xs-4"></div>
				</div>
			</form:form>
		</div>		
	</section>
</main>	
<%@include file="../includes/footer.html" %>