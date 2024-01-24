insert into usuarios  (username, password, nombre, apellido) values ('juan','1234','Juan', 'Lopez'); 
insert into usuarios  (username, password, nombre, apellido) values ('admin','9876','Pedro', 'Arias');

insert into roles (nombre) values ('ROLE_USER');
insert into roles (nombre) values ('ROLE_ADMIN');

insert into usuarios_roles (usuario_id,role_id) values (1, 1);
insert into usuarios_roles (usuario_id,role_id) values (2, 1);
insert into usuarios_roles (usuario_id,role_id) values (2, 2);