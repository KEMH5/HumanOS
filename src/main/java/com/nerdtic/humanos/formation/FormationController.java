package com.nerdtic.humanos.formation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/formations")
@RequiredArgsConstructor
public class FormationController{

    private final FormationService formationService;

    @GetMapping
    public ResponseEntity<List<Formation>> getAllFormations(){
        return new ResponseEntity<>(formationService.getAllFormations(), HttpStatus.OK);
    }

    @PostMapping
    public Formation createFormation(@RequestBody FormationCreateRequest formation){
        return formationService.createFormation(formation);
    }

    @PutMapping("/update/{id}")
    public Formation updateFormation(@RequestBody FormationCreateRequest formation, @PathVariable Long id){
        return formationService.updateFormation(formation, id);
    }

    @DeleteMapping("/{id}")
    public void deleteFormation(@PathVariable Long id){
        formationService.deleteFormation(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable Long id){
        return new ResponseEntity<>(formationService.getFormationById(id), HttpStatus.OK);
    }
}
