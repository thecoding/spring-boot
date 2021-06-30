package com.example.swagger.stater.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Field;

/**
 * @author Mirko
 * @Description
 * @createTime 2021年07月01日 00:44:00
 */
@Configuration
@EnableSwagger2
public class Swagger2Config implements BeanPostProcessor {

    @Autowired
    ApplicationContext applicationContext;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API接口文档")
                .description("用户信息管理")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.spring.swagger.controller")) //这里写的是API接口所在的包位置
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf(){
        return new ApiInfoBuilder().title("API接口文档")
                .description("用户信息管理")
                .version("1.0.0")
                .build();
    }

    private Docket buildDocketWithGroupName(String groupName) {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(buildApiInf())
//                .groupName(groupName)
//                .select()
//                .apis(input -> {
//                    if (input.getHandlerMethod().hasMethodAnnotation(ApiVersion.class)) {
//                        ApiVersion apiVersion = input.getHandlerMethod().getMethodAnnotation(ApiVersion.class);
//                        if (apiVersion.group() != null && apiVersion.group().length != 0) {
//                            if (Arrays.asList(apiVersion.group()).contains(groupName)) {
//                                return true;
//                            }
//                        }
//
//                    }
//                    ApiVersion clzzApiVersion = input.getHandlerMethod().getBeanType().getAnnotation(ApiVersion.class);
//                    if (clzzApiVersion != null) {
//                        if (clzzApiVersion.group() != null && clzzApiVersion.group().length != 0) {
//                            if (Arrays.asList(clzzApiVersion.group()).contains(groupName)) {
//                                return true;
//                            }
//                        }
//                    }
//                    return false;
//                })//controller路径
//                .paths(PathSelectors.any())
//                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.spring.swagger.controller")) //这里写的是API接口所在的包位置
                .paths(PathSelectors.any())
                .build();
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName);
        return bean;
    }

    public void afterPropertiesSet() throws Exception {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // 根据ApiConstantVersion构造 docket
        Class<ApiVersionConstant> clzz = ApiVersionConstant.class;
        Field[] declaredFields = clzz.getDeclaredFields();
        // 动态注入bean
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        if(autowireCapableBeanFactory instanceof DefaultListableBeanFactory){
            DefaultListableBeanFactory capableBeanFactory = (DefaultListableBeanFactory) autowireCapableBeanFactory;
            for (Field declaredField : declaredFields) {
                AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().setFactoryMethodOnBean("buildDocketWithGroupName", "com.example.swagger.stater.config.swagger2Config")
                        .addConstructorArgValue(declaredField.get(ApiVersionConstant.class)).getBeanDefinition();
                capableBeanFactory.registerBeanDefinition(declaredField.getName(), beanDefinition);
            }
        }
    }
}
