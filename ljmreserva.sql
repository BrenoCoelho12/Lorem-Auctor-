create database bancoljmreserva;
use bancoljmreserva;

create table produtos (
	idProduto int auto_increment,
	nomeProduto varchar(50) not null,
	precoVarejo decimal(10,2) not null,
	precoRevenda decimal(10,2) not null,
	precoDeCompra decimal(10,2) not null,
    unidade varchar(40) not null,
    estoque int not null,
	localizacao varchar(50) not null,
	marca varchar (20),
    idTipoProduto int not null,
	primary key(idProduto),
	foreign key (idTipoProduto) references tipoProduto(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

ALTER TABLE produtos ADD COLUMN estoque int not null;
drop table produtos;
select * from produtos;

create table tipoProduto (
	id int auto_increment,
	descricao varchar(20) not null,
	primary key(id)
    
);

	insert into tipoProduto (descricao) values ('');
	insert into tipoProduto (descricao) values ('Motocicleta');
	insert into tipoProduto (descricao) values ('Bicicleta');

create table cliente_fisico (
	idCliente int auto_increment,
	nomeCliente varchar(40) not null,
	cpf char(14),
	rgInscricao varchar(15),
	email varchar(50) not null,
	cidade varchar(30) not null,
	estado char(2) not null,
	endereco varchar(50) not null,
	tCelular varchar(20) not null,
	tResidencial varchar(20) not null,
	primary key(idCliente)
);

drop table cliente_fisico;
create table movimentoDiario (
	idMovimento int auto_increment,
	precoTotal decimal(10,2) not null,
	dataa varchar(50) not null,
    dataMes varchar(20) not null,
	primary key(idMovimento)
);

drop table movimentoDiario;

create table vendedor (
	idVendedor int auto_increment,
	nomeVendedor varchar(50) not null,
	salario decimal(10,2) not null,
	primary key(idVendedor)
);
drop table vendedor;

	insert into vendedor (nomeVendedor, salario) values('EMERSON', 0000.00);
	insert into vendedor (nomeVendedor, salario) values('EDINHO', 0000.00);
	insert into vendedor (nomeVendedor, salario) values('ERIVAM', 1000.00);

create table venda (
	idVenda int auto_increment,
	idCliente int not null,
	idVendedor int,
	dataVenda char(10) not null,
	observacoes varchar(255),
	acrescimos decimal(10,2),
	desconto decimal(10,2),
	total decimal(10,2) not null,
    totalCompra decimal(10,2) not null,
	totalConta decimal(10,2),
    totalRestante decimal(10,2),
	qtdVolumes int not null,
	situacao varchar(20),
	primary key(idVenda),
	foreign key (idVendedor) references vendedor(idVendedor),
	foreign key(idCliente) references cliente_fisico(idCliente)
    
);
ALTER TABLE venda ADD COLUMN totalRestante decimal(10,2);
select * from venda;
delete from venda where idVenda = 69;
drop table venda;

create table itemProduto (
	idItemProduto int primary key auto_increment,
    idProduto int not null,
    idVenda int not null,
    valorRevenda decimal(8,2) not null,
    quantidade int not null,
    foreign key (idProduto) references produtos(idProduto),
    foreign key (idVenda) references venda(idVenda)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);
delete from itemProduto where idVenda = 69;
select * from itemProduto where idVenda = 56;
drop table itemProduto;

create table formaPagamento (
	idFormaPagamento int auto_increment,
	formaPagamento varchar(15) not null,
	primary key(idFormapagamento)
);

	insert into formaPagamento (formaPagamento) values ('Especie');
	insert into formaPagamento (formaPagamento) values ('Duplicata');
	insert into formaPagamento (formaPagamento) values ('Boleto');

create table pagarContas (
	idConta int auto_increment,
	empresa varchar(50) not null,
	valor decimal(7,2) not null,
	idFormaPagamento int not null,
	dataVencimento char(10) not null,
	dataCheque char(10),
	contaBancaria varchar(50),
	situacaoConta varchar(20),
	primary key (idConta),
	foreign key(idFormaPagamento) references formaPagamento(idFormaPagamento)
);

