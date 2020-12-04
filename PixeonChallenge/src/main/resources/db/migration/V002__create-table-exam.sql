create table exam(
	id bigint not null auto_increment,
	id_healthcareinstitution bigint, 
	patient_name varchar(100), 
	patient_age  integer, 
	patient_gender ENUM('M','F','N'), #For classifying gender I defined M for 'masculino', F for 'feminino' and N for 'Não informado' 
	physician_name varchar(100), 
	physician_crm  varchar(50), 
	procedure_name varchar(250),
	primary key(id),
	foreign key (id_healthcareinstitution) references healthcare_institution(id)
)