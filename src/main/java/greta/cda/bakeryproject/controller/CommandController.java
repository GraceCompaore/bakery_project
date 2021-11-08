package greta.cda.bakeryproject.controller;

import greta.cda.bakeryproject.dto.CreateCommandRequestDto;
import greta.cda.bakeryproject.entity.Command;
import greta.cda.bakeryproject.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<Command> create(@RequestBody CreateCommandRequestDto commandDto) {
        return ResponseEntity.ok(commandService.create(commandDto));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Command>> findAll() {
        return ResponseEntity.ok(commandService.findAll());
    }

    @DeleteMapping("{/id}")
    public void deleteById(@PathVariable String id) {
        commandService.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Command> update(String id, @RequestBody Command command) {
        return ResponseEntity.ok(commandService.update(id, command));
    }
}

