package marcos.restspringbootandjava.mapper.custom;

import marcos.restspringbootandjava.data.vo.v2.PersonVOV2;
import marcos.restspringbootandjava.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonMapper() { }

    public synchronized Person convertVOtoEntity(PersonVOV2 personVO) {
        Person personEntity = new Person();

        personEntity.setId(personVO.getId());
        personEntity.setFirstName(personVO.getFirstName());
        personEntity.setLastName(personVO.getLastName());
        personEntity.setAdress(personVO.getAdress());
        // personEntity.setBirthday(new Date()); -> caso o versionamento fosse aplicado.
        personEntity.setGender(personVO.getGender());
        return personEntity;
    }

    public PersonVOV2 convertEntityToVO(Person personEntity) {
        PersonVOV2 personVO = new PersonVOV2();

        personVO.setId(personEntity.getId());
        personVO.setFirstName(personEntity.getFirstName());
        personVO.setLastName(personEntity.getLastName());
        personVO.setAdress(personEntity.getAdress());
        personVO.setGender(personEntity.getGender());

        personVO.setBirthDay(new Date());
        return personVO;
    }

}
