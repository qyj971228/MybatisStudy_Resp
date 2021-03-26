package com.qyj.dao;

import com.qyj.domain.Order;
import com.qyj.domain.User;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    public void updateOrderTime(Order order);
    public List<Order> findAll();

}
