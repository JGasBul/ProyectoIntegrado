
<?php

require ("usarGestion.php");

$Nombre=$_REQUEST['Nombre'];
$Primer_apellido=$_REQUEST['Primer apellido'];
$Segundo_apellido=$_REQUEST['Segundo apellido'];

$Contraseña=$_REQUEST['Contraseña'];
$Email=$_REQUEST['E-mail'];
$Username=$_REQUEST['Username'];
$DNI=$_REQUEST['DNI'];
$Teléfono=$_REQUEST['Teléfono'];



$consulta ="INSERT INTO usuarios (DNI,Nombre,Primer apellido,Segundo apellido,Contraseña,E-mail,Username,Teléfono) VALUES ('$DNI', '$Primer_apellido', '$Segundo_apellido', '$Contraseña', '$Email', '$Username', '$Teléfono');";
echo ("La instruccion es: $consulta <br>");
 
if (!$resultado = $mysqli->query($consulta))
{
  echo ("Lo sentimos la instrucción de BBDD ha fallado debido a: <br>");
  echo ("Query: $consulta <br>");
  echo ("Error_numero: ". $mysqli->errno . "<br>");
  echo ("Error: ". $mysqli->error . "<br>");
  exit;
}
else echo ("Se ha grabado el registro");




?>