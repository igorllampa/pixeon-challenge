create table healthcare_institution(
	id bigint not null auto_increment,
	name varchar(100),
	cnpj varchar(14),
	primary key (id)
)