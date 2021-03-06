package greta.cda.bakeryproject.repository;

import greta.cda.bakeryproject.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommandRepository extends JpaRepository<Command, UUID> {
}
