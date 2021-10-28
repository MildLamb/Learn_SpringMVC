# 注解实现SpringMVC
- 配置web.xml 注册DispatcherServlet
```xml
<servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:config/springmvc-config.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```
- springmvc-config.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/mvc
       http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!-- 配置自动扫描包，让指定包下的注解生效，由IOC容器统一管理 -->
    <context:component-scan base-package="com.mildlamb.controller"></context:component-scan>

    <!-- 让SpringMVC 不处理静态资源 -->
    <mvc:default-servlet-handler></mvc:default-servlet-handler>

    <!-- 开启映射器和适配器-->
    <mvc:annotation-driven></mvc:annotation-driven>

    <!-- 配置视图解析器 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
        <!-- 前缀 -->
        <property name="prefix" value="/WEB-INF/jsp/"></property>
        <!--后缀-->
        <property name="suffix" value=".jsp"></property>
    </bean>

</beans>
```
- controller
```java
@Controller
@RequestMapping("/test")
public class HelloController {
    @RequestMapping("/hello")
    public String Hello(Model model){
        model.addAttribute("msg","Never One,Without the other");
        return "kindred";
    }
}
```
### @RequestMapping
@RequestMapping: 请求映射
- 可以作用于类或者方法
