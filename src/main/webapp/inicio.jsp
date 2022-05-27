<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Registrar Candidato</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #01579B">
                    <div>
                        <a href="<%=request.getContextPath()%>/inicio" class="navbar-brand"> Inicio </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/candidato" class="nav-link"> Registrar Candidato </a></li>
                        <li><a href="<%=request.getContextPath()%>/votante" class="nav-link"> Registrar Votante </a></li>
                        <li><a href="<%=request.getContextPath()%>/votar" class="nav-link"> VOTAR </a></li>
                    </ul>
                </nav>
            </header>
            
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Lista Candidatos</h3>
                   
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Proceso</th>
                                <th>Numero</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="candidato" items="${listCandidatos}">

                                <tr>
                                    <td>
                                        <c:out value="${candidato.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.apellido}" />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.eleccion.getId()} - Elecciones a rectoria"  />
                                    </td>
                                    <td>
                                        <c:out value="${candidato.numero}" />
                                    </td>
                                    <td>
                                    	<a href="editCandidato?id=<c:out value='${candidato.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteCandidato?id=<c:out value='${candidato.id}' />">Eliminar</a>
                                    </td>
                               
                                  </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                    
                    
                    
                </div>
            </div>
            
            
            
            
        </body>
