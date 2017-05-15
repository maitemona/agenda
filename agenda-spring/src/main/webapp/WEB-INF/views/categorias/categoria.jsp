<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<spring:message var="men" code="form.crear" text="Crear" />
<c:if test="${categoria.idcategoria > 0}" >
	<spring:message var="men"  code="form.editar" text="Editar" />
</c:if> 
<spring:message var="seccion" code="categoria.titulo" text="categoria" />
<c:set scope="request" var="seccion" value="${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main  class="container-fluid">
	<section class="row">
	<div class="container">
		<header class="col-xs-12 col-md-12">
			<h2 class="text-center text-capitalize">
			<spring:message code="categoria.crear" text="Crear Categoría"/></h2>
		</header>
		<div class="espacio"></div>
		<c:url var="sendUrl" value="/categorias/save"/>
		<c:url var="cancelUrl" value="/categorias"/>
		<div class="espacio"></div>
		<form:form action="${sendUrl}" method="post" cssClass="form-horizontal" modelAttribute="categoria">
			<c:if test="${!empty categoria}">
				<form:hidden path="idcategoria"/>
				<form:hidden path="activo" value ="true"/>
			</c:if>
			<div class="form-group">
				<form:label path="ncategoria" cssClass="control-label col-xs-2">
					<spring:message code="categoria.nombre" text="Categoría"/>:
				</form:label>
				<div class="col-xs-4">
					<form:input type="text" path="ncategoria" cssClass="form-control" cssErrorClass="form-control text-danger"/>
				</div>
				<form:errors path="ncategoria" cssClass="text-danger col-xs-6"></form:errors>
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