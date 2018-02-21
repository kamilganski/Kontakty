package pl.kganski.Contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kganski.Contact.model.Person;

import java.util.List;

public interface PersonsRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);
}
