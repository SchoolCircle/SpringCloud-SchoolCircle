spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: root
    driver-class-name: com.mysql.cj.jdbc.Driver
    password: ******
  jpa:
    show-sql: true
  #  mail:
  #    host: smtp.163.com
  #    username: kepadedaidai@163.com
  #    port: 25
  #    default-encoding: UTF-8
  #    properties:
  #      mail:
  #        smtp:
  #          socketFactoryClass: javax.net.ssl.SSLSocketFactory
  #        debug: true
  application:
    name: SchoolCircle-Register
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8002/eureka
    fetch-registry: true # 发现
    register-with-eureka: true # 注册

server:
  port: 8003

