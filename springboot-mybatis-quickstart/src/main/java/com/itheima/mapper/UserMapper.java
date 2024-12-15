package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper()
public interface UserMapper {

//    @Select("select id, username, password, name, age from user")
    public List<User> findAll();

    @Delete("delete from user where id = #{id}")
    public Integer deleteById(Integer id);

    @Insert("insert into user(username, password, name, age) VALUES (#{username}, #{password}, #{name}, #{age})")
    public void insert(User user);

    @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    public void update(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
//    public User findByUserAndPassword(@Param("username") String username, @Param("password") String password);
    public User findByUserAndPassword(String username, String password);
}
