package com.nerdtic.humanos.controllers;

import com.nerdtic.humanos.entities.Pointage;
import com.nerdtic.humanos.services.PointageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pointage")
@RequiredArgsConstructor
public class PointageController {

    private final PointageService pointageService;

    @GetMapping
    public ResponseEntity<List<Pointage>> getPointage() {
        return new ResponseEntity<>(pointageService.getAllPointages(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pointage> createPointage(@RequestBody Pointage pointage){
        return new ResponseEntity<>(pointageService.createPointage(pointage), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pointage> updatePointage(@PathVariable int id, @RequestBody Pointage pointage){
        return new ResponseEntity<>(pointageService.updatePointage(pointage, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pointage> deletePointage(@PathVariable int id){
        pointageService.deletePointage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pointage> getPointageById(@PathVariable int id){
        return new ResponseEntity<>(pointageService.getPointageById(id), HttpStatus.OK);
    }
}
