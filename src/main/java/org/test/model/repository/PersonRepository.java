package org.test.model.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import java.util.List;

import org.test.model.domain.Person;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person>{
    public List<Person> findAllPersons(){
        return this.findAll().list();
    }

    public Person findByPersonId(String id){
        return this.find("id", id).firstResult();
    }
    
    @Transactional
    public Person persistAndReturn(Person Person){
        Person newPerson = null;
        this.persist(Person);
        newPerson = this.find("id",Person.getId()).firstResult();
        return newPerson;
    }

    
}
