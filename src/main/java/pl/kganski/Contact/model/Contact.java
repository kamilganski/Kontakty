package pl.kganski.Contact.model;

import javax.persistence.*;

/*@Entity
@Table(name = "contact")*/
public class Contact {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_contact")
    private Integer id_contact;

    @Column(name = "Mobile_Phone")
    private String mobile_phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    public Contact() {
    }

    public Contact(String mobile_phone, String email, String phone) {
        this.mobile_phone = mobile_phone;
        this.email = email;
        this.phone = phone;
    }

    public Contact(Integer id_contact) {
        this.id_contact = id_contact;
    }

    public Integer getId_contact() {
        return id_contact;
    }

    public void setId_contact(Integer id_contact) {
        this.id_contact = id_contact;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
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
    }*/
}
