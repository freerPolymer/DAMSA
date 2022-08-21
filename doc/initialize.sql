
/* 
 DAMSA系统初始化SQL
 create for mysql 8.x
 drop database db_msa;
*/
create database if not exists db_msa;

use db_msa;

create table if not exists sys_user(
	sid char(32) not null,
	s_name varchar(20) not null,
	s_password varchar(30) default '',
	enabled tinyint(1) default 0,
	create_time datetime,
	primary key (sid)
)comment '系统用户表';


create table if not exists cus_user(
	cid char(32) not null primary key ,
	c_name varchar(20) not null,
	c_password varchar(20) default '',
	enabled tinyint(1) default 0,
	create_time datetime ,
	modify_time datetime 
)comment '用户信息表';

create table if not exists sys_menus(
	m_id char(32) not null primary key ,
	m_parent char(32) default '',
	m_name varchar(20) default '',
	m_url varchar(255) default '',
	m_logo varchar(255) default '',
	enabled tinyint(1) comment '默认启用' default 1,
	create_time datetime ,
	modify_time datetime
)comment '菜单功能信息表';

create table if not exists sys_roles(
	r_id char(32) not null primary key ,
	r_name varchar(50) default '',
	r_expired tinyint (1) comment '默认0，未过期' default 0
)comment '角色信息表';

create table if not exists sys_department(
	d_id char(32) not null primary key ,
	d_name varchar(30) default '',
	d_address varchar(255) comment '地址，如255号房，XX隔壁等' ,
	d_logo varchar(255) comment '部门标识，如logo图，口号等',
	enabled tinyint(1) comment '默认启用' default 1,
	create_time datetime ,
	modify_time datetime
)comment '单位部门信息表';


create table if not exists sys_permissions(
	p_id char(32) not null primary key ,
	p_name varchar(30) default '',
	p_permission JSON ,
	r_expired tinyint (1) comment '默认1，过期' default 1,
	create_time datetime ,
	modify_time datetime
)comment '用户权限管理表';

/*系统基础数据初始化*/
-- 默认用户名密码(MD5数据加密)：admin adsh3009
insert into sys_user
values(
	'h5fd5f5f45s5f5s4f4sf44i2h3a7fx8p','admin','gq+L7TphPuXkv0QDhl7/rg==',1,now()
);
