package de.denkformat.austauch_last_update.modell;

import javax.persistence.*;

@Entity
@Table(name = "Contact")
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;

    @Column(name = "email")
    private String email;


    @Column(name = "email2")
    private String email2;

    @Column(name = "mobile")
    private  String phoneMobile;

    @Column(name = "phonehome")
    private  String phoneHome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private  Person person;

    public Contact(long id, String email, String email2, String phoneMobile, String phoneHome) {
        this.id = id;
        this.email = email;
        this.email2 = email2;
        this.phoneMobile = phoneMobile;
        this.phoneHome = phoneHome;
    }

    public Contact() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }
}
