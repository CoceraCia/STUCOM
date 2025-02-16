<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sessions1</title>
</head>

<body>
    <h1>Supermarket management</h1>
    <form method="POST">
        <label for="name">Worker name: </label>
        <input type="text" name="name" id="name">

        <h2>Choose product: </h2>
        <select name="choose_product" id="choose_product">
            <option value="soft">Soft Drink</option>
            <option value="hard">Hard Drink</option>
        </select>

        <h2>Product quantity</h2>
        <input type="number" name="quantity" id="quantity"><br><br>
        <input type="submit" name="add_product" id="add_product" value="add">
        <input type="submit" name="remove_product" id="remove_product" value="remove">
        <input type="submit" name="reset_product" id="reset_product" value="reset">
    </form>

</body>
<?php
session_start();

// check if the form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // retrieve form data
    $name = htmlspecialchars($_POST["name"]);
    $product = htmlspecialchars($_POST["choose_product"]);
    $quantity = intval($_POST["quantity"]);

    // Depending on the action we are gonna execute a different process
    if (isset($_POST["add_product"])) {
        $action = 1;
    } else if (isset($_POST["remove_product"])) {
        $action = -1;
    } else if (isset($_POST["reset_product"])) {
        $action = 0;
    }

    // The array structure will be something like this
    // $_session["workers"] = [
    //      $worker => [
    //              $product => $quantity
    //              $product => $quantity
    //     ]
    // ]


    //initialize the array if not set
    if (!isset($_SESSION["workers"])) {
        $_SESSION["workers"] = [];
    }

    //if the workes doesnt exists yet, we initialize the array were the products are going to add
    if (!isset($_SESSION["workers"][$name])) {
        $_SESSION["workers"][$name] = [];
    }
    //if the product isnt initialized
    if (!isset($_SESSION["workers"][$name][$product])) {
        $_SESSION["workers"][$name][$product] = $quantity * $action;
    } else {
        if ($action == 0 || ($_SESSION["workers"][$name][$product] += $quantity * $action) < 0){
            $_SESSION["workers"][$name][$product] = 0;
        }
    }

    

    echo ("<br><h2>Inventary:</h2>");
    foreach ($_SESSION["workers"] as $worker => $products) {
        echo("worker: ".$worker."<br>");
        foreach ($products as $pr => $quan) {
            echo("units ".$pr.": $quan<br>");
        }
    }
}
?>
</html>