package dom4j;

import java.net.URL;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;

public class Dom4jHelloworld {

	/**
	 * @param args
	 * @throws Exception 
	 */ 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("11");
	
		URL url = Dom4jHelloworld.class.getClassLoader().getResource("sample.xml");
		
		
		
		
		SAXReader saxReader = new SAXReader();
		DOMReader domReader = new DOMReader();
		
	
		
        Document document = saxReader.read(url);
        
        
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document document2 = db.parse(url.openStream());
//        document = domReader.read(document2); //Comment me if use SAX, else use DOM
        Element rootElement = document.getRootElement();
    
        System.out.println(rootElement.asXML());
        String prefix = "hjming";
        String uri = "http://www.hjming.com";
        
        Namespace nameSpace = new Namespace(prefix, uri);
        
        System.out.println(nameSpace);
        System.out.println(nameSpace.asXML());
        System.out.println(nameSpace.getUniquePath());
        
        
        QName qname = new QName("extAtt", nameSpace);
        
        System.out.println("=====");
        
        Iterator<Element> itr = rootElement.elementIterator(qname);
        while (itr.hasNext()) {
			Element e = itr.next();
			System.out.println(e+" "+e.getText());
			
		}
//        return document;
	}

}
