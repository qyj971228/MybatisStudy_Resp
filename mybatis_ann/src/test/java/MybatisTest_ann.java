import com.qyj.domain.Order;
import com.qyj.mapper.OrderMapper;
import com.qyj.mapper.UserMapper;
import com.qyj.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest_ann {

    private UserMapper mapper;
    private OrderMapper ordermapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
        ordermapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setId(30);
        user.setUsername("test");
        user.setPassword("123");
        mapper.save(user);
    }

    @Test
    public void update() throws IOException {
        User user = new User();
        user.setId(30);
        user.setUsername("test1");
        user.setPassword("1231");
        mapper.update(user);
    }

    @Test
    public void delete() throws IOException {
        User user = new User();
        user.setId(30);
        mapper.delete(user);
    }

    @Test
    public void findOne() throws IOException {
        User user = new User();
        user.setId(10);
        User one = mapper.findOneById(user);
        System.out.println(one);
    }

    @Test
    public void findAllUser() throws IOException {
        List<User> allUser = mapper.findAllUser();
        for (User user: allUser){
            System.out.println(user);
        }
    }

    @Test
    public void findAllOrder() throws IOException {
        List<Order> allOrder = ordermapper.findAllOrder();
        for (Order order: allOrder){
            System.out.println(order);
        }
    }

    /**
     * 注解方式一对多查询
     */
    @Test
    public void findUserAndOrderAll(){
//        List<User> userAndOrderAll = mapper.findUserAndOrderAll();
//        for (User user: userAndOrderAll){
//            System.out.println(user);
//        }
        List<User> userAndOrderAll1 = mapper.findUserAndOrderAll1();
        for (User user: userAndOrderAll1){
            System.out.println(user);
        }
    }
    /**
     * 注解方式多对多查询
     */
    @Test
    public void findUserAndRoleAll(){
        List<User> userAndRoleAll = mapper.findUserAndRoleAll();
        for (User user: userAndRoleAll){
            System.out.println(user);
        }
        List<User> userAndRoleAll1 = mapper.findUserAndRoleAll1();
        for (User user: userAndRoleAll1){
            System.out.println(user);
        }
    }
}
