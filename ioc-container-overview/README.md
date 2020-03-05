
## 依赖查找

    按照Bean类型区分：单一类型 集合类型 层次类型

    实时查找 VS 延迟查找
    区别：https://time.geekbang.org/course/detail/265-189606
    
## Spring IoC 依赖来源
    
    Bean: 
        自定义bean: 自己xml配置或者注解配置的Bean eg: User
        容器内建bean: 非自己定义，由容器初始化的Bean eg:Environment
    非Bean: 容器内建依赖(不可以通过依赖查找[getBean(XXXX)]的方法来获取) eg:BeanFactory
    
## ApplicationContext VS BeanFactory 谁是真正的IoC容器？
    
    ApplicationContext 是 BeanFactory 的子接口。
    ApplicationContext is BeanFactory, ApplicationContext在BeanFactory基础上提高了更多企业特性，
    ApplicationContext 是具备应用特性的 BeanFactory 的超集
    在 org.springframework.context.support.AbstractRefreshableApplicationContext 
 ```java
    @Nullable
    private DefaultListableBeanFactory beanFactory;
    
```
     中通过组合的方式 （所以可以解释ApplicationContext toString 为 DefaultListableBeanFactory了）.
    
## ApplicationContext提供功能
* 面向切面（AOP）
* 配置元信息（Configuration Metadata）
* 资源管理（Resources）
* 事件（Events）
* 国际化（i18n）
* 注解（Annotation）
* Environment抽象（Environment Abstraction）
    
