package greta.cda.bakeryproject.repository;

import greta.cda.bakeryproject.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Integer> {
    // void update(Command myOrder);
}
