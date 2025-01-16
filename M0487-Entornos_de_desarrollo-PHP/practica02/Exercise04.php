<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise04</title>
</head>

<body>
    <!-- Formulario con enctype para permitir la subida de archivos -->
    <form action="Exercise04.php" method="POST" enctype="multipart/form-data">
        <label for="file">Archivo:</label>
        <input type="file" id="file" name="file" required><br>
        <input type="submit" value="submit">
    </form>

    <?php
    if ($_SERVER['REQUEST_METHOD'] == "POST") {

        // Verificar si el formulario fue enviado y si el archivo está disponible
        $target_dir = "uploads/";
        $target_file = $target_dir . basename($_FILES["file"]["name"]);
        $uploadOk = 1;
        $imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));

        if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file)) {
            echo "The file " . htmlspecialchars(basename($_FILES["file"]["name"])) . " has been uploaded.";
        } else {
            echo "Sorry, there was an error uploading your file.";
        }
    }
    ?>
</body>

</html>