create table t_order (
	id uuid NOT NULL constraint or_id_pk primary key,
	created_by varchar,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);