package de.denkformat.austauch_last_update.modell;

import javax.persistence.*;


@Entity
@Table(name = "helper")
public class Helper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;



    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private  Services services;

    public Helper(Person needer, Services services) {
        this.person = needer;
        this.services = services;
    }

    public Helper() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
