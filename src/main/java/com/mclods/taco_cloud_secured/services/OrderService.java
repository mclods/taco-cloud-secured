package com.mclods.taco_cloud_secured.services;

import com.mclods.taco_cloud_secured.entities.TacoOrder;

public interface OrderService {
    TacoOrder saveOrder(TacoOrder tacoOrder);
}
