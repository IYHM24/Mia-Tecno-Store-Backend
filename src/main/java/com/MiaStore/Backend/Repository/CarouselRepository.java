package com.MiaStore.Backend.Repository;

import com.MiaStore.Backend.CrudInterface.CarouselCrudRepository;
import com.MiaStore.Backend.Model.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarouselRepository {
    @Autowired
    CarouselCrudRepository crud ;

    public List<Carousel> getAll(){
        return (List<Carousel>) crud.findAll();
    }

    public Optional<Carousel> findLastId(){
        return crud.findTopByOrderByIdDesc();
    }

    public Optional<Carousel> findById(int id){
        return crud.findById(id);
    }

    public Carousel save(Carousel carousel){
        return crud.save(carousel);
    }

    public void Update(Carousel carousel){
        crud.save(carousel);
    }

    public void Delete(Carousel carousel){
        crud.delete(carousel);
    }
}
