-- DDL: 查看表结构
-- 查看: 当前数据库下的表
show tables;
-- 查看: 查看指定表结构
DESCRIBE user;
-- 查看: 数据库的建表语句
SHOW CREATE TABLE user;

-- DDL: 修改表结构
-- 修改: 为表 tb_emp 添加字段 qq varchar(11)
ALTER TABLE tb_emp
    ADD (qq varchar(11));
-- 修改: 修改 tb_emp 字段类型 qq varchar(13)
ALTER TABLE tb_emp
    MODIFY qq varchar(13);
-- 修改: 修改 tb_emp 字段名 qq 为 qq_num varchar(13)
ALTER TABLE tb_emp
    CHANGE qq qq_num varchar(13);
-- 修改: 删除 tb_emp 的 qq_num 字段
ALTER TABLE tb_emp
    DROP COLUMN qq_num;
-- 修改: 将tb_emp 表名修改为 emp
RENAME TABLE tb_emp TO emp;
-- 修改: 将emp 表名修改为 tb_emp
RENAME TABLE emp TO tb_emp;

-- DDL: 删除表结构
-- 删除: 删除 tb_emp 表
DROP TABLE tb_emp;

-- DML : 数据操作语言
-- DML : 插入数据 - insert

-- 1. 为 tb_emp 表的 username, name, gender 字段插入值
INSERT into tb_emp(username, name , gender)
values ('二蛋', 'erdan', 10);
-- 2. 为 tb_emp 表的 所有字段插入值
insert into tb_emp
values (null, 'ergouzi', '123', '二狗子', 2, '1.jpg', 1, '2010-01-01', now(), now());
-- 3. 批量为 为 tb_emp 表的 username , name , gender 字段插入数据。一次插入两条记录
insert into tb_emp(username, name, gender)
values ('xiaoyang', '小样', 1),
       ('pig', '二弟', 1);