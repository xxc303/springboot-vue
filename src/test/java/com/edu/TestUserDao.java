package com.edu;

import com.edu.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 123
 * @create 2020/4/17
 */
@SpringBootTest(classes = SpringbootVueApplication.class)
@RunWith(SpringRunner.class)
public class TestUserDao {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDao(){
        userDao.findAll().forEach(user -> System.out.println("user=" + user));
    }

}
