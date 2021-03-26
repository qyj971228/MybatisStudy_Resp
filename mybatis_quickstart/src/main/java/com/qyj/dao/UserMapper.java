package com.qyj.dao;

import com.qyj.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    public List<User> findAll() throws IOException;

    public List<User> findUserAndRoleAll() throws IOException;

    public List<User> findOne(User user) throws IOException;

    public List<User> findByIds(List<Integer> ids) throws IOException;

    public void save(User user) throws IOException;

    public void update(User user) throws IOException;

    public void delete(User user) throws IOException;



}
