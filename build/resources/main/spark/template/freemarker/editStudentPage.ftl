<!doctype html>

<html lang="en">
<head>
    <meta charset="utf-8">

    <title>The Coolest Page</title>
    <meta name="description" content="Some Cool Page">
    <meta name="author" content="Eduardo Veras">

    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


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

    <form method="POST" action="">
        <fieldset>
            <legend>Personal information:</legend>
            Matricula:<br>
            <input type="text" name="matricula" id="matricula" value="${matricula}"><br><br>
            First name:<br>
            <input type="text" name="firstname" id="firstname" value="${nombre}"><br><br>
            Last name:<br>
            <input type="text" name="lastname" id="lastname" value="${apellido}"><br><br>
            Phone:<br>
            <input type="text" name="phone" id="phone" value="${telefono}"><br><br>
            <input type="submit" value="Submit">
        </fieldset>
    </form>

</div>

<div id="footer">
    Copyright © Eduardo Veras
</div>

</body>