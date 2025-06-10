DROP TABLE IF EXISTS employee;

CREATE TABLE
    IF NOT EXISTS employee (
        id int NOT NULL AUTO_INCREMENT,
        first_name varchar(45) DEFAULT NULL,
        last_name varchar(45) DEFAULT NULL,
        email varchar(45) DEFAULT NULL,
        PRIMARY KEY (id)
    );

SELECT
    *
FROM
    employee;

INSERT INTO
    employee (first_name, last_name, email)
VALUES
    ('John', 'Doe', 'john.doe@example.com'),
    ('Jane', 'Smith', 'jane.smith@example.com'),
    ('Alice', 'Johnson', 'alice.johnson@example.com'),
    ('Bob', 'Williams', 'bob.williams@example.com'),
    ('Charlie', 'Brown', 'charlie.brown@example.com');

TRUNCATE TABLE employee;