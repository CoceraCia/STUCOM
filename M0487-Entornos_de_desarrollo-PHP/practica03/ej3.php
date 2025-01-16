<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 3</title>
</head>
<body>
    <h1>Ejercicio 3</h1>

    <?php
    $asociativo = array(
        // key  =>  value
        "nombre" => "Sara",
        "apellido" => "Martinez",
        "edad" => 23,
        "ciudad" => "Barcelona"
    );
    
    //cambiamos el value de la key edad
    $asociativo['edad'] = 24;

    //La funcion array values nos hace un array de solo los values
    $asociativoValues = array_values($asociativo);

    //Usamos un for normal ya que solo queremos los values y contar cada dato
    for ($i = 0; $i < count($asociativo); $i++){
        echo("dato ".($i+1). "º:"." $asociativoValues[$i]<br>");
    }
    ?>
</body>
</html>