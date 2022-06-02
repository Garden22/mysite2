CREATE TABLE users (
    no NUMBER,
    id VARCHAR2(20) UNIQUE NOT NULL,
    password VARCHAR(20) NOT NULL,
    name VARCHAR2(20),
    gender VARCHAR2(10),
    PRIMARY KEY (no)
);

DROP TABLE users;

CREATE SEQUENCE seq_users_no
INCREMENT BY 1
START WITH 1
NOCACHE;

DROP SEQUENCE seq_users_no;

INSERT INTO users VALUES(seq_users_no.NEXTVAL,);

UPDATE users
SET password = 'test'
WHERE id = '테스트';

COMMIT;
ROLLBACK;

SELECT * 
FROM users;
