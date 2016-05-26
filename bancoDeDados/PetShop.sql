-- tabela animal
CREATE TABLE animal(
  id BIGSERIAL NOT NULL,
  nome varchar(50),
  idade integer,
  tipo varchar(50),
  raca varchar(50),
  CONSTRAINT animal_pkey PRIMARY KEY (id)
);

-- tabela cliente, fkey id_animal.
create table cliente(
  id bigserial not null,
  nome varchar(50),
  cpf integer,
  endereco varchar(50),
  telefone varchar(15),
  id_animal integer,
  constraint cliente_pkey primary key (id),
  constraint cliente_fkey foreign key (id_animal)
  references animal (id)
);

-- tabela fornecedor.
create table fornecedor(
  id bigserial not null,
  nome varchar(50),
  cnpj varchar(15),
  endereco varchar(50),
  constraint fornecedor_pkey primary key (id)
  );

  -- tabela
