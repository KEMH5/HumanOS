package com.nerdtic.humanos.controllers;

import com.nerdtic.humanos.dto.FeuilleTempsCreateRequest;
import com.nerdtic.humanos.entities.FeuilleTemps;
import com.nerdtic.humanos.services.FeuilleTempsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feuilles")
public class FeuilleTempsController {

    FeuilleTempsService feuilleTempsService;

    @GetMapping
    public ResponseEntity<List<FeuilleTemps>> getAllFeuilleDeTemps() {
        return new ResponseEntity<>(feuilleTempsService.getAllFeuilleDeTemps(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeuilleTemps> createFeuilleDeTemps(@RequestBody FeuilleTempsCreateRequest feuilleTemps) {
        return new ResponseEntity<>(feuilleTempsService.createFeuilleDeTemps(feuilleTemps), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeuilleTemps> updateFeuilleTemps(@RequestBody FeuilleTempsCreateRequest feuilleTemps, @PathVariable Long id){
        return new ResponseEntity<>(feuilleTempsService.updateFeuilleDeTemps(feuilleTemps, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteFeuilleTemps(@PathVariable Long id){
        feuilleTempsService.deleteFeuilleDeTemps(id);
    }

    @GetMapping("/{id")
    public ResponseEntity<FeuilleTemps> getFeuilleDeTemps(@PathVariable Long id){
        return new ResponseEntity<>(feuilleTempsService.getFeuilleDeTemps(id), HttpStatus.OK);
    }
}
