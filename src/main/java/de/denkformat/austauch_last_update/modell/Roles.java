package de.denkformat.austauch_last_update.modell;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "role")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;


    @Column(name = "name")
    private  String name;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "person_Role",joinColumns = @JoinColumn(name = "Role_id"),
            inverseJoinColumns=@JoinColumn(name = "person_id"))
    private Set<Person> persons;

    public Roles(int id, String name,  Set<Person> persons) {
        this.id = id;
        this.name = name;
        this.persons = persons;
    }

    public Set<Person> getPersons() {
        return persons;
    }


    public Roles() {

    }

    public long Id() {
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
