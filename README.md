# DAMSA
 数据化微服务框架。微服务架构（MicroServices Architecture，**MSA**）：微服务架构可以看做是面向服务架构和分布式服务架构的拓展，使用更细粒度的服务（所以叫微服务）和一组设计准则来考虑大规模的复杂系统架构设计。

# 项目结构：

- DBMANAGER 数据安全服务
    - 该微服务主要负责系统数据的更新与同步操作。独立对数据进行维护操作。
- DBPROVIDER 数据提供者
    - 该微服务是以查询数据为主，提供快速可读、安全隔离的数据服务。
- SERVERAPI API接口服务
    - 该微服务对外开放，依赖DBMANAGER、DBPROVIDER完成数据的封装。
- SERVERDRS 灾备系统
    - 该服务为全局系统服务，其它服务出现wait、done、lock时，该服务系统启动并正常提供服务。
- SERVERWEB WEB系统
    - 该微服务为web响应式服务。依赖DBMANAGER、DBPROVIDER完成信息的操作。
- SYSMANAGER 微服务系统管理器
    - 全局微服务治理中心，实时监控各项微服务运行状态及详细信息。
# 端口定义

- 数据层 65000 - 65999

- 服务层 88000 - 89000

- 系统治理 90000 - 91000

# 软件技术框架
-采用最新稳定的 spring-cloud-alibaba 技术架构实现。