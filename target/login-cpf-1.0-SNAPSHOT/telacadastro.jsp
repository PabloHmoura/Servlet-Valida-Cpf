<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 18/02/2023
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tela Login</title>
</head>
<body>
    <div align="center">
        <h2>Digite um CPF válido para fazer o cadastro</h2>
        <form action="cadastrar" method="post">
            <p><input type="text" name="txtNome" placeholder="Digite seu nome"></p>
            <p><input type="text" name="txtCpf" placeholder="Digite o CPF"></p>
            <P><input type="submit" value="Cadastrar"></P>
            <h3><a href="index.jsp">Clique aqui para fazer Login</a></h3>
        </form>
    </div>
</body>
</html>
