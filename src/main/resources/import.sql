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
INSERT INTO usuario (dni, password, nombre, apellido1, apellido2, email) VALUES('05464654K', 'pass', 'Isa', 'Nuñez', 'De La Torre', 'isa@ucm.es');

/*Tabla gasto*/
INSERT INTO gasto (id_orden, comentarios, importe, descripcion, iva) VALUES('1', 'coment', '25', 'descripcion', '21');

