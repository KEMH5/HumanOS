package com.nerdtic.humanos.controllers;

import com.nerdtic.humanos.entities.Poste;
import com.nerdtic.humanos.services.PosteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PosteController {
    private PosteService posteService;

    public PosteController(PosteService posteService) {
        this.posteService = posteService;
    }

    @PostMapping("/postes")
    public Poste addPoste(
            @RequestBody
            Poste poste
    ) {
        return posteService.createPoste(poste);
    }

    @GetMapping("/postes")
    public List<Poste> getAllPostes() {
        return posteService.getAllPostes();
    }

    @GetMapping("/postes/{poste-id}")
    public Poste getPoste(
            @PathVariable("poste-id")
            Integer posteId
    ) {
        return posteService.getPoste(posteId);
    }

    @DeleteMapping("/postes/{poste-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePoste(
            @PathVariable("poste-id")
            Integer posteId
    ){
        posteService.deletePoste(posteId);
    }
}
