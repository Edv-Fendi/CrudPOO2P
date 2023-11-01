create database projetoOOP;
use projetoOOP;

create table ramo(
     id_Ramo int auto_increment primary key,
     nome varchar(40)
);

create table porte(
      id_porte int auto_increment primary key,
      nome varchar(40)
);

CREATE TABLE Endereco (
      Id_Endereco int primary key auto_increment,
      Cidade varchar(50) not null,
      Numero char(10) not null,
      Estado varchar(50) not null,
      Bairro varchar(50) not null,
      CEP char(10) not null,
      Complemento varchar(50)
);

CREATE TABLE Colaborador (
     Id_Colaborador int primary key auto_increment,
     Nome varchar(55) NOT NULL,
     Telefone char(11),
     Email varchar(55),
     Funcao varchar(50) NOT NULL,
     Setor varchar(50) NOT NULL,
     is_Admin boolean,
     Id_Endereco int,
     FOREIGN KEY (Id_Endereco) REFERENCES Endereco (Id_Endereco)
);
create table Empresa(
    id_empresa int auto_increment primary key,
    email varchar(50),
    razao_socail varchar(100),
    nome_fantasia varchar(50),
    cnpj char(14),
    quantidade_funcionario int,
    telefone char(9),
    pontuacao int,

    id_ramo int,
    foreign key (id_ramo) references ramo (id_Ramo),

    id_porte int,
    foreign key (id_porte) references porte (id_porte),

    id_endereco int,
    foreign key (id_endereco) references Endereco (Id_Endereco)

);

