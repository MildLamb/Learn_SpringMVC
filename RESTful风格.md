# RESTful风格
### 概念
RESTful就是一个资源定位及资源操作的风格。不是标准也不是协议，只是一种风格。基于这个风格  
设计的软件可以更简洁，更有层次，更易于实现缓存等。  
通过不同的请求方式，实现不同的功能效果  

### 使用RESTful
- 原生方式
```java
@Controller
public class RestFulController {

    //原生方式：http://localhost:8080/add?a=1&b=2
    //RSETful：

    @RequestMapping("/add")
    public String restFulTest(int a,int b,Model model){
        model.addAttribute("msg","结果为:" + (a+b));
        return "rest";
    }
}
```
- RESTful方式
```java
@Controller
public class RestFulController {

    //原生方式：http://localhost:8080/add?a=1&b=2
    //RSETful：http://localhost:8080/add/1/2

    @RequestMapping(value = "/add/{a}/{b}", method = {RequestMethod.GET})
    //@PathVariable: 路径变量 从url中获取对应的参数
    public String restFulTest(@PathVariable int a,@PathVariable int b, Model model){
        model.addAttribute("msg","结果为:" + (a+b));
        return "rest";
    }
}
```
```bash
可以使用更加简便的注解代替@RequestMapping
@RequestMapping(value = "/add/{a}/{b}", method = {RequestMethod.GET})
等价于 @GetMapping("/add/{a}/{b}")
类似的还有
@PostMapping
@DeleteMapping
...  ...

可以使用RESTful实现通过不同的请求方式，实现不同的功能效果  

```
