<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ej2</title>
</head>
<body>
    <h1>Ejercicio 2</h1>
    <?php
    $asociativo = array(
        // key  =>  value
        "nombre" => "Sara",
        "apellido" => "Martinez",
        "edad" => 23,
        "ciudad" => "Barcelona"
    );

    foreach($asociativo as $key => $value){
        echo($key.": ".$value."<br>");
    }

    ?>
</body>
</html>