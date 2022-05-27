<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Registrar Candidato</title>
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

                        <c:if test="${listas.get(0) != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${listas.get(0) == null}">
                            <form action="insertarCandidato" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${listas.get(0) != null}">
                                    Editar candidato
                                </c:if>
                                <c:if test="${listas.get(0) == null}">
                                    Agregar nuevo candidato
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${listas.get(0) != null}">
                            <input type="hidden" name="id" value="<c:out value='${listas.get(0).id}' />" />
                        </c:if>
                        
                        <fieldset class="form-group">
                            <label>Documento</label> <input type="text" value="<c:out value='${listas.get(0).documento}' />" class="form-control" name="documento" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Nombre</label> <input type="text" value="<c:out value='${listas.get(0).nombre}' />" class="form-control" name="nombre">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Apellido</label> <input type="text" value="<c:out value='${listas.get(0).apellido}' />" class="form-control" name="apellido">
                        </fieldset>

                       
                        
                         <fieldset class="form-group">
                        	<label>Proceso</label>
                            <select class="form-control" name="proceso" required>
							<option disabled="disabled" selected="selected"></option>
							<c:forEach var="ele" items="${listas.get(1)}">
								<option value="<c:out value='${ele.id}'/>"> "${ele.nombre}"</option>                           
                            </c:forEach>
                            </select>
                        </fieldset>
                       
                        <fieldset class="form-group">
                            <label>Numero</label> <input type="text" value="<c:out value='${listas.get(0).numero}' />" class="form-control" name="numero">
                        </fieldset>
          
                        <button type="submit" class="btn btn-success" onclick="saludo()">Registrar Candidato</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
<html>