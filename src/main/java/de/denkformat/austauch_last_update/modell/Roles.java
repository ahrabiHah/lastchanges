package de.denkformat.austauch_last_update.modell;

import java.util.Collection;
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




    public Roles(int id, String name,  Set<Person> persons) {
        this.id = id;
        this.name = name;
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
