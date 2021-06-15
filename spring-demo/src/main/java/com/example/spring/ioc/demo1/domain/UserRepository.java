package com.example.spring.ioc.demo1.domain;

import javafx.application.Application;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;


/**
 * @author Mirko
 * @Description
 * @createTime 2021年06月16日 00:01:00
 */
@Data
@ToString
public class UserRepository {

    ObjectFactory<ApplicationContext> objectFactory;
    BeanFactory beanFactory;
}
