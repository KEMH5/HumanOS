package com.nerdtic.humanos.contrat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/contrats")
public class ContratController {
    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @PostMapping
    public Contrat createContrat(
            @RequestBody
            ContratCreateRequest contrat
    ) {
        return this.contratService.saveContrat(contrat);
    }

    @GetMapping
    public List<Contrat> getAllContrats() {
        return contratService.getAllContrats();
    }

    @GetMapping("/{contrat-id}")
    public Contrat getContratById(
            @PathVariable("contrat-id")
            Long contratId
    ) {
        return contratService.getContrat(contratId);
    }

    @DeleteMapping("/{contrat-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("contrat-id")
            Long id
    ){
        contratService.deleteContrat(id);
    }

}
