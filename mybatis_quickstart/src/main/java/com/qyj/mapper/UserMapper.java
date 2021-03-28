package com.qyj.mapper;

import com.qyj.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> findAll();

    public List<User> findUserAndRoleAll();

    public List<User> findOne(User user);

    public List<User> findByIds(List<Integer> ids);

    public void save(User user);

    public void update(User user);

    public void delete(User user);

    public List<User> findAllUser();





}
