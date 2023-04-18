package com.stc.petlove.controllers;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.dtos.DatChoDTO;
import com.stc.petlove.services.DatCho.DatChoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class DatChoController {
    private final DatChoService datChoService;

        @Autowired
        public DatChoController(DatChoService datChoService) {
            this.datChoService = datChoService;
        }

        @GetMapping("/datcho/{id}")
        public ResponseEntity<DatCho> getDatCho(@PathVariable String id){
            return new ResponseEntity<>(datChoService.getDatCho(id), HttpStatus.OK);
        }

        @GetMapping("/datcho")
        public ResponseEntity<Iterable<DatCho>> getAllDatCho(){
            return new ResponseEntity<>(datChoService.getAllDatCho(), HttpStatus.OK);
        }

        @PostMapping("/datcho")
        public ResponseEntity<DatCho> create(@RequestBody DatChoDTO DTO){
            return new ResponseEntity<>(datChoService.create(DTO), HttpStatus.OK);
        }

        @PutMapping("/datcho/{id}")
        public ResponseEntity<DatCho> update(@PathVariable String id, @RequestBody DatChoDTO DTO){
            return new ResponseEntity<>(datChoService.update(id,DTO), HttpStatus.OK);
        }

        @DeleteMapping("/datcho/{id}")
        public ResponseEntity<DatCho> delete(@PathVariable String id){
            return new ResponseEntity<>(datChoService.delete(id), HttpStatus.OK);
        }
}
