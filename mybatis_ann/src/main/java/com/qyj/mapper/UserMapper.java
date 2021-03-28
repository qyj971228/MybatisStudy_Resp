package com.qyj.mapper;

import com.qyj.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public List<User> findOneById(User user);

    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);

    @Update("update user set username = #{username},password = #{password} where id = #{id}")
    public void update(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(User user);

    @Select("select * from user")
    public List<User> findAllUser();





}
