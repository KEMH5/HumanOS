package com.nerdtic.humanos.controllers;

import com.nerdtic.humanos.entities.Contrat;
import com.nerdtic.humanos.services.ContratService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContratController {
    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @PostMapping("/contrats")
    public Contrat createContrat(
            @RequestBody
            Contrat contrat
    ) {
        return this.contratService.saveContrat(contrat);
    }

    @GetMapping("/contrats")
    public List<Contrat> getAllContrats() {
        return this.contratService.getAllContrats();
    }

    @GetMapping("/contrats/{contrat-id}")
    public Contrat getContratById(
            @PathVariable("contrat-id")
            Integer contratId
    ) {
        return contratService.getContrat(contratId);
    }

    @DeleteMapping("/contrats/{contrat-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("contrat-id")
            Integer id
    ){
        contratService.deleteContrat(id);
    }

}
