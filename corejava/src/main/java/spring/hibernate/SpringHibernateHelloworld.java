package spring.hibernate;

import hibernate.domain.Person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateHelloworld {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		PersonDao dao = applicationContext.getBean("simpleHibernateDao",
				PersonDao.class);

		Person person = new Person();
		person.setAge(18);
		person.setFirstname("Jimmy");
		person.setFirstname("He");

		String personId = dao.addPerson(person);
		
		System.out.println("personId:" + personId);
		System.out.println(dao.getPersons());
		System.out.println(dao.getPersonById(personId));

		
		
	}
}
