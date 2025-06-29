采用 ddd来重构苍穹外卖项目（新手练手）
<h1>工程结构</h1>
agileboot
├── agileboot-admin -- 管理后台接口模块（供后台调用）
│
├── agileboot-api -- 开放接口模块（供客户端调用）
│
├── agileboot-common -- 精简基础工具模块
│
├── agileboot-infrastructure -- 基础设施模块（主要是配置和集成，不包含业务逻辑）
│
├── agileboot-domain -- 业务模块
├    ├── user -- 用户模块（举例）
├         ├── command -- 命令参数接收模型（命令）
├         ├── dto -- 返回数据类
├         ├── db -- DB操作类
├              ├── entity -- 实体类
├              ├── service -- DB Service
├              ├── mapper -- DB Dao
├         ├── model -- 领域模型类
├         ├── query -- 查询参数模型（查询）
│         ├────── UserApplicationService -- 应用服务（事务层，操作领域模型类完成业务逻辑）
