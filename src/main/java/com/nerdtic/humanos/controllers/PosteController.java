package com.nerdtic.humanos.controllers;

import com.nerdtic.humanos.dto.PosteCreateRequest;
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
            PosteCreateRequest poste
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
            Long posteId
    ) {
        return posteService.getPoste(posteId);
    }

    @DeleteMapping("/postes/{poste-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePoste(
            @PathVariable("poste-id")
            Long posteId
    ){
        posteService.deletePoste(posteId);
    }
}
