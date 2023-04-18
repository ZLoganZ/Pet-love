package com.stc.petlove.controllers;

import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.repositories.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaiKhoanController {
    private final TaiKhoanRepository taiKhoanRepository;

    @Autowired
    public TaiKhoanController(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @GetMapping("/taikhoan")
    public List<TaiKhoan> getAllTaiKhoan(){
        return taiKhoanRepository.findAll();
    }

    @GetMapping("/taikhoan/{id}")
    public Optional<TaiKhoan> getTaiKhoanById(String id){
        return taiKhoanRepository.findById(id);
    }

    @PostMapping("/taikhoan")
    public TaiKhoan createTaiKhoan(TaiKhoan taiKhoan){
        return taiKhoanRepository.save(taiKhoan);
    }

    @PutMapping("/taikhoan/{id}")
    public TaiKhoan updateTaiKhoan(TaiKhoan taiKhoan){
        return taiKhoanRepository.save(taiKhoan);
    }

    @DeleteMapping("/taikhoan/{id}")
    public void deleteTaiKhoan(String id){
        taiKhoanRepository.deleteById(id);
    }
}
