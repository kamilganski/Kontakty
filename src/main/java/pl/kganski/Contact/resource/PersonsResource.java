package pl.kganski.Contact.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kganski.Contact.model.Contact;
import pl.kganski.Contact.model.Person;
import pl.kganski.Contact.repository.PersonsRepository;

import java.util.List;

@RestController
public class PersonsResource {

    @Autowired
    PersonsRepository personsRepository;

    public PersonsResource(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Person> getAll() {
        try {
            return personsRepository.findAll();
        }
        catch (Exception ex) {
            return personsRepository.findAll();
        }

    }

    @RequestMapping("/create")
    @ResponseBody
    public String create(String name, String surname, String gender, String date_of_birth, String pesel) {

        String person_id = "";

        try {
            Person person = new Person(name, surname, gender, date_of_birth, pesel);

            if(findByPesel(pesel) == "0") {

                personsRepository.save(person);
                person_id = String.valueOf(person.getId());

                return "Dodano osobe o id: " + person_id;
            }
        }
        catch (Exception ex) {
            return "Nie udało się dodać osoby, błąd: " + ex.toString();
        }
        return "Istnieje już osoba o takim peselu!";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id) {
        try {
            Person person = new Person(id);

            personsRepository.delete(person);
        }
        catch (Exception ex) {
            return "Nie udało się usunąć osoby, błąd: " + ex.toString();
        }
        return "Osoba pomyślnie usunięta!";
    }

    @RequestMapping("/find-by-id")
    @ResponseBody
    public Integer findById(Integer id) {
        try {
            Person person = personsRepository.findById(id);
        }
        catch (Exception ex) {
            return 0;
        }
        return id;
    }

    @RequestMapping("/find-by-pesel")
    @ResponseBody
    public String findByPesel(String pesel) {
        try {
            Person person = null;
            person = personsRepository.findByPesel(pesel);

            if(person == null) {
                return "0";
            }
        }
        catch (Exception ex) {
            return "Błąd: " + ex.toString();
        }
        return "1";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Integer id, String name, String surname, String gender, String date_of_birth, String pesel) {
        try {
            Person person = personsRepository.findOne(id);

            person.setName(name);
            person.setSurname(surname);
            person.setGender(gender);
            person.setDate_of_birth(date_of_birth);
            person.setPesel(pesel);
        }
        catch (Exception ex) {
            return "Bład przy aktualizacji rekordu: " + ex.toString();
        }

        return "Rekord zaktualizowany!";
    }
}
