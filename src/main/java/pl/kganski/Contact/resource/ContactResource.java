package pl.kganski.Contact.resource;

import org.springframework.web.bind.annotation.*;
import pl.kganski.Contact.model.Contact;
import pl.kganski.Contact.model.Person;
import pl.kganski.Contact.repository.ContactRepository;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/personscontact")
public class ContactResource {

    private ContactRepository contactRepository;

    public ContactResource(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping(value = "/all")
    public List<Contact> getContact() {

        return contactRepository.findAll();
    }

    @GetMapping(value = "/update/{name}")
    public List<Contact> update(@PathVariable final String name) {

        Contact contact = new Contact();
        Contact contact2 = new Contact();
        Person person = new Person();

        person.setName(name);
        person.setSurname("Smith");
        person.setGender("M");
        person.setDate_of_birth("1990-05-12");
        person.setPesel("90051233897");
        person.setContactList(Arrays.asList(contact, contact2));

        contact.setEmail("mike_test@gmial.com");
        contact.setMobile_phone("600900700");
        contact.setPerson(person);

        contact2.setPhone("817328120");
        contact.setPerson(person);

        contactRepository.save(contact);

        return contactRepository.findAll();
    }
}
