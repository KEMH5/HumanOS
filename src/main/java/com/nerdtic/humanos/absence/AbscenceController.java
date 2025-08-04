package com.nerdtic.humanos.absence;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbscenceController {

    private final AbscenceService abscenceService;

    public AbscenceController(
        AbscenceService abscenceService
    ) {
        this.abscenceService = abscenceService;
    }

    @PostMapping("/absences")
    public Abscence createAbsence(
            @RequestBody
            AbscenceCreateRequest abscence
    ) {
        return abscenceService.createAbscence(abscence);
    }

    @GetMapping("/absences")
    public List<Abscence> getAllAbsences() {
        return abscenceService.findAllAbscences();
    }


    @DeleteMapping("absences/{absence-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAbsence(
            @PathVariable("absence-id")
            Long absenceId
    ){
        abscenceService.deleteAbscence(absenceId);
    }


}
