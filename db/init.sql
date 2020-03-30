CREATE TABLE "lists" (
    "id" SERIAL PRIMARY KEY,
    "name" varchar
);

CREATE TABLE "items" (
    "id" SERIAL PRIMARY KEY,
    "listId" INTEGER NOT NULL,
    "value" varchar,
    "checkedState" boolean DEFAULT false
);

ALTER TABLE "items" ADD FOREIGN KEY ("listId") references "lists" ("id");
