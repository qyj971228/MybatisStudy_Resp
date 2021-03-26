package com.qyj.service;

import com.qyj.dao.UserMapper;
import com.qyj.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ServiceDemo {

    public static void main(String[] args) throws IOException {

        User user = new User();
        user.setId(10);
        //user.setUsername("qyj");
        user.setPassword("123");

        List Ids = new ArrayList();
        Ids.add(1);
        Ids.add(2);
        Ids.add(3);

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        //代理实现
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> all = mapper.findAll();
//        List<User> one = mapper.findOne(user);
        List<User> byIds = mapper.findByIds(Ids);
//        mapper.save(user);
//        mapper.delete(user);
//        mapper.update(user);
        sqlSession.commit();
        System.out.println(byIds);
    }
}
