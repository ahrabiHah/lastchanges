package de.denkformat.austauch_last_update.modell;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name="coin_transactions")
public class CoinTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;


    @Column(name = "price")
    private double price;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "transaction_date")
    private  Timestamp transactionDate;



    @ManyToOne
    @JoinColumn(name = "coin_requestes_id", referencedColumnName = "id")
    private  CoinRequest coinRequest;

    @OneToOne(targetEntity = PaymentMethod.class,cascade = CascadeType.DETACH)
    @JoinColumn(name = "paymentMethod_id")
    private  PaymentMethod paymentMethod;

    public CoinTransactions(long id, double price, double totalAmount, Timestamp transactionDate,
                            CoinRequest coinRequest, PaymentMethod paymentMethod) {
        this.id = id;
        this.price = price;
        this.totalAmount = totalAmount;
        this.transactionDate = transactionDate;
        this.coinRequest = coinRequest;
        this.paymentMethod = paymentMethod;
    }

    public CoinTransactions() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public CoinRequest getRequest() {
        return coinRequest;
    }

    public void setRequest(CoinRequest request) {
        this.coinRequest = request;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
