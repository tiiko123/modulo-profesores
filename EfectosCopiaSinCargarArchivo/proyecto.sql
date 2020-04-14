SELECT * FROM proyecto.disponibilidad;
desc proyecto.disponibilidad;

INSERT INTO disponibilidad(id,Lunes,Martes,Miercoles,Jueves,Viernes,Sabado) VALUES (14,0,1,0,1,1,0);
UPDATE disponibilidad SET id = 1,Lunes=1, Martes=0, Miercoles=0, Jueves=0, Viernes=0,Sabado=0 where id =1;
alter table disponibilidad add primary key(id);
ALTER TABLE proyecto.disponibilidad ADD CONSTRAINT PK_TransactionHistoryArchive_id PRIMARY KEY CLUSTERED (id);
alter table disponibilidad drop id;
delete from disponibilidad where id = NULL;
alter table proyecto.disponibilidad drop primary key;

select * from usuarios;
CREATE TABLE usuarios (
  clv_usuario VARCHAR(50) NOT NULL PRIMARY KEY,
  pass_usuario CHAR(41) NOT NULL,
  tipo_usuario CHAR(4) NOT NULL DEFAULT 'PROF' CHECK (tipo_usuario IN ('PROF', 'ADMI', 'DIRE')),
  idcarrera TINYINT NOT NULL,
  nombre_usuario VARCHAR(50) NOT NULL,
  nivel_ads VARCHAR(5) NOT NULL DEFAULT 'Ing.' CHECK (nivel_ads IN ('Dr.', 'M.C', 'Ing.', 'Lic.')),
  contrato VARCHAR(3) NOT NULL DEFAULT 'PA' CHECK (contrato IN ('PTC', 'PA')));
  
  desc usuarios;
  INSERT INTO usuarios VALUES ('spolancom@upv.edu.mx', 'hola', 'ADMI', 1, 'Said Polanco', 'Dr.', 'PTC');
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  