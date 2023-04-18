package com.stc.petlove.controllers;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.repositories.DatChoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class DatChoController {
    private final DatChoRepository datChoRepository;

    @Autowired
    public DatChoController(DatChoRepository datChoRepository) {
        this.datChoRepository = datChoRepository;
    }

    @GetMapping("/datcho")
    public List<DatCho> getAllDatCho(){
        return datChoRepository.findAll();
    }

    @GetMapping("/datcho/{id}")
    public Optional<DatCho> getDatChoById(@PathVariable String id){
        return datChoRepository.findById(id);
    }

    @PostMapping("/datcho")
    public DatCho createDatCho(@RequestBody DatCho datCho){
        return datChoRepository.save(datCho);
    }

    @PutMapping("/datcho/{id}")
    public DatCho updateDatCho(@RequestBody DatCho datCho, @PathVariable String id){
        DatCho datCho1 = datChoRepository.findById(id).get();
        datCho1.setInfo(datCho);
        return datChoRepository.save(datCho1);
    }

    @DeleteMapping("/datcho/{id}")
    public void deleteDatCho(@PathVariable String id){
        datChoRepository.deleteById(id);
    }
}
