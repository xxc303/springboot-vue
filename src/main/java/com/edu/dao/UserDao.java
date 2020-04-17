package com.edu.dao;

import com.edu.entity.User;

import java.util.List;

/**
 * @author 123
 * @version 1.0
 * @date 2020 2020/4/17 13:47
 */
public interface UserDao {

    //模糊查询
    List<User> findByNameOrPhone(String name, String phone);
    //更新
    void update(User user);

    //根据id查询
    User findUserById(String id);

    //删除用户信息
    void delete(String id);

    //保存用户信息
    int save(User user);

    //查询所有用户
    List<User> findAll();
}
