package com.qyj.mapper;

import com.qyj.domain.Order;
import com.qyj.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("select * from orders where uid = #{uid}")
    public List<Order> findById(int uid);

    //一对一查询方式1
    /*
    @Select("select * from orders o,user u where o.uid = u.id")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user.id"),
            @Result(column = "username",property = "user.username"),
            @Result(column = "password",property = "user.password"),
            @Result(column = "birthday",property = "user.birthday")
    })
    */

    //一对一查询方式2
    //此语句相当于
    //select * from orders
    //select * from user where id = #{id}
    @Select("select * from orders")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property = "user",//要封装的属性名称 -> 来自OrderBean的成员变量user
                    column = "uid",//根据哪个字段去查询user表的数据 -> findOneById的参数
                    javaType = User.class,//要封装的实体类型 -> 成员变量user的类型
                    one = @One(select = "com.qyj.mapper.UserMapper.findOneById")//select 代表调用哪个接口的方法
            )
    })
    public List<Order> findAllOrder();
}
