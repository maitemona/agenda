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
				<h2 class="text-center text-capitalize"><spring:message code="categoria.listar" text="Lista de  Categorías"/></h2>
			</header>
			<div class="espacio"></div>
			<a class="btn btn-info" href="<c:url value='/categorias/addCategoria'/>">
			 <spring:message code="categoria.crear" text="Crear Categoría" /></a>
			 <div class="espacio"></div>
			<div class="col-xs-12 col-md-12">
				<!-- Si se anidan las columnas se tiene que meter otro row -->
				<div class="row">
					<div class="col-xs-8">
						<span><spring:message code="categoria.nombre" text="Nombre" /></span>
					</div>
					<div class="col-xs-4  col-sm-4 col-md-4"></div>
					</div>
				<c:choose>
					<c:when test="${not empty listadoCategorias}">
						<c:forEach var="categoria" items="${listadoCategorias}">
							<div class="col-xs-8">${categoria.ncategoria}</div>
							<div class="col-xs-4 col-sm-4 col-md-4">
								<a class="btn btn-warning" href="<c:url value="/categorias/${categoria.idcategoria}"/>"> <spring:message code="categoria.editar" text="Editar" /></a>
					            <a class="btn btn-danger" href="<c:url value="/categorias/deleteCategoria/${categoria.idcategoria}"/>"><spring:message code="categoria.borrar" text="Borrar" /></a>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise><!-- Cuando la lista NO tiene datos -->
						<div class="row">
						<spring:message code="categoria.noencontrada" text="No se han encontrado Categorías en la Base de Datos" /></div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</section>
</main>	
<%@include file="../includes/footer.html" %>