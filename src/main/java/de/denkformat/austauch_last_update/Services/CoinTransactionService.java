package de.denkformat.austauch_last_update.Services;

import de.denkformat.austauch_last_update.modell.CoinRequest;
import de.denkformat.austauch_last_update.modell.CoinTransactions;
import de.denkformat.austauch_last_update.repository.CoinTransactioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoinTransactionService  {



    @Autowired
    private CoinTransactioRepository coinTransactioRepository;


    @Autowired
    public  CoinTransactionService(CoinTransactioRepository coinTransactioRepository){
        this.coinTransactioRepository=coinTransactioRepository;
    }

    @Query("SELECT count(CoinTransactions)* CoinTransactions.totalAmount from CoinTransactions ")

    public  List<CoinTransactions> findAll(){
        return  coinTransactioRepository.findAll();
    }

    public CoinTransactions findById(Long theId) {
        Optional<CoinTransactions> result = coinTransactioRepository.findById(theId);
        CoinTransactions coinTransactions = null;
        if (result.isPresent()) {
            coinTransactions = result.get();
        } else {
            throw new RuntimeException("didnt found" + theId);
        }
        return coinTransactions;

    }
}
