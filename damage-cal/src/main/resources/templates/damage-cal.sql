CREATE TABLE characters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    hp INT,
    ad INT,
    ar INT,
    mr INT,
    tier INT
);

INSERT INTO characters (name, hp, ad, ar, mr, tier)
VALUES ('バナナ', 826, 258, 88, 0, 3);
