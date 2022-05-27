<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Registrar Votante</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script>
	        function saludo() {
	        	 window.alert("Registrado con Exito");
	        	}
        </script>
       
        </head>

        <body>

            <header>
               <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #01579B">
                    <div>
                        <a href="<%=request.getContextPath()%>/inicio" class="navbar-brand"> Volver al Inicio </a>
                    </div>

                    
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${votante != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${votante == null}">
                            <form action="insertVotante" method="post">
                           
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${votante != null}">
                                    Editar votante
                                </c:if>
                                <c:if test="${votante == null}">
                                    Agregar nuevo votante
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${votante != null}">
                            <input type="hidden" name="id" value="<c:out value='${votante.id}' />" />
                        </c:if>
                        
                        
                         <fieldset class="form-group">
                        	<label>Tipo Documento</label>
                            <select class="form-control" name="tipodocumento" required>
							<option disabled="disabled" selected="selected"></option>
							<c:forEach var="tipo" items="${listas.get(0)}">
								<option value="<c:out value='${tipo.id}'/>"> "${tipo.descripcion}"</option>                                  
                            </c:forEach>
                            </select>
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Documento</label> <input type="text" value="<c:out value='${votante.documento}' />" class="form-control" name="documento">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Nombre</label> <input type="text" value="<c:out value='${votante.nombre}' />" class="form-control" name="nombre">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${votante.email}' />" class="form-control" name="email">
                        </fieldset>
                        
                       <fieldset class="form-group">
                        	<label>Eleccion</label>
                            <select class="form-control" name="eleccion" required>
							<option disabled="disabled" selected="selected"></option>
							<c:forEach var="ele" items="${listas.get(1)}">   
								<option value="<c:out value='${ele.id}'/>"> "${ele.nombre}"</option>                             
                            </c:forEach>
                            </select>
                        </fieldset>
                       
                       	
          		
                        <button type="submit" class="btn btn-success" onclick="saludo()">Registrar Votante</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
<html>