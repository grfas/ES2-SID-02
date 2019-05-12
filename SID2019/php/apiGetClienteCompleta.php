<?php
header("Content-Type:application/json");

$data = get_data();

if(empty($data)){
	echo 'Data Not Found';
}
else{
	echo $data;
}

function get_data(){
	$url="127.0.0.1";
	$database="sid";
	$username="root";
	$password="";
	$conn = mysqli_connect($url, $username, $password, $database);
	if (!$conn){
		die ("Connection Failled: ".$conn->connect_error);
	}
	$sql = "Select * from sid_log";
	$result = mysqli_query($conn, $sql);
	$rows = array();

	if ($result) {
		if (mysqli_num_rows($result)>0){
			while($r=mysqli_fetch_array($result)){
				array_push($rows, $r);
			}
		} else {
			echo 'Migracao';
		}
	}

	$sql2 = "UPDATE sid_log SET migracao = 1 WHERE  migracao IS NULL";
	$result2 = mysqli_query($conn, $sql2);
	return json_encode($rows);
	mysqli_close ($conn);
}
?>
