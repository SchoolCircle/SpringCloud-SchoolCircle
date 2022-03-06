server:
  port: 8001
spring:
  application:
    name: SchoolCircle-Gateway
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true #与注册中心连接
          lower-case-service-id: true #服务名称全小写


eureka:
  client:
    service-url:
      defaultZone: http://localhost:8002/eureka
    fetch-registry: true # 发现
    register-with-eureka: true # 注册
