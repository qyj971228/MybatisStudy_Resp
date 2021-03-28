package com.qyj.service;

import com.qyj.mapper.OrderMapper;
import com.qyj.domain.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class ServiceDemo {

    public static void main(String[] args) throws IOException {

//        User user = new User();
//        user.setId(21);
//        user.setUsername("com.qyj");
//        user.setPassword("123");

//        user.setBirthday(new Date());

        Order order = new Order();
        order.setId(6);
        order.setOrdertime(new Date());

//        List Ids = new ArrayList();
//        Ids.add(1);
//        Ids.add(2);
//        Ids.add(3);

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        //代理实现
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        //设置分页的相关参数 当前页+每页显示的条数
//        PageHelper.startPage(1,3);
//        PageHelper.startPage(2,3);
//        PageHelper.startPage(3,3);

        mapper.updateOrderTime(order);

//        List<User> all = mapper.findAll();

//        List<User> one = mapper.findOne(user);
//        List<User> byIds = mapper.findByIds(Ids);
//        mapper.save(user);
//        mapper.delete(user);
//        mapper.update(user);

        sqlSession.commit();

//        for (User user1:all){
//            System.out.println(user1);
//        }

        //获得分页相关参数
//        PageInfo<User> pageInfo = new PageInfo<User>(all);
//        System.out.println("当前页:"+pageInfo.getPageNum());
//        System.out.println("每页显示条数:"+pageInfo.getPageSize());
//        System.out.println("总页数:"+pageInfo.getPages());
//        System.out.println("总条数:"+pageInfo.getTotal());
//        System.out.println("上一页:"+pageInfo.getPrePage());
//        System.out.println("下一页:"+pageInfo.getNextPage());
//        System.out.println("是否是第一页:"+pageInfo.isIsFirstPage());
//        System.out.println("是否是最后一页:"+pageInfo.isIsLastPage());

        sqlSession.close();

    }
}
