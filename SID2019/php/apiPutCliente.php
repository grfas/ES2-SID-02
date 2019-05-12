<?php
header("Content-Type:application/json");
if(!empty($_GET['data'])){
	$data=$_GET['data'];
	$result=put_data($data);
	echo "<br>";
    echo "<br>";
	echo $result . " records inserted."; 		
}
else{
	echo "Missing Parameter";
}
	
	
function put_data($data){
	$data = json_decode($data);	
	$url="127.0.0.1";
	$database="sid2";
	$username="root";
	$password="";
	$number_inserts = 0;

	$conn = mysqli_connect($url, $username, $password, $database);
	if ($conn){
		
		$sql = "select max(id_user) as id_user_max from sid_log;";
		$result = mysqli_query($conn, $sql);
		$rows = array();
		if (mysqli_num_rows($result)>0) {
			$r=mysqli_fetch_assoc($result);
			$next_record_id = $r["id_user_max"]+1 ;	
		}
		else{
			$next_record_id = 1;
		}
		foreach ($data as $inv ) {
			if ($inv->id_user >=$next_record_id){
				$id_user = $inv->id_user;
			}
			else{
				$id_user= $next_record_id;
			}
			$id_user = $inv->id_user;
			$mensagem= $inv->mensagem;
			$migracao=$inv->migracao;
			$momento_criacao= $inv->momento_criacao;
			$operacao= $inv->operacao;
			if (empty($id_user)){
				$id_user = 'null';
			}
			if (empty($mensagem)){
				$mensagem = 'null';
			}
			if (empty($migracao)){
				$migracao = 'null';
			}
			if (empty($momento_criacao)){
				$momento_criacao = 'null';
			}
			if (empty($operacao)){
				$operacao = 'null';
			}
			$sql = "INSERT INTO sid_log (id_user, mensagem, migracao,momento_criacao,operacao) VALUES ($id_user,'$mensagem','$migracao','$momento_criacao','$operacao');";
			$res = mysqli_query($conn, $sql);
			if(!$res){
				$result = new stdClass();
				$result->status = false;
				$result->msg = mysqli_error($conn);
				echo json_encode($result);
				exit;
			}
			$number_inserts = $number_inserts  + 1;
			$next_record_id =$next_record_id + 1;
	}
	mysqli_close ($conn);
	}
	return $number_inserts;
}
	