<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set scope="request" var="nombreApp" value="${nombreApp}"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class= "row">
	<div class="container">
		<header class="col-xs-12 col-md-12">
			<h2 class="text-center text-capitalize">
			<spring:message code="contacto.listar" text="Lista de Contactos"/></h2>
		</header>
		<div class="espacio"></div>
		<a class="btn btn-info" href="<c:url value='/contactos/addContacto'/>">
		 <spring:message code="contacto.crear" text="Crear Contacto" /></a>
		 <div class="espacio"></div>
		<div class="col-xs-12 col-md-12">
			<!-- Si se anidan las columnas se tiene que meter otro row -->
			<div class="row">
				<div class="col-xs-1">
					<span><spring:message code="contacto.nombre" text="Nombre" /></span>
				</div>
				<div class="col-xs-1">
					<span><spring:message code="contacto.cargo" text="Cargo" /></span>
				</div>
				<div class="col-xs-3">
					<span><spring:message code="contacto.email" text="Email" /></span>
				</div>
				<div class="col-xs-1">
					<span><spring:message code="contacto.telefono" text="Teléfono" /></span>
				</div>
				<div class="col-xs-2">
					<span><spring:message code="contacto.poblacion" text="Dirección" /></span>
				</div>
				<div class="col-xs-2">
					<span><spring:message code="contacto.categoria" text="Categoria" /></span>
				</div>
				<div class="col-xs-2 col-sm-2 col-md-2"></div>
				</div>
			<c:choose>
				<c:when test="${not empty listadoContactos}">
					<c:forEach var="contacto" items="${listadoContactos}">
					<div class="row">
						<div class="col-xs-1">
							${contacto.ncontacto}
						</div>
						<div class="col-xs-1">
							${contacto.cargo}
						</div>
						<div class="col-xs-3">
							${contacto.email}
						</div>
						<div class="col-xs-1">
							${contacto.telefono}
						</div>
						<div class="col-xs-2">
							${contacto.poblacion} ${contacto.direccion}
						</div>
						<div class="col-xs-2">
							${contacto.categoria.ncategoria}
						</div>	
						<div class="col-xs-2 col-sm-2 col-md-2">
							<a class="btn btn-warning" href="<c:url value="/contactos/editContacto/${contacto.idcontacto}"/>"> 
								<spring:message code="contacto.editar" text="Editar" /></a>
				            <a class="btn btn-danger" href="<c:url value="/contactos/deleteContacto/${contacto.idcontacto}"/>">
				            	<spring:message code="contacto.borrar" text="Borrar" /></a>
						</div>
					</div>
					</c:forEach>
				</c:when>
				<c:otherwise><!-- Cuando la lista NO tiene datos -->
					<div class="row">
					<spring:message code="contacto.noencontrada" text="No se han encontrado Contactos en la Base de Datos" /></div>
				</c:otherwise>
			</c:choose>
		</div>
		</div>
	</section>
</main>	
<%@include file="../includes/footer.html" %>
