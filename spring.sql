CREATE USER spring IDENTIFIED BY spring;
GRANT RESOURCE, CONNECT TO spring;
GRANT UNLIMITED TABLESPACE TO spring;

CREATE TABLE MEMBER(
    ID VARCHAR2(100) PRIMARY KEY,
    PASSWORD VARCHAR2(150) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    ADDRESS VARCHAR2(200) NOT NULL
);
SELECT * FROM MEMBER;

--------------------------------------------------------------------------------

CREATE SEQUENCE SEQ_BOARD;
CREATE TABLE BOARD(
    NO NUMBER,
    TITLE VARCHAR2(200) NOT NULL,
    CONTENT VARCHAR2(2000) NOT NULL,
    WRITER VARCHAR2(50) NOT NULL,
    REGDATE DATE DEFAULT SYSDATE
);

SELECT * FROM BOARD;

DROP SEQUENCE SEQ_BOARD;
DROP TABLE BOARD;

DROP TABLE BOARD;

-- 리스트 늘리기(복사복사)
INSERT INTO board(no, title, content, writer)
(SELECT SEQ_BOARD.NEXTVAL, title, content, writer FROM board);
COMMIT;

ALTER TABLE board ADD CONSTRAINT PK_BOARD PRIMARY KEY(no);

SELECT * FROM board ORDER BY no DESC;

-- 힌트..: /*+ INDEX_DESC(board PK_BOARD) */  => 사용 이유 오류가 있어도 실행시켜줘 
-- 첫페이지
SELECT NUM, NO, TITLE, WRITER, REGDATE
FROM (SELECT /*+ INDEX_ASC(board PK_BOARD) */ 
      ROWNUM NUM, NO, TITLE, WRITER, REGDATE
      FROM board
      WHERE ROWNUM <= 10)
WHERE ROWNUM > 0;

-- 두 번째 페이지(11~20까지), ROWNUM은 무조건 1이 포함되어 있음
SELECT NUM, NO, TITLE, WRITER, REGDATE
FROM (SELECT /*+ INDEX_DESC(board PK_BOARD) */ 
     ROWNUM NUM, NO, TITLE, WRITER, REGDATE
      FROM board
      WHERE ROWNUM <= 20)
WHERE NUM > 10;

-- 세 번째 페이지(21~30)
SELECT NUM, NO, TITLE, WRITER, REGDATE
FROM (SELECT /*+ INDEX_DESC(board PK_BOARD) */ 
      ROWNUM NUM, NO, TITLE, WRITER, REGDATE
      FROM board
      WHERE ROWNUM <= 30)
WHERE NUM > 20;
 

SELECT ROWNUM NUM, NO, TITLE, CONTENT FROM BOARD;

----------------------------------------------------------------------

ALTER TABLE board ADD url VARCHAR(200);

SELECT * FROM board WHERE no=4095;

-------------------------------------------------------------------------
 DROP TABLE member;
 
 create table member(
    id varchar2(50) primary key,
    password varchar2(100) not null,
    name varchar2(50) not null,
    address varchar2(200),
    -- 스프링에서 필수적으로 들고 있어야 함--
    auth varchar2(50) default 'ROLE_MEMBER' not null,
    enabled number(1) default 1 not null
);























