create table pessoa(nome varchar2(255),
nascimento date,
cpf varchar2(255),
genero varchar2(255));

create table produto(descricao varchar2(255),codigo varchar2(255),quantidade number(4, 0),localizacao varchar2(255),valor number(8, 2));
create table contrato(contratante varchar2(255),contratado varchar2(255),data date,valor number(8, 2),clausulas varchar2(255),multa varchar2(255));
