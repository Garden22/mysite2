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

DROP TABLE guestbook;

CREATE TABLE guestbook(
    no NUMBER,
    name VARCHAR2(80),
    password VARCHAR2(20),
    content VARCHAR2(2000),
    reg_date DATE,
    PRIMARY KEY (no)
);

DROP SEQUENCE seq_guestbook_no;

CREATE SEQUENCE seq_guestbook_no
INCREMENT BY 1
START WITH 1
NOCACHE;

COMMIT;
ROLLBACK;

SELECT * 
FROM users;

SELECT *
FROM guestbook;