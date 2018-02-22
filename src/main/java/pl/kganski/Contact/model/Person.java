package pl.kganski.Contact.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String gender;

    @NotNull
    private String date_of_birth;

    @NotNull
    private String pesel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person", referencedColumnName = "id_person")
    private List<Contact> contacts;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Person(String name, String surname, String gender, String date_of_birth, String pesel) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.pesel = pesel;
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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
