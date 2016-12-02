package com.mkdika.zkspringhbmvn.service;

import com.mkdika.zkspringhbmvn.entity.Person;
import com.mkdika.zkspringhbmvn.entity.PersonDto;
import java.util.List;

/**
 *
 * @author Maikel
 */
public interface ServiceDao {
    
    public boolean save(Object obj);        

    public boolean delete(Object obj);
    
    public boolean truncateDb();
    
    public Person getPersonById(Integer id);
    
    public List<Person> getPersons();                           
    
    // interface untuk contoh native query via hibernate
    public List<PersonDto> getPersonQueryByGender(Integer gender);
}
