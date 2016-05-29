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

<div id="header">
<h1>Practica #2</h1>
</div>

<div id="nav">
    ver datos
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
    </tr>

        <#list estudiantes as estudiante>
            <tr>
                <td>${estudiante.getMatricula()}</td>
                <td>${estudiante.getNombre()}</td>
                <td>${estudiante.getApellido()}</td>
                <td>${estudiante.getTelefono()}</td>
            </tr>
        </#list>
</table>

</div>

<div id="footer">
Copyright © Eduardo Veras
</div>

</body>