-- 查看所有数据库
/*
多行注释
*/
show databases;

create database db2;
-- 存在情况下不会报错的方法
create database if not exists db2;

drop database db2;

drop database if exists db2;

create table tb_user(
  id int PRIMARY KEY auto_increment comment 'ID，唯一标识',
  username varchar(20) unique not null comment '用户名',
  age int comment '年龄',
  gender char(1) default '男'comment '性别'
)comment '用户表';

create table tb_emp(
                       id int primary key auto_increment comment '主键ID',
                       username    varchar(20)                  not null comment '用户名',
                       password    varchar(32) default '123456' null comment '密码',
                       name        varchar(10)                  not null comment '姓名',
                       gender      tinyint unsigned             not null comment '性别, 1 男, 2 女',
                       image       varchar(300)                 null comment '图像url',
                       job         tinyint unsigned             null comment '职位, 1 班主任 , 2 讲师 , 3 学工主管, 4 教研主管',
                       entry_date   date                         null comment '入职日期',
                       create_time datetime                     not null comment '创建时间',
                       update_time datetime                     not null comment '修改时间',
                       constraint tb_emp_username_uindex unique (username)
) comment '员工表';

describe tb_emp

