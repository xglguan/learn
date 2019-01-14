package com.lldpet.springcloudlearn.dao.demo;

import com.lldpet.springcloudlearn.entity.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author llduo
 * @Description
 * @create 2019-01-14 10:47
 */
public interface UserDao extends JpaRepository<User,Long> {
    User findByUserName(String userName);
}
