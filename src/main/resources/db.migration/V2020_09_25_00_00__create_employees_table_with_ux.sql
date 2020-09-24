-- Create "employees" table with ux

create table if not exists employees (document jsonb not null);

create unique index ux_employees_document_id on employees using btree ((document->>'id'));
