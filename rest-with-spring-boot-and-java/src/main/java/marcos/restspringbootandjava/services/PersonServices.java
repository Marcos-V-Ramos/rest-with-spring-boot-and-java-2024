package marcos.restspringbootandjava.services;

import marcos.restspringbootandjava.exception.ResourceNotFoundException;
import marcos.restspringbootandjava.model.Person;
import marcos.restspringbootandjava.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    public Person findById(Long id) {
        logger.info("Finding one person!");
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records founded for this ID!"));
    }

    public List<Person> findAll() {
        logger.info("Finding all people!");
        return personRepository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        Person personEntity = personRepository.findById(person.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("No records founded for this ID!"));

        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAdress(person.getAdress());
        personEntity.setGender(person.getGender());
        return personRepository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person personEntity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records founded for this ID!"));

        personRepository.delete(personEntity);
    }
}