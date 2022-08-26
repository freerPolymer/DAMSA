
/* DAMSA系统初始化SQL */
/* DDL for mysql 8.x */
-- 注意：如果使用的是DBeaver工具连接的数据库，那么上述属性在需要在驱动属性中设置 allowMultiQueries 为 true
use db_msa ;
-- table
drop table if exists `sys_user`;
drop table if exists `cus_user`;
drop table if exists `sys_menus`;
drop table if exists `sys_roles`;
drop table if exists `sys_department`;
drop table if exists `sys_permissions`;
-- database
drop database if exists `db_msa`;

#database
create database `db_msa` default charset utf8MB4;