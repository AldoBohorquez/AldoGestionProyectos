<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
</head>
<body>
<jsp:include page="components/header.jsp"></jsp:include>

	<div class="container">
	    <div class="login-container">
	        <h1>Registrar</h1>
	        <form action="<%=request.getContextPath() %>/LoginControlador" method="post">
	        <h4>Ingrese un usuario</h4>
	            <input type="text" name="username" placeholder="Usuario" required>
	            	        <h4>Ingrese un nombre</h4>
	            
	           	<input type="text" name="name" placeholder="Nombre" required>
	           		        <h4>Ingrese una contraseña </h4>
	           	
	            <input type="password" name="password" placeholder="Contraseña" required>
	            <button type="submit">Registrar</button>
	            <button class="custom-button" onclick="window.location.href='<%=request.getContextPath()%>/vista/login.jsp'">Login</button>
	            <c:if test="${not empty errorMessage}">
	                <p class="error">${errorMessage}</p>
	            </c:if>
	        </form>
	    </div>

    </div>
    <jsp:include page="components/footer.jsp"></jsp:include>
    
</body>
</html>