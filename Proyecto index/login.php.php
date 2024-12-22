/ index.php
// login.php
<?php
session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Lógica para verificar las credenciales y autenticar al usuario
    if ($autenticado) {
        $_SESSION['admin1'] = $nombre_de_usuario;
        header('Location: index.php');
        exit();
    } else {
        $mensaje_error = "Credenciales incorrectas";
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form method="post" action="login.php">
        Usuario: <input type="text" name="usuario"><br>
        Contraseña: <input type="password" name="contrasena"><br>
        <input type="submit" value="Iniciar sesión">
    </form>
    <?php if (isset($mensaje_error)) echo $mensaje_error; ?>
</body>
</html>