-- 查询语法
/*
select
    字段列表
from
    表名列表
where
    条件列表
group by
    分组字段列表
having
    分组后条件列表
order by
    排序字段列表
limit
    分页参数
*/

-- 员工表
create table emp
(
    id          int unsigned primary key auto_increment comment 'ID',
    username    varchar(20)      not null unique comment '用户名',
    password    varchar(32) default '123456' comment '密码',
    name        varchar(10)      not null comment '姓名',
    gender      tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
    image       varchar(300) comment '图像',
    job         tinyint unsigned comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管',
    entry_date  date comment '入职时间',
    create_time datetime         not null comment '创建时间',
    update_time datetime         not null comment '修改时间'
) comment '员工表';

-- 员工表演示数据
INSERT INTO emp
(id, username, password, name, gender, image, job, entry_date, create_time, update_time)
VALUES (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', now(), now()),
       (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', now(), now()),
       (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', now(), now()),
       (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', now(), now()),
       (5, 'changyuchun', '123456', '常遇春', 1, '5.jpg', 2, '2012-12-05', now(), now()),
       (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', now(), now()),
       (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', now(), now()),
       (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', now(), now()),
       (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', now(), now()),
       (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', now(), now()),
       (11, 'luzhangke', '123456', '鹿杖客', 1, '11.jpg', 2, '2007-02-01', now(), now()),
       (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 2, '2008-08-18', now(), now()),
       (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 1, '2012-11-01', now(), now()),
       (14, 'zhangsanfeng', '123456', '张三丰', 1, '14.jpg', 2, '2002-08-01', now(), now()),
       (15, 'yulianzhou', '123456', '俞莲舟', 1, '15.jpg', 2, '2011-05-01', now(), now()),
       (16, 'songyuanqiao', '123456', '宋远桥', 1, '16.jpg', 2, '2010-01-01', now(), now()),
       (17, 'chenyouliang', '12345678', '陈友谅', 1, '17.jpg', NULL, '2015-03-21', now(), now()),
       (18, 'zhang1', '123456', '张一', 1, '2.jpg', 2, '2015-01-01', now(), now()),
       (19, 'zhang2', '123456', '张二', 1, '2.jpg', 2, '2012-01-01', now(), now()),
       (20, 'zhang3', '123456', '张三', 1, '2.jpg', 2, '2018-01-01', now(), now()),
       (21, 'zhang4', '123456', '张四', 1, '2.jpg', 2, '2015-01-01', now(), now()),
       (22, 'zhang5', '123456', '张五', 1, '2.jpg', 2, '2016-01-01', now(), now()),
       (23, 'zhang6', '123456', '张六', 1, '2.jpg', 2, '2012-01-01', now(), now()),
       (24, 'zhang7', '123456', '张七', 1, '2.jpg', 2, '2006-01-01', now(), now()),
       (25, 'zhang8', '123456', '张八', 1, '2.jpg', 2, '2002-01-01', now(), now()),
       (26, 'zhang9', '123456', '张九', 1, '2.jpg', 2, '2011-01-01', now(), now()),
       (27, 'zhang10', '123456', '张十', 1, '2.jpg', 2, '2004-01-01', now(), now()),
       (28, 'zhang11', '123456', '张十一', 1, '2.jpg', 2, '2007-01-01', now(), now()),
       (29, 'zhang12', '123456', '张十二', 1, '2.jpg', 2, '2020-01-01', now(), now())
;


-- ====================================> DQL <=======================================


--  =================== 基本查询 ======================
-- 1. 查询指定字段 name,entry_date 并返回

select name, entry_date
from emp;

-- 2. 查询返回所有字段
-- 2.1 all columns
select *
from emp;

-- 2.2 *

select id,
       username,
       password,
       name,
       gender,
       image,
       job,
       entry_date,
       create_time,
       update_time
from emp;

-- 3. 查询所有员工的 name,entry_date, 并起别名(姓名、入职日期)

select name as "姓名", entry_date as "入职日期"
from emp;

-- as omit

select name "姓名", entry_date "入职日期"
from emp;


-- 4. 查询员工的职位字段

select job
from emp;

-- 5. 查询员工有哪几种职位(不要重复)

select distinct job
from emp;
--  =================== 条件查询 ======================
-- 1. 查询 姓名 为 杨逍 的员工

select *
from emp
where name = '杨逍';
-- 2. 查询在 id小于等于5 的员工信息

select *
from emp
where id <= 5;
-- 3. 查询 没有分配职位 的员工信息

select *
from emp
where job is null ;
-- 4. 查询 有职位 的员工信息

select *
from emp
where job is not null ;
-- 5. 查询 密码不等于 '123456' 的员工信息

select *
from emp
where password != '123456';

select *
from emp
where password <> '123456';
-- 6. 查询入职日期 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间的员工信息 -- between ... and ...

select entry_date
from emp
where entry_date between '2000-01-01' and '2010-01-01';

select entry_date
from emp
where entry_date >= '2000-01-01' and entry_date <= '2010-01-01';


-- 7. 查询 入职时间 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间 且 性别为女 的员工信息

select *
from emp
where entry_date between '2000-01-01' and '2010-01-01' and gender = 2;
-- 8. 查询 职位是 2 (讲师), 3 (学工主管), 4 (教研主管) 的员工信息 -- orin

select *
from emp
where job = 2 or job = 3 or job = 4;
-- 9. 查询姓名为两个字的员工信息

select *
from emp
where name like '__';
-- 10. 查询姓 '张' 的员工信息

select *
from emp
where name like '张%';
-- 11. 查询姓名中包含 '三' 的员工信息

select *
from emp
where name like '%三%';
-- 练习 : 员工管理列表查询
-- 条件 : name , gender , entry_date
/*
select * from emp where name like '%张%' and gender = 1 and entry_date between '2000-01-01' and '2010-01-01';
 */


--  =================== 排序查询 ======================
-- 1. 根据入职时间, 对员工进行升序排序  -- 排序条件 asc/desc
select id, username, entry_date
from emp
order by entry_date asc;


-- 2. 根据入职时间, 对员工进行降序排序

select id, username, entry_date
from emp
order by entry_date desc;
-- 3. 根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 ID 进行降序排序

select id, username, entry_date
from emp
order by entry_date asc ,id desc ;
-- 练习 : 员工管理列表查询 , 根据最后操作时间, 进行倒序排序
-- 条件 : name , gender , entry_date

/*
select * from emp where name like '%张%' and gender = 1 and entry_date between '2000-01-01' and '2010-01-01' order by update_time desc;
 */


--  =================== 分页查询 ======================
-- 1. 查询第1页员工数据, 每页展示10条记录 -- index, size

select *
from emp
limit 10;
-- 2. 查询第2页员工数据, 每页展示10条记录

select *
from emp
limit 0, 10;
-- 公式
-- limit (n-1) * num , num;