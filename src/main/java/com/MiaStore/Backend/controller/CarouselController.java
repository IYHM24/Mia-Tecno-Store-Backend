package com.MiaStore.Backend.controller;

import com.MiaStore.Backend.Model.Carousel;
import com.MiaStore.Backend.Service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carousel")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CarouselController {
    @Autowired
    CarouselService service;

    @GetMapping("/all")
    public List<Carousel> getAll(){
        return service.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Carousel save(@RequestBody Carousel carousel){
        return service.save(carousel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean update(@RequestBody Carousel carousel) {
        return service.Update(carousel);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.Delete(id);
    }
}
