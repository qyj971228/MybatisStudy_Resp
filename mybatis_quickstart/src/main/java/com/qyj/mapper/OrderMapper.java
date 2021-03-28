package com.qyj.mapper;

import com.qyj.domain.Order;

import java.util.List;

public interface OrderMapper {

    public void updateOrderTime(Order order);
    public List<Order> findAll();

}
