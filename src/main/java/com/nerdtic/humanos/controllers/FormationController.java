package com.nerdtic.humanos.controllers;

import com.nerdtic.humanos.entities.Departement;
import com.nerdtic.humanos.entities.Formation;
import com.nerdtic.humanos.repositories.FormationRepository;
import com.nerdtic.humanos.services.FormationService;
import com.nerdtic.humanos.services.implementations.FormationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
@RequiredArgsConstructor
public class FormationController{

    private final FormationService formationService;

    @GetMapping
    public ResponseEntity<List<Formation>> getAllFormations(){
        return new ResponseEntity<>(formationService.getAllFormations(), HttpStatus.OK);
    }

    @PostMapping
    public Formation createFormation(@RequestBody Formation formation){
        return formationService.createFormation(formation);
    }

    @PutMapping("/update/{id}")
    public Formation updateFormation(@RequestBody Formation formation, @PathVariable int id){
        return formationService.updateFormation(formation, id);
    }

    @DeleteMapping("/{id}")
    public void deleteFormation(@PathVariable int id){
        formationService.deleteFormation(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable int id){
        return new ResponseEntity<>(formationService.getFormationById(id), HttpStatus.OK);
    }
}
