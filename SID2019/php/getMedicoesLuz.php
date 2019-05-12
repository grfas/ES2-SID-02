	<?php
	$url="127.0.0.1";
	$database="sid";
	//$username="root";
	//$password="";
	//$conn = mysqli_connect($url, $username, $password, $database);
  $conn = mysqli_connect($url,$_POST['username'],$_POST['password'],$database);
	$sql = "SELECT data_hora_medicao, valor_medicao FROM medicoes\n"
    . "WHERE id_variavel IN (SELECT id_variavel\n"
    . "FROM variaveis WHERE nome LIKE \'Luminosidade\')";
	$result = mysqli_query($conn, $sql);
	$response["medicoes"] = array();
	if ($result){
		if (mysqli_num_rows($result)>0){
			while($r=mysqli_fetch_assoc($result)){
				$ad = array();
				$ad["valorMedicaoLuminosidade"] = $r['valor_medicao'];
				$ad["dataHoraMedicao"] = $r['data_hora_medicao'];
				array_push($response["medicoes"], $ad);
			}
		}
	}
	$json = json_encode($response["medicoes"]);
	echo $json;
	mysqli_close ($conn);
