<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <fieldset style="width: 18rem;">
        <legend>Introduce numeros</legend>
            <form action="Exercise02.php" method="POST">
            
            <label for="num1">Numero1:</label>
            <input type="number" name="num1" id="num1" required><br><br>
            
            <label for="num2">Numero2:</label>
            <input type="number" name="num2" id="num2" required><br>

            <input type="submit" value="enviar">
        </form>
        
    </fieldset>

    <?php
    if ($_SERVER["REQUEST_METHOD"]== "POST") {
        $num1 = htmlspecialchars($_POST['num1']); // Previene inyección de código malicioso (XSS)
        $num2 = htmlspecialchars($_POST['num2']);

        if ($num1 == $num2){
            echo("El numero 1-->".$num1." es el mismo que el numero 2-->".$num2);
        } else if ($num1 > $num2){
            echo("El numero 1-->". $num1." es mayor que el numero 2-->".$num2);
        } else {
            echo("El numero 2-->". $num2." es mayor que el numero 1-->".$num1);
        }
    }
    ?>

</body>
</html>