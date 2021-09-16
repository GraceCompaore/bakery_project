package greta.cda.bakeryproject.controller;

import greta.cda.bakeryproject.entity.Command;
import greta.cda.bakeryproject.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class CommandController {
    private final CommandService commandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Command command) {
        commandService.create(command.getId(), command.getName(), command.getUser());
    }

    @GetMapping
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

