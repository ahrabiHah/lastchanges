package de.denkformat.austauch_last_update.modell;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;
import javax.management.relation.Role;
import javax.persistence.*;


@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String last_name;


    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="date_joined")
    private Date dateJoined;

    @Column(name = "profile_picture")
    private Blob image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "person_Role",joinColumns = @JoinColumn(name = "Person_id"),
            inverseJoinColumns=@JoinColumn(name = "Role_id"))
    private Set<Roles> roles;

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Contact getContact() {
        return contact;
    }


    public Person(int id, String firstName, String last_name,
                  String country, String city, String password, boolean isActive,
                  Date dateJoined, Blob image,Set<Roles> roles) {
        this.id = id;
        this.firstName = firstName;
        this.last_name = last_name;
        this.country = country;
        this.city = city;
        this.password = password;
        this.isActive = isActive;
        this.dateJoined = dateJoined;
        this.image = image;
        this.roles=roles;
    }



    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        isActive = isActive;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
