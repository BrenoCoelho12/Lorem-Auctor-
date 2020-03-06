create database bancoljm;
use bancoljm;


CREATE TABLE horaMysql(
    id INT not null,
    created_on DATETIME NOT NULL DEFAULT NOW() -- or CURRENT_TIMESTAMP
);

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
	cpf varchar(25),
	rgInscricao varchar(15),
	email varchar(50) not null,
	cidade varchar(30) not null,
	estado char(2) not null,
	endereco varchar(50) not null,
	tCelular varchar(20) not null,
	tResidencial varchar(20) not null,
    bairro varchar(50),
    numero varchar(8),
    complemento varchar(100),
    observacao varchar(250),
	primary key(idCliente)
);

create table movimentoDiario (
	idMovimento int auto_increment,
	precoTotal decimal(10,2) not null,
	dataa varchar(50) not null,
    dataMes varchar(20) not null,
	primary key(idMovimento)
);



create table vendedor (
	idVendedor int auto_increment,
	nomeVendedor varchar(50) not null,
	salario decimal(10,2) not null,
	primary key(idVendedor)
);

	insert into vendedor (nomeVendedor, salario) values('EMERSON', 0000.00);
	insert into vendedor (nomeVendedor, salario) values('EDINHO', 0000.00);
	insert into vendedor (nomeVendedor, salario) values('ERIVAM', 1000.00);

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

create table preVenda (
	idPreVenda int auto_increment,
    idCliente int not null,
    dataPreVenda date not null,
    valorAtual decimal(8,2) not null,
    primary key(idPreVenda),
    foreign key(idCliente) references cliente_fisico(idCliente)
);

create table produtosPreVenda (
	idItemProdutoPreVenda int primary key auto_increment,
    idProduto int not null,
    idPreVenda int not null,
    valorRevenda decimal(8,2) not null,
    quantidade int not null,
    foreign key (idProduto) references produtos(idProduto),
    foreign key (idPreVenda) references preVenda(idPreVenda)
);

create table venda (
	idVenda int auto_increment,
	idCliente int not null,
	idVendedor int,
	dataVenda varchar(60) not null,
    dataVencimento varchar(60),
	observacoes varchar(255),
	acrescimos decimal(10,2),
	desconto decimal(10,2),
	total decimal(10,2) not null,
    totalPago decimal(10,2),
    totalCompra decimal(10,2),
	totalConta decimal(10,2),
    totalRestante decimal(10,2),
	qtdVolumes int,
    formaPagamento varchar(50) not null,
	situacao varchar(20),
	primary key(idVenda),
	foreign key (idVendedor) references vendedor(idVendedor),
	foreign key(idCliente) references cliente_fisico(idCliente)    
);

create table itemProduto (
	idItemProduto int primary key auto_increment,
    idProduto int not null,
    idVenda int not null,
    valorRevenda decimal(8,2) not null,
    quantidade int not null,
    foreign key (idProduto) references produtos(idProduto),
    foreign key (idVenda) references venda(idVenda)
);

create table parcela (
	idParcela int auto_increment,
    idVenda int not null,
    idCliente int not null,
    dataVencimento varchar(20) not null,
    descricao varchar(50) not null,
    quantidadeParcelas int not null,
    valorDevido decimal(10,2) not null,
    valorTotalCompra decimal(10,2) not null,
    situacao varchar(50) not null,
    primary key(idParcela),
    foreign key(idVenda) references venda(idVenda),
    foreign key(idCliente) references cliente_fisico(idCliente)
);

create table detalhamentoConta (
	idDetalhamento int auto_increment,
    cliente int not null,
    idVenda int,
    valor decimal(10,2) not null,
    dataInformada varchar(60) not null,
    datasVencimento varchar(50) not null,
	observacao varchar(50) not null,
	valorPago decimal(10,2),
    valorCompras decimal(10,2),
    saldoDevedor decimal(10,2),
    situacao varchar(50) not null,
    formaPagamento varchar(50) not null,
    primary key(idDetalhamento),
    foreign key (cliente) references cliente_fisico(idCliente),
    foreign key(idVenda) references venda(idVenda)
);
