-- ------------------------------------
-- CREATION TABLE RACE-----------------
-- ------------------------------------
drop table if exists Race ;
create table Race (id_race INT auto_increment not null,
				   nom_race VARCHAR(100) not null,
				   primary key (id_race))
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- ------------------------------------
-- CREATION TABLE CHIEN----------------
-- ------------------------------------

drop table if exists Chien ;
create table Chien (id_puce_chien INT not null unique,
					nom_chien VARCHAR(100) not null,
					age_chien INT(2) not null,
					id_couleur INT not null,
					id_race INT not null,
					id_utilisateur INT not null,
					primary key (id_puce_chien))
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- ------------------------------------
-- CREATION TABLE COULEUR--------------
-- ------------------------------------

drop table if exists Couleur ;
create table Couleur (id_couleur INT auto_increment not null,
					  couleur VARCHAR(50) not null,
					  primary key (id_couleur))
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- ------------------------------------
-- CREATION TABLE UTILISATEUR----------
-- ------------------------------------

drop table if exists Utilisateur ;
create table Utilisateur (id_utilisateur INT auto_increment not null,
						  nom_utilisateur VARCHAR(100) not null,
						  prenom_utilisateur VARCHAR(100) not null,
						  login VARCHAR(100) not null unique,
						  password VARCHAR(200) not null,
						  primary key (id_utilisateur))
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;						  


alter table Chien
add constraint FK_Chien_id_race
foreign key (id_race)
references Race (id_race);


alter table Chien
add constraint FK_Chien_id_utilisateur
foreign key (id_utilisateur)
references Utilisateur (id_utilisateur);


alter table Chien
add constraint FK_Chien_id_couleur
foreign key (id_couleur)
references Couleur (id_couleur);


insert into race(NOM_RACE) values ('border collie');
insert into race(NOM_RACE) values ('caniche');
insert into race(NOM_RACE) values ('berger allemand');
insert into race(NOM_RACE) values ('golden retriever');
insert into race(NOM_RACE) values ('doberman');
insert into race(NOM_RACE) values ('berger des shetland');
insert into race(NOM_RACE) values ('labrador retriever');
insert into race(NOM_RACE) values ('epagneul papillon');
insert into race(NOM_RACE) values ('rottweiller');
insert into race(NOM_RACE) values ('berger australien');

insert into couleur(couleur) values ('noir');
insert into couleur(couleur) values ('gris');
insert into couleur(couleur) values ('sable');
insert into couleur(couleur) values ('chocolat');
insert into couleur(couleur) values ('blanc');

insert into utilisateur(nom_utilisateur, prenom_utilisateur, login, password) values ('mango', 'ruddy', 'jm333', md5('jm333'));
insert into utilisateur(nom_utilisateur, prenom_utilisateur, login, password) values ('penia', 'julio', 'dc111', md5('dc111'));
insert into utilisateur(nom_utilisateur, prenom_utilisateur, login, password) values ('franz', 'jean', 'jmledoux222', md5('jmledoux222'));
insert into utilisateur(nom_utilisateur, prenom_utilisateur, login, password) values ('tela', 'anthony', 'mcfi1', md5('mcfi1'));
insert into utilisateur(nom_utilisateur, prenom_utilisateur, login, password) values ('boulay', 'sammy', 'paystar', md5('paystar'));
insert into utilisateur(nom_utilisateur, prenom_utilisateur, login, password) values ('chalan', 'francois', 'situs112', md5('situs112'));

insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (212, 'Seal, northern elephant', 1, 3, 9, 1);
insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (217, 'Yellow-crowned night heron', 5, 3, 2, 2);
insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (126, 'Caribou', 5, 5, 7, 3);
insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (100, 'Dog, african wild', 2, 4, 7, 4);
insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (149, 'Seal, southern elephant', 5, 2, 6, 5);
insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (139, 'Helmeted guinea fowl', 6, 5, 5, 6);
insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (121, 'Bahama pintail', 7, 2, 8, 1);
insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (117, 'Jacana, african', 2, 5, 2, 3);
insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (189, 'Whale, southern right', 3, 5, 1, 2);
insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (178, 'Land iguana', 3, 3, 2, 1);

select * from CHIEN;
select * from UTILISATEUR;
select * from RACE;
select * from COULEUR;

select * from UTILISATEUR u join chien c on c.id_utilisateur = u.ID_UTILISATEUR where u.ID_UTILISATEUR = 1;

SELECT ch.id_puce_chien, ch.nom_chien, ch.age_chien, r.id_race, r.nom_race, c.id_couleur, c.couleur, u.id_utilisateur, u.nom_utilisateur, u.prenom_utilisateur, u.login, u.password
FROM chien AS ch
   JOIN
   race AS r
   ON ch.id_race = r.id_race
   JOIN
   couleur AS c
   ON ch.id_couleur = c.id_couleur
   JOIN
   utilisateur AS u
   ON ch.id_utilisateur = u.id_utilisateur;