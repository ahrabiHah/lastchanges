package de.denkformat.austauch_last_update.Controller;


import de.denkformat.austauch_last_update.Services.CoinRequestService;
import de.denkformat.austauch_last_update.Services.CoinTransactionService;
import de.denkformat.austauch_last_update.Services.TransactionService;
import de.denkformat.austauch_last_update.modell.CoinRequest;
import de.denkformat.austauch_last_update.modell.CoinTransactions;
import de.denkformat.austauch_last_update.modell.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinsController {

    @Autowired
    private CoinRequestService coinRequestService;
    @Autowired
    private CoinTransactionService coinTransactionService;




    @Autowired
    private CoinsController(CoinRequestService coinRequestService,CoinTransactionService coinTransactionService){
        this.coinRequestService=coinRequestService;
        this.coinTransactionService=coinTransactionService;
    }



    /**list all coin requests **/
    @GetMapping("/api/coin/requests")
    public List<CoinRequest> findAll(){
        return  coinRequestService.findAll();
    }
    @GetMapping("/api/coin/request/{id}")
    public CoinRequest findRequestById(@PathVariable long id){
        return coinRequestService.findById(id);
    }

    @GetMapping("/api/coin/transaction/{id}")
    public CoinTransactions findTransactionById(@PathVariable long id){
        return coinTransactionService.findById(id);
    }
    /**list all coin request transaction*/
    @GetMapping("/api/coin/transactions")
    public List<CoinTransactions> findAllTransaction(){
        return  coinTransactionService.findAll();
    }


}
