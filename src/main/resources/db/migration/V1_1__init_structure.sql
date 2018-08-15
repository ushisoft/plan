-- DROP TABLE IF EXISTS "task";

CREATE SEQUENCE task_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE "task" (
  "id" int8 NOT NULL DEFAULT nextval('task_id_seq'::regclass),
  "type" varchar(120),
  "title" varchar(120) NOT NULL,
  "status" char(2)
);

ALTER TABLE "task" ADD CONSTRAINT "pk_task" PRIMARY KEY ("id");
