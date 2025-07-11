采用 ddd来重构苍穹外卖项目（新手练手）
## 🙊 系统内置功能 🙊  
  

🙂 大部分功能，均有通过 **单元测试** **集成测试** 保证质量。

|     | 功能    | 描述                              |
|-----|-------|---------------------------------|
|     | 用户管理  | 用户是系统操作者，该功能主要完成系统用户配置          |
| ⭐   | 部门管理  | 配置系统组织机构（公司、部门、小组），树结构展现支持数据权限  |
| ⭐   | 岗位管理  | 配置系统用户所属担任职务                    |
|     | 菜单管理  | 配置系统菜单、操作权限、按钮权限标识等，本地缓存提供性能    |
| ⭐   | 角色管理  | 角色菜单权限分配、设置角色按机构进行数据范围权限划分      |
|     | 参数管理  | 对系统动态配置常用参数                     |
|     | 通知公告  | 系统通知公告信息发布维护                    |
| 🚀  | 操作日志  | 系统正常操作日志记录和查询；系统异常信息日志记录和查询     |
|     | 登录日志  | 系统登录日志记录查询包含登录异常                |
|     | 在线用户  | 当前系统中活跃用户状态监控                   |
|     | 系统接口  | 根据业务代码自动生成相关的api接口文档            |
|     | 服务监控  | 监视当前系统CPU、内存、磁盘、堆栈等相关信息         |
|     | 缓存监控  | 对系统的缓存信息查询，命令统计等                |
|     | 连接池监视 | 监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈 |


## 🐯 工程结构 🐯

``` 
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

```

### 代码流转

请求分为两类：一类是查询，一类是操作（即对数据有进行更新）。

**查询**：Controller > xxxQuery > xxxApplicationService > xxxService(Db) > xxxMapper  
**操作**：Controller > xxxCommand > xxxApplicationService > xxxModel(处理逻辑) > save 或者 update (本项目直接采用JPA的方式进行插入已经更新数据)

这是借鉴CQRS的开发理念，将查询和操作分开处理。操作类的业务实现借鉴了DDD战术设计的理念，使用领域类，工厂类更面向对象的实现逻辑。 
如果你不太适应这样的开发模式的话。可以在domain模块中按照你之前从Controller->Service->DAO的模式进行开发。it is up to you.



### 二次开发指南

假设你要新增一个会员member业务，可以在以下三个模块新增对应的包来实现你的业务
``` 
agileboot
├── agileboot-admin -- 
│                ├── member -- 会员模块
│
├── agileboot-domain -- 
├                ├── member -- 会员模块（举例）
├                     ├── command -- 命令参数接收模型（命令）
├                     ├── dto -- 返回数据类
├                     ├── db -- DB操作类
├                          ├── entity -- 实体类
├                          ├── service -- DB Service
├                          ├── mapper -- DB Dao
├                     ├── model -- 领域模型类
├                     ├── query -- 查询参数模型（查询）
│                     ├────── MemberApplicationService -- 应用服务（事务层，操作领域模型类完成业务逻辑）
└─
```
前端暂时采用nginx反向代理来启动，后期在考虑是否需要重构
