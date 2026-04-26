package com.mclods.taco_cloud_secured.repositories;

import com.mclods.taco_cloud_secured.entities.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Integer> {
}
