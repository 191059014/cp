# cp
简单的把项目按模块分层，提供简单的模板，方便快速的搭建一个项目
1. druid监控：http://127.0.0.1:8888/druid/sql.html
2. 依赖了simple-mybatis，unic-base，unic-cache，unic-util，unic-logger
3. 分模块管理整个项目
- cp-web  
web端，暴露对外的服务
- cp-api  
提供各种业务接口
- cp-dao  
操作数据库层
- cp-model  
公共模型

