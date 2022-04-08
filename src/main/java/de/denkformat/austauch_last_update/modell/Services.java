package de.denkformat.austauch_last_update.modell;

import javax.persistence.*;

@Entity
@Table(name = "services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne
    @JoinColumn(name = "serviceType_id", referencedColumnName = "id")
    private  ServiceType serviceType;


    @Column(name = "service_name")
    private  String name;

    public void setId(int id) {
        this.id = id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Services(int id, ServiceType serviceType, String name) {
        this.id = id;
        this.serviceType = serviceType;
        this.name = name;
    }

    public Services() {

    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
