package de.denkformat.austauch_last_update.modell;

import javax.persistence.*;

@Entity
@Table(name = "payment_methodes")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;


    @Column(name = "name")
    private  String name;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CoinTransaction_id", referencedColumnName = "id")
    private  CoinTransactions coinTransactions;

    public PaymentMethod(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PaymentMethod() {

    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
