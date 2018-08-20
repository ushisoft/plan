/* 说明

1. sequence increment 统一设置为50，保持与SequenceGenerator allocationSize的默认配置一致

*/


-- Project Definition ----------------------------------------------

CREATE SEQUENCE project_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE "project" (
  "id" int8 NOT NULL DEFAULT nextval('project_id_seq'::regclass),
  "title" varchar(150) NOT NULL,
  "start" timestamp,
  "end" timestamp,
  "description" text,
  "created_time" timestamp,
  "created_by" varchar(50),
  "lastmodified_time" timestamp,
  "lastmodified_by" varchar(50)
);

ALTER TABLE "project" ADD CONSTRAINT "pk_project" PRIMARY KEY ("id");

-- Task Definition ----------------------------------------------

CREATE SEQUENCE task_id_seq START WITH 1 INCREMENT BY 50;

CREATE TYPE task_type AS ENUM ('Group', 'Task', 'Milestone');

CREATE TABLE "task" (
  "id" int8 NOT NULL DEFAULT nextval('task_id_seq'::regclass),
  "type" task_type NOT NULL,
  "title" varchar(120) NOT NULL,
  "status" char(2)
);

ALTER TABLE "task" ADD CONSTRAINT "pk_task" PRIMARY KEY ("id");

