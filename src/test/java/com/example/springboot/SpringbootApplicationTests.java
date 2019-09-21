package com.example.springboot;

import com.example.springboot.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =SpringbootApplication.class)
public class SpringbootApplicationTests {

    @Autowired
    private UserDao userDao;

   /* @Before
    public void before() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("风清扬");
        userDO.setAccount("fengqy");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO = new UserDO();
        userDO.setId(3L);
        userDO.setName("东方不败");
        userDO.setAccount("bubai");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO.setId(5L);
        userDO.setName("向问天");
        userDO.setAccount("wentian");
        userDO.setPwd("123456");
        userDao.save(userDO);
    }*/
    @Test
    public void testAdd() {

    }


}
