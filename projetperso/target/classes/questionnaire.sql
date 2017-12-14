CREATE TABLE base.question
(
    id BIGINT NOT NULL,
    intitule VARCHAR(255),
    num_question INT,
    PRIMARY KEY (id)
);

CREATE TABLE base.reponse
(
    id BIGINT NOT NULL,
    libelle VARCHAR(255),
    question_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES question(id)
);

INSERT INTO base.question VALUES(1,"Vous souhaitez un ordinateur portable ou fixe ?",1);
INSERT INTO base.reponse VALUES(1,"Portable",1);
INSERT INTO base.reponse VALUES(2,"Fixe",1);

INSERT INTO base.question VALUES(2,"Quelle est votre activité principale ?",2);
INSERT INTO base.reponse VALUES(3,"Jouer",2);
INSERT INTO base.reponse VALUES(4,"Naviger sur internet/Cours",2);
INSERT INTO base.reponse VALUES(5,"Montage Photo/Vidéo",2);

INSERT INTO base.question VALUES(3,"Quel est votre type de jeux préféré ?",3);
INSERT INTO base.reponse VALUES(6,"MMO (WOW, BlackDesertOnline, AION)",3);
INSERT INTO base.reponse VALUES(7,"FPS (PUBG, Destiny, CSGO)",3);
INSERT INTO base.reponse VALUES(8,"AVENTURE (Tom Raider, GTA V)  ",3);
INSERT INTO base.reponse VALUES(9,"PLATEFORME (LOL, Dofus, Battlerite)",3);

INSERT INTO base.question VALUES(4,"Que favorisez vous pour un PC Portable ?",4);
INSERT INTO base.reponse VALUES(10,"Légèreté",4);
INSERT INTO base.reponse VALUES(11,"Autonomie",4);
INSERT INTO base.reponse VALUES(12,"Puissance",4);
INSERT INTO base.reponse VALUES(13,"Design",4);

INSERT INTO base.question VALUES(5,"Que favorisez vous pour un PC Fixe ?",5);
INSERT INTO base.reponse VALUES(14,"Puissance",5);
INSERT INTO base.reponse VALUES(15,"Silence",5);
INSERT INTO base.reponse VALUES(16,"Design",5);
INSERT INTO base.reponse VALUES(27,"Graphisme",5);

