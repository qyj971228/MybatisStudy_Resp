package com.qyj.test;

import com.qyj.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatistest {

    /**
     * 抽取方法
     * @return
     * @throws IOException
     */
    public SqlSession test() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    /**
     * 查询
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {

        //获取sqlSession对象
        SqlSession sqlSession = this.test();
        //执行操作
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印
        System.out.println(userList);
        //释放
        sqlSession.close();
    }

    /**
     * 插入
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        User user = new User();
        user.setId(0);
        user.setUsername("wanger");
        user.setPassword("123");
        //获取sqlSession对象
        SqlSession sqlSession = this.test();
        //执行操作
        int length = sqlSession.insert("userMapper.save",user);
//        //提交事务 -> mybatis默认开启事务,因此必须提交事务后才能改变数据
//        sqlSession.commit();
        //打印
        System.out.println(length);
        //释放
        sqlSession.close();
    }

    /**
     * 修改操作
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        User user = new User();
        user.setId(0);
        user.setUsername("lisan");
        user.setPassword("321");
        //获取sqlSession对象
        SqlSession sqlSession = this.test();
        //执行操作
        int update = sqlSession.update("userMapper.update", user);
//        //提交事务
//        sqlSession.commit();
        //打印
        System.out.println(update);
        //释放
        sqlSession.close();
    }

    /**
     * 删除操作
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        User user = new User();
        user.setId(0);
        user.setUsername("lisan");
        user.setPassword("321");
//        int id = 0;
        //获取sqlSession对象
        SqlSession sqlSession = this.test();
        //执行操作
        int update = sqlSession.delete("userMapper.delete", user);
//        int update = sqlSession.delete("userMapper.delete", id);
//        //提交事务
//        sqlSession.commit();
        //打印
        System.out.println(update);
        //释放
        sqlSession.close();
    }
}
