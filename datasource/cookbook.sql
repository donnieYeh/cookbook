create table cookbook
(
	id int auto_increment
		primary key,
	name varchar(32) charset utf8 not null,
	`desc` varchar(32) charset utf8 null,
	url varchar(32) charset utf8 null,
	session varchar(6) null,
	day_of_week int null,
	period_of_day varchar(16) null,
	create_date datetime default CURRENT_TIMESTAMP null
);

