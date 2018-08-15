-- DROP TABLE IF EXISTS "task";

CREATE SEQUENCE task_id_seq START WITH 1 INCREMENT BY 1;

CREATE TYPE task_type AS ENUM ('Group', 'Task', 'Milestone');

CREATE TABLE "task" (
  "id" int8 NOT NULL DEFAULT nextval('task_id_seq'::regclass),
  "type" task_type NOT NULL,
  "title" varchar(120) NOT NULL,
  "status" char(2)
);

ALTER TABLE "task" ADD CONSTRAINT "pk_task" PRIMARY KEY ("id");
