package com.nerdtic.humanos.controllers;

import com.nerdtic.humanos.entities.Conge;
import com.nerdtic.humanos.services.CongeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conges")
@RequiredArgsConstructor
public class CongeController {

    private final CongeService congeService;

    @GetMapping
    public ResponseEntity<List<Conge>> getAllConge() {
        return new ResponseEntity<>(congeService.getAllConge(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Conge> createConge(@RequestBody Conge conge) {
        return new ResponseEntity<>(congeService.createConge(conge), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conge>  updateConge(@PathVariable int id, @RequestBody Conge conge) {
        return new ResponseEntity<>(congeService.updateConge(conge, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteConge(@PathVariable int id) {
        congeService.deleteConge(id);
    }

    @GetMapping("/conge/{id}")
    public ResponseEntity<Conge> getConge(@PathVariable int id) {
        return new ResponseEntity<>(congeService.getConge(id), HttpStatus.OK);
    }
}
