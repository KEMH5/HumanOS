package com.nerdtic.humanos.controllers;

import com.nerdtic.humanos.dto.PaieCreateRequest;
import com.nerdtic.humanos.entities.Paie;
import com.nerdtic.humanos.services.PaieService;
import com.nerdtic.humanos.services.implementations.PaieServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaieController {
    private final PaieService paieService;

    public  PaieController(
            PaieService paieService
    ){
        this.paieService = paieService;
    }

    @PostMapping("/paies")
    public Paie create(
            @RequestBody
            PaieCreateRequest paie
    ){
        return paieService.createPaie(paie);
    }

    @GetMapping("/paies")
    public List<Paie> getAllPaies() {
        return paieService.getPaies();
    }

    @GetMapping("/paies/{paie-id}")
    public Paie getPaie(
            @PathVariable("paie-id")
            Long paieId
    ) {
        return paieService.getPaie(paieId);
    }

    @DeleteMapping("/paies/{paie-id}")
    public void deletePaie(
            @PathVariable("paie-id")
            Long paieId
    ){
        paieService.deletePaie(paieId);
    }
}
