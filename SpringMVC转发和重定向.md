# 转发和重定向
- 无视图解析器
```java
@Controller
public class ForwardController {
    @GetMapping("/test")
    public String test(HttpServletRequest req, HttpServletResponse resp){
        //转发
        return "forward:/WEB-INF/jsp/forward.jsp";
    }

    @GetMapping("/test2")
    public String test2(HttpServletRequest req, HttpServletResponse resp){
        //重定向
        //WEB-INF目录对客户端隐藏，是服务器级别，所以重定向不到，要想访问得到需要写controller处理
        //重定向不会走视图解析器的，请求转发才会。并且重定向不能访问WEB-INF目录下的内容
        return "redirect:/index.jsp";
    }
}
```
- 有视图解析器
加了forward或者redirect就不走视图解析器了
```java
@Controller
public class ForwardController {
    @GetMapping("/test")
    public String test(HttpServletRequest req, HttpServletResponse resp){
        //转发
        return "forward";
    }

    @GetMapping("/test2")
    public String test2(HttpServletRequest req, HttpServletResponse resp){
        //重定向
        //WEB-INF目录对客户端隐藏，是服务器级别，所以重定向不到，要想访问得到需要写controller处理
        //有视图解析器直接写地址
        return "redirect:/index.jsp";
    }
}
```
