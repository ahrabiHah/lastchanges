package de.denkformat.austauch_last_update.repository;

import de.denkformat.austauch_last_update.modell.CoinRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRequestRepository extends JpaRepository<CoinRequest,Long> {
}
