<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <h2>Formulario de contacto</h2>
    <fieldset>
        <legend>Datos personales</legend>
            <form action="Exercise01.php" method="POST">
            
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" id="nombre" required><br><br>
            
            <label for="nombre">Apellido:</label>
            <input type="text" name="apellido" id="apellido" required><br>

            <input type="submit" value="enviar">
        </form>
        
    </fieldset>

    <?php
    if ($_SERVER["REQUEST_METHOD"]== "POST") {
        $nombre = htmlspecialchars($_POST['nombre']); // Previene inyección de código malicioso (XSS)
        $apellido = htmlspecialchars($_POST['apellido']);

        echo("Nombre: ".$nombre . "<br>");
        echo("Apellido: ". $apellido. "<br>");
    }
    ?>

</body>
</html>