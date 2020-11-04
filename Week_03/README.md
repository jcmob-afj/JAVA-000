学习笔记
OkhttpOutboundHandler

服务端项目为：server
访问地址：http://localhost:8088

网关项目为：gateway
启动 NettyServerApplication.java
页面返回：hello I'm server  并且response headers 中包含 nio: fengjian

gateway新增RequestFilter.java类，为request header 设置 nio

有个问题：麻烦助教老师看一下，为什么使用我新建的OkhttpOutboundHandler.java，连接一直关闭不了呢？