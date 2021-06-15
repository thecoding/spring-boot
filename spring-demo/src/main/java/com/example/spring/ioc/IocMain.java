package com.example.spring.ioc;

import com.example.spring.ioc.demo1.annotation.Super;
import com.example.spring.ioc.demo1.domain.SuperUser;
import com.example.spring.ioc.demo1.domain.User;
import com.example.spring.ioc.demo1.domain.UserRepository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @author Mirko
 * @Description
 * @createTime 2021年06月15日 23:24:00
 */
@SpringBootApplication
public class IocMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IocMain.class, args);
        loadByName(context);
        loadByType(context);
        loadByAnnotation(context);

        System.out.println("==========");
        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);

//        ObjectFactory<User> objectFactory = (ObjectFactory<User>) context.getBean("objectFactory");
//        User object = objectFactory.getObject();
//        System.out.println(object); // User
        // ObjectFactory
//        System.out.println("objectFactory 是否一致：" + (userRepository.getObjectFactory() == objectFactory));
        // BeanFactory  context.getBeanFactory() 为内建Bean
//        System.out.println("BeanFactory 是否一致：" + (userRepository.getBeanFactory() == context.getBeanFactory()));


//        System.out.println(userRepository.getObjectFactory().getObject());
        System.out.println(userRepository.getObjectFactory() == context); // User


    }

    private static void loadByAnnotation(ConfigurableApplicationContext context) {
        System.out.println("====loadByAnnotation===");
        if (context instanceof ListableBeanFactory) {
            ListableBeanFactory beanFactory = (ListableBeanFactory) context;
            Map<String, Object> beansOfType = beanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(beansOfType);
        }
    }

    private static void loadByType(ConfigurableApplicationContext context) {
        System.out.println("====loadByType===");
        if (context instanceof ListableBeanFactory) {
            ListableBeanFactory beanFactory = (ListableBeanFactory) context;
            Map<String, User> beansOfType = beanFactory.getBeansOfType(User.class);
            System.out.println(beansOfType);
        }
    }

    private static void loadByName(ConfigurableApplicationContext context) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) context.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println(user);
    }


    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }

    @Bean
    public SuperUser superUser(){
        SuperUser superUser = new SuperUser();
        superUser.setAddress("111");
        superUser.setName("11");
        superUser.setAge("11");
        return superUser;
    }

    @Bean
    public User user(){
        User user = new User();
        user.setAge("18");
        user.setName("user");
        return user;
    }

    @Bean
    public ObjectFactoryCreatingFactoryBean objectFactory(){
        ObjectFactoryCreatingFactoryBean objectFactoryCreatingFactoryBean = new ObjectFactoryCreatingFactoryBean();
        objectFactoryCreatingFactoryBean.setTargetBeanName("user");
        return objectFactoryCreatingFactoryBean;
    }

}
