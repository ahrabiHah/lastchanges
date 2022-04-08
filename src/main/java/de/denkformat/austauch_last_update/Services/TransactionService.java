package de.denkformat.austauch_last_update.Services;

import de.denkformat.austauch_last_update.modell.Needer;
import de.denkformat.austauch_last_update.modell.Transaction;
import de.denkformat.austauch_last_update.repository.TransactionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository=transactionRepository;
    }


    //find All Trnsaction in DB
    public  List<Transaction> findAll(){
        return transactionRepository.findAll();
    }
    public Transaction findById(Long theId) {
        Optional<Transaction> result = transactionRepository.findById(theId);
        Transaction theUser = null;
        if (result.isPresent()) {
            theUser = result.get();
        } else {
            throw new RuntimeException("didnt found" + theId);
        }
        return theUser;

    }



}
