<?php
session_start();
$servername = "localhost";
$username = "root";
$password = "root";
$dbname = "todoapp";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


// Get user input
$user = $_POST['username'];
$pass = $_POST['password'];

// Protect against SQL injection
$user = stripslashes($user);
$pass = stripslashes($pass);
$user = $conn->real_escape_string($user);
$pass = $conn->real_escape_string($pass);

// Hash the password
$pass = md5($pass);

// Check credentials
$sql = "SELECT * FROM users WHERE name='$user' AND password='$pass'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Store user session
    header("Location: dashboard.html");
    $_SESSION['username'] = $user;

    echo "Login successful. Welcome, " . $user . "!";
} else {
    echo "Invalid username or password.";
}

$conn->close();
?>
