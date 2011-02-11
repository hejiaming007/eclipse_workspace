package net;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.hsqldb.lib.StringInputStream;


public class HTTPConnection {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL("http://www.baidu.com");
		System.out.println(url.getUserInfo());
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.connect();
		InputStream inputStream = connection.getInputStream();
		byte[] b = new byte[100000];
		inputStream.read(b);
		System.out.println(new String(b));
		
	}

}
