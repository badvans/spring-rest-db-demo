create schema `demo-app` collate utf8_general_ci;

create table demo_table
(
  id int auto_increment
    primary key,
  value int null
);
