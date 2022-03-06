server:
  port: 8002
spring:
  application:
    name: SchoolCircle-Eureka
eureka:
  server:
    enable-self-preservation: false #关闭自我保护机制
  instance:
    hostname: localhost

  client:
    register-with-eureka: false # 不要把自己作为客户端注册
    fetch-registry: false # 不需要从服务端获取注册信息
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/