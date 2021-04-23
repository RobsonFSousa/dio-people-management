package one.digitalinnovation.peoplemanagement.repository;

import one.digitalinnovation.peoplemanagement.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryImpl extends JpaRepository<Person, Long> {
}
