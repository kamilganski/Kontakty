package pl.kganski.Contact.model;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_contact")
    private Integer id_contact;

    @Column(name = "Mobile_Phone")
    private String mobile;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "id_person")
    private Integer personId;

    public Contact() {
    }

    public Contact(String mobile, String email, String phone, Integer personId) {
        this.mobile = mobile;
        this.email = email;
        this.phone = phone;
        this.personId = personId;
    }

    public Integer getId_contact() {
        return id_contact;
    }

    public void setId_contact(Integer id_contact) {
        this.id_contact = id_contact;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
