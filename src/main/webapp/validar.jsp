<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Proceso Validacion</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #01579B">
                   	<div>
                        <a href="<%=request.getContextPath()%>/inicio" class="navbar-brand">Cancelar Operación </a>
                    </div>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                         <form action="validar" method="post">
                        
                        <fieldset class="form-group">
                        	<label>Votantes</label>
                            <select class="form-control" name="id" required>
							<option disabled="disabled" selected="selected"></option>
							<c:forEach var="v" items="${listvotantes}">  
								<option value="<c:out value='${v.id}'/>"> "${v.documento}" "${v.nombre}"</option>                        
                            </c:forEach>
                            </select>
                        </fieldset>
                        
                         
                        

                        <button type="submit" class="btn btn-success">Confirmar</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
