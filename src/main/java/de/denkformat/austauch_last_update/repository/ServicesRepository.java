package de.denkformat.austauch_last_update.repository;

import de.denkformat.austauch_last_update.modell.Services;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository  extends JpaRepository<Services,Long> {
    public Services findByName(String name);
}
