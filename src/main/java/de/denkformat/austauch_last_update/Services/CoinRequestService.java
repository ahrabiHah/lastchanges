package de.denkformat.austauch_last_update.Services;

import de.denkformat.austauch_last_update.modell.CoinRequest;
import de.denkformat.austauch_last_update.modell.CoinTransactions;
import de.denkformat.austauch_last_update.modell.Person;
import de.denkformat.austauch_last_update.repository.CoinRequestRepository;
import de.denkformat.austauch_last_update.repository.CoinTransactioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoinRequestService {



    @Autowired
    private CoinRequestRepository coinRequestRepository;
    @Autowired
    private CoinTransactioRepository coinTransactioRepository;

    @Autowired
    public CoinRequestService(CoinRequestRepository coinRequestRepository,  CoinTransactioRepository coinTransactioRepository){
        this.coinRequestRepository=coinRequestRepository;
        this.coinTransactioRepository=coinTransactioRepository;
    }



    public  List<CoinRequest> findAll(){
        return  coinRequestRepository.findAll();
    }

    public CoinRequest findById(Long theId) {
        Optional<CoinRequest> result = coinRequestRepository.findById(theId);
        CoinRequest coinRequest = null;
        if (result.isPresent()) {
            coinRequest = result.get();
        } else {
            throw new RuntimeException("didnt found" + theId);
        }
        return coinRequest;

    }

//    public List<CoinRequest> findAll() {
//        return coinRequestRepository.findAll();
//    }
}
