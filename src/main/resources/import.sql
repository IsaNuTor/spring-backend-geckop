/*Tabla clientes*/
INSERT INTO clientes (nombre, apellidos, email, fecha_registro) VALUES('Isa', 'Núñez de la Torre', 'dev@ucm.es', '2019-03-16');
INSERT INTO clientes (nombre, apellidos, email, fecha_registro) VALUES('Juan', 'García Pérez', 'Juan@ucm.es', '2019-02-15');
INSERT INTO clientes (nombre, apellidos, email, fecha_registro) VALUES('María', 'García Sánchez', 'Maria@ucm.es', '2019-01-20');
INSERT INTO clientes (nombre, apellidos, email, fecha_registro) VALUES('Alberto', 'Ruíz', 'Alberto@ucm.es', '2018-12-05');
INSERT INTO clientes (nombre, apellidos, email, fecha_registro) VALUES('Inma', 'Fernández', 'Inma@ucm.es', '2019-03-15');


/*Tabla acreedor*/
INSERT INTO acreedor (nif, iban, nombre) VALUES('05464654K', 'ES40548500001111', 'Isa');
INSERT INTO acreedor (nif, iban, nombre) VALUES('11111111G', 'ES46048500002222', 'María');
INSERT INTO acreedor (nif, iban, nombre) VALUES('46546156L', 'ES40548500003333', 'Juan');
INSERT INTO acreedor (nif, iban, nombre) VALUES('05648746A', 'ES40548500004444', 'Pedro');

/*Tabla Usuario*/
INSERT INTO usuario (dni, password, nombre, apellido1, apellido2, email, telefono, departamento, centro) VALUES('05464654K', 'passs', 'Isa', 'Núñez', 'De La Torre', 'isa@ucm.es', '612345678', 'Departamento de sistemas informáticos', 'Facultad de Informática');
INSERT INTO usuario (dni, password, nombre, apellido1, apellido2, email, telefono, departamento, centro) VALUES('12345678A', 'passs', 'Pepito', 'Núñez', 'Pérez', 'pepito@ucm.es', '612345678', 'Departamento de sistemas informáticos', 'Facultad de Informática');
INSERT INTO usuario (dni, password, nombre, apellido1, apellido2, email, telefono, departamento, centro) VALUES('01234567A', 'passs', 'Mercedes', 'García', 'Merayo', 'mercedes@ucm.es', '612345678', 'Departamento de sistemas informáticos', 'Facultad de Informática');
INSERT INTO usuario (dni, password, nombre, apellido1, apellido2, email, telefono, departamento, centro) VALUES('04863609Y', 'passs', 'Aza', 'Fernández', 'Notario', 'aza@ucm.es', '612345678', 'Departamento de sistemas informáticos', 'Facultad de Informática');

/*Tabla gasto*/
INSERT INTO gasto (id_orden, comentarios, importe, descripcion, iva) VALUES('1', 'coment', '25', 'descripcion', '21');
INSERT INTO gasto (id_orden, comentarios, importe, descripcion, iva) VALUES('2', 'comentario2', '85', 'descripcion2', '21');

/*Tabla tipo gasto*/
INSERT INTO tipogasto (nombre) VALUES('Viajes');
INSERT INTO tipogasto (nombre) VALUES('Material');

/*Tabla Orden*/
INSERT INTO orden(acronimo, numeracion, estado, nif_user, fecha_orden, num_contabilidad, concepto, memoria,relacion, nif_acreedor, observaciones) VALUES('proy_orden', 'acr', '1200', 'pendiente','04863609Y', '03-05-21','cont5874521', 'concepto', 'memoria','relacion','01155456L','obseravaciones');


/*Tabla Proyectos*/
INSERT INTO proyecto (acronimo, fecha_cierre, fecha_inicio, ip1, ip2, n_contabilidad, nombre, presupuesto) VALUES('Geckop', '2019-05-20', '2018-10-01', '05464654K', '04863609Y', '1', 'Gestión Economica de Proyectos de Investigación', '0')
INSERT INTO proyecto (acronimo, fecha_cierre, fecha_inicio, ip1, ip2, n_contabilidad, nombre, presupuesto) VALUES('AT', '2018-06-01', '2018-02-01', '12345678A', '', '2', 'AirsoftTeam', '0')
INSERT INTO proyecto (acronimo, fecha_cierre, fecha_inicio, ip1, ip2, n_contabilidad, nombre, presupuesto) VALUES('P1', '2019-04-20', '2019-01-01', '01234567A', '12345678A', '3', 'Proyecto1', '10000')
INSERT INTO proyecto (acronimo, fecha_cierre, fecha_inicio, ip1, ip2, n_contabilidad, nombre, presupuesto) VALUES('P2', '2019-02-20', '2018-11-01', '04863609Y', '', '4', 'Proyecto2', '1000')

/*Tabla de UsuarioProyecto*/
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('Geckop', '05464654K' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('Geckop', '04863609Y' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('Geckop', '12345678A' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('Geckop', '01234567A' , 'Miembro del equipo de trabajo')

INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('AT', '01234567A' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('AT', '05464654K' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('AT', '04863609Y' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('AT', '12345678A' , 'Profesor Invitado')

INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('P1', '12345678A' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('P1', '01234567A' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('P1', '05464654K' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('P1', '04863609Y' , 'Profesor Invitado')

INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('P2', '04863609Y' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('P2', '12345678A' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('P2', '01234567A' , 'Miembro del proyecto')
INSERT INTO usuarioproyecto (acronimo, dni, rol) VALUES ('P2', '05464654K' , 'Miembro del equipo de trabajo')




