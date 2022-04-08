package de.denkformat.austauch_last_update.repository;

import de.denkformat.austauch_last_update.modell.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository  extends JpaRepository<ServiceType,Long> {
}
