package com.mclods.taco_cloud_secured.services.impl;

import com.mclods.taco_cloud_secured.entities.TacoOrder;
import com.mclods.taco_cloud_secured.repositories.OrderRepository;
import com.mclods.taco_cloud_secured.services.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public TacoOrder saveOrder(TacoOrder tacoOrder) {
        if(tacoOrder.getOrderDate() == null) {
            tacoOrder.setOrderDate(LocalDateTime.now());
        }

        return orderRepository.save(tacoOrder);
    }
}
