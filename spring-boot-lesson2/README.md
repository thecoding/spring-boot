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
