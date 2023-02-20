<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <div align="center">
    <h1><%= "Digite seu CPF para fazer login" %></h1>
        <form action="cadastrar" method="get">
            <p><input type="text" name="txtCpf" placeholder="Digite o CPF"></p>
            <P><input type="submit" value="Login"></P>
        </form>
    <br/>
    <a href="telacadastro.jsp">Clique aqui para cadastrar</a>
    </div>
</body>
</html>