package corejava.encoding;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.SortedMap;

import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.SystemUtils;

public class EncodingHelloworld {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Properties p = new Properties();
//		p.setProperty("file.encoding", "GBK");
//		System.setProperties(p);
		System.out.println(SystemUtils.FILE_ENCODING);
		
		System.out.println(java.nio.charset.Charset.defaultCharset());
		
		
		SortedMap map = java.nio.charset.Charset.availableCharsets();
		System.out.println(map);
		
		
		
		//check this file's property, found that this file is encoded by "UTF-8", so all
		//Programming character should be comprehend as "UTF-8" character.
		String str = "";
		str = new String("何嘉明".getBytes(),"GBK");
		System.out.println(str);
		
		str = new String("何嘉明".getBytes(),"UTF-8");
		System.out.println(str);
		
		
//		CharEncoding.ISO_8859_1
		
		
	}

}
