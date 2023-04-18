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
    public Optional<TaiKhoan> getTaiKhoanById(@PathVariable String id){
        return taiKhoanRepository.findById(id);
    }

    @PostMapping("/taikhoan")
    public TaiKhoan createTaiKhoan(@RequestBody TaiKhoan taiKhoan){
        // check if email is existed
        if(taiKhoanRepository.findByEmail(taiKhoan.getEmail()) != null){
            return null;
        }
        return taiKhoanRepository.save(taiKhoan);
    }

    @PutMapping("/taikhoan/{id}")
    public TaiKhoan updateTaiKhoan(@RequestBody TaiKhoan taiKhoan, @PathVariable String id){
        TaiKhoan taiKhoan1 = taiKhoanRepository.findById(id).get();
        taiKhoan1.setInfo(taiKhoan);
        return taiKhoanRepository.save(taiKhoan1);
    }

    @DeleteMapping("/taikhoan/{id}")
    public void deleteTaiKhoan(String id){
        taiKhoanRepository.deleteById(id);
    }
}
