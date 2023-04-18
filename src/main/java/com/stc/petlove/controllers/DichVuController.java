package com.stc.petlove.controllers;

import com.stc.petlove.entities.DichVu;
import com.stc.petlove.dtos.DichVuDTO;
import com.stc.petlove.services.DichVu.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class DichVuController {
    private final DichVuService dichVuService;

    @Autowired
    public DichVuController(DichVuService dichVuService) {
        this.dichVuService = dichVuService;
    }

    @GetMapping("/dichvu/{id}")
    public ResponseEntity<DichVu> getDichVu(@PathVariable String id){
        return new ResponseEntity<>(dichVuService.getDichVu(id), HttpStatus.OK);
    }

    @GetMapping("/dichvu")
    public ResponseEntity<Iterable<DichVu>> getAllDichVu(){
        return new ResponseEntity<>(dichVuService.getAllDichVu(), HttpStatus.OK);
    }

    @PostMapping("/dichvu")
    public ResponseEntity<DichVu> create(@RequestBody DichVuDTO DTO){
        return new ResponseEntity<>(dichVuService.create(DTO), HttpStatus.OK);
    }

    @PutMapping("/dichvu/{id}")
    public ResponseEntity<DichVu> update(@PathVariable String id, @RequestBody DichVuDTO DTO){
        return new ResponseEntity<>(dichVuService.update(id,DTO), HttpStatus.OK);
    }

    @DeleteMapping("/dichvu/{id}")
    public ResponseEntity<DichVu> delete(@PathVariable String id){
        return new ResponseEntity<>(dichVuService.delete(id), HttpStatus.OK);
    }
}
