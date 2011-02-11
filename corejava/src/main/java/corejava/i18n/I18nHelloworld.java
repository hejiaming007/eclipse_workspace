/**
 * 
 */
package corejava.i18n;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * @author hejiaming
 *
 */
public class I18nHelloworld {

	/**
	 * 
	 * 
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {

		String str = null;
		
		Locale.setDefault(Locale.US);
		System.out.println(Locale.getDefault());
		str = Messages.getString("text.name");
		System.out.println(str);
		
		
		Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
		System.out.println(Locale.getDefault());
		str = Messages.getString("text.name");
		System.out.println(str);
		
//		Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
//		System.out.println(new String(Messages.getString("text.name").getBytes(),"UTF-8"));
		
	}

}
