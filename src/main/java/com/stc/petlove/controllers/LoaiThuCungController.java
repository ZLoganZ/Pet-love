package com.stc.petlove.controllers;


import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.repositories.LoaiThuCungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LoaiThuCungController {
    private final LoaiThuCungRepository loaiThuCungRepository;

    @Autowired
    public LoaiThuCungController(LoaiThuCungRepository loaiThuCungRepository) {
        this.loaiThuCungRepository = loaiThuCungRepository;
    }

    @GetMapping("/loaithucung")
    public List<LoaiThuCung> getAllLoaiThuCung(){
        return loaiThuCungRepository.findAll();
    }

    @GetMapping("/loaithucung/{id}")
    public Optional<LoaiThuCung> getLoaiThuCungById(String id){
        return loaiThuCungRepository.findById(id);
    }

    @PostMapping("/loaithucung")
    public LoaiThuCung createLoaiThuCung(LoaiThuCung loaiThuCung){
        return loaiThuCungRepository.save(loaiThuCung);
    }

    @PutMapping("/loaithucung/{id}")
    public LoaiThuCung updateLoaiThuCung(LoaiThuCung loaiThuCung){
        return loaiThuCungRepository.save(loaiThuCung);
    }

    @DeleteMapping("/loaithucung/{id}")
    public void deleteLoaiThuCung(String id){
        loaiThuCungRepository.deleteById(id);
    }
}
