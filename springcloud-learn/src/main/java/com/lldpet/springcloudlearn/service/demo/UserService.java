package com.lldpet.springcloudlearn.service.demo;

import com.lldpet.springcloudlearn.entity.demo.User;

/**
 * @author llduo
 * @Description
 * @create 2019-01-14 10:52
 */
public interface UserService {
    public User findByUserName(String userName);
}
