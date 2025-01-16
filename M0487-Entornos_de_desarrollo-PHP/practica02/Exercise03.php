<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise03</title>
</head>

<body style="display: flex;">
    <div>
        <fieldset style="width: 18rem;">
            <legend>Introduce numeros Entre 0 y 20</legend>
            <form action="Exercise03.php" method="POST">
                <label for="num1">Numero1:</label>
                <input type="number" name="num1" id="num1" min="0" max="20" required><br><br>

                <label for="num2">Numero2:</label>
                <input type="number" name="num2" id="num2" min="1" max="20" required><br>

                <input type="submit" value="enviar">
            </form>
        </fieldset>
    </div>
    <div>
        <?php
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            $num1 = htmlspecialchars($_POST['num1']); // Previene inyección de código malicioso (XSS)
            $num2 = htmlspecialchars($_POST['num2']);

            if ($num1 > $num2){
                echo"Lista de menor a mayor";
                echo("<ul>");
                    for ($i = $num2; $i <= $num1; $i++ ){
                        echo "<li style='color: blue'>$i</li>";
                    }
                echo("</ul>");
                echo"Lista de mayor a menor";
                echo("<ul>");
                    for ($i = $num1; $i >= $num2; $i-- ){
                        echo "<li style='color: red'>$i</li>";
                    }
                echo("</ul>");
            }else{
                echo"Lista de menor a mayor";
                echo("<ul>" );
                    for ($i = $num1; $i <= $num2; $i++ ){
                        echo "<li style='color: blue'>$i</li>";
                    }
                echo("</ul>");
                echo"Lista de mayor a menor";
                echo("<ul>");
                    for ($i = $num2; $i >= $num1; $i-- ){
                        echo "<li style='color: red'>$i</li>";
                    }
                echo("</ul>");
            }
        }
        ?>
    </div>

</body>

</html>