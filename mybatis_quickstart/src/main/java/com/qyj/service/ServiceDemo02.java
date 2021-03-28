package com.qyj.service;

import com.qyj.mapper.OrderMapper;
import com.qyj.mapper.UserMapper;
import com.qyj.domain.Order;
import com.qyj.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceDemo02 {

    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        //代理实现
        OrderMapper ordermapper = sqlSession.getMapper(OrderMapper.class);
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

        List<Order> all1 = ordermapper.findAll();
        List<User> all2 = usermapper.findAll();
        List<User> userAndRoleAll = usermapper.findUserAndRoleAll();
        sqlSession.commit();

        for (Order order: all1){
            System.out.println(order);
        }
        System.out.println();

        for (User user: all2){
            System.out.println(user);
        }
        System.out.println();

        for (User user: userAndRoleAll){
            System.out.println(user);
        }
        System.out.println();

        sqlSession.close();

    }
}
