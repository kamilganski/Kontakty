package pl.kganski.Contact.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kganski.Contact.model.Person;
import pl.kganski.Contact.repository.PersonsRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/persons")
public class PersonsResource {

    @Autowired
    PersonsRepository personsRepository;

    @GetMapping(value = "/all")
    public List<Person> getAll() {

        return personsRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Person> persist(@RequestBody final Person person) {

        personsRepository.save(person);
        return personsRepository.findAll();
    }
}
