package pl.kganski.Contact.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import pl.kganski.Contact.model.Contact;
import pl.kganski.Contact.repository.ContactRepository;

import java.util.List;

@RestController
public class ContactResource {

    @Autowired
    ContactRepository contactRepository;

    public ContactResource(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @RequestMapping("/allcontact")
    @ResponseBody
    public List<Contact> getAll() {
        try {
            return contactRepository.findAll();
        }
        catch (Exception ex) {
            return contactRepository.findAll();
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addContact(String mobile, String email, String phone, Integer personId) {
        try {
            Contact contact = new Contact(mobile, email, phone, personId);

            if((findByMobile(mobile) == "0" || findByPersonId(personId) != personId) || (findByEmail(email) == "0" || findByPersonId(personId) != personId) || (findByPhone(phone) == "0" || findByPersonId(personId) != personId)) {

                contactRepository.save(contact);

                return "Kontakt został dodany!";
            }
        }
        catch (Exception ex) {
            return "Nie udało się dodać kontaktu, błąd: " + ex.toString();
        }
        return "Istnieje już kontakt z takim nr telefonu lub emailem lub nr telefonu stacjonarnego!";
    }

    @RequestMapping("/delete-contact")
    @ResponseBody
    public String delete(Integer id) {
        try {
            Contact contact = new Contact(id);

            contactRepository.delete(contact);
        }
        catch (Exception ex) {
            return "Nie udało się usunąć kontaktu, błąd: " + ex.toString();
        }
        return "Kontakt pomyślnie usunięty!";
    }

    @RequestMapping("/find-by-mobile")
    @ResponseBody
    public String findByMobile(String mobile) {
        try {
            Contact contact = null;
            contact = contactRepository.findByMobile(mobile);

            if(contact == null) {
                return "0";
            }
        }
        catch (Exception ex) {
            return "Błąd: " + ex.toString();
        }
        return "1";
    }

    @RequestMapping("/find-by-email")
    @ResponseBody
    public String findByEmail(String email) {
        try {
            Contact contact = null;
            contact = contactRepository.findByEmail(email);

            if(contact == null) {
                return "0";
            }
        }
        catch (Exception ex) {
            return "Błąd: " + ex.toString();
        }
        return "1";
    }

    @RequestMapping("/find-by-phone")
    @ResponseBody
    public String findByPhone(String phone) {
        try {
            Contact contact = null;
            contact = contactRepository.findByPhone(phone);

            if(contact == null) {
                return "0";
            }
        }
        catch (Exception ex) {
            return "Błąd: " + ex.toString();
        }
        return "1";
    }

    @RequestMapping("/find-by-person-id")
    @ResponseBody
    public Integer findByPersonId(Integer personId) {
        try {
            Contact contact = null;
            contact = contactRepository.findByPersonId(personId);

            if(contact == null) {
                return 0;
            }
        }
        catch (Exception ex) {
            return ex.hashCode();
        }
        return personId;
    }
}
