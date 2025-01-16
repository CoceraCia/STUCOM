<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $variable1 = $base = 4;
    $variable2 = $altura = 5;
    if ($variable1 > 1 and $variable2 > 1) {
        
        echo"suma = ".$variable1 + $variable2 . "<br>";
        echo"resta = ".$variable1 - $variable2 . "<br>";
        echo"division = ".$variable1 / $variable2 . "<br>";
        if ($variable1 > $variable2) {
            echo"The number " . $variable1 . " is the greatest number";
        } else {
            echo"The number " . $variable2 . " is the greatest number";
        }
        echo "<br>";
        echo"The triangle area is = ".$base*$altura/2 . "<br>";
    }

    ?>
</body>
</html>