<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ex02</title>
</head>

<body>
    <h1>Modify array saved in session</h1>
    <form method="POST">
        <label for="position">Position to modify: </label>
        <select name="position" id="position">
            <option value="0">0</option>
            <option value="1">1</option>
            <option value="2">2</option>
        </select>
        <br><br>

        <label for="new_value">New value: </label>
        <input type="number" name="new_value" id="new_value">
        <br><br>

        <input type="submit" name="modify" id="modify" value="modify">
        <input type="submit" name="average" id="average" value="average">
        <input type="submit" name="reset" id="reset" value="reset">
        <br><br>
    </form>
    <?php
    session_start();

    // in case its null we initialize the array
    if (!isset($_SESSION["nums"])) {
        $_SESSION["nums"] = [0, 0, 0];
    }

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        // retrieve form data
        $position = intval($_POST["position"]);
        $value = intval($_POST["new_value"]);

        if (isset($_POST["modify"])) {
            $_SESSION["nums"][$position] = $value;
        } else if (isset($_POST["reset"])) {
            for ($i = 0; $i < count($_SESSION["nums"]); $i++) {
                $_SESSION["nums"][$i] = 0;
            }
        }

        echo "Current Array: ";
        for ($i = 0; $i < count($_SESSION["nums"]); $i++) {
            $message = ($i == (count($_SESSION["nums"]) - 1)) ? $_SESSION["nums"][$i] : $_SESSION["nums"][$i] . ", ";
            echo ($message);
        }
        echo "<br>";

        if (isset($_POST["average"])) {
            $average = 0;
            for ($count = 0; $count < count($_SESSION["nums"]); $count++) {
                if ($_SESSION["nums"][$count] == 0 && $count != 0) {
                    break;
                }
                $average += $_SESSION["nums"][$count];
            }
            echo ("Average:" . $average / ($count) . "<br>");
        }
        
    } else {
        echo "Current Array: ";
        for ($i = 0; $i < count($_SESSION["nums"]); $i++) {
            $message = ($i == (count($_SESSION["nums"]) - 1)) ? $_SESSION["nums"][$i] : $_SESSION["nums"][$i] . ", ";
            echo ($message);
        }
        echo "<br>";
    }
    ?>
</body>

</html>