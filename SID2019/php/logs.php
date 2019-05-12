<?php
header("Content-Type:application/json");

$user = $_POST['idauditor'];

$data = getdata($user);	
	if(empty($data)){
		echo 'Data Not Found';
	}
	else{
		echo $data;
	}

function getdata($user){
	$url="127.0.0.1";
	$database="sid";
	$username="root";
	$password="";
	$conn = mysqli_connect($url, $username, $password, $database);
	if (!$conn){
		die ("Connection Failled: ".$conn->connect_error);
	}

  $sql = "SELECT * FROM sid_user WHERE id_user = ".$user;
  $result = mysqli_query($conn, $sql);
  $rows = array();

  if ($result){
	if (mysqli_num_rows($result)>0){
    $sql2 = "SELECT * FROM `sid_log`";
    $result2 = mysqli_query($conn, $sql2);
    if (mysqli_num_rows($result2)>0){
      while($r=mysqli_fetch_array($result2)){
        array_push($rows, $r);
      }
    }
    
	echo "Tabela de Logs da Base de Dados de Origem:";
	echo  "\n";
	echo  "\n";
   
  } else {
  echo "ID de Auditor inválido";
  echo  "\n";
  echo  "\n";
  }

return json_encode($rows);
mysqli_close ($conn);
  
} 
} 


?>
