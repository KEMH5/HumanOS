package com.nerdtic.humanos.controllers;

import com.nerdtic.humanos.dto.DepartementCreateRequest;
import com.nerdtic.humanos.dto.readRequest.DepartementReadRequest;
import com.nerdtic.humanos.entities.Departement;
import com.nerdtic.humanos.services.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departements")
@RequiredArgsConstructor
public class DepartementController {

    private final DepartementService departementService;

    @GetMapping
    public ResponseEntity<List<DepartementReadRequest>> getAllDepartements(){
        return new ResponseEntity<>(departementService.getAllDepartements(), HttpStatus.OK);
    }

    @PostMapping
    public Departement createDepartement(
            @RequestBody
            DepartementCreateRequest departement
    ) {
        return departementService.createDepartement(departement);
    }

    @PutMapping("/update/{id}")
    public Departement updateDepartement(
            @PathVariable
            Long id,
            @RequestBody
            DepartementCreateRequest departement
    ){
        return departementService.updateDepartement(departement, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartement(@PathVariable Long id){
        departementService.deleteDepartement(id);
    }

    @GetMapping("/{id}")
    public DepartementReadRequest getDepartementById(
            @PathVariable("id")
            Long departementId
    ){
        return departementService.getDepartement(departementId);
    }

}
