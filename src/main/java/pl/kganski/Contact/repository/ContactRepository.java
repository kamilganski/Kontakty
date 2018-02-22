package pl.kganski.Contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kganski.Contact.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {


}
