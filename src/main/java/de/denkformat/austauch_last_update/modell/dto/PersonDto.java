package de.denkformat.austauch_last_update.modell.dto;

import de.denkformat.austauch_last_update.modell.Contact;
import de.denkformat.austauch_last_update.modell.Roles;

import java.sql.Blob;
import java.util.Date;
import java.util.Set;

public class PersonDto {


    private String firstName;

    private String last_name;

    private boolean isActive;

    private Date dateJoined;

    private Blob image;

    private String country;

    private String city;

    private Set<Roles> roles;

    private Contact contact;

    public Contact getContact() {
        return contact;
    }


    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
}

