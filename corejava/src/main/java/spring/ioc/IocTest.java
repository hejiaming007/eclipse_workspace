/**
 * 
 */
package spring.ioc;

import java.sql.Connection;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * @author hejiaming
 *
 */
public class IocTest {

public static void main(String[] args) throws Exception {
		

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BeanA a = (BeanA)ctx.getBean("BeanA");
		a = ctx.getBean("BeanA", BeanA.class);//this way of getting bean no need downclass
		a.sayHello();
		

		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		DataSource dataSource2 = (DataSource)ctx.getBean("dataSource");
		DataSource dataSource3 = (DataSource)(new ClassPathXmlApplicationContext("applicationContext.xml")).getBean("dataSource");
		System.out.println("is datasource object same:"+(dataSource == dataSource2));//true, same Ioc Container
		System.out.println("is datasource object same:"+(dataSource == dataSource3));//false, because they are get from different IoC container.
		
		
	}

}
