package greta.cda.bakeryproject.controller;

import greta.cda.bakeryproject.entity.Command;
import greta.cda.bakeryproject.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/command")
public class CommandController {
    private final CommandService commandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_CUSTOM')")
    public void create(@RequestBody Command command) {
        commandService.create(command.getUser(), command.getProductOrder());
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Command> findAll() {
        return commandService.findAll();
    }

    @DeleteMapping("{/id}")
    public void deleteById(@PathVariable Integer id) {
        commandService.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(int id, @RequestBody Command command) {
        commandService.update(id, command);
    }
}

