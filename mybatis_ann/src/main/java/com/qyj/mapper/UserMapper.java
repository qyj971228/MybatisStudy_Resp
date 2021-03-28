package com.qyj.mapper;

import com.qyj.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public User findOneById(User user);

    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);

    @Update("update user set username = #{username},password = #{password} where id = #{id}")
    public void update(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(User user);

    @Select("select * from user")
    public List<User> findAllUser();


    // 一对多查询
    // 查询目标user的所有order
    // select * from user
    // select * from orders where uid = #{uid}
    // 先查出每一条user的信息,再根据每条user信息的id查询orderList
    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "orderList",//要封装的名称
                    column = "id",//findById的参数
                    javaType = List.class,//被封装的类型
                    many = @Many(select = "com.qyj.mapper.OrderMapper.findById")
            )
    })
    public List<User> findUserAndOrderAll();

    @Select("select * from orders, user where user.id = orders.uid")
    public List<User> findUserAndOrderAll1();


    //多对多查询
    //通过中间表user_role查询user的对应role
    //select * from user
    //select * from user_role,role where user_role.roleId = role.id and user_role.userId = #{id}
    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "roleList",//要封装的名称
                    column = "id",
                    javaType = List.class,//被封装的类型
                    many = @Many(select = "com.qyj.mapper.RoleMapper.findById")
            )
    })
    public List<User> findUserAndRoleAll();





}







