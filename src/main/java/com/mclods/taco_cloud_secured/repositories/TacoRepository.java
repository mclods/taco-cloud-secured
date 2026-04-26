package com.mclods.taco_cloud_secured.repositories;

import com.mclods.taco_cloud_secured.entities.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Integer> {
}
