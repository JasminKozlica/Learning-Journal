--CREATE NEW TABLE learning_journal_user(
--    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
--    firstName varchar(255),
--    lastName varchar(255),
--    email varchar(255),
--    password varchar(255),
--    class varchar(255),
--    CONSTRAINT pk_person PRIMARY KEY(id)
--);

CREATE TABLE appuser(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    username varchar(255),
    email varchar(255),
    password varchar(255),
    userrole varchar(255),
    CONSTRAINT pk_person PRIMARY KEY(id)
);

CREATE TABLE journal(
    entryId BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    datum date,
    content text,
    category varchar(255),
    tags varchar(255),
    CONSTRAINT pk_journal PRIMARY KEY(entryId)
);


