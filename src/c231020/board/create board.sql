create table boards(
	"id" number generated as identity primary key,
	"user_id" number not null ,
	"title" varchar2(30) not null,
	"content" long not null,
	"created_at" date default sysdate
	); 