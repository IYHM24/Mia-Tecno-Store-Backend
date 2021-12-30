package com.MiaStore.Backend.CrudInterface;

import com.MiaStore.Backend.Model.Carousel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CarouselCrudRepository extends MongoRepository<Carousel,Integer> {
    Optional<Carousel> findTopByOrderByIdDesc();
}
