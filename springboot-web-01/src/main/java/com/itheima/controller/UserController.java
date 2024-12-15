package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

/**
 * 用户信息Controller
 */

@RestController
public class UserController {

//    @RequestMapping("/list")
//    public List<User> list(InputStream inputStream) {
//        //1. 加载并读取user.txt文件，获取用户信息
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//        //2. 解析用户信息，封装为User对象 -> list集合
//        List<User> userList = lines.stream().map(line -> {
//            String[] parts = line.split(",");
//            Integer id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            return new User(id, username, password, name, age, updateTime);
//        }).toList();
//        //2. 返回数据（json）
//        return userList;
//      }

//    方式1-属性注入
//    @Autowired
//    private UserService userService;

    //方式2-构造器注入
//    private final UserService userService;
//    @Autowired - 只有一个构造函数可以省略
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //方式3-setter注入
    private UserService userService;
//    @Qualifier("userServiceImpl") - 指定使用Bean
    @Autowired // DI - 默认使用类型注入 - 多个类型相同时，使用名称注入

//    @Resource(name = "userServiceImpl") - 指定使用Bean

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public List<User> list(InputStream inputStream) {
        List<User> userList = userService.findAll();

        //2. 返回数据（json）
        return userList;
    }
}
