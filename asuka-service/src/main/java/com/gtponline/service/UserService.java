package com.gtponline.service;

import com.gtponline.model.User;


public interface UserService {
    User save(User user);
    User get(long id);
    Iterable<User> list();
    void update(User user);
    void delete(long id);
}
