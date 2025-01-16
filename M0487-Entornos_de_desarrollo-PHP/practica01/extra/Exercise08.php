<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $suma = 0;
    $pares = 0;
    $impares = 0;
    for ($i = 0; $suma < 100; $i++) {
        $x = rand(0,20);
        echo($x. ",");
        $suma += $x;
        if ($x%2== 0) {
            $pares++;
        } else {
            $impares++;
        }
    }
    echo"<br>";
    echo("The total sum is: ".$suma);
    echo"<br>";
    echo("The process was executed ".$i." times");
    echo"<br>";
    echo("There were ". $pares. " peers numbers");
    echo"<br>";
    echo("There were ". $impares. " odd numbers");
    echo"<br>";

    ?>
</body>
</html>