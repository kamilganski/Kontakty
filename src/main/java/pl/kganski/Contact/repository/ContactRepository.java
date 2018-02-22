package pl.kganski.Contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kganski.Contact.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    public Contact findByMobile(String mobile);
    public Contact findByEmail(String email);
    public Contact findByPhone(String phone);
    public Contact findByPersonId(Integer personId);
}
