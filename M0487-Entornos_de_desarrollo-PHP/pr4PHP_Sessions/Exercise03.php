<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Compras</title>
</head>

<body>
    <h1>Shopping list</h1>

    <form method="POST">
        <label for="name">name:</label>
        <input type="text" name="name" id="name" required>
        <br>

        <label for="quantity">quantity:</label>
        <input type="number" name="quantity" id="quantity" required>
        <br>

        <label for="price">price:</label>
        <input type="number" name="price" id="price" required>
        <br>

        <input type="submit" name="add" id="add" value="Add">
        <input type="submit" name="update" id="update" value="Update">
        <input type="reset" name="reset" id="reset" value="Reset">
        <br>
    </form>

    <?php
    session_start();

    // The array is like this ->
    // $_SESSION["products"] = [
    //     ["name" => "vino", "quantity" => 2, "price" => 10],
    //     ["name" => "pan", "quantity" => 3, "price" => 2],
    //     ["name" => "queso", "quantity" => 1, "price" => 5]
    // ];

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        // retrieve form data
        $name = (isset($_POST["name"]))?htmlspecialchars($_POST["name"]):null;
        $quantity = (isset($_POST["quantity"]))?intval($_POST["quantity"]):null;
        $price = (isset($_POST["price"]))?intval($_POST["price"]):null;
        $pos_product = (isset($_POST["pos_product"]))?intval($_POST["pos_product"]):null;
        $action = (isset($_POST["action"]))?htmlspecialchars($_POST["action"]):null;
        $total_cost = (isset($_POST["total_cost"]))?intval($_POST["total_cost"]):0;


        if (!isset($_SESSION["products"])) {
            $_SESSION["products"] = [];
        }

        //we are saving the position on the session to not lose it
        // so if not exist we are going to initialize
        if (!isset($_SESSION["pos_product"])) {
            $_SESSION["pos_product"] = [];
        }
        if (isset($pos_product)){
            $_SESSION["pos_product"] = $pos_product;
        }

        if (isset($_POST["add"])){
            $_SESSION["products"][] = [
                "name" => $name,
                "quantity" => $quantity,
                "price" => $price
            ];
            echo'<p style="color: green;">Item added properly</p>';
        } else if (isset($_POST["update"]) && isset($_SESSION["pos_product"])){
            $_SESSION["products"][$_SESSION["pos_product"]] = [
                "name" => $name,
                "quantity" => $quantity,
                "price" => $price
            ];
            unset($_SESSION["pos_product"]);
            echo'<p style="color: green;">Item updated properly</p>';

        } else if(isset($_POST["action"]) && $_POST["action"] == "delete"){
            unset($_SESSION["products"][$_SESSION["pos_product"]]);
            $_SESSION["products"] = array_values($_SESSION["products"]); // Reindex array
            echo'<p style="color: green;">Item deleted properly</p>';

        } else if (isset($_POST["pos_product"])){
            echo'<p style="color: green;">Item selected properly</p>';
        }
        showProducts($total_cost);
    }

    // variable products references the $_SESSION["products"]
    function showProducts($total_cost){
        echo '
        <table border="1">
                <thead>
                    <tr>
                        <th>name</th>
                        <th>quantity</th>
                        <th>price</th>
                        <th>cost</th>
                        <th>actions</th>
                    </tr>
                </thead>
                <tbody>';
            $count = 0;
            $total = 0;
            foreach($_SESSION["products"] as $product){
                $cost = $product["price"] * $product["quantity"];
                $total += $cost; // Sum to total
                echo '
                    <tr>
                        <td>'.$product["name"].'</td>
                        <td>'.$product["quantity"].'</td>
                        <td>'.$product["price"].'</td>
                        <td>'.$cost.'</td>
                        <td style="display: flex;">
                            <form method="POST">
                                <input type="hidden" name="pos_product" value="'.$count.'">
                                <input type="submit" name="action" id="action" value="edit">
                            </form>
                            <form method="POST">
                                <input type="hidden" name="pos_product" value="'.$count.'">
                                <input type="submit" name="action" id="action" value="delete">
                            </form>
                        </td>
                    </tr>';
                $count++;
            }
                echo '<tr>
                        <td colspan="3" style="text-align: right;">Total:</td>
                        <td>'.$total_cost.'</td>
                        <td>
                            <form method="POST">
                                <input type="hidden" name="total_cost" value="'.$total.'">
                                <input type="submit" name="action" id="action" value="Calculate total">
                            </form>
                        </td>
                    </tr>
                </tbody>
        </table>';
    }
    ?>
</body>

</html>