create table pets(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    idade varchar(100) not null,
    porte varchar(100) not null,
    personalidade varchar(150) not null,
    ativo tinyint default 1,

    primary key(id)

);