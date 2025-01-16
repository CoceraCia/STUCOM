<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 4</title>
</head>

<body>
    <h1>Ejercicio 4</h1>
    <?php
    $asociativo = array(
        // key  =>  value
        "nombre" => "Sara",
        "apellido" => "Martinez",
        "edad" => 23
    );

    //cambiamos el value de la key edad
    $asociativo['edad'] = 24;

    var_dump($asociativo);
    ?>
</body>

</html>