insert into eif209_2021_01.rol (id_rol, descripcion) values (1, "Administrador");
insert into eif209_2021_01.rol (id_rol, descripcion) values (2, "Profesor");
insert into eif209_2021_01.rol (id_rol, descripcion) values (3, "Estudiante");

insert into eif209_2021_01.area_tematica (id_area, descripcion) values (1, "Informática");
insert into eif209_2021_01.area_tematica (id_area, descripcion) values (2, "Matemática");
insert into eif209_2021_01.area_tematica (id_area, descripcion) values (3, "Administración");

insert into eif209_2021_01.curso (id_curso, descripcion, area_tematica_id, promocion) 
values (1, "Programacion IV", 1, 1);
insert into eif209_2021_01.curso (id_curso, descripcion, area_tematica_id, promocion) 
values (2, "Programacion III", 1, 0);
insert into eif209_2021_01.curso (id_curso, descripcion, area_tematica_id, promocion) 
values (3, "Programacion II", 1, 1);
insert into eif209_2021_01.curso (id_curso, descripcion, area_tematica_id, promocion) 
values (4, "Programacion I", 1, 1);

insert into eif209_2021_01.curso (id_curso, descripcion, area_tematica_id, promocion) 
values (5, "Álgebra lineal", 2, 0);
insert into eif209_2021_01.curso (id_curso, descripcion, area_tematica_id, promocion) 
values (6, "Matemática para informática", 2, 1);
insert into eif209_2021_01.curso (id_curso, descripcion, area_tematica_id, promocion) 
values (7, "Probabilidad y estadistica", 2, 0);
insert into eif209_2021_01.curso (id_curso, descripcion, area_tematica_id, promocion) 
values (8, "Cálculo I", 2, 1);

insert into eif209_2021_01.curso (id_curso, descripcion, area_tematica_id, promocion) 
values (9, "Organización y su entorno", 3, 0);
insert into eif209_2021_01.curso (id_curso, descripcion, area_tematica_id, promocion) 
values (10, "Liderazgo", 3, 1); 

insert into eif209_2021_01.estado (id_estado, descripcion) values (1, "Aprobado");
insert into eif209_2021_01.estado (id_estado, descripcion) values (2, "Extraordinario");
insert into eif209_2021_01.estado (id_estado, descripcion) values (3, "Reprobado");
insert into eif209_2021_01.estado (id_estado, descripcion) values (4, "Sin asignar");

insert into eif209_2021_01.usuario 
(id_usuario, rol_id, clave, ultimo_aceso, activo)
values ("admin", 1, "VRRA", '2013-07-15 20:44:11', 0);

insert into eif209_2021_01.administrador 
(id_administrador, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
values 
(111222333, "admin", "Reyes", "Hernandez", "Fernanda", 86549861, "fer.reina@email.com");

insert into eif209_2021_01.usuario 
(id_usuario, rol_id, clave, ultimo_aceso, activo)
values ("profe2", 2, "MaUr", '2013-07-15 20:44:11', 0);

insert into eif209_2021_01.profesor 
(id_profesor, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
values 
(222222222, "profe2", "Elizondo", "Alvarado", "Muricio", 86549861, "mauricio.elizondo@email.com");

insert into eif209_2021_01.usuario 
(id_usuario, rol_id, clave, ultimo_aceso, activo)
values ("profe1", 2, "MkOp", '2013-07-15 20:44:11', 0);

insert into eif209_2021_01.profesor 
(id_profesor, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
values 
(111111111, "profe1", "Fernandez", "Jimenez", "Marianela", 86849821, "mari.nela@email.com");

insert into eif209_2021_01.usuario 
(id_usuario, rol_id, clave, ultimo_aceso, activo)
values ("profe3", 2, "LoPe", '2013-07-15 20:44:11', 0);

insert into eif209_2021_01.profesor 
(id_profesor, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
values 
(333333333, "profe3", "Ramirez", "Jimenez", "Carlos", 86849231, "carlitos.ra@email.com");

insert into eif209_2021_01.especialidad 
(profesor_id_profesor, area_tematica_id)
values (111111111, 1);

insert into eif209_2021_01.especialidad 
(profesor_id_profesor, area_tematica_id)
values (222222222, 2);

insert into eif209_2021_01.especialidad 
(profesor_id_profesor, area_tematica_id)
values (333333333, 3);

insert into eif209_2021_01.usuario 
(id_usuario, rol_id, clave, ultimo_aceso, activo)
values ("est1", 3, "MnJi", '2013-07-15 20:44:11', 0);

insert into eif209_2021_01.estudiante 
(id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
values 
(111111222, "est1", "Miranda", "Alvarado", "Karla", 76549861, "karlita.miranda@email.com");

insert into eif209_2021_01.usuario 
(id_usuario, rol_id, clave, ultimo_aceso, activo)
values ("est2", 2, "OpKj", '2013-07-15 20:44:11', 0);

insert into eif209_2021_01.estudiante 
(id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
values 
(222222111, "est2", "Fernandez", "Alvarado", "Juan", 76849821, "juan.cito@email.com");

insert into eif209_2021_01.usuario 
(id_usuario, rol_id, clave, ultimo_aceso, activo)
values ("est3", 2, "MnJu", '2013-07-15 20:44:11', 0);

insert into eif209_2021_01.estudiante 
(id_estudiante, usuario_id, apellido1, apellido2, nombre, telefono, e_mail) 
values 
(333333111, "est3", "Zamora", "Jimenez", "Harry", 76849231, "harry.potter@email.com");