# spring-boot-lesson2
## aop测试多数据源

本例是通过面向切面来完成多数据源的实现

主要步骤：

    1、多数据的加载（DataSourceConfig.java）
    2、线程访问时数据源的切换（UserController.java）
    3、面向切面的实现（DS.java、DynamicDataSourceAspect.java）
