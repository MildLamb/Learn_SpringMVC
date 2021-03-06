# SpringMVC的特点
1. 轻量级，简单易学
2. 高效，基于请求响应的MVC框架
3. 与Spring兼容性好，无缝结合
4. 约定大于配置
5. 功能强大：RESTful，数据验证，格式化，主题等
6. 简洁灵活

### springmvc环境搭建
- 创建web项目
- 导入SpringMVC相关依赖
- 配置web.xml，注册DispatcherServlet
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <!-- 注册DispatcherServlet -->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- 关联一个springmvc配置文件 -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc-config.xml</param-value>
        </init-param>
        <!-- 启动级别 开服启动 -->
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

</web-app>
```
- 创建一个springmvc.xml 配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 添加 处理器映射器 -->
    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean>
    <!-- 添加 处理器适配器 -->
    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"></bean>
    <!-- 添加 视图解析器 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
        <!-- 前缀 -->
        <property name="prefix" value="/WEB-INF/jsp/"></property>
        <!--后缀-->
        <property name="suffix" value=".jsp"></property>
    </bean>

    <!-- 配置请求映射 -->
    <bean id="/hello" class="com.mildlamb.controller.HelloController"></bean>

</beans>
```
- 创建一个controller类
```java
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        //封装对象，放到ModelAndView中
        mv.addObject("msg","Hello,SpringMVC");

        //封装要跳转的视图
        mv.setViewName("hello");  //: /WEB-INF/jsp/hello.jsp
        return mv;
    }
}
```
- 测试即可

## SpringMVC执行流程
1. 用户发送请求至前端控制器DispatcherServlet。
2. DispatcherServletch接收到请求调用处理器映射器，HandlerMapping。
3. 处理器映射器根据请求的url找到具体的处理器，生成处理器执行链HandlerExecutionChain(包括处理器对象和拦截器对象)一并返回给DispatcherServlet。
4. DispatcherServlet根据处理器Handler获取处理器适配器HandlerAdapter执行HandlerAdapter处理一系列的操作，如：参数封装，数据格式转换等。
5. 执行处理器Handler。
6. Handler执行完成返回ModelAndView。
7. HandlerAdapter将Handler执行结果ModelAndView返回给DispatcherServlet。
8. DispatcherServlet将ModelAndView传给ViewReslover视图解析器。
9. ViewReslover解析后返回具体的View。
10. DispatcherServlet对View进行渲染。
11. DispatcherServlet响应用户
