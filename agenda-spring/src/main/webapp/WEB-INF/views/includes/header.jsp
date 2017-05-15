<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false" %>
<spring:message var="nombreApp" code="aplicacion.nombre" />
<c:set scope="request" var="nombreApp" value="${nombreApp}"/>
<c:set scope="request" var="seccion" value="${seccion}"/>
<html>
<head>
	<title>${nombreApp}</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<spring:url var="misEstilos" value="/resources/css/styles.css"/>
<link rel="stylesheet" href="${misEstilos}">

<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
  <spring:url var="misScript" value="/resources/js/script.js"/>
<script type="text/javascript" src="${misScript}"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body class="container-fluid">
<header class="row">
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="<c:url value='/'/>">
			<spring:message code="menu.website" text="Agenda-Mailing" />
			</a>
		</div>
	    <ul class="nav navbar-nav menu">
	      <li>
		      <a href="<c:url value='/mailing'/>">
		      <spring:message code="menu.mailing" text=" Mailing" />
		      </a>
	      </li>
	      <li>
		      <a href="<c:url value='/contactos'/>">
		      <spring:message code="menu.contactos" text="Contactos" />
		      </a>
	      </li>
	      <li>
	      	<a href="<c:url value='/categorias'/>">
	      	<spring:message code="menu.categorias" text="Categoria" /></a>
	      </li>
	      <li>
		      <a href="<c:url value='/newsletters'/>">
		      <spring:message code="menu.newsletter" text="Newsletter" />
		      </a>
	      </li>
	    </ul>
	    <ul class="nav navbar-nav navbar-left">
	      <li class="dropdown">
	        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	          <spring:message code="menu.idioma" text="Idioma" />
	          <span class="caret"></span>
	        </a>
		        <ul class="dropdown-menu">
			         <li>	
						<a  href="?locale=es">				
							<spring:message code="idioma.castellano" text="castellano"/>
						</a>
					</li>
					<li>
						<a href="?locale=en">
							<spring:message code="idioma.ingles" text="ingles"/>
						</a>
					</li>
					
		        </ul>
	      </li>
	      <li>
				<sec:authorize access="isAnonymous()">
				    <form method="POST"  role="form" class="navbar-form navbar-right" action="<c:url value='/login'/>">
				         <div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
					        <input name="userId" type="text" class="form-control" value="${SPRING_SECURITY_LAST_USERNAME}" />
					     </div> 
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
							<input name="password" class="form-control" type="password" />
						</div> 
		
				        <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
						<div class="form-group ">				
					   		 <button type="submit" class="btn btn-primary">Login</button>
					   	</div>
				    </form>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
				    <a class="btn " href="<c:url value="/logout" />">Logout</a>
				</sec:authorize>
			</li>
    	</ul>
 	</div>
</nav>
<div class="container">
	<c:if test="${not empty mensaje}">
		<div class="${mensaje.type.styles}">
			<a href="#" class="close" data-dismiss="alert" aria-label="close" title="close">×</a>
			<strong>${mensaje.msg}</strong>
		</div>
	</c:if>
</div>
</header>