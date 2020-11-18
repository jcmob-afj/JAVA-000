##作业一 ：写代码实现Spring Bean的装配

####方法1.使用XML的方式装配，setter的方式注入 在resources添加 applicationContext.xml，然后在其中添加bean的描述

#####在Student类中添加set/get方法
```html
  <bean id="student01"
        class="com.spring.demo.entity.Student">
      <property name="age" value="22" />
      <property name="name" value="张三" />
  </bean>
```
#####在main方法中调用
```java
   ApplicationContext context =
           new ClassPathXmlApplicationContext("applicationContext.xml");
   Student student01 = (Student) context.getBean("student01");
   System.out.println(student01);
```

####方法2.使用构造器的方式注入

##### 定义有两个参数的构造器
```java
    public Student(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
```
##### 添加构造器配置的XML
```html
   <bean id = "student02" class="com.spring.demo.entity.Student">
       <constructor-arg name="age" value="33"></constructor-arg>
       <constructor-arg name="name" value="李四"></constructor-arg>
   </bean>
```
##### main 方法调用
```java
   Student student02 = (Student) context.getBean("student02");
   System.out.println(student02);
```
####方法3.使用Annotation的方式来装配
#####先在resources添加 applicationContext.xml，然后添加bean扫描
```html
  <context:component-scan base-package="com.spring.demo" />
```
##### 实体类里面使用注解的标签来进行赋值
```java
@Component
@Data
public class Student {

    @Value("33")
    Integer age;

    @Value("西西")
    String name;
    
}
```
#####在main方法中调用
```java
   ApplicationContext context =
           new ClassPathXmlApplicationContext("applicationContext.xml");

   Student student03 = (Student) context.getBean("Student");
   System.out.println(student03); 
```
####方法4.自动装配

##### 使用@Autowired来自动装配
```java
    @Component
    public class School {
        @Autowired
        Teacher teacher;
    
        public Teacher getTeacher() {
            return teacher;
        }
    
        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }
    }
```
#####在main方法中调用
```java
   ApplicationContext context =
           new ClassPathXmlApplicationContext("applicationContext.xml");

   School sh = (School)context.getBean("school");
   System.out.println(sh.getTeacher());
```

##作业二 ：给前面课程提供的 Student/Klass/School 实现自动配置和 Starter
作业链接：<https://www.mdeditor.com>
##作业三：研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法： 
    1）使用 JDBC 原生接口，实现数据库的增删改查操作。 
    2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。 
    3）配置 Hikari 连接池，改进上述操作。
作业链接：<https://www.mdeditor.com>