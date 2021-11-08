package greta.cda.bakeryproject.controller;

import greta.cda.bakeryproject.dto.LoginDto;
import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        personService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable String id, @RequestBody LoginDto person) {
        return ResponseEntity.ok(personService.update(id, person));
    }
}
