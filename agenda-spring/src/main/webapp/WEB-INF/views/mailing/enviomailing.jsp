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
	<h1><spring:message code="mailing.correcto" text="Perfecto, Mailing realizado"/></h1>
</section>
</main>
<%@include file="../includes/footer.html" %>