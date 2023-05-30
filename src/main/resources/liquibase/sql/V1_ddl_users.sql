--liquibase formatted sql

--changeset ayubovma:create-users-table logicalFilePath:/

CREATE SCHEMA IF NOT EXISTS ${users.schemaName};

CREATE TABLE IF NOT EXISTS ${users.schemaName}.users
(
    id                         BIGSERIAL                PRIMARY KEY,
    nickname                   VARCHAR(32),
    first_name                 VARCHAR(32)              NOT NULL,
    lastname                   VARCHAR(32),
    gender                     VARCHAR(6)               NOT NULL,
    brith_date                 DATE                     NOT NULL,
    email                      VARCHAR(128)             NOT NULL,
    status                     VARCHAR(32)              NOT NULL,
    updated_at                 TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE UNIQUE INDEX IF NOT EXISTS users_nikname_idx ON ${users.schemaName}.users (nickname);
CREATE UNIQUE INDEX IF NOT EXISTS users_email_idx ON ${users.schemaName}.users (email);

CREATE TABLE IF NOT EXISTS ${users.schemaName}.follows(
    id                         BIGSERIAL                PRIMARY KEY,
    following_id               INTEGER                  NOT NULL REFERENCES ${users.schemaName}.users (id) ON DELETE CASCADE, --подписчик, кто подписался на тебя
    follower_id                INTEGER                  NOT NULL REFERENCES ${users.schemaName}.users (id) ON DELETE CASCADE,  --подписка, на кого ты подписался
    followed_at                TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE UNIQUE INDEX IF NOT EXISTS follow_idx ON ${users.schemaName}.follows (following_id, follower_id);