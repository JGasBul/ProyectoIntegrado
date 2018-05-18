
<?php

require ("usarGestion.php");

$DNI=$_REQUEST['DNI'];
$Nombre=$_REQUEST['Nombre'];
$Primer_apellido= $_REQUEST['Primer_apellido'];
$Segundo_apellido=$_REQUEST['Segundo_Apellido'];
$Username=$_REQUEST['Username'];
$Teléfono=$_REQUEST['Teléfono'];
$Contraseña=$_REQUEST['Contraseña'];
$Email=$_REQUEST['Email'];






$consulta ="INSERT INTO usuarios (DNI,Nombre,1ºApellido,2ºApellido,UserName,Telefono,Email,Contraseña) VALUES ('$DNI','$Nombre', '$Primer_apellido', '$Segundo_apellido', '$Username', '$Teléfono', 
'$Email','$Contraseña');";
 ("La instruccion es: $consulta <br>");
 
if (!$resultado = $mysqli->query($consulta))
{
 ("Lo sentimos la instrucción de BBDD ha fallado debido a: <br>");
 ("Query: $consulta <br>");
 ("Error_numero: ". $mysqli->errno . "<br>");
 ("Error: ". $mysqli->error . "<br>");
  exit;
}
else echo ("Se ha grabado el registro");




?>