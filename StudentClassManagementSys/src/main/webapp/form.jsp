<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
        <html>

        <head>
            <title>Student Management Application</title>
           <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        </head>

        <body class= $colors( "pink":  $pink-200)>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
                    <div class="container-fluid" >
                    
                        <a href=# class="navbar-brand"> Student Management App </a>
                 

                        <ul class="navbar-nav"  class="d-flex">
                        
                        <li ><a class="btn btn-light" href="<%=request.getContextPath()%>/list" class="nav-link">Students</a></li>
                      
                    </ul>
                    </div>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body" style="background: radial-gradient(circle, rgba(48,60,222,1) 0%, rgba(236,130,225,1) 100%)";>
                        <c:if test="${student != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${student == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2 style="text-align:center">
                                <c:if test="${student != null}">
                                    Edit Student
                                </c:if>
                                <c:if test="${student == null}">
                                    Add New Student
                                </c:if>
                                
                            </h2>
                            <br>
                            <br>
                        </caption>

                        <c:if test="${student != null}">
                            <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Student Name</label> <input type="text" value="<c:out value='${student.name}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Student Standard</label> <input type="number" value="<c:out value='${student.standard}' />" class="form-control" name="standard" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                      
                        	
                        	<label for="sub">Student Subject</label>
                           		<select name="subject" id="sub" value="<c:out value='${student.subject}'/>" class="form-control" required="required">
		                           <option value="SELECT">@ CLICK HERE TO SELECT SUBJECT</option>
		                           <option value="Mathemtics">Mathemtics</option>
		                           <option value="ComputerScience">ComputerScience</option>
		                           <option value="History-Civics">History-Civics</option>
		                           <option value="Geography">Geography</option>
		                           <option value="Marathi">Marathi</option>
		                           <option value="Hindi">Hindi</option>
								</select>
                        </fieldset>
                        <br>
                        <br>
                        <div class="d-flex justify-content-center">
                        <button  type="submit" class="btn btn-success">Save</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>