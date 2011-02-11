/**
 * 
 */
package corejava.i18n;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author hejiaming
 *
 */
public class Messages {
	private static final String BUNDLE_NAME = "corejava.i18n.messages"; //$NON-NLS-1$

	public static String getString(String key) {
		try {
			return ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault()).getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
