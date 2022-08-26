
/* DAMSA系统初始化SQL */
/* DDL for mysql 8.x */
-- 注意：如果使用的是DBeaver工具连接的数据库，那么上述属性在需要在驱动属性中设置 allowMultiQueries 为 true
use db_msa;

create table sys_user(
	sid char(32) not null primary key,
	name varchar(20) not null unique,
	password varchar(30) default '',
	enabled tinyint(1) default 0,
	create_time datetime
)comment '系统用户表';

create table cus_user(
	cid char(32) not null primary key ,
	name varchar(20) not null unique,
	password varchar(30) default '',
	enabled tinyint(1) default 0,
	create_time datetime ,
	modify_time datetime
)comment '用户信息表';

create table sys_menus(
	mid char(32) not null primary key ,
	parent char(32) default '',
	name varchar(20) default '',
	url varchar(255) unique default '',
	logo varchar(255) default '',
	enabled tinyint(1) comment '默认启用' default 1,
	create_time datetime ,
	modify_time datetime
)comment '菜单功能信息表';

create table sys_roles(
	rid char(32) not null primary key ,
	name varchar(30) default '',
	code varchar(20) default '',
	expired tinyint (1) comment '默认0，未过期' default 0
)comment '角色信息表';

create table sys_department(
	did char(32) not null primary key ,
	name varchar(30) default '',
	address varchar(255) comment '地址，如255号房，XX隔壁等' ,
	logo varchar(255) comment '部门标识，如logo图，口号等',
	enabled tinyint(1) comment '默认启用' default 1,
	create_time datetime ,
	modify_time datetime
)comment '单位部门信息表';

create table sys_permissions(
	pid char(32) not null primary key ,
	name varchar(30) default '',
	permission JSON ,
	expired tinyint (1) comment '默认1，过期' default 1,
	create_time datetime ,
	modify_time datetime
)comment '用户权限管理表';
