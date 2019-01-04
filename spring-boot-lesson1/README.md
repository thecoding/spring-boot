# spring-boot test

## 2019-01-01 spring-boot集成mybatis注解版

### pom.xml中增加以下配置
	
	<dependency>
		<groupId>org.mybatis.spring.boot</groupId>
		<artifactId>mybatis-spring-boot-starter</artifactId>
		<version>1.1.1</version>
	</dependency>
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<optional>true</optional>
	</dependency>

本地创建mysql数据库，并创建spring_boot测试库

	create database spring_boot;
用root创建 spring_user用户 密码为spring_boot

	create user spring_user identified by 'spring_boot';
再给用户spring_user授权

	grant all privileges on spring_boot.* to 'spring_user'@'%' identified by 'spring_root' with grant option;
	grant all privileges on spring_boot.* to 'spring_user'@'localhost' identified by 'spring_boot' with grant option;
	flush privileges;
然后用spring_user用户创建user表，创建sql参考User.sql

接下来就可以写mybatis的实体User和db操作的接口UserMapper
比如：

	@Select("select * from user")
    @Results({
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();
这里需要注意的是，数据库中的字段和我们实体不一致的情况如何处理。在result中property为实体User的属性，column为数据库中的字段名，其他也是一样的。
下面的update语句也是一样的：

	@Update("UPDATE user SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

然后在Application类名上增加

	@SpringBootApplication
	@MapperScan("com.spring_boot.mapper")
	public class Application {
		public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		}
	}

表示应用自动去扫描com.spring_boot.mapper包下的映射文件

写完，我们就可以测试了

	@Test
    public void testInsert() throws Exception {
        UserMapper.insert(new User("aa", "a123456"));
        UserMapper.insert(new User("bb", "b123456"));
        UserMapper.insert(new User("cc", "b123456"));

        Assert.assertEquals(3, UserMapper.getAll().size());
    }
测试先我们先没空数据库中user表的数据





