package com.dao;


import com.xiaoxu.User;

import java.util.List;

/**
 * @author  xiaoxu
 * @date  2020年4月12日
 * @description 持久层
 */
public interface iUserDao {
    List<User> findAll();
    User findByid(int id);
    void updateUser(User user);
    void deleteUser(int id);
}
