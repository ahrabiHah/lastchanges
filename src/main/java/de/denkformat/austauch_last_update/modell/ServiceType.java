package de.denkformat.austauch_last_update.modell;

import javax.persistence.*;

@Entity
@Table(name = "service_type")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;


    @Column(name = "Service_name")
    private  String name;

    @Column(name = "service_points")
    private int points;



    public ServiceType(long id, String name, int points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public ServiceType() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
