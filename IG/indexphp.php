<?php
// Verificar las credenciales (esto es muy básico y no seguro, solo para fines demostrativos)
$username = $_POST['username'];
$password = $_POST['password'];

// Compara las credenciales con valores predefinidos (deberías almacenar estas credenciales de manera segura)
$valid_username = 'usuario';
$valid_password = 'contrasena';

if ($username === $valid_username && $password === $valid_password) {
    // Credenciales válidas
    echo "¡Bienvenido, $username!";
} else {
    // Credenciales inválidas
    echo "Credenciales incorrectas. Por favor, inténtalo de nuevo.";
}
?>
