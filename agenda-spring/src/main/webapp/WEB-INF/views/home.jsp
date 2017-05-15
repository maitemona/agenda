<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="includes/header.jsp" />

<main>
	<section>


	<h2> <spring:message code="home.app" text="Aplicación para mandar emails desde tu agenda" /></h2>
	<div class="container">
		<div class="espacio"></div>
		<p>
			<spring:message code="home.contacto" text="Contacto -> Podremos listar, crear, modificar y borrar un cantacto de la agenda." />
		</p>
		<p>
		<spring:message code="home.newsletter" text="Newsletter -> Podremos listar, crear, modificar y borrar un newsletter." />
		</p>
		<p>
		<spring:message code="home.categoria" text="Categoria -> Podremos listar, crear, modificar y borrar un categoría." />
		
		</p>
		<p>
		<spring:message code="home.mailing" text="Para hacer Mailing debemos elegir una categoría y un newsletter, fecha de envio y el titulo del Mailing." />
		
		</p>
	</div>

	</section>
	
</main>
<%@include file="includes/footer.html" %>