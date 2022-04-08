package de.denkformat.austauch_last_update.modell;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "person",uniqueConstraints = {@UniqueConstraint(columnNames = "first_name"),@UniqueConstraint(columnNames = "email")})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

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



    public Person(int id, String firstName, String last_name, String phone, String email,
                  String country, String city, String password, boolean isActive, Date dateJoined, Blob image) {
        this.id = id;
        this.firstName = firstName;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.city = city;
        this.password = password;
        this.isActive = isActive;
        this.dateJoined = dateJoined;
        this.image = image;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
