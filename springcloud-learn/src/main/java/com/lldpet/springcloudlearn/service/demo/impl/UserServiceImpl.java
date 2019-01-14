package com.lldpet.springcloudlearn.service.demo.impl;

import com.lldpet.springcloudlearn.dao.demo.UserDao;
import com.lldpet.springcloudlearn.entity.demo.User;
import com.lldpet.springcloudlearn.service.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author llduo
 * @Description
 * @create 2019-01-14 10:53
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
