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
    private  CoinRequest request;

    @ManyToOne
    @JoinColumn(name = "payment_methodes_id", referencedColumnName = "id")
    private  PaymentMethod paymentMethod;

    public CoinTransactions(long id, double price, double totalAmount, Timestamp transactionDate, CoinRequest request, PaymentMethod paymentMethod) {
        this.id = id;
        this.price = price;
        this.totalAmount = totalAmount;
        this.transactionDate = transactionDate;
        this.request = request;
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
        return request;
    }

    public void setRequest(CoinRequest request) {
        this.request = request;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
