 <?php

 $option = $_POST['migracao'];
 
 if($option == "Completa"){ 

  echo "Migração Completa"; 
  $url = "http://localhost/sid/apiGetClienteCompleta.php";
  $client = curl_init($url);
  curl_setopt($client,CURLOPT_RETURNTRANSFER,true);
  $response = curl_exec($client);
  echo "<br>";
  echo "<br>";
  echo $response; 

} else { 

  echo "Migração Básica";
  $url = "http://localhost/sid/apiGetClienteBasica.php";
  $client = curl_init($url);
  curl_setopt($client,CURLOPT_RETURNTRANSFER,true);
  $response = curl_exec($client);
  echo "<br>";
  echo "<br>";
  echo $response;
  
}

  $url = "http://localhost/sid2/apiPutCliente.php?data=".$response;
  $url = str_replace ( ' ', '%20', $url);
  $client = curl_init($url);
  curl_setopt($client,CURLOPT_RETURNTRANSFER,true);
  $response = curl_exec($client);
  echo $response;
  
?>
