package de.denkformat.austauch_last_update.repository;

import de.denkformat.austauch_last_update.modell.Roles;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

@Reference
public interface RolesRepository extends JpaRepository<Roles,Long> {


}
