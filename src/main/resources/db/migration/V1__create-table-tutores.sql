create table tutores(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    senha varchar(255) not null,
    telefone varchar(20),
    cidade varchar(100),
    sobre varchar(500),
    ativo tinyint default 1,

    primary key(id)

);