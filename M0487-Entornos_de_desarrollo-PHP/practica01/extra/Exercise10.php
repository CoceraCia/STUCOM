<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        //1. Se declaren dos variables con valores numéricos superiores a 10 y seguidamente:
        $x = 12;
        $y = 15;
        
        // 2. Muestra la progresión numérica de los números pares desde 0 hasta el valor de la
        // primera con un bucle for.
        for ($i = 1; $i <= $x; $i++) {
            if ($i % 2 == 0) {
                echo($i.",");
            }
        }

        // 3. Muestra la progresión numérica desde la segunda variable hasta 0 con un bucle
        // while. 
        echo"<br>";
        $cont = $y;
        while ($cont >= 0) {
            echo($cont. ",");
            $cont--;
        }
        
        // 4. Muestra la progresión numérica desde la primera variable a la segunda con un bucle
        // do/while.
        // a. Si la segunda variable es más pequeña, sólo queremos que imprima una vez
        // el valor de la primera variable.
        echo "<br>";
        if ($x < $y) {
            do {
                echo($x.",");
                $x++;
            } while ($x <= $y);
            echo "<br>";
        } else {
            echo($x);
            echo"<br>";
        }
    ?>
</body>
</html>