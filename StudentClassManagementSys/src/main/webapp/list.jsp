<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
       <html>

        <head>
            <title>Student Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
                    <div class="container-fluid">
                        <a href="https://www.javaguides.net" class="navbar-brand"> Student Management App </a>
                    

                    <ul class="navbar-nav" class="d-flex">
                        <li><a class="btn btn-light" href="<%=request.getContextPath()%>/list" class="nav-link">Students</a></li>
                    </ul>
                    </div>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center ">List of Students</h3>
                    <hr>
                    <div class="container d-flex justify-content-center " >

                     <a href="<%=request.getContextPath()%>/new" class="btn btn-success ">Add New Student</a>
                    </div>
                    <br>
                    <table class="table table-bordered " style="background: radial-gradient(circle, rgba(48,60,222,1) 0%, rgba(236,130,225,1) 100%)">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Standard</th>
                                <th>Subject</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="student" items="${studentList}">

                                <tr>
                                    <td>
                                        <c:out value="${student.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.standard}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.subject}" />
                                    </td>
                                    <td><a class="btn btn-success" href="edit?id=<c:out value='${student.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-danger" href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
                                	
                                
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>