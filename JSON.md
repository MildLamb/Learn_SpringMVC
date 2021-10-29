# JSON
### 什么是JSON?
- JSON(JavaScript Object Notation,JS对象标记)是一种轻量级的数据交换格式
- 采用完全独立于编程语言的文本格式来存储和表示数据
- 简洁和清晰的层次结构使得JSON成为理想的数据交换语言
- 易于人阅读和编写，同时也易于机器解析和生成，并有效提升网络传输效率

语法格式:  
- 对象表示为键值对，数据由逗号分隔
- 花括号保存对象
- 方括号存储数组


### JS对象和JSON之间的转换,通过前端自带的对象JSON的方法实现
- 将js对象转化为json对象 stringify
- 将JSON对象转换为JavaScript对象 parse
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script type="text/javascript">
        //编写一个JavaScript对象
        var user = {
            name:"千珏",
            age:1500,
            sex:"女"
        }

        //将js对象转化为json对象
        var json = JSON.stringify(user);
        console.log("json: " + json)


        console.log("=====================")

        //将JSON对象转换为JavaScript对象
        var obj = JSON.parse('{"name":"千珏","age":1500,"sex":"女"}');
        console.log(obj)
    </script>
</head>
<body>

</body>
</html>
```

## jackson
- 导入依赖
```xml
<!-- jackson -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.0</version>
</dependency>
```
- 使用jackson的ObjectMapper中的方法进行对象和字符串之间的转换
```java
@Controller
public class UserController {
    @GetMapping("/j1")
    @ResponseBody   //不会走视图解析器,会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson 中有一个对象叫 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User(1,"千珏",1500);

        //将对象变为字符串
        String s = mapper.writeValueAsString(user);

        return s;
    }
}
```
- 结果
    - 直接toString输出结果 ：User(id=1, name=??, age=1500)
    - jackson的方式输出结果为 ： {"id":1,"name":"??","age":1500}

出现??的解决方法
- 在RequestMapping或GetMapping注解的produces属性中设置这个字符串 @GetMapping(value = "/j1",produces = "application/json;charset=utf-8")
