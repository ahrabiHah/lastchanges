package de.denkformat.austauch_last_update.modell;

import javax.persistence.*;

@Entity
@Table(name = "coin_requestes")
public class CoinRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;


    @Column(name = "amount")
    private double amount;


    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private  Person person;


    public CoinRequest(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public CoinRequest() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
