package marcos.restspringbootandjava.services;

import marcos.restspringbootandjava.data.vo.v1.PersonVO;
import marcos.restspringbootandjava.data.vo.v2.PersonVOV2;
import marcos.restspringbootandjava.exception.ResourceNotFoundException;
import marcos.restspringbootandjava.mapper.DozerMapper;
import marcos.restspringbootandjava.mapper.custom.PersonMapper;
import marcos.restspringbootandjava.model.Person;
import marcos.restspringbootandjava.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    public PersonVO findById(Long id) {
        logger.info("Finding one person!");
        var personEntity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records founded for this ID!"));
        return DozerMapper.parseObject(personEntity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("Finding all people!");
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");

        var personEntity = DozerMapper.parseObject(person, Person.class);
        var personVO = DozerMapper.parseObject(personRepository.save(personEntity), PersonVO.class);
        return personVO;
    }

    public PersonVOV2 createV2(PersonVOV2 personVO) {
        logger.info("Creating one person with V2!");

        var personEntity = personMapper.convertVOtoEntity(personVO);
        var personVOV2 = personMapper.convertEntityToVO(personRepository.save(personEntity));
        return personVOV2;
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");
        Person personEntity = personRepository.findById(person.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("No records founded for this ID!"));

        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAdress(person.getAdress());
        personEntity.setGender(person.getGender());

        var personVO = DozerMapper.parseObject(personRepository.save(personEntity), PersonVO.class);
        return personVO;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person personEntity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records founded for this ID!"));

        personRepository.delete(personEntity);
    }
}