CREATE TABLE user
(
    userid   BIGINT      NOT NULL AUTO_INCREMENT,
    name     VARCHAR(45) NOT NULL,
    sureName VARCHAR(45) NOT NULL,

    PRIMARY KEY (userid)
);

CREATE TABLE account
(
    accountid BIGINT NOT NULL AUTO_INCREMENT,
    account   BIGINT NOT NULL,
    userid    BIGINT NOT NULL,

    PRIMARY KEY (accountid),
    FOREIGN KEY (userid)
        REFERENCES user(userid)
);