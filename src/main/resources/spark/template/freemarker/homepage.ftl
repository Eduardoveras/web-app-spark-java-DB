<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>The Coolest Page</title>
  <meta name="description" content="Some Cool Page">
  <meta name="author" content="Eduardo Veras">

    <link rel="stylesheet" type="text/css" href="/css/styles.css">

</head>
<body>
<#setting number_format="computer">
<div id="header">
<h1>Practica #2</h1>
</div>

<div id="nav">
    <b>ver datos</b>
    <br>
    <a href="/add"> Agregar datos </a>
    <br>
    borrar datos
</div>

<div id="section">
<h1>${message}</h1>

<table border="1" style="width:100%">
    <tr>
        <th>Matricula</th>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Telefono</th>
        <th>Borrar</th>
        <th>Editar</th>
    </tr>
<#setting number_format="computer">
        <#list estudiantes as estudiante>
            <tr>
                <td>${estudiante.getMatricula()}</td>
                <td>${estudiante.getNombre()}</td>
                <td>${estudiante.getApellido()}</td>
                <td>${estudiante.getTelefono()}</td>
                <td>

                    <form method="POST" action="">
                            <input type="hidden" id="kind" name="kind" value="erase">
                            <input type="hidden" name="matricula" id="matricula" value="${estudiante.getMatricula()}">
                            <input type="submit" value="Erase">
                    </form>


                </td>
                <td>

                    <form method="POST" action="">
                        <input type="hidden" id="kind" name="kind" value="edit">
                        <input type="hidden" name="matricula" id="matricula" value="${estudiante.getMatricula()}">
                        <input type="submit" value="Edit">
                    </form>


                </td>
            </tr>
        </#list>
</table>

</div>

<div id="footer">
Copyright © Eduardo Veras
</div>

</body>