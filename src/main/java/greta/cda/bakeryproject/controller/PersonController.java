package greta.cda.bakeryproject.controller;

import greta.cda.bakeryproject.dto.LoginDto;
import greta.cda.bakeryproject.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        personService.deleteById(UUID.fromString(id));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody LoginDto person) {
        personService.update(UUID.fromString(id), person);
    }
}
