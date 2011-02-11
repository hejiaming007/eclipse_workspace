package spring.jmx;

import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MalformedObjectNameException;
import javax.management.ReflectionException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmxTest {

	/**
	 * @param args
	 * @throws NullPointerException 
	 * @throws ReflectionException 
	 * @throws MalformedObjectNameException 
	 * @throws IntrospectionException 
	 * @throws InstanceNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		
		/*
		 * Spring will automatically config jmx according to the springJmxContext.xml
		 * */
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		
////		MBeanServer mbs = (MBeanServer)applicationContext.getBean("mbeanServer");//com.sun.jmx.mbeanserver.JmxMBeanServer
//		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//		System.out.println(ArrayUtils.toString(mbs.getDomains()));
//		
//		
//		ObjectName name = new ObjectName("testBean1","name","testBean2");
//		JmxTest bean = (JmxTest)applicationContext.getBean("testBean");
//		
//		
//		
//		System.out.println("isRegisted:"+mbs.isRegistered(name));
//		
//		mbs.registerMBean(bean, name);
//		
//		System.out.println("isRegisted:"+mbs.isRegistered(name));
//		System.out.println(mbs.getMBeanInfo(name));	
//		
		System.out.println("Sleeping for jconsole connect...");
		Thread.sleep(Integer.MAX_VALUE);
	}

}
