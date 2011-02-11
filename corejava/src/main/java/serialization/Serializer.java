package serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializer implements Serializable{
		
	//java.io.InvalidClassException: serialization.Serializer; local class incompatible: 
	//stream classdesc serialVersionUID = 5092091347849277395, local class serialVersionUID = 9131025113238683778
	
	String name;
	
	String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tempFile = "c:/a.txt";

		Serializer object = new Serializer();
		object.setName("jimmy");


		try {
			FileOutputStream fos = new FileOutputStream(tempFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Please change Serializer's source code before deserialize the object to meet the problem.");
	}

}
