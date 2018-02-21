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

    @GetMapping(value = "/{name")
    public List<Person> getPerson(@PathVariable("name") final String name) {

        return personsRepository.findByName(name);
    }

    @GetMapping(value = "/id/{id}")
    public Person getId(@PathVariable("id") final Integer id) {

        return personsRepository.findOne(id);
    }

    @GetMapping(value = "/update/{id}/{name}")
    public Person update(@PathVariable("id") final Integer id, @PathVariable("name") final String name) {

        Person person = getId(id);
        person.setName(name);

        return personsRepository.save(person);
    }
}
