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
    <a href="/"> Ver datos </a>
    <br>
    <b>Agregar datos</b>
    <br>
    borrar datos
</div>

<div id="section">

    <form method="POST" action="add">
        <fieldset>
            <legend>Personal information:</legend>
            First name:<br>
            <input type="text" name="firstname" id="firstname" value="Mickey"><br>
            Last name:<br>
            <input type="text" name="lastname" id="lastname" value="Mouse"><br><br>
            Matricula:<br>
            <input type="text" name="matricula" id="matricula" value=""><br>
            Phone:<br>
            <input type="text" name="phone" id="phone" value=""><br><br>
            <input type="submit" value="Submit">
        </fieldset>
    </form>

</div>

<div id="footer">
    Copyright © Eduardo Veras
</div>

</body>