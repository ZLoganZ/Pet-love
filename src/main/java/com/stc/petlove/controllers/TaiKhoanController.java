package com.stc.petlove.controllers;

import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.dtos.TaiKhoanDTO;
import com.stc.petlove.services.TaiKhoan.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaiKhoanController {
    private final TaiKhoanService taiKhoanService;

    @Autowired
    public TaiKhoanController(TaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping("/taikhoan/{id}")
    public ResponseEntity<TaiKhoan> getTaiKhoan(@PathVariable String id){
        return new ResponseEntity<>(taiKhoanService.getTaiKhoan(id), HttpStatus.OK);
    }

    @GetMapping("/taikhoan")
    public ResponseEntity<Iterable<TaiKhoan>> getAllTaiKhoan(){
        return new ResponseEntity<>(taiKhoanService.getAllTaiKhoan(), HttpStatus.OK);
    }

    @PostMapping("/taikhoan")
    public ResponseEntity<TaiKhoan> create(@RequestBody TaiKhoanDTO DTO){
        return new ResponseEntity<>(taiKhoanService.create(DTO), HttpStatus.OK);
    }

    @PutMapping("/taikhoan/{id}")
    public ResponseEntity<TaiKhoan> update(@PathVariable String id, @RequestBody TaiKhoanDTO DTO){
        return new ResponseEntity<>(taiKhoanService.update(id,DTO), HttpStatus.OK);
    }

    @DeleteMapping("/taikhoan/{id}")
    public ResponseEntity<TaiKhoan> delete(@PathVariable String id){
        return new ResponseEntity<>(taiKhoanService.delete(id), HttpStatus.OK);
    }
}
