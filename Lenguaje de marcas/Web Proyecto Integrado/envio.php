
<?php


require("index.html");
	$destino = "luuudaaa2@gmail.com";
	$nombre = $_POST["Nombre"];
	$correo = $_POST["Correo"];
	$telefono = $_POST["Telefono"];
	$mensaje = $_POST["mensaje"];
	$contenido = "Nombre: " . $nombre . "\n Correo: " . $correo . "\n Teléfono: " . $telefono . "\n Mensaje: " . $mensaje;
	mail($destino, "Contacto", $contenido);
	
	header('Location:PaginaPrincipal.html');









	?>