package de.denkformat.austauch_last_update.Controller;


import de.denkformat.austauch_last_update.Services.TransactionService;
import de.denkformat.austauch_last_update.modell.Transaction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionContoller {


    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionContoller(TransactionService transactionService){
        this.transactionService=transactionService;
    }

    @GetMapping("/api/transactions")
    public List<Transaction> findAlltrans(){
        return  transactionService.findAll();
    }
    @GetMapping("/api/transaction/{id}")
    public Transaction getTransaction(@PathVariable long id){
        return transactionService.findById(id);
    }


}
