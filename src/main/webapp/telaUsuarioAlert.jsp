<%--
  Created by IntelliJ IDEA.
  User: pmoura
  Date: 01/03/2023
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tela Home</title>
  <script type="text/javascript">
    alert("Cliente cadastrado com sucesso!");
  </script>
</head>
<body>
<div align="center">
  <h2>Insira os dados do cliente que deseja cadastrar</h2>
  <form action="cadastrarCliente" method="post">
    <p><input type="text" name="txtNome" placeholder="Digite seu nome"></p>
    <p><input type="text" name="txtCpf" placeholder="Digite o CPF"></p>
    <P><input type="submit" value="cadastrar cliente"></P>
  </form>
</div>
<div align="center">
  <form action="telaUsuarioListaCliente.jsp" method="get">
    <button type="submit" onclick="location.href='telaUsuarioListaCliente.jsp'" >Listar clientes</button>
  </form>
</div>
</body>
</html>
