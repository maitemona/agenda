<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set scope="request" var="nombreApp" value="${nombreApp}"/>
<spring:message var="seccion" code="mailing.titulo" text="Mailing" />
<c:set scope="request" var="seccion" value="${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class= "row">
		<header class="col-xs-12 col-md-12">
			<h2 class="text-center text-capitalize">
			<spring:message code="newsletter.listar" text="Lista de Newsletters"/></h2>
		</header>
		<div class="espacio"></div>
		<a class="btn btn-info" href="<c:url value='/newsletters/addNewsletter'/>">
		 <spring:message code="newsletter.crear" text="Crear Newsletter" /></a>
		 <div class="espacio"></div>
		<div class="col-xs-12 col-md-12">
			<!-- Si se anidan las columnas se tiene que meter otro row -->
			<div class="row">
				<div class="col-xs-3">
					<span><spring:message code="newsletter.nombre" text="Titulo" /></span>
				</div>
				<div class="col-xs-5">
					<span><spring:message code="contacto.cuerpo" text="Cuerpo" /></span>
				</div>
				<div class="col-xs-2">
					<span><spring:message code="contacto.fecha" text="Fecha de creación" /></span>
				</div>
				<div class="col-xs-2"></div>
			</div>
			<c:choose>
				<c:when test="${not empty listadoNews}">
					<c:forEach var="news" items="${listadoNews}">
					<div class="row">
						<div class="col-xs-3">
							${news.titulo}
						</div>
						<div class="col-xs-5">
							${news.body}
						</div>
						<div class="col-xs-2" >
						<fmt:formatDate pattern="dd/MM/yyyy" value="${news.fcreacion}" />
							
						</div>
						
						<div class="col-xs-2 col-sm-2 col-md-2">
							<a class="btn btn-warning" href="<c:url value="/newsletters/${news.idnewsletter}"/>"> 
								<spring:message code="newsletter.editar" text="Editar" /></a>
				            <a class="btn btn-danger" href="<c:url value="/newsletters/deleteNewsletter/${news.idnewsletter}"/>">
				            	<spring:message code="newsletter.borrar" text="Borrar" /></a>
						</div>
					</div>
					</c:forEach>
				</c:when>
				<c:otherwise><!-- Cuando la lista NO tiene datos -->
					<div class="row">
					<spring:message code="newsletter.noencontrada" text="No se han encontrado Newsletters en la Base de Datos" /></div>
				</c:otherwise>
			</c:choose>
		</div>
	</section>
</main>	
<%@include file="../includes/footer.html" %>