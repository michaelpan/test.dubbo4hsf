HSF集成DUBBO DEMO
============================
HSF和DUBBO是两个优秀的RPC框架，其中HSF由淘宝开发并维护，而DUBBO则由阿里巴巴中文站开发及维护。

为了实现无缝合并DUBBO，HSF2.0 开始支持直接在同一个Spring配置文件中配置HSF协议和DUBBO协议的服务了。

HSF2.0开始，有三种配置方式可以向外暴露一个服务接口：
1. 通过定义**com.taobao.hsf.app.spring.util.HSFSpringProviderBean**类型的Bean，向外暴露HSF协议的服务
2. 通过**&lt;dubbo:service>**向外暴露DUBBO协议的服务
3. 通过**&lt;dubbo:service protocol="hsf">**向外暴露HSF协议的服务

同时，有三种方式可以在客户端使用一个服务接口
1. 通过定义**com.taobao.hsf.app.spring.util.HSFSpringConsumerBean**类型的Bean，使用HSF协议的服务
2. 通过**&lt;dubbo:service>**使用DUBBO协议的服务
3. 通过**&lt;dubbo:service protocol="hsf">**使用HSF协议的服务

本DEMO 工程演示如何进行依赖配置和Spring配置文件编写，以及应该避免哪些错误的写法。

##### 使用方法
- 必须在阿里巴巴环境内运行，否则需要修改注册中心的配置
- 下载代码，使用maven进行编译打包
- 执行test.dubbo4hsf.server工程中*com.mitch3.test.dubbo4hsf.server.Bootstrap*类的main方法
- 执行test.dubbo4hsf.client工程中*com.mitch3.test.dubb4hsf.client.TestClient*类中的Junit测试方法

**项目地址** [https://github.com/michaelpan/test.dubbo4hsf]<https://github.com/michaelpan/test.dubbo4hsf>
