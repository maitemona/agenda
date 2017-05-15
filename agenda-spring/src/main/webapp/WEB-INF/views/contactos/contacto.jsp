<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<spring:message var="men" code="form.crear" text="Crear" />
<c:if test="${contacto.idcontacto > 0}" >
	<spring:message var="men"  code="form.editar" text="Editar" />
</c:if> 
<spring:message var="seccion" code="contacto.titulo" text="Contacto" />
<c:set scope="request" var="seccion" value="${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main  class="container-fluid">
	<section class="row">
		<div class="container">
			<c:url var="sendUrl" value="/contactos/save"/>
			<c:url var="cancelUrl" value="/contactos"/>
				<header class="col-xs-12 col-md-12">
					<h2 class="text-center text-capitalize">
					<spring:message code="contacto.crear" text="Crear Contacto"/></h2>
				</header>
			
					<div class="espacio"></div>
					<form:form action="${sendUrl}" method="POST" commandName="contacto"  cssClass="form-horizontal">
					<c:if test="${!empty contacto}">
						<form:hidden path="idcontacto" />
						<form:hidden path="activo" value="true"/>
					</c:if>
				   	<div class="form-group">
						<form:label path="ncontacto" cssClass="control-label  col-xs-2"><spring:message code="contacto.nombre" text="Nombre"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="ncontacto" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
						<form:errors path="ncontacto" cssClass="text-danger col-xs-6"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="cargo" cssClass="control-label  col-xs-2">
							<spring:message code="contacto.cargo" text="Cargo"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="cargo" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
					<form:errors path="cargo" cssClass="text-danger col-xs-6"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="email" cssClass="control-label col-xs-2"><spring:message code="contacto.email" text="F.Inicio"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="email" cssClass="form-control" cssErrorClass="text-danger"/>
						</div>
						<form:errors path="email" cssClass="text-danger col-xs-6"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="telefono" cssClass="control-label  col-xs-2">
							<spring:message code="contacto.telefono" text="Teléfono"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="telefono" cssClass="form-control" cssErrorClass="text-danger"/>
						</div>
						<form:errors path="telefono" cssClass="text-danger col-xs-6"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="direccion" cssClass="control-label  col-xs-2">
							<spring:message code="contacto.direccion" text="Dirección"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="direccion" cssClass="form-control" cssErrorClass="text-danger"/>
						</div>
						<form:errors path="direccion" cssClass="text-danger col-xs-6"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="poblacion" cssClass="control-label  col-xs-2">
							<spring:message code="contacto.poblacion" text="Población"/></form:label>
						<div class="col-xs-4">
							<form:input path="poblacion" cssClass="form-control" cssErrorClass="text-danger"/>
						</div>
						<form:errors path="poblacion" cssClass="text-danger col-xs-6"></form:errors>
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
					<div class="espacio"></div>
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