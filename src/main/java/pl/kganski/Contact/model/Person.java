package pl.kganski.Contact.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person", catalog = "test")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "idPerson")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Date_of_birth")
    private String date_of_birth;

    @Column(name = "Pesel")
    private String pesel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPerson", referencedColumnName = "idPerson")
    private List<Contact> contactList;

    public Person() {
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
