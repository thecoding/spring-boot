# spring-boot-lesson3 rabbit_mq
## rabbitMq测试



准备工作：

1. 安装RabbitMq
2. 配置RabbitMq，配置信息参考：application.properties
        
        spring.rabbitmq.host=127.0.0.1
        spring.rabbitmq.port=5672
        spring.rabbitmq.username=admin
        spring.rabbitmq.password=admin

项目增加依赖
        
        <dependency>
        	<groupId>org.springframework.boot</groupId>
        	<artifactId>spring-boot-starter-amqp</artifactId>
        </dependency>







测试一对多<br>
RabbitMqMessageSender为发送者
RabbitMqMessageReceiver 为接收者
RabbitMqMessageReceiver2 为接收者2

     一个发送者，多个接收者，一个消息只能是其中一个接收者接收，并且不会重复接收
     
测试多对多<br>  
增加了发送对象，RabbitMqObjectSender，刚遇到一个问题是如果第一次用message发送了User，
后面再来发送，就会一直报错。解决办法就是去后台把queue删除，修改代码后重新跑。
   
       AmqpException: No method found for class com.spring_boot.bean.User
       


topic 包下是交换机  
Topic Exchange主要有两种通配符：# 和 *  
\*（星号）：可以（只能）匹配一个单词  
\#（井号）：可以匹配多个单词（或者零个）  
当一个队列被绑定为binding key为”\#”时，它将会接收所有的消息，这类似于广播形式的交换机模式。  
当binding key不包含”\*”和”\#”时，这类似于Direct Exchange直连交换机模式。  
 
 
fanout是类似广播  
三种其实相差不大，主要体现在config文件中

   
 
 

 