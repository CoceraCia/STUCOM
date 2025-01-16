<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercise06</title>
</head>

<body>
    <fieldset style="width: 40%">
        <form action="Exercise06.php" method="POST" enctype="multipart/form-data">
            <label for="file">Archivo:</label>
            <input type="file" id="file" name="file" required><br>
            <label for="extension-list">Extension:</label>
            <select name="extension-list" id="extension-list">
                <option value="jpg">jpg</option>
                <option value="png">png</option>
                <option value="pdf">pdf</option>
            </select><br>
            <label for="size">Tamaño maximo en MB:</label>
            <input type="number" name="size" id="size">
            <input type="submit" value="submit">
        </form>
    </fieldset>


    <?php
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        // Directorio en el cual se subiran los archivos
        $uploadDir = 'uploads/';
        if (!is_dir($uploadDir)) {
            mkdir($uploadDir, 0755, true); // Create the uploads directory if it doesn't exist
        }

        // Obtenemos los valores de el archivo
        $file = $_FILES['file']; //el archivo
        $fileName = $file['name']; //el nombre del archivo
        $fileTmpName = $file['tmp_name']; //ruta temporal en el servidor
        $fileSize = $file['size'];  //tamaño del archivo
        $fileError = $file['error']; //Indica si hubo un error, nos dara un numero dependiendo del error

        // Obtenemos el tamaño maximo y la extension de nuestro formulario
        if (empty($_POST["size"])) {
            echo ("No se ha introducico ningun valor en el tamaño maximo");
            exit();
        } else {
            $maxSize = (int)$_POST["size"] * 1024 * 1024;
        }
        //Subimos la extension seleccionada en el formulario html
        $allowedExtension = $_POST['extension-list'];

        // Extraemos la extension del archivo subido
        $fileExtension = strtolower(pathinfo($fileName, PATHINFO_EXTENSION));

        // Comprobamos si hay algun error
        if ($fileError !== 0) {
            echo "Se ha producido un error al subir el archivo.";
            exit();
        }

        // Comprobamos si las extensiones coinciden
        if ($fileExtension !== $allowedExtension) {
            echo "La extension de archivo no coincide con la seleccionada-->.$allowedExtension";
            exit();
        }

        // Validamos si el tamaño es menor al maximo
        if ($fileSize > $maxSize) {
            echo "El tamaño excede al maximo--> " . ($_POST['size']) . " MB.";
            exit();
        }

        // Creamos el path donde se almacenara nuestro archivo
        $targetFilePath = $uploadDir . basename($fileName);

        // Subimos el archivo al directorio
        if (move_uploaded_file($fileTmpName, $targetFilePath)) {
            echo "Archivo subido! Guardado en: $targetFilePath";
        } else {
            echo "Error al guardar el archivo.";
        }
    }
    ?>

</body>

</html>