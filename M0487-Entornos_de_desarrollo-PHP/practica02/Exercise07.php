<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise07</title>
</head>

<body>
    <div>
        <fieldset style="width: 18rem;">
            <form method="POST">
                <div style="display: flex">
                    <div>
                        <label for="lista-personajes1">Personaje</label>
                        <select name="lista-personajes1" id="lista-personajes1">
                            <option value="doraemon">doraemon</option>
                            <option value="novita">novita</option>
                        </select>
                        <br>
                        <label for="lista-objetos1">Objeto</label>
                        <select name="lista-objetos1" id="lista-objetos1">
                            <option value="sarten">Sartén 1d8</option>
                            <option value="dorayaki">Dorayaki 2d4</option>
                        </select>
                        <br>
                    </div>
                    <div>
                        <label for="lista-personajes2">Personaje</label>
                        <select name="lista-personajes2" id="lista-personajes2">
                            <option value="doraemon">doraemon</option>
                            <option value="novita">novita</option>
                        </select>
                        <br>
                        <label for="nombre">Objeto</label>
                        <select name="lista-objetos2" id="lista-objetos2">
                            <option value="sarten">Sartén 1d8</option>
                            <option value="dorayaki">Dorayaki 2d4</option>
                        </select>
                        <br>
                    </div>
                </div>
                <br>
                <label for="rondas">Rondas</label>
                <input type="number" name="rondas" id="rondas">
                <input type="submit" value="enviar">
            </form>
        </fieldset>
    </div>
    <div style='font-size: 2rem;'>
        <?php
        //Subimos los datos
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            $pers1 = htmlspecialchars($_POST['lista-personajes1']);
            $pers2 = htmlspecialchars($_POST['lista-personajes2']);
            $obj1 = htmlspecialchars($_POST['lista-objetos1']);
            $obj2 = htmlspecialchars($_POST['lista-objetos2']);
            $rondas = htmlspecialchars($_POST['rondas']);
            for ($i = 0; $i < $rondas; $i++) {
                echo("<br>RONDA ".($i+1)."<br>");
                echo("<hr>");
                echo("<div>");
                    //Jugador1
                    if ($pers1 == "doraemon"){
                        echo('<img src="https://i.pinimg.com/originals/31/be/7c/31be7cf14e9e6b684683dbab92f21554.jpg" width="20%"><br>');
                    } else {
                        echo('<img src="https://img.desmotivaciones.es/201103/a06cL%5B1%5D.jpg" width="20%"><br>');
                    }

                    $puntuacion1 = 0;
                    if ($obj1 == "sarten") {
                        $puntuacion1 = mt_rand(1, 8);
                    } else {
                        for ($j = 0; $j < 2; $j++) {
                            $puntuacion1 += mt_rand(1, 4);
                        }
                    }
                    echo ("Puntuación de $pers1-->$puntuacion1<br>");
                echo("</div>");
                echo("<div>");
                    //jugador2
                    if ($pers2 == "doraemon"){
                        echo('<img src="https://i.pinimg.com/originals/31/be/7c/31be7cf14e9e6b684683dbab92f21554.jpg" width="20%"><br>');
                    } else {
                        echo('<img src="https://img.desmotivaciones.es/201103/a06cL%5B1%5D.jpg" width="20%"><br>');
                    }
                    $puntuacion2 = 0;
                    if ($obj2 == "sarten") {
                        $puntuacion2 = mt_rand(1, 8);
                    } else {
                        for ($j = 0; $j < 2; $j++) {
                            $puntuacion2 += mt_rand(1, 4);
                        }
                    }
                    echo ("Puntuación de $pers2-->$puntuacion2<br>");
                echo("</div>");
                if ($puntuacion1 > $puntuacion2) {
                    echo ("El ganador ha sido $pers1");
                } else if ($puntuacion2 > $puntuacion1) {
                    echo ("El ganador ha sido el $pers2");
                } else {
                    echo ("Empate");
                }
                echo("<br>");
            }
        }
        ?>
    </div>
</body>

</html>