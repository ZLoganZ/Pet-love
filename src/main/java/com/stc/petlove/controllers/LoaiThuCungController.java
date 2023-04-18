package com.stc.petlove.controllers;


import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.dtos.LoaiThuCungDTO;
import com.stc.petlove.services.LoaiThuCung.LoaiThuCungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class LoaiThuCungController {
    private final LoaiThuCungService loaiThuCungService;

    @Autowired
    public LoaiThuCungController(LoaiThuCungService loaiThuCungService) {
        this.loaiThuCungService = loaiThuCungService;
    }

    @GetMapping("/loaithucung/{id}")
    public ResponseEntity<LoaiThuCung> getLoaiThuCung(@PathVariable String id){
        return new ResponseEntity<>(loaiThuCungService.getLoaiThuCung(id), HttpStatus.OK);
    }

    @GetMapping("/loaithucung")
    public ResponseEntity<Iterable<LoaiThuCung>> getAllLoaiThuCung(){
        return new ResponseEntity<>(loaiThuCungService.getAllLoaiThuCung(), HttpStatus.OK);
    }

    @PostMapping("/loaithucung")
    public ResponseEntity<LoaiThuCung> create(@RequestBody LoaiThuCungDTO DTO){
        return new ResponseEntity<>(loaiThuCungService.createLoaiThuCung(DTO), HttpStatus.OK);
    }

    @PutMapping("/loaithucung/{id}")
    public ResponseEntity<LoaiThuCung> update(@PathVariable String id, @RequestBody LoaiThuCungDTO DTO){
        return new ResponseEntity<>(loaiThuCungService.updateLoaiThuCung(id,DTO), HttpStatus.OK);
    }

    @DeleteMapping("/loaithucung/{id}")
    public ResponseEntity<LoaiThuCung> delete(@PathVariable String id){
        return new ResponseEntity<>(loaiThuCungService.deleteLoaiThuCung(id), HttpStatus.OK);
    }
}
