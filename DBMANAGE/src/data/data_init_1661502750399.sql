 /* DAMSA系统初始化SQL */ 
 /* DDL for mysql 8.x */ 
 -- 注意：如果使用的是DBeaver工具连接的数据库，那么上述属性在需要在驱动属性中设置 allowMultiQueries 为 true 
 use db_msa; 
begin; 
set autocommit=0; 
start transaction; 
 /*系统基础数据初始化*/ 
 -- 默认用户名密码(MD5数据加密)：admin adsh3009 
 insert into sys_user(sid,name,`password`,enabled,create_time) 
 values( 
 'LwQMCdaxZhMf1FUafRf4V6swD8yYYacL','admin','7SWVW7KWoIEj9kkN27FXmA==',1,now() 
 ),( 
 'Qd4BbcegeLbTCcv4mKcskozQE0xFedUx','develop','1AKHukZIU67Yjii230Y5uA==',0,now() 
 ); 
 insert into sys_roles(rid,name,code,expired) 
 values ( 
 'SaoxVfTgpTMdcvoCkda9dEao8uMBa2b6','系统管理员','SYS_MANAGER',0 
 ); 
 -- permission 为json格式的菜单列表，其中标注可读，可写属性 
 insert into sys_permissions(pid,name,permission,expired,create_time,modify_time) 
 values( 
 'RouaC73AAbKPeqfgVc6LdlcPHlG8rYrS','系统管理员','{"ALL":"*"}',1,now(),null 
 ); 
 insert into sys_menus (`mid`,parent,name,url,logo,enabled,create_time,modify_time) 
 values ( 
 'tWQyjcgmxqfYeZ27NOQ1T91lcgfoeSot','ROOT','权限列表','/system/manager/db/','',1,now(),null 
 ); 
 insert into sys_department (did,name,address,logo,enabled,create_time,modify_time) 
 values( 
 'iBvSuyktbZG3Ao0nAMbohcYCaC2ACbUM','技术部','xx省xx市xx区xx路xx号豪苑大厦1507-208','',1,now(),null 
 ); 
 insert into cus_user (cid,name,`password`,enabled,create_time,modify_time) 
 values( 
 'gEehLde0QT5BPK9UWJTK042cn5wG5Rle','ly','21R2HOBB44W0NGHGC4lk3g==',0,now(),null 
 ); 
commit; 

