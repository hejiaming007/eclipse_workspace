/**
 * 
 */
package spring.i18n;

import java.io.IOException;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author hejiaming
 *
 */
public class I18nTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Test Resource bundle function.
		System.out.println(ctx.getMessage("text.name", null, Locale.getDefault()));
		
		//accessing resource:
		Resource res = null;
		res = ctx.getResource("file:///c:/a.txt");
		System.out.println(res.getURL().getContent());
		res = ctx.getResource("applicationContext.xml");
		System.out.println(res.getURL().getContent());
//		res = ctx.getResource("classpath:src/main/java/corejava/i18n/messages/properties");
//		System.out.println(res.getURL().getContent());
		res = ctx.getResource("http://www.baidu.com");
		System.out.println(res.getURL().getContent());

	}

}
