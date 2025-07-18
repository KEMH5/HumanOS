package com.nerdtic.humanos.controllers;

import com.nerdtic.humanos.entities.TypeContrat;
import com.nerdtic.humanos.services.TypeContratService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeContratController {
    private final TypeContratService typeContratService;

    public TypeContratController(
            TypeContratService typeContratService
    ) {
        this.typeContratService = typeContratService;
    }

    @PostMapping("/typeContrats")
    public TypeContrat createTypeContrat(
            @RequestBody
            TypeContrat typeContrat
    ){
        return typeContratService.save(typeContrat);
    }

    @GetMapping("/typeContrats")
    public List<TypeContrat> getAllTypeContrats() {
        return typeContratService.getAllTypeContrats();
    }

    @GetMapping("/typeContrats/{typecontrat-id}")
    public TypeContrat getTypeContratById(
            @PathVariable("typecontrat-id")
            Integer typecontratId
    ){
        return typeContratService.getTypeContratById(typecontratId);
    }

    @GetMapping("/typeContrats/{typeContrat-name}")
    public List<TypeContrat> getTypeContratByName(
            @PathVariable("typeContrat-name")
            String name
    ){
        return typeContratService.getAllTypeContratByName(name);
    }

    @DeleteMapping("/typeContrats/{typeContrat-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTypeContratById(
            @PathVariable("typeContrat-id")
                Integer id
    ){
        typeContratService.deleteTypeContratById(id);
    }
}
