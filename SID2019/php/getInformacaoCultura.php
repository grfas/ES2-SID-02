<?php
$url="127.0.0.1";
$database="sid";
/*$username="root";
$password="";
$conn = mysqli_connect($url, $username, $password, $database);
$idCultura='1';*/
$idCultura = $_POST['id_cultura'];
$conn = mysqli_connect($url,$_POST['username'],$_POST['password'],$database);
$sql = "select nome_cultura, descricao_cultura\n"
    . "from cultura\n"
    . "where id_cultura =".$idCultura;
$result = mysqli_query($conn, $sql);
$response["informacaoCultura"] = array();
if ($result){
  if (mysqli_num_rows($result)>0){
    while($r=mysqli_fetch_assoc($result)){
      $ad = array();
      $ad["NomeCultura"] = $r['nome_cultura'];
      $ad["DescricaoCultura"] = $r['descricao_cultura'];
      array_push($response["informacaoCultura"], $ad);
    }
  }
}
$json = json_encode($response["informacaoCultura"]);
echo $json;
mysqli_close ($conn);
