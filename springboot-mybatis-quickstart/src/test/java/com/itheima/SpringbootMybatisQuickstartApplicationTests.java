package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testDeleteById() {
        Integer i = userMapper.deleteById(5);
        System.out.println("执行完毕，影响的记录数：" + i);
    }

    @Test
    public void testInsert() {
        User user = new User(null, "537", "778778", "乌萨奇", 17);
        userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User(1, "zhouyu", "123456", "周瑜", 20);
        userMapper.update(user);
    }

    @Test
    public void testFindByUserAndPassword(){
        User user = userMapper.findByUserAndPassword("zhouyu", "123456");
        System.out.println(user);
    }

}
