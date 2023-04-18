package com.stc.petlove.controllers;


import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.repositories.LoaiThuCungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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
    public Optional<LoaiThuCung> getLoaiThuCungById(@PathVariable String id){
        return loaiThuCungRepository.findById(id);
    }

    @PostMapping("/loaithucung")
    public LoaiThuCung createLoaiThuCung(@RequestBody LoaiThuCung loaiThuCung){
        // Check maLoaiThuCung is existed
        if (!loaiThuCungRepository.findByTenLoaiThuCung(loaiThuCung.getTenLoaiThuCung()).isEmpty()){
            return null;
        }
        return loaiThuCungRepository.save(loaiThuCung);
    }

    @PutMapping("/loaithucung/{id}")
    public LoaiThuCung updateLoaiThuCung(@RequestBody LoaiThuCung loaiThuCung, @PathVariable String id){
        LoaiThuCung loaiThuCung1 = loaiThuCungRepository.findById(id).get();
        loaiThuCung1.setInfo(loaiThuCung);
        return loaiThuCungRepository.save(loaiThuCung1);
    }

    @DeleteMapping("/loaithucung/{id}")
    public void deleteLoaiThuCung(@PathVariable String id){
        loaiThuCungRepository.deleteById(id);
    }
}
