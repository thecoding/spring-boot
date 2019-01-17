# spring-boot-lesson2
## aop测试多数据源

本例是通过面向切面来完成多数据源的实现

主要步骤：

    1、多数据的加载（DataSourceConfig.java）
    2、线程访问时数据源的切换（UserController.java）
    3、面向切面的实现（DS.java、DynamicDataSourceAspect.java）


不过目前有个问题：每个线程进来只能访问其中一个数据库，不能同时访问多个数据库，多个数据库的事务也是不能处理的

注解测试：

    @RequestMapping("/getUserAndBook")
    public Map getUserAndBook() {
        User user = getFirstUser();
        Book book = getFirstBook();
        Map map = new HashMap();
        map.put("user", user);
        map.put("book", book);
        return null;
    }


    @DS(value = "datasource2")
    private Book getFirstBook() {
        return bookMapper.getOneBook();
    }

    @DS
    private User getFirstUser(){
        return userMapper.getOneUser();
    }
    
上面的代码尝试一个请求去访问多个库，结果失败了，注解是适用于方法的入口处。
比如：getUserAndBook是方法入口，但是里面调用的getFirstBook()和getFirstUser()是不会进到自定义的注解的。
有人知道怎么处理吗？



    注解	含义
    @Component	最普通的组件，可以被注入到spring容器进行管理
    @Repository	作用于持久层
    @Service	作用于业务逻辑层
    @Controller	作用于表现层（spring-mvc的注解）


我们先看一下自定义注解


    注解 ElementType 枚举常量
    ANNOTATION_TYPE  注解类型声明
    CONSTRUCTOR  构造方法声明
    FIELD  字段声明（包括枚举常量）
    LOCAL_VARIABLE   局部变量声明
    METHOD  方法声明
    PACKAGE  包声明
    PARAMETER  参数声明
    TYPE  类、接口（包括注解类型）或枚举声明
    TYPE_PARAMETER    @since 1.8
    TYPE_USE    @since 1.8


解决方案：<br>
>把user和book对数据分开，请参考service包下的文件

具体代码参考UserController.getUserAndBookOther()方法


参考：[在同一个类中，一个方法调用另外一个有注解](https://blog.csdn.net/clementad/article/details/47339519)