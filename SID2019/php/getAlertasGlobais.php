<?php
$url="127.0.0.1";
$database="sid";
/*$username="root";
$password="";
$conn = mysqli_connect($url, $username, $password, $database);
$date = "2019-05-09 %";*/
$date = $_POST['data_hora'];
$conn = mysqli_connect($url,$_POST['username'],$_POST['password'],$database);
$sql = "SELECT alertas.data_hora, variaveis.nome, alertas.limite_inferior, alertas.limite_superior, alertas.valor_medicao, cultura.descricao_cultura\n"
    . "FROM alertas\n"
    . "inner join cultura ON alertas.id_cultura=cultura.id_cultura\n"
    . "inner join variaveis ON alertas.id_variavel=variaveis.id_variavel\n"
    . "WHERE alertas.data_hora LIKE \"$date\"";
$result = mysqli_query($conn, $sql);
$response["alertasGlobais"] = array();
if ($result){
  if (mysqli_num_rows($result)>0){
    while($r=mysqli_fetch_assoc($result)){
      $ad = array();
      $ad["DataHora"] = $r['data_hora'];
      $ad["NomeVariavel"] = $r['nome'];
      $ad["LimiteInferior"] = $r['limite_inferior'];
      $ad["LimiteSuperior"] = $r['limite_superior'];
      $ad["ValorMedicao"] = $r['valor_medicao'];
      $ad["Descricao"] = $r['descricao_cultura'];
      array_push($response["alertasGlobais"], $ad);
    }
  }
}
$json = json_encode($response["alertasGlobais"]);
echo $json;
mysqli_close ($conn);
