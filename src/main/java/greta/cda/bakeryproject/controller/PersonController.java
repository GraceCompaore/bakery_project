package greta.cda.bakeryproject.controller;

import greta.cda.bakeryproject.dto.PersonIdentifierDto;
import greta.cda.bakeryproject.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        personService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody PersonIdentifierDto person) {
        personService.update(id, person);
    }
}
