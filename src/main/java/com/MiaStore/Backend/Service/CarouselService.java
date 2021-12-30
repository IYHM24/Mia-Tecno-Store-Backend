package com.MiaStore.Backend.Service;

import com.MiaStore.Backend.Model.Carousel;
import com.MiaStore.Backend.Repository.CarouselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarouselService {
    @Autowired
    CarouselRepository repository;

    public List<Carousel> getAll(){
        return repository.getAll();
    }

    public Carousel save(Carousel carousel){
        Optional<Carousel> carouselExists = repository.findLastId();
        if(!carouselExists.isEmpty()){
            carousel.setId(carouselExists.get().getId() + 1);
            return repository.save(carousel);
        }else{
            carousel.setId(0);
            return repository.save(carousel);
        }
    }

    public boolean Update(Carousel carousel){
        if(carousel.getId() != null){
            Optional<Carousel> CarouselDB = repository.findById(carousel.getId());
            if(!CarouselDB.isEmpty()){
                if(carousel.getTitle() != null){
                    CarouselDB.get().setTitle(carousel.getTitle());
                }
                if(carousel.getParagraph() != null){
                    CarouselDB.get().setParagraph(carousel.getParagraph());
                }
                if(carousel.getImg() != null){
                    CarouselDB.get().setImg(carousel.getImg());
                }
                repository.Update(CarouselDB.get());
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean Delete(int id){
        Optional<Carousel> carousel = repository.findById(id);
        if(!carousel.isEmpty()){
            repository.Delete(carousel.get());
            return true;
        } else {
            return false;
        }
    }

}
