package de.denkformat.austauch_last_update.modell;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;


    @Column(name = "creation_date")
    private  Timestamp creationDate;

    /**there is for every coin state, if the review was not good, the admin will search by coinState
     * and get messeage accoriding to the false state **/
    @Column(name = "coin_state")
    private boolean coinState;

    @Column(name = "helper_review")
    private String helperReview;

    @Column(name = "needer_review")
    private String neederReview;

    /**
     * this for admin, if there was not gut review, admin will  check it manuel**/
    @Column(name = "admin_check")
    private boolean adminCheck;

    @ManyToOne
    @JoinColumn(name = "needer_id", referencedColumnName = "id")
    private  Person needer;

    @ManyToOne
    @JoinColumn(name = "helper_id", referencedColumnName = "id")
    private  Person helper;





    public Transaction(int id, Timestamp creationDate, boolean coinState, String helperReview, String neederReview, boolean adminCheck,
    Person helper, Person needer) {
        this.id = id;
        this.creationDate = creationDate;
        this.coinState = coinState;
        this.helperReview = helperReview;
        this.neederReview = neederReview;
        this.adminCheck = adminCheck;
        this.needer=needer;
        this.helper=helper;
    }

    public Person getNeeder() {
        return needer;
    }

    public void setNeeder(Person needer) {
        this.needer = needer;
    }

    public Person getHelper() {
        return helper;
    }

    public void setHelper(Person helper) {
        this.helper = helper;
    }

    public Transaction() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isCoinState() {
        return coinState;
    }

    public void setCoinState(boolean coinState) {
        this.coinState = coinState;
    }

    public String getHelperReview() {
        return helperReview;
    }

    public void setHelperReview(String helperReview) {
        this.helperReview = helperReview;
    }

    public String getNeederReview() {
        return neederReview;
    }

    public void setNeederReview(String neederReview) {
        this.neederReview = neederReview;
    }

    public boolean isAdminCheck() {
        return adminCheck;
    }

    public void setAdminCheck(boolean adminCheck) {
        this.adminCheck = adminCheck;
    }
}
