DROP SCHEMA IF EXISTS pearl cascade;
CREATE SCHEMA pearl;

CREATE TABLE pearl.todolist (
    todo_id uuid,
    todo varchar(300),
    created_date TIMESTAMP WITH TIME ZONE,
    modified_date TIMESTAMP WITH TIME ZONE,
    PRIMARY KEY (todo_id)
);
