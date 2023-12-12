create table abrigos(

    id bigint not null auto_increment,
    localidade varchar(100) not null,
    ativo tinyint default 1,

    primary key(id)

);