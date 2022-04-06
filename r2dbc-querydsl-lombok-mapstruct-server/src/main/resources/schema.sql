create table if not exists t_order (
	id uuid NOT NULL constraint t_order_id_pk primary key,
	created_by varchar,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);

create table if not exists t_user (
	id uuid NOT NULL constraint t_user_id_pk primary key,
	name varchar,
	created_at timestamp default now() not null,
	updated_at timestamp default now() not null
);