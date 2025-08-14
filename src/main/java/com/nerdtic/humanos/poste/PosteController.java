package com.nerdtic.humanos.poste;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postes")
public class PosteController {
    private PosteService posteService;

    public PosteController(PosteService posteService) {
        this.posteService = posteService;
    }

    @PostMapping
    public Poste addPoste(
            @RequestBody
            PosteCreateRequest poste
    ) {
        return posteService.createPoste(poste);
    }

    @GetMapping
    public List<Poste> getAllPostes() {
        return posteService.getAllPostes();
    }

    @GetMapping("/{poste-id}")
    public Poste getPoste(
            @PathVariable("poste-id")
            Long posteId
    ) {
        return posteService.getPoste(posteId);
    }

    @DeleteMapping("/{poste-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePoste(
            @PathVariable("poste-id")
            Long posteId
    ){
        posteService.deletePoste(posteId);
    }
}
