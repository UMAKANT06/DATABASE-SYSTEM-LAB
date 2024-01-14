<?php

// phpinfo();

if (!function_exists('mysqli_init') && !extension_loaded('mysqli')) {
    echo 'We don\'t have mysqli!!!';
} else {
    echo 'We are connected with mysql !'."<br>";
}

//making the connection with databse
$servername = "localhost";
$username = "root";
$password = "1234";
$dbname = "new_database";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Create table if not exists
$createTableSql = "CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    rollnumber VARCHAR(50) NOT NULL
)";

if ($conn->query($createTableSql) === FALSE) {
    echo "Error creating table: " . $conn->error;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $name = $_POST['name'];
  $email = $_POST['email'];
  $rollnumber=$_POST['rollnumber'];

  $sql = "INSERT INTO users (name, email, rollnumber) VALUES ('$name', '$email', '$rollnumber')";

  if ($conn->query($sql) === TRUE) {
      echo "New record created successfully"."<br>";
  } else {
      echo "Error: " . $sql . "<br>" . $conn->error;
  }
}

// Fetch data from the database
$sql = "SELECT * FROM users";
$result = $conn->query($sql);

echo '<style>
table {
    width: 100%;
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
    padding: 15px;
    text-align: left;
}

table tr:nth-child(even) {
    background-color: #f2f2f2;
}

table th {
    background-color: #4CAF50;
    color: white;
}
</style>';

if ($result->num_rows > 0) {
    // Start the table
    echo "<table>";
    echo "<tr><th>ID</th><th>Name</th><th>Email</th><th>Roll Number</th></tr>";

    // Output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>" . $row["id"]. "</td><td>" . $row["name"]. "</td><td>" . $row["email"]. "</td><td>" . $row["rollnumber"]. "</td></tr>";
    }

    // End the table
    echo "</table>";
} else {
    echo "0 results";
}

$conn->close();

?>
