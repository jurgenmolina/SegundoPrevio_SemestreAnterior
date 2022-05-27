<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Registrar Voto</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
         <script>
	        function saludo() {
	        	 window.alert("Votaste con exito");
	        	}
        </script>
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #01579B">
                    <div>
                        <a href="<%=request.getContextPath()%>/inicio" class="navbar-brand"> Cancelar </a>
                    </div>
 
                    
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        
                         <form action="procesoVotacion" method="post">
                         
                         <h2>Proceso de Votación</h2>

                        

                        <c:if test="${votante != null}">
                            <input type="hidden" name="id" value="<c:out value='${listas.get(0).id}' />" />
                        </c:if>
                        
                        <fieldset class="form-group">
                            <label>Fecha Creacion</label> <input type="text"  class="form-control" name="fechacreacion" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Fecha voto</label> <input type="text"  class="form-control" name="fechavoto" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Uuid</label> <input type="text" class="form-control" name="uuid" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Enlace</label> <input type="text" class="form-control" name="enlace" required="required">
                        </fieldset>

                       
                        
                       	<fieldset class="form-group">
                        	<label>Estamento</label>
                            <select class="form-control" name="estamento" required>
							<option disabled="disabled" selected="selected"></option>
							<c:forEach var="est" items="${listas.get(1)}"> 
								<option value="<c:out value='${est.id}'/>">  "${est.descripcion}"</option>                             
                            </c:forEach>
                            </select>
                        </fieldset>
                        
                        <fieldset class="form-group">
                        	<label>Candidato</label>
                            <select class="form-control" name="candidato" required>
							<option disabled="disabled" selected="selected"></option>
							<c:forEach var="can" items="${listas.get(2)}"> 
								<option value="<c:out value='${can.id}'/>">   "${can.numero}" "${can.nombre}"</option>                           
                            </c:forEach>
                            </select>
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Votante: "${listas.get(0).documento }" "${listas.get(0).nombre }"</label> <input type="text" readonly value="<c:out value='${listas.get(0).id}'/>" class="form-control" name="votante" required="required">
                        </fieldset>
          
                        <button type="submit" class="btn btn-success" onclick="saludo()">Votar</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
<html>