<?php

$url="127.0.0.1";
$database="sid";
$username="root";
$password="";
$conn = mysqli_connect($url, $username, $password, $database);
if (!$conn){
  die ("Connection Failled: ".$conn->connect_error);
}

$id_variavel=0;
$nome="var";

for ($i=1; $i<=1000; $i++){
$id_variavel++;
$name = $nome.$i;
$sql = "INSERT INTO Variáveis (IDVariável, NomeVariável) VALUES ('$id_variavel', '$name');";
$result = mysqli_query($conn, $sql);
}
mysqli_close ($conn);
?>
