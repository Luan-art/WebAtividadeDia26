<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de tarefas</title>
</head>
<body>

<h1>Registro de Nova tarefa</h1>
  <form action="<%= request.getContextPath() %>/CadastroDeTarefa" method="post">
   <table style="with: 80%">
    <tr>
     <td>Titulo</td>
     <td><input type="text" name="titulo" /></td>
    </tr>
    <tr>
     <td>Descirção</td>
     <td><input type="text" name="descricao" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>

</body>
</html>