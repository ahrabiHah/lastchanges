package de.denkformat.austauch_last_update.modell;

import javax.persistence.*;

@Entity
@Table(name = "needer")
public class Needer {


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

    @Column(name = "descripotion")
    private String description;



    public Needer() {

    }

    public  String getDescription(String description){
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getNeeder() {
        return person;
    }

    public Services getServices() {
        return services;
    }

  }

