<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise05</title>
</head>

<body style="display: flex;">
    <div>
        <fieldset style="width: 18rem;">
            <legend>Datos personales</legend>
            <form method="POST">
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre"><br><br>

                <label for="num1">Numero1</label>
                <input type="number" name="num1" id="num1" min="0" max="20" required><br><br>

                <label for="num2">Numero2</label>
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
            $nombre = htmlspecialchars($_POST['nombre']);

            //Imprimimos el nombre
            echo ("Welcome $nombre!<br>");

            //Imprimimos si los numeros son pares o impares
            if ($num1 % 2 == 0) {
                echo ("$num1 is even and ");
            } else {
                echo ("$num1 is odd and ");
            }

            if ($num2 % 2 == 0) {
                echo ("$num2 is even<br>");
            } else {
                echo ("$num2 is odd<br>");
            }

            //Ordenamos de menor a mayor, cada numero dentro de un div y los numeros pares
            //deben aparecer de color verde y los impares de color naranja

            if ($num1 < $num2) {
                for ($i = $num1; $i <= $num2; $i++) {
                    if ($i % 2 == 0) {
                        echo ("<div style='color: green;'>$i</div>");
                    } else {
                        echo ("<div style='color: orange;'>$i</div>");
                    }
                }
            } else if ($num2 < $num1) {
                for ($i = $num2; $i <= $num1; $i++) {
                    if ($i % 2 == 0) {
                        echo ("<div style='color: green;'>$i</div>");
                    } else {
                        echo ("<div style='color: orange;'>$i</div>");
                    }
                }
            } else {
                if ($num1 % 2 == 0) {
                    echo ("<div style='color: green;'>$num1</div>");
                } else {
                    echo ("<div style='color: orange;'>$num1</div>");
                }
            }
        }
        ?>
    </div>

</body>

</html>