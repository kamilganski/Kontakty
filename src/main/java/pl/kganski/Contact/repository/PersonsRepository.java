package pl.kganski.Contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kganski.Contact.model.Person;

public interface PersonsRepository extends JpaRepository<Person, Integer> {
}
