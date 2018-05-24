CREATE DEFINER=`root`@`localhost` TRIGGER `usuarios_after_insert` AFTER INSERT ON `usuarios` FOR EACH ROW BEGIN
INSERT INTO `tragaperras`.`saldo` (DNI) VALUES (new.DNI);
INSERT INTO `tragaperras`.`estadisticas` (DNI) VALUES (new.DNI);
END