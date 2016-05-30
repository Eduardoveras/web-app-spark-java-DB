<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>The Coolest Page</title>
  <meta name="description" content="Some Cool Page">
  <meta name="author" content="Eduardo Veras">


    <link rel="stylesheet" type="text/css" href="/css/styles.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <!--<meta name="viewport" content="width=device-width, initial-scale=1">-->




</head>
<body>

<#setting number_format="computer">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <h3 class="navbar-text">Student Manager</h3>
        <a type="button" href="/" class="btn btn-default navbar-btn">Ver Lista Estudiantes</a>
        <a type="button" href="/add" class="btn btn-default navbar-btn">Agregar Estudiante Nuevo</a>
    </div>
</nav>

<div id="section">
<h1>${message}</h1>

<table class="table table-hover" border="1" style="width:100%">
    <thead class="thead-inverse">
        <th>Matricula</th>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Telefono</th>
        <th>Borrar</th>
        <th>Editar</th>
    </thead>
<#setting number_format="computer">
        <#list estudiantes as estudiante>
            <tr>


                <td><a data-toggle="modal" href="#myModal">${estudiante.getMatricula()}</a></td>
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


<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Perfil Estudiante</h4>
            </div>
            <div class="modal-body">
                <p>Matricula:</p>
                <p>Nombre:</p>
                <p>Apellido:</p>
                <p>Telefono:</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>


</body>