create database canil;
	\c canil


begin;
create table Cliente(Cpf varchar (11) not null, Nome varchar (50) not null, Endereco varchar(80) not null,
	 Telefone varchar(9) not null, primary key (Cpf));

create table Cao(Cao_id serial, Raca varchar(15), Cnome varchar(20) not null, Tamanho varchar(15) not null, 
	Cor varchar(15), Temperamento varchar(15), Dono_cpf varchar(11) not null, primary key (Cao_id),
	 foreign key (Dono_cpf) references Cliente(Cpf) on delete cascade);

create table Hospedagem(Hospnr serial, Cao_id int not null, Qtd_dias int not null, primary key (Hospnr),
	foreign key (Cao_id) references Cao(Cao_id)on delete cascade);

create table Servicos( Id_serv serial, Scpf varchar(11) not null, Banho int, Tosa int, primary key ( Id_serv),
	foreign key (Scpf) references Cliente (Cpf) on delete cascade);

create table Adestramento(id_adestramento serial, Hospnr int not null, Tempo_aula time not null, Qtd_aula int not null, 
	primary key (id_adestramento), foreign key (Hospnr) references Hospedagem(Hospnr) on delete cascade);

create table Passeio(Hospnr int, qtd_passeio int, Tempo_passeio time, 
	primary key (Hospnr), foreign key (Hospnr) references Hospedagem(Hospnr)on delete cascade);				  

create table Pagamento(Id_pg serial, Valor decimal not null, Data_pg date not null, Cliente_cpf varchar(11), 
	primary key(Id_pg), foreign key (Cliente_cpf) references Cliente(Cpf)on delete cascade);	


insert into Cliente values
	('12345678966', 'Raimundo das chagas',	'Rua Grito de alerta, 751, Goiabeiras, Fortaleza Ce', '86726354'),
	('33344555587', 'Jose pereira dos santos', 'Av Leste oeste, 1002, Pirambu, Fortaleza Ce', '88227364'),
	('99988777767',	'Fukushita Kishimoto', 'Rua Sao Paulo, 322, Centro, Fortaleza Ce', '96152437'),
	('98765432168',	'Seu ze da carroca', 'Av Francisco Sa, 9872, Carlito Pamplona, Fortaleza Ce', '99115463'),
	('66688444476',	'Klebson marcondes de arruda', 'Rua são Jose, 898, Parque Leblon, Caucaia Ce', '87143657'),
	('45345345376',	'Ronaldo lopes souza', 'Av Ulisses Guimaraes, 10016, Iparana, Caucaia Ce', '89273642'),
	('98798798733',	'Joao dos cheiro verde', 'Rua Santa Rosa, 234, Pirambu, Fortaleza Ce', '96561786'),
	('88866555576',	'Luiz mata porco', 'Av Coronel de Carvalho, 635, Barra do Ceara, Fortaleza Ce', '88550313'),
	('89283542599',	'Yukihira Souma', 'AV 13 de maio, 108, Benfica, Fortaleza Ce', '88223741'),
	('62435647890',	'Jair Fernando Daciolo', 'Rua Artulieta Albuquerque, 331, Parque Leblon, Caucaia Ce', '99964532');


insert into Cao (Raca, Cnome, Tamanho, Temperamento, Cor,  Dono_cpf) values
	('Pe duro', 'Parasita', 'pequeno', 'docil','castanho', '12345678966'),
	('Pitbull', 'Bob','grande', 'docil','preto', '33344555587'),
	('Rottweiler', 'Noite Escura','grande', 'agressivo', 'escuro', '33344555587'),
	('Pastor Alemao', 'Tin Tin','pequeno', 'agressivo', 'preto', '12345678966'),
	('Pinscher', 'Golias', 'pequeno', 'agressivo', 'cinza', '99988777767'),
	('Chow chow', 'China', 'medio' ,'agressivo', 'preto', '45345345376'),
	('Pastor Alemao', 'Rufus','grande', 'docil', 'padrao', '98798798733'),
	('Pitbull', 'Mainha','grande', 'docil', 'dourado', '99988777767'),
	('Dog Alemao', 'Bobao', 'gigante', 'docil', 'rajado', '88866555576'),
	('Pe duro', 'Bacteria', 'medio','agressivo', 'preto', '88866555576'),
	('Poodle','Algodao', 'pequeno', 'agressivo', 'cinza', '12345678966'),
	('Yorkshire', 'Padilha','pequeno','docil', 'branco','98798798733'),
	('Rottweiler', 'Cyber','pequeno','docil','padrao','45345345376'),
	( 'Fox Paulistinha','Fuzil', 'medio', 'docil', 'vermelho', '89283542599'),
 	( 'Dalmata','Cabra', 'grande', 'docil',	'padrao', '62435647890');


insert into Servicos(Scpf, Banho, Tosa) values
	('12345678966',	'4', '1'),
	('33344555587',	'1', '0'),
	('99988777767',	'2', '2'),
	('98765432168',	'4', '1'),
	('66688444476',	'1', '0'),
	('45345345376',	'1', '1'),
	('98798798733', '2', '0'),
	('88866555576', '2', '1'),
	('89283542599',	'3', '0'),
	('62435647890',	'2', '1');


