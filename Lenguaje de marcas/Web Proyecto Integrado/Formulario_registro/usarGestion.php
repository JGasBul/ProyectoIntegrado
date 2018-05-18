<?php
$servidor = "34.228.255.166";
$usuario = "tragaperras";
$clave ="1234";

$mysqli = @mysqli_connect($servidor,$usuario,$clave);
#if (mysqli_connect_errno($mysqli)){
#	echo ("Fallo al conectar a Mysql: ".mysqli_connect_errno($mysqli). " ".
#		mysqli_connect_error($mysqli));
#	die ("NO SE PUDO REALIZAR LA CONEXIÓN");
#}
#else echo ("La conexión se ha producido OK");

$basedatos = "tragaperras";
mysqli_select_db($mysqli,$basedatos);

?>
