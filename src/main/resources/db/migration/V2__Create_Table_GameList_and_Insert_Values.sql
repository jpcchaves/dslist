CREATE TABLE
    `tb_game_list` (
                       `id` bigint NOT NULL AUTO_INCREMENT,
                       `name` varchar(255) DEFAULT NULL,
                       PRIMARY KEY (`id`)
);

CREATE TABLE
    `tb_belonging` (
                       `position` int DEFAULT NULL,
                       `list_id` bigint NOT NULL,
                       `game_id` bigint NOT NULL,
                       PRIMARY KEY (`game_id`, `list_id`),
                       KEY `FKrchwdikeu66uky1hf75ym1kh` (`list_id`),
                       CONSTRAINT `FK2slybclee7wdfxhfltbvqkgpg` FOREIGN KEY (`game_id`) REFERENCES `tb_game` (`id`),
                       CONSTRAINT `FKrchwdikeu66uky1hf75ym1kh` FOREIGN KEY (`list_id`) REFERENCES `tb_game_list` (`id`)
);


INSERT INTO tb_game_list (name)
VALUES  ('Aventura e RPG'), ('Jogos de plataforma');

INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 1, 0);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 2, 1);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 3, 2);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 4, 3);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 5, 4);

INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 6, 0);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 7, 1);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 8, 2);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 9, 3);
INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 10, 4);