insert into Hospedagem (Cao_id, Qtd_dias)values	
	(1	,26),
	(9,	12),
	(3,	5),
	(7,	13),
	(5,	34),
	(10, 4),
	(13, 5),
	(8,	2),
	(12, 45),
	(14, 22),
	(15, 17);

insert into Adestramento (Hospnr, Tempo_aula, Qtd_aula)values
	
	(2,	'0:30:0', 10),
	(4,	'1:00:0', 10),
	(5,	'1:00:0', 30),
	(9,	'0:30:0', 45),
	(6,	'0:30:0', 20),
	(7,	'0:30:0', 17);


insert into Passeio values
	(6,	5, '0:30:0'),
	(7,	5, '0:30:0'),
	(8,	2, '0:30:0'),
	(3,	2, '01:0:0'); 

insert into Pagamento(Valor, Data_pg, Cliente_cpf) Values
	('1000.00', '25/05/18', '12345678966'),
	('150.00', '30/01/18', '33344555587'),
	('3150.00', '12/09/18', '99988777767'),
	('500.00', '14/07/18', '45345345376'),
	('4000.00', '25/01/18', '98798798733'),
	('1350.00', '12/05/18', '88866555576'),
	('1080.00', '22/10/18', '89283542599'),
	('1400.00', '08/10/18', '62435647890');

commit;


---------------------------------------------------------------------------------------------------------
-- nome cliente, nome cao ,raca, quantidade de dias hospedado; 
select c.nome as Cliente, ca.cnome as Nome_cao, ca.raca as Raca, Qtd_dias as Dias_Hospedado      
from cliente c, cao ca , Hospedagem h 
where c.cpf = ca.Dono_cpf and ca.cao_id = h.Cao_id;


--nome, cnome, qtd_banho, qtd_tosa, qtd_aula, qtd_passeio, qtd_dias, cpf;
select cl.nome as Nome_cliente, c.cnome as Nome_Cao , c.Raca, s.banho as qtd_banho, s.tosa as qtd_Tosa,
 a.Qtd_aula, p.qtd_passeio, h.qtd_dias, cl.cpf
from servicos s, cliente cl, cao c, Hospedagem h full join Adestramento a on a.Hospnr = h.Hospnr 
full join Passeio p on p.Hospnr = h.Hospnr
where c.Cao_id = h.Cao_id and cl.cpf = c.Dono_cpf and cl.cpf = s.scpf order by  cl.nome asc;


--nome de todos os caes e caes  hospedados e suas racas
select ca.cnome as Caes, c.cnome , c.raca as Estao_hospedados from cao ca 
left join (select c.cnome from cao c, hospedagem h where c.Cao_id = h.cao_id) c
on c.cnome = ca.cnome order by ca.cnome;


--selecionar nome cliente, nome e raca de todos os caes que que sao de caucaia
select c.nome as Nome_cliente, ca.cnome as Nome_Cao, ca.raca
from cao ca, Cliente c
where ca.dono_cpf = c.cpf 
and c.Endereco = ANY (select Endereco from cao where c.Endereco like '%Caucaia%');

--Mostrar Clientes que possuem mais de um Cao
select	c.nome as Cliente,	count(*) as qtd_caes	
from	Cliente c, Cao ca
where	c.cpf	=	ca.Dono_cpf		
group	by	c.cpf	
having	count(*)>=2;

-- Mostrar o nome do cliente que gastou mais e o nome e racas de seu(s) cao(es) 
select c.nome, p.Valor as  Total , ca.cnome as Nome_cao, ca.raca  
from  Cliente c, Pagamento p 
left join cao ca on ca.dono_cpf = p.Cliente_cpf  
where Valor >= ALL (select Valor from 
Pagamento ) and p.Cliente_cpf = c.cpf;

--Mostrar o nome dos caes que nao estao hospedados
select	Ca.cnome as Cao_Nao_Hospedado, ca.raca  		
from	cao ca 		
where	not exists (select * from hospedagem h where ca.Cao_id = h.Cao_id);	

--Soma de todos os pagamentos, Menor Valor pago e a Media de todos os Pagamentos
select (select SUM(Valor) from Pagamento) as Soma_Total, 
(select MIN(Valor) from Pagamento) as Menor_pagamento,
(select round(AVG(Valor),3) from Pagamento) as Media_Pagamentos;




CREATE USER padrao WITH PASSWORD 'padrao';
CREATE USER gabriel WITH PASSWORD 'gabriel';

create role admin;
GRANT ALL PRIVILEGES ON DATABASE canil TO admin;	
grant admin to gabriel;


create or replace view informacoes as(select cl.nome as Nome_cliente,
 c.cnome as Nome_Cao , c.Raca, s.banho as qtd_banho, s.tosa as qtd_Tosa,
 a.Qtd_aula, p.qtd_passeio, h.qtd_dias, cl.cpf
from servicos s, cliente cl, cao c, Hospedagem h 
left join Adestramento a on a.Hospnr = h.Hospnr 
left join Passeio p on p.Hospnr = h.Hospnr
where c.Cao_id = h.Cao_id and cl.cpf = c.Dono_cpf and cl.cpf = s.scpf order by  cl.nome asc);

select c.nome as Cliente, ca.cnome as Nome_cao, ca.raca as Raca, Qtd_dias as Dias_Hospedado      
from cliente c, cao ca , Hospedagem h 
where c.cpf = ca.Dono_cpf and ca.cao_id = h.Cao_id;