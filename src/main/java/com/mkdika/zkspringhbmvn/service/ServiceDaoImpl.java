package com.mkdika.zkspringhbmvn.service;

import com.mkdika.zkspringhbmvn.entity.Person;
import com.mkdika.zkspringhbmvn.entity.PersonDto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maikel
 */
@Service("serviceDao")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ServiceDaoImpl implements ServiceDao {

    @Autowired
    private SessionFactory sessionFactory;

    public final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = false)
    public boolean save(Object obj) {
        getCurrentSession().saveOrUpdate(obj);
        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Object obj) {
        getCurrentSession().delete(obj);
        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean truncateDb() {
        getCurrentSession().createSQLQuery("DELETE FROM coderclub.person;").executeUpdate();
        return true;
    }

    @Override
    public Person getPersonById(Integer id) {
        Person t = (Person) getCurrentSession().get(Person.class, id);
        return t;
    }

    @Override
    public List<Person> getPersons() {
        List<Person> list = getCurrentSession().createQuery("FROM Person a ORDER BY a.personname ASC").list();
        return list;
    }

    // contoh pengunaan native query db di dalam serviceDaoImpl dengan memanfaatkan fitur createSQLQery hibernate
    // sql yg ditulis adalah sql query native ke db bersangkutan, dalam hal ini MySQL.
    @Override
    public List<PersonDto> getPersonQueryByGender(Integer gender) {
        return (List<PersonDto>) getCurrentSession().createSQLQuery("SELECT id, personname as name, email as mail FROM person WHERE gender = :gender") // ini adalah native sql query, bukan hql.
                .addEntity(PersonDto.class)
                .setParameter("gender", gender)
                .list();
    }
}
