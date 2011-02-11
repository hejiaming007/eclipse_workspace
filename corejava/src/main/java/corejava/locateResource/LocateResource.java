package corejava.locateResource;

import java.net.URL;

import dom4j.Dom4jHelloworld;

public class LocateResource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url = Dom4jHelloworld.class.getClassLoader().getResource("pom.xml");
	}

}
