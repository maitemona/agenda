<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<spring:message var="men" code="form.crear" text="Crear" />

<spring:message var="seccion" code="mailing.titulo" text="Mailing" />
<c:set scope="request" var="seccion" value="${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main  class="container-fluid">
	<section class= "row">
		<c:url var="sendUrl" value="/mailing/save"/>
		<c:url var="cancelUrl" value="/mailing"/>
		<header class="col-xs-12 col-md-12">
			<h2 class="text-center text-capitalize"><spring:message code="mailing.crear" text="Crear envio de Mailing"/></h2>
		</header>
		
		<div class="container">
		<div class="espacio"></div>
			<form:form cssClass="form-horizontal" id="mailingform" action="${sendUrl}" method="POST" commandName="mailing">	
				<div class="form-group">
					<form:label path="titulo" cssClass="control-label  col-xs-2"><spring:message code="mailing.nombre" text="Título"/></form:label>
					<div class="col-xs-4">
						<form:input type="text" path="titulo" cssClass="form-control" cssErrorClass="form-control text-danger"/>
					</div>
					<form:errors path="titulo" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="fenvio" cssClass="control-label  col-xs-2">
						<spring:message code="mailing.fecha" text="Fecha de envío"/></form:label>
					<div class="col-xs-4">
						<form:input type="text" required="required" path="fenvio" cssClass="form-control" cssErrorClass="form-control text-danger"/>
					</div>
					<form:errors path="fenvio" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label cssClass="control-label col-xs-2" path="newsletter">
						<spring:message code="mailing.newsletter" text="Neswletter"/></form:label>
					<div class="col-xs-4">
						<form:select cssClass="form-control" path="newsletter" multiple="false">
			               <form:option value="0" label="Elija un Newsletter"/>
						   <form:options items="${listadoNewsletters}" itemValue="idnewsletter" itemLabel="titulo" />
			            </form:select> 
			            <form:errors path="newsletter" cssClass="text-danger col-xs-6"></form:errors>
		            </div>
				</div>
				
				<div class="form-group">
					<form:label cssClass="control-label col-xs-2" path="categoria">
						<spring:message code="contacto.categoria" text="Categoría"/></form:label>
					<div class="col-xs-4">
						<form:select cssClass="form-control" path="categoria">
			               <form:option value="0" label="Elija una categoria"/>
						   <form:options items="${listadoCategorias}" itemValue="idcategoria" itemLabel="ncategoria" />
			            </form:select> 
			            <form:errors path="categoria" cssClass="text-danger col-xs-6"></form:errors>
		            </div>
				</div>
				<div id="ocultar">
					
					<!--  <strong><spring:message code="categoria.nombre" /></strong>-->
			   			<div id="nombre" class="col-xs-2  text-capitalize"></div>
			
	               <!--  <strong><spring:message code="contacto.email"/></strong>-->
			            <div id="email" class="col-xs-4  text-capitalize"> </div>
			  
			        <div class="col-xs-6"></div>
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