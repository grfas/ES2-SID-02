<?php
$url="127.0.0.1";
$database="sid";
/*$username="root";
$password="";
$conn = mysqli_connect($url, $username, $password, $database);*/
$user = $_POST['username'];
//$user='jorge';
$conn = mysqli_connect($url,$_POST['username'],$_POST['password'],$database);
$sql = "SELECT id_cultura, nome_cultura\n"
. "  FROM cultura \n"
. " WHERE responsavel IN (SELECT id_investigador \n"
. "               FROM investigador\n"
. "               WHERE email LIKE (\n"
. "               SELECT email\n"
. "               FROM sid_user\n"
. "               WHERE user_name LIKE \"$user\"))";
$result = mysqli_query($conn, $sql);
$response["culturasOfUser"] = array();
if ($result){
  if (mysqli_num_rows($result)>0){
    while($r=mysqli_fetch_assoc($result)){
      $ad = array();
      $ad["IDCultura"] = $r['id_cultura'];
      $ad["NomeCultura"] = $r['nome_cultura'];
      array_push($response["culturasOfUser"], $ad);
    }
  }
}
$json = json_encode($response["culturasOfUser"]);
echo $json;
mysqli_close ($conn);
