package spring.hibernate;

import hibernate.domain.Person;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PersonDao extends HibernateDaoSupport{
	
	
	
	public String addPerson(Person person){
		
        //Save a domain
		getHibernateTemplate().save(person);
        return person.getId();
	}

	
	public Person getPersonById(String personId){
		return getHibernateTemplate().get(Person.class, personId);
	}
	
	public List<Person> getPersons(){
		return getHibernateTemplate().loadAll(Person.class);
	}
	
}
