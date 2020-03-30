CREATE TABLE "lists" (
    "id" SERIAL PRIMARY KEY,
    "name" varchar
);

CREATE TABLE "items" (
                         "id"            SERIAL PRIMARY KEY,
                         "list_id"       INTEGER NOT NULL,
                         "value"         varchar,
                         "checked_state" boolean DEFAULT false
);

ALTER TABLE "items"
    ADD FOREIGN KEY ("list_id") references "lists" ("id");
