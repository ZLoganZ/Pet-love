package com.stc.petlove.controllers;

import com.stc.petlove.entities.DichVu;
import com.stc.petlove.repositories.DichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DichVuController {
    private final DichVuRepository dichVuRepository;

    @Autowired
    public DichVuController(DichVuRepository dichVuRepository) {
        this.dichVuRepository = dichVuRepository;
    }

    @GetMapping("/dichvu")
    public List<DichVu> getAllDichVu(){
        return dichVuRepository.findAll();
    }

    @GetMapping("/dichvu/{id}")
    public Optional<DichVu> getDichVuById(String id){
        return dichVuRepository.findById(id);
    }

    @PostMapping("/dichvu")
    public DichVu createDichVu(DichVu dichVu){
        return dichVuRepository.save(dichVu);
    }

    @PutMapping("/dichvu/{id}")
    public DichVu updateDichVu(DichVu dichVu){
        return dichVuRepository.save(dichVu);
    }

    @DeleteMapping("/dichvu/{id}")
    public void deleteDichVu(String id){
        dichVuRepository.deleteById(id);
    }
}
