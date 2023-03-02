<%--
  Created by IntelliJ IDEA.
  User: pmoura
  Date: 28/02/2023
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tela Home</title>
</head>
<body>
    <div align="center">
        <h2>Operações realizadas</h2>
        <c:forEach items="${lista_clientes}" var="listar">
            <h2><c:out value="${listar}" /></h2>
        </c:forEach>
    </div>
    <script src="/cadastrarCliente"></script>
    <div align="center">
      <button onclick="location.href='telaUsuario.jsp'">Voltar a tela principal</button>
    </div>
</body>
</html>
