<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Arrays</title>
</head>

<body>
    <h1>Ejercicio 1</h1>

    <?php
    $asociativo = array(
        // key  =>  value
        "nombre" => "Sara",
        "apellido" => "Martinez",
        "edad" => 23,
        "ciudad" => "Barcelona"
    );

    //La funcion array values nos hace un array de solo los values
    $asociativoValues = array_values($asociativo);

    //Usamos un for normal ya que solo queremos los values y contar cada dato
    for ($i = 0; $i < count($asociativo); $i++) {
        echo ("dato " . ($i + 1) . "º:" . " $asociativoValues[$i]");
        echo ("<br>");
    }
    ?>

    <h1>Ejercicio 2</h1>
    <?php
    //Usamos un for each para sacar cada key y cada value
    foreach ($asociativo as $key => $value) {
        echo ($key . ": " . $value . "<br>");
    }

    ?>

    <h1>Ejercicio 3</h1>
    <?php

    //cambiamos el value de la key edad
    $asociativo['edad'] = 24;

    //La funcion array values nos hace un array de solo los values
    $asociativoValues = array_values($asociativo);

    //Usamos un for normal ya que solo queremos los values y contar cada dato
    for ($i = 0; $i < count($asociativo); $i++) {
        echo ("dato " . ($i + 1) . "º:" . " $asociativoValues[$i]<br>");
    }
    ?>

    <h1>Ejercicio 4</h1>
    <?php

    //con el unset eliminamos valores de un array
    unset($asociativo['ciudad']);

    //La funcion var_dump sirve para mostrar información más detallada sobre la variable
    // Nos mostrara el tipo de dato, el valor de la variable y la longitud del contenido
    var_dump($asociativo);
    ?>

    <h1>Ejercicio 5</h1>
    <?php
    //Usaremos la funcion explode que es parecida al split
    //nos crea un array indicando con que caracter queremos dividir el string

    $letters = explode(",", "a,b,c,d,e,f");

    //usaremos un for para inicializar una variable con el tamaño del array
    //de esta forma lo mostraremos en orden descendente
    for ($i = count($letters); $i > 0; $i--) {
        echo ("letter " . $i . "º: " . $letters[$i - 1] . "<br>");
    }

    ?>

    <h1>Ejercicio 6</h1>
    <?php
    //creamos un array asociativo en el cual almacenaremos las notas
    $marks = array(
        //key => value
        "Miguel" => 5,
        "Luis" => 7,
        "Marta" => 10,
        "Isabel" => 8,
        "Aitor" => 4,
        "Pepe" => 1,
    );

    //para ordenar por valores se usa el asort o arsort
    //para ordenar por claves se usa el ksort y el krsort
    arsort($marks);

    echo ("Nota de los estudiantes: ");
    foreach ($marks as $key => $value) {
        echo ($key . ":" . $value . " ");
    }

    ?>

    <h1>Ejercicio 7</h1>
    <?php

    $media = 0;
    foreach ($marks as $key => $value) {
        $media += $value;
    }
    $media /= count($marks);
    $media = round($media, 2);

    echo ("Media de las notas: " . $media . "<br>");
    echo ("Alumnos con nota por encima de la media: <br>");
    foreach ($marks as $alu => $nota) {
        if ($nota > $media) {
            echo ("$alu <br>");
        }
    }
    ?>

    <h1>Ejercicio 8</h1>
    <?php
    echo ("La nota más alta es " . max($marks) . " y el mejor alumno es " . array_search(max($marks), $marks));
    ?>
</body>

</html>