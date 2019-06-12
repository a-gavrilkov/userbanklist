CREATE TABLE user
(
    userid   INT         NOT NULL AUTO_INCREMENT,
    name     VARCHAR(45) NOT NULL,
    sureName VARCHAR(45) NOT NULL,

    PRIMARY KEY (userid)
);

CREATE TABLE account
(
    accountid INT NOT NULL AUTO_INCREMENT,
    account   INT NOT NULL,
    userid    INT NOT NULL,

    PRIMARY KEY (accountid),
    FOREIGN KEY (userid)
        REFERENCES user(userid)
